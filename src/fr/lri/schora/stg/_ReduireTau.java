package fr.lri.schora.stg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.lri.schora.basicEvent.Tau;
import fr.lri.schora.expr.BTrue;

class _ReduireTau {
	STG stg;
	public _ReduireTau(STG stg){
		this.stg = stg.clone();
	}
	
	STG reduire(){
		visitedState = new ArrayList<State>();
		_visit(stg.initialState);
		
		//remove the transitions which have same label, same source, and same destination
		List<Transition> lst = new ArrayList<Transition>();
		List<String> strs = new ArrayList<String>();
		for (Transition t : stg.transitions){
			String s = t.toString();
			if (strs.contains(s)){
				lst.add(t);
			}else
				strs.add(s);
		}
		stg.transitions.removeAll(lst);
		
		//update states
		Set<State> states = new HashSet<State>();
		for (Transition t : stg.transitions){
			if (!stg.states.contains(t.source))
				states.add(t.source);
			if (!stg.states.contains(t.destination))
				states.add(t.destination);
		}
		stg.states.addAll(states);
		return stg;
	}
	
	List<State> visitedState;
	void _visit(State s){
		if (visitedState.contains(s))
			return;
		visitedState.add(s);
		
		List<Transition> trans = stg.getOutgoingTransitions(s);
		if (trans.size() == 1){
			Transition t = trans.get(0);
			_canRemove(t);
			_visit(t.destination);
		}else
			for (Transition t : trans){
				if (stg.getOutgoingTransitions(t.destination).size() > 0)
					_canRemove(t);
				_visit(t.destination);
			}
	}
	
	void _canRemove(Transition t){
		if (t.event instanceof Tau && t.guard instanceof BTrue){
			State s = t.source;
			if (stg.initialState.equals(s))
				stg.initialState = t.destination;
			
			stg.states.remove(s);
			
			stg.transitions.remove(t);
			for (Transition tt : stg.transitions){
				if (tt.destination == s){
					tt.destination = t.destination;
				}
				if (tt.source == s)
					tt.source = t.destination;
			}
			//can visit again
		}
	}
}
