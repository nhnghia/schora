package fr.lri.schora.stg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.lri.schora.basicEvent.BasicEvent;
import fr.lri.schora.basicEvent.BoundEvent;
import fr.lri.schora.basicEvent.FreeInteraction;

class _STGDataOwner {
	STG stg;
	public _STGDataOwner(STG stg){
		this.stg = stg;
		owners = new HashMap<String, HashMap<String,List<String>>>();
	}
	
	public HashMap<String, List<String>> dataOwner(State s){
		if (owners.size() == 0){
			visitedStates = new ArrayList<State>();
			visite(stg.initialState);
		}
		return owners.get(s.name);
	}
	
	List<State> visitedStates;
	HashMap<String, HashMap<String, List<String>>> owners;		//<state, <variable.name, roles>
	
	void visite(State s){
		if (visitedStates.contains(s))
			return;
		visitedStates.add(s);
		
		HashMap<String, List<String>> datas = owners.get(s.name);
		if (datas == null){
			datas = new HashMap<String, List<String>>();
			owners.put(s.name, datas);
		}
		
		List<Transition> trans = stg.getOutgoingTransitions(s);
		for (Transition t: trans){
			if (!(t.event instanceof BasicEvent))
				continue;
			BasicEvent ev = (BasicEvent) t.event;
			
			List<String> lst = new ArrayList<String>();
			// if "ev" is a boundEvent ==> after this event, only its sender and receiver know the bound variable of "ev"
			if (ev instanceof BoundEvent){
				lst = new ArrayList<String>();
				lst.add(ev.getSender());
				lst.add(ev.getReceiver());
				datas.put(ev.getVariable().getName(), lst);
			}else if (ev instanceof FreeInteraction){
				//the receiver knows also the variable
				lst = datas.get(ev.getVariable().getName());
				if (lst == null)
					lst = new ArrayList<String>();
				lst.add(ev.getSender());
				lst.add(ev.getReceiver());
			
				datas.put(ev.getVariable().getName(), lst);
			}
			visite(t.destination);
		}
	}
}
