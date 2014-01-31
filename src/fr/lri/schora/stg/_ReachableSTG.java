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
package fr.lri.schora.stg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.lri.schora.solver.Z3SMT;
import fr.lri.schora.expr.BTrue;
import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.util.BoolExpression;

/**
 * get a reachable stg
 * @author nhnghia
 */
class _ReachableSTG {
	Z3SMT z3Solver;
	public _ReachableSTG(Z3SMT z3Solver){
		this.z3Solver= z3Solver;
	}
	
	
	List<State> _visitedStates;
	STG stg;
	public STG getReachableSTG(STG s){
		stg = s.clone();
		_visitedStates = new ArrayList<State>();
		visitReachableSTG(ExprFactory.eINSTANCE.createBTrue(), stg.initialState);
		
		stg.updateFreeVariableList();
		updateStates();
		return stg;
	}
	
	void visitReachableSTG(Condition lastCondition, State s){
		if (_visitedStates.contains(s)){
			return;
		}
		_visitedStates.add(s);
		
		//consider only reachable transitions
		List<Transition> transLst = stg.getOutgoingTransitions(s);
		Iterator<Transition> iter = transLst.iterator();
		while (iter.hasNext()){
			Transition t = iter.next();
			Condition c = lastCondition;
			if (!(t.guard instanceof BTrue)){
				c = BoolExpression.createAnd(c, t.guard);
				if (z3Solver.assertFalse(c)){
					cutoffTransition(t);
				}
			}
			visitReachableSTG(c, t.destination);
		}
	}
	
	void cutoffTransition(Transition t){
		stg.transitions.remove(t);
		if (_visitedStates.contains(t.destination))
			return;
		if (stg.getIncomingTransitions(t.destination).size() > 1)
			return;
		
		List<Transition> transLst = stg.getOutgoingTransitions(t.destination);
		stg.transitions.removeAll(transLst);
		for (Transition tt : transLst)
			cutoffTransition(tt);
	}
	
	/**
	 * After cutting off, some states may be removed
	 */
	void updateStates(){
		List<State> states = new ArrayList<State>();
		List<Transition> trans = stg.transitions;
		for (Transition t : trans){
			if (!states.contains(t.source))
				states.add(t.source);
			if (!states.contains(t.destination))
				states.add(t.destination);
		}
		stg.states = states;
	}
}
