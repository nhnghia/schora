package fr.lri.schora.stg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.lri.schora.basicEvent.BasicEvent;

class _FirstEventOfRole {
	STG stg;
	public _FirstEventOfRole(STG stg){
		this.stg = stg;
		_resultTrue = new HashMap<String, List<State>>();
	}
	List<State> _visitedState;
	HashMap<String, List<State>> _resultTrue;
	
	public boolean isFirstEventsOfRoleIsReceiverAfterState(String roleName, State s){
		
		if (_resultTrue.containsKey(roleName)){	//this role is considered
			List<State> lst = _resultTrue.get(roleName);
			return lst.contains(s);
		}
		
		_visitedState = new ArrayList<State>();
		return _isFirstEventsOfRoleIsReceiverAfterState(roleName, s);
	}
	
	boolean _isFirstEventsOfRoleIsReceiverAfterState(String roleName, State s){
		if (_visitedState.contains(s)){
			List<State> lst = _resultTrue.get(roleName);
			if (lst == null)
				return false;
			return lst.contains(s);
		}
		_visitedState.add(s);
		
		List<Transition> trans = stg.getOutgoingTransitions(s);
		if (trans.size() == 0)
			return false;
		
		for (Transition t : trans){
			if (t.event instanceof BasicEvent){
				BasicEvent ev = (BasicEvent) t.event;
				if (ev.getSender().equals(roleName))
					return false;
				if (ev.getReceiver().equals(roleName))
					continue;
			}
			if (! _isFirstEventsOfRoleIsReceiverAfterState(roleName, t.destination))
				return false;
		}
		List<State> lst = _resultTrue.get(roleName);
		if (lst == null)
			lst = new ArrayList<State>();
		lst.add(s);
		_resultTrue.put(roleName, lst);
		return true;
	}
}
