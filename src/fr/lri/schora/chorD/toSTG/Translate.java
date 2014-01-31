/*******************************************************************************
 * This code is distributed under GPL v2 licence.
 * 
 * This code is provided solely "as is". 
 * There is no warranty or other guarantee of fitness of this code.
 * The author disclaims all responsibility and liability 
 * with respect to this code's usage
 * or its effect upon hardware or computer systems.
 * 
 * author: Huu-Nghia Nguyen
 * email : nhnghia@me.com
 ******************************************************************************/
package fr.lri.schora.chorD.toSTG;

import java.util.ArrayList;
import java.util.List;

import fr.lri.schora.basicEvent.*;
import fr.lri.schora.chorD.*;
import fr.lri.schora.chorD.Bracket;
import fr.lri.schora.expr.*;
import fr.lri.schora.expr.util.*;
import fr.lri.schora.stg.*;

public class Translate {
	private ExprFactory exprFactory;
	private BasicEventFactory eventFactory;
	private STG sTG;
	private int index;

	private String getStateName() {
		return String.format("%d", ++index);
	}

	public STG get(ChorD chor) {

		if (chor == null)
			return null;
		// Initial
		index = 0;

		exprFactory = ExprFactory.eINSTANCE;
		eventFactory = BasicEventFactory.eINSTANCE;

		sTG = new STG();
		sTG.name = "-";

		State source = new State(getStateName(), chor.toString());

		sTG.states.add(source);
		sTG.initialState = source;

		createSTG(source, chor);
		
		sTG.updateFreeVariableList();
		updateStateLabel();
		return sTG;
	}

	void updateStateLabel(){
		for (State s : sTG.states){
			s.label = s.name;
		}
	}
	
	// A chor specification can be fire, so
	private class FireTransition {
		public Event firedEvent;
		public Condition guard;
		public ChorD remainder;
	}

	private void createSTG(State source, ChorD spec) {
		if (spec == null)
			return;

		List<FireTransition> lst = canBeFired(spec);
		if (lst == null)
			return;

		for (FireTransition ft : lst) {
			Transition trans = new Transition(source, source, ft.guard,
					ft.firedEvent);

			// Verify if existed a state which has same terms
			boolean noLoop = true;

			String str = "-";
			try {
				if (ft.remainder != null)
					str = ft.remainder.toString();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			for (State s : sTG.states)
				if (s.label.compareTo(str) == 0) {
					trans.destination = s;
					sTG.transitions.add(trans);
					noLoop = false;
					break;
				}

			// OK, not exist ==> create a new state
			if (noLoop) {
				// New state
				State target = new State(getStateName(), str);
				// add to trans
				trans.destination = target;
				sTG.transitions.add(trans);

				// add to STG
				sTG.states.add(target);

				// for the rest : Deep First Search
				if (ft.remainder != null)
					createSTG(target, ft.remainder);
			}
		}
	}

	/**
	 * Given a ChorD, applying the semantics of the ChorData language, this spec
	 * can be run?
	 * 
	 * @param spec
	 * @return action fired
	 */
	private List<FireTransition> canBeFired(ChorD spec) {

		if (spec instanceof Skip)
			return canBeFired((Skip) spec);
		else if (spec instanceof Communication)
			return canBeFired((Communication) spec);
		else if (spec instanceof Sequence)
			return canBeFired((Sequence) spec);
		else if (spec instanceof Choice)
			return canBeFired((Choice) spec);
		else if (spec instanceof Parallel)
			return canBeFired((Parallel) spec);
		else if (spec instanceof Interruption)
			return canBeFired((Interruption) spec);
		else if (spec instanceof If)
			return canBeFired((If) spec);
		else if (spec instanceof Loop)
			return canBeFired((Loop) spec);
		// else if (spec instanceof FunctionCall)
		// return canBeFired((FunctionCall) spec);
		else if (spec instanceof Bracket)
			return canBeFired(((Bracket) spec).spec); // Bracket

		return null; // new ArrayList<Lang2STG.FireTransition>();
	}

	// FunctionCall
	// private List<FireTransition> canBeFired(FunctionCall spec) {
	// return canBeFired(spec.getFunction().getSpecification());
	// }

	// SKIP
	private List<FireTransition> canBeFired(Skip spec) {
		FireTransition trans = new FireTransition();
		trans.guard = exprFactory.createBTrue();
		trans.firedEvent = eventFactory.createTick();
		trans.remainder = null;

		List<FireTransition> lst = new ArrayList<FireTransition>();
		lst.add(trans);
		return lst;
	}

	// COMMUNICATION
	private List<FireTransition> canBeFired(Communication c) {
		FireTransition trans = new FireTransition();
		trans.remainder = new Skip();
		trans.guard = exprFactory.createBTrue();

		trans.firedEvent = c.event;

		List<FireTransition> lst = new ArrayList<FireTransition>();
		lst.add(trans);
		return lst;
	}

	// SEQUENCE
	private List<FireTransition> canBeFired(Sequence seq) {

		List<FireTransition> ls = canBeFired(seq.spec);
		if (ls == null)
			return null;

		List<FireTransition> lst = new ArrayList<FireTransition>();

		for (FireTransition tr : ls) {
			Event act = tr.firedEvent;
			if (act instanceof Tick) {
				List<FireTransition> l = canBeFired(seq.rightSpec);
				for (FireTransition t : l) {
					FireTransition trans = new FireTransition();
					trans.guard = BoolExpression.createAnd(tr.guard, t.guard);
					trans.firedEvent = t.firedEvent;
					trans.remainder = t.remainder;
					lst.add(trans);
				}
			} else {
				FireTransition trans = new FireTransition();
				trans.guard = tr.guard;
				trans.firedEvent = tr.firedEvent;
				Sequence s = new Sequence();
				s.spec = tr.remainder;
				s.rightSpec = seq.rightSpec;
				trans.remainder = s;
				lst.add(trans);
			}
		}
		return lst;
	}

	// CHOICE
	private List<FireTransition> canBeFired(Choice choi) {

		List<FireTransition> lst = canBeFired(choi.spec);
		List<FireTransition> lst2 = canBeFired(choi.rightSpec);
		if (lst == null)
			lst = lst2;
		else
			lst.addAll(lst2);

		return lst;
	}

	// PARALLEL
	private List<FireTransition> canBeFired(Parallel par) {
		ChorD spec1 = par.spec;
		ChorD spec2 = par.rightSpec;

		List<FireTransition> lst1 = canBeFired(spec1);
		List<FireTransition> lst2 = canBeFired(spec2);

		List<FireTransition> lst = new ArrayList<FireTransition>();

		for (FireTransition f1 : lst1)
			for (FireTransition f2 : lst2) {
				if ((f1.firedEvent instanceof Tick)
						&& (f2.firedEvent instanceof Tick)) {

					FireTransition f = new FireTransition();
					f.guard = BoolExpression.createAnd(f1.guard, f2.guard);
					f.firedEvent = eventFactory.createTick();

					// Parallel s = chorFactory.createParallel();
					// s.setSpec(f1.specification);
					// s.setSpec2(f2.specification);

					f.remainder = null;

					lst.add(f);
				}
			}
		for (FireTransition f1 : lst1)
			if (!(f1.firedEvent instanceof Tick)) {
				FireTransition f = new FireTransition();
				f.guard = f1.guard;

				Parallel s = new Parallel();
				s.spec = f1.remainder;
				s.rightSpec = spec2;
				f.remainder = s;
				f.firedEvent = f1.firedEvent;
				lst.add(f);
			}

		for (FireTransition f2 : lst2)
			if (!(f2.firedEvent instanceof Tick)) {
				FireTransition f = new FireTransition();
				f.guard = f2.guard;

				Parallel s = new Parallel();
				s.spec = spec1;
				s.rightSpec = f2.remainder;
				f.remainder = s;
				f.firedEvent = f2.firedEvent;
				lst.add(f);
			}

		return lst;
	}

	// INTERUPTION
	private List<FireTransition> canBeFired(Interruption ite) {

		List<FireTransition> lst = canBeFired(ite.rightSpec);

		List<FireTransition> l = canBeFired(ite.spec);

		for (FireTransition f : l) {
			if (f.firedEvent instanceof Tick) {
				lst.add(f);
			} else {
				Interruption i = new Interruption();
				i.spec = f.remainder;
				i.rightSpec = ite.rightSpec;
				f.remainder = i;

				lst.add(f);
			}
		}

		return lst;
	}

	// GUARD
	private List<FireTransition> canBeFired(If gad) {
		List<FireTransition> l = canBeFired(gad.spec);

		List<FireTransition> lst = new ArrayList<FireTransition>(l.size());
		for (FireTransition f : l) {
			f.guard = BoolExpression.createAnd(gad.guard, f.guard);
			lst.add(f);
		}

		return lst;
	}

	// LOOP
	private List<FireTransition> canBeFired(Loop lop) {
		List<FireTransition> ls = canBeFired(lop.spec);

		List<FireTransition> lst = new ArrayList<FireTransition>();
		Condition c = lop.guard;

		for (FireTransition f : ls) {
			f.guard = BoolExpression.createAnd(c, f.guard);

			Sequence s = new Sequence();
			s.spec = f.remainder;
			s.rightSpec = lop;
			f.remainder = s;
			lst.add(f);

			FireTransition ff = new FireTransition();
			ff.guard = BoolExpression.createNot(c);
			ff.firedEvent = eventFactory.createTick();
			ff.remainder = null;// chorFactory.createZeroSpec();

			lst.add(ff);
		}

		return lst;
	}
}
