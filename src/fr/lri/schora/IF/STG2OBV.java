package fr.lri.schora.IF;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import fr.lri.schora.stg.*;
import fr.lri.schora.expr.*;
import fr.lri.schora.basicEvent.*;

public class STG2OBV{
	String additionalVars;
	public String toIFObserver(STG stg){
		List<Variable> vars = new ArrayList<Variable>();
		for (Transition t : stg.transitions){
			vars.addAll(t.guard.variables());
			vars.addAll(t.event.getBoundVariables());
			vars.addAll(t.event.getFreeVariables());
		}
		
		String str = ""; //String.format("process %s(1);\n", stg.name);
		Set<String> varNames = new TreeSet<String>();
		for (Variable v : vars){
			String s = getVarName(v);
			if (varNames.contains(s))
				continue;
			varNames.add(s);
			varNames.add(s);
			str += "var " + v.getName() + " INT;\n";
		}
		
		additionalVars = "";
		
		stg.initialState.name = "s0";
		int i=1;
		for (State s : stg.states){
			if (s.equals(stg.initialState))
				continue;
			s.name = "s" + i;
			i++;
		}
		str += state2IF(stg, stg.initialState);
		
		
		for (State s : stg.states){
			if (s.equals(stg.initialState))
				continue;
			str += state2IF(stg, s);
		}
		String procName = stg.name;
		str = String.format("pure observer %s;\n%s\n%s\nendobserver;\n", 
				procName,
				additionalVars,
				str);
		return str;
	}
	
	String state2IF(STG stg, State s){
		List<Transition> trans = stg.getOutgoingTransitions(s);
		String str = "\nstate " + s.name;
		if (s.equals(stg.initialState))
			str += " #start ;\n";
		else{
			if (trans.size() == 0)
				str += "  #success ";
			str += " ;\n";
		}
		//there is no outgoing transitions
		if (trans.size() == 0){
			str += "  stop;\n";
		}else
		for (Transition t : trans){
			if (!(t.guard instanceof BTrue) || (t.guard instanceof BFalse)){
				str += String.format("  provided %s;\n", t.guard.toString().replaceAll("!=", "<>"));
			}
			if (t.event instanceof BoundInteraction){
				BoundInteraction ev = (BoundInteraction) t.event;
				str += String.format("  match output %s(%s);\n", 
						ev.getOperationName(),
						getVarName(ev.getVariable()));
				str += String.format("  nextstate %s_;\n  endstate;\n", s.name);
				str += String.format("state %s_;\n", s.name);
				str += String.format("  match input %s(%s);\n", 
						ev.getOperationName(),
						getVarName(ev.getVariable()));
			}else if (t.event instanceof FreeInteraction){
				FreeInteraction ev = (FreeInteraction) t.event;
				String vName = getVarName(ev.getVariable()) ;
				
				str += String.format("  match output %s(%s);\n", 
						ev.getOperationName(),
						getVarName2(ev.getVariable()) );
				str += String.format("  nextstate %s_;\n  endstate;\n", s.name);
				str += String.format("state %s_;\n", s.name);
				if (vName != ""){
					str += String.format("  provided %s = %s_1; \n",
							vName, vName);
				}
				str += String.format("  match input %s(%s);\n", 
						ev.getOperationName(),
						getVarName(ev.getVariable()));
			}else if (t.event instanceof Tick){
				str += "  match informal \"success\";\n";
			}
			str += String.format("  nextstate %s;\n", t.destination.name);
		}
		str += "endstate;\n";
		return  str;
	}
	
	String getVarName(Variable v){
		if (v != null)
			return v.getName();
		else return "";
	}
	
	String getVarName2(Variable v){
		if (v == null)
			return "";
		String s = "var " + v.getName() + "_1 INT;\n";
		if (additionalVars.contains(s) == false)
			additionalVars += s;
		return v.getName() + "_1";
	}
}
