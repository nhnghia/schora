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
package fr.lri.schora.stg.conformance;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import fr.lri.schora.basicEvent.*;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.Variable;
import fr.lri.schora.stg.*;

class _Restriction {
	BasicEventFactory factory;
	int index;

	Hashtable<String, Integer> varIndex;

	/**
	 * Change all events, which do not appear in stgs, to TAU
	 * 
	 * @param stgSrc
	 * @param stgs
	 * @return
	 */
	public STG restrict(STG stgSrc, STG stgs) {
		List<Event> comms = getCommunications(stgs);

		factory = BasicEventFactory.eINSTANCE;
		index = 0;
		varIndex = new Hashtable<String, Integer>();

		STG stg = new STG();
		stg.name = stgSrc.name;
		stg.initialState = stgSrc.initialState;
		stg.states.addAll(stgSrc.states);

		List<Transition> trans = stgSrc.transitions;
		List<Transition> ts = new ArrayList<Transition>();
		boolean b;
		for (Transition t : trans) { // Restrict action of each transition
			if (t.event instanceof Tau)
				continue;

			b = !(comms.contains(t.event));
			Transition tt = createTrans(t, b, stgSrc);
			ts.add(tt);
		}

		stg.transitions.addAll(ts);
		stg.updateFreeVariableList();
		return stg;
	}

	/**
	 * 
	 * @param tran
	 * @param isTau
	 * @return
	 */
	private Transition createTrans(Transition tran, boolean isTau, STG stg) {
		Transition t = new Transition(tran.source, tran.destination,
				tran.guard, tran.event);

		if (isTau) { // we need create a Tau, and add a free variable to source
						// state
			t.event = factory.createTau();
		}
		return t;
	}

	/**
	 * get list of all communication action in stg
	 * 
	 * @param stg
	 * @return
	 */
	private List<Event> getCommunications(STG stg) {
		List<Event> comms = new ArrayList<Event>();
		for (Transition t : stg.transitions) {
			Event c = t.event;
			if (!comms.contains(c))
				comms.add(c);
		}
		return comms;
	}

	Variable copyVariable(Variable v) {
		Variable v_copy = ExprFactory.eINSTANCE.createVariable();
		v_copy.setName(v.getName());
		return v_copy;
	}
}
