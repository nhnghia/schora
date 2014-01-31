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
import java.util.HashMap;
import java.util.List;

import fr.lri.schora.basicEvent.BasicEvent;
import fr.lri.schora.basicEvent.BoundEvent;
import fr.lri.schora.expr.Variable;

/**
 * update variables using in guard/event
 * for examples: x *3 + x: there is only one variable (name x) is used rather than two different variables (same name x)
 * no more used 
 */

//Not used
class _UpdateVariableSTG {
	List<State> _visitedStates;
	STG stg;
	public STG update(STG s){
		stg = s;
		_visitedStates = new ArrayList<State>();
		
		updateVariables(stg.initialState, new HashMap<String, Variable>());
		
		return stg;
	}
	
	void updateVariables(State s, HashMap<String, Variable> _variables){
		if (_visitedStates.contains(s)){
			return;
		}
		_visitedStates.add(s);
		
		List<Transition> trans = stg.getOutgoingTransitions(s);
		for (Transition t : trans){
			List<Variable> vars = t.guard.freeVariables();
			vars.addAll(t.event.getFreeVariables());
			
			update(vars, _variables);
			
			//if a bound event ==> create a new variable
			if (t.event instanceof BoundEvent){
				if (t.event instanceof BasicEvent){
					Variable v = ((BasicEvent) t.event).getVariable();
					_variables.put(v.getName(), v);
				}
			}
			updateVariables(t.destination, _variables);
		}
	}
	
	void update(List<Variable> vars, HashMap<String, Variable> _variables){
		for (Variable v : vars){
			if (_variables.containsKey(v.getName()))
				v = _variables.get(v.getName());
			else 
				_variables.put(v.getName(), v);
		}
	}
}
