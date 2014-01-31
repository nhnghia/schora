package fr.lri.schora.stg;

import java.util.ArrayList;
import java.util.List;


import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.Variable;
import fr.lri.schora.expr.util.BoolExpression;
import fr.lri.schora.basicEvent.*;



/**
 * 
 * @author nhnghia
 * Product n STSs
 */

public class Production {

	private STG sTG;
	private List<String> visitedStates;
	/**
	 * Product two STG
	 * @param stg1
	 * @param stg2
	 * @return
	 */
	public STG product(List<STG> stgs){
		if (stgs == null)
			return null;
		
		List<STG> stgss = new ArrayList<STG>();
		for (STG s : stgs)
			stgss.add(s.clone());
		stgs = stgss;
		
		sTG = new STG();
		visitedStates = new ArrayList<String>();
		
		String str = "";
		for (STG s : stgs){
			str += "||" + s.getName();
		}
		if (str != "")
			str = str.substring(2);
		sTG.setName(str);
		
		int n = stgs.size();
		State[] states = new State[n];
		STG[] stgg = new STG[n];
		stgg = stgs.toArray(stgg);
		
		
		for (int i=0; i<n; i++){
			states[i] = stgg[i].getInitialState();
		}
		
		State s = createState(states);
		
		sTG.setInitialState(s);
		sTG.getStates().add(s);
		
		product(stgg, states, s);
		
		//Delete the freeVariables do not use.
		//(1-x)---c.x--->(2) and (1)---c?y--->(2) 
		//after production, (1.1)---c.y--->(2.2)
		//so freeVariable x does not need.
		sTG.updateFreeVariableList();
		
		List<State> lst1 = sTG.getStates();
		for (State ss : lst1){
			ss.label = ss.name;
		}
		return sTG;
	}


	
	private void product(STG[] stgs, State[] states, State source){

		if (visitedStates.contains(source.getName()))
			return;
		
		visitedStates.add(source.getName());
		
		int n=stgs.length;
		List<Transition> trans[] = new List[n];
		for (int i=0; i<n; i++){
			trans[i] = stgs[i].getOutgoingTransitions(states[i]);
		}
		
		//Two states are leaves (finish states)
		/*boolean isLeaf = true;
		for (int i=0; i<n; i++)
			if (trans[i].size() > 0)
				isLeaf = false;
		
		if (isLeaf)	//these exist at less a leaf (no outgoing transition)
			return;
		*/
		
		//Change EList to Array
		Transition[][] trs = new Transition[n][];
		
		int tickIndex[] = new int[n];
		for (int i=0; i<n; i++){
			tickIndex[i] = 0;
			int j=0;
			trs[i] = new Transition[trans[i].size()];
			for (Transition t : trans[i])
				trs[i][j++] = t;
		}

		//find tick
		boolean foundTick = true;
		while(foundTick){
			State[] ss = new State[states.length];
			Condition guard = ExprFactory.eINSTANCE.createBTrue();
			for (int i=0; i<n; i++){
				boolean hasTick = false;
				for (int j=tickIndex[i]; j<trs[i].length; j++){
					tickIndex[i] ++;
					if (trs[i][j].getEvent() instanceof fr.lri.schora.basicEvent.Tick){
						hasTick = true;
						ss[i] = trs[i][j].destination;
						guard = BoolExpression.createAnd(guard, trs[i][j].getGuard());
						break;
					}
				}
				
				if (!hasTick){	//a state
					foundTick = false;
					break;
				}
			}
			
			if (foundTick){
				State target = createState(ss);
				createTick(guard, source, target);
			}
		}
		
		
		// for each state
		for (int i = 0; i < (n - 1); i++) {
			for (Transition t1 : trans[i]) { // for each possible transition
												// from current state
				Event a1 = t1.getEvent();
				if (a1 instanceof Tick)
					continue;
				
				// now we compare t with other
				for (int j = i+1; j < n; j++) {
					for (Transition t2 : trans[j]) {
						Event a2 = t2.getEvent();

						if ((a1 instanceof BasicEvent)
								&& (a2 instanceof BasicEvent)) {
							BasicEvent com1 = (BasicEvent) a1;
							BasicEvent com2 = (BasicEvent) a2;

							// two actions can be synchronized
							if (canBeSync(com1, com2)) {
								State[] ss = states.clone();
								ss[i] = t1.destination;
								ss[j] = t2.destination;

								State target = createState(ss);
								createInteraction(t1, t2, source, target, stgs[i], stgs[j]);

								product(stgs, ss, target);
							}
						}
					}
				}
			}
		}

		
	}

	private boolean canBeSync(BasicEvent com1, BasicEvent com2) {
		if ((com1 instanceof Reception && (com2 instanceof FreeSending || com2 instanceof BoundSending))
				|| (com2 instanceof Reception && (com1 instanceof FreeSending || com1 instanceof BoundSending))){
			BasicEvent c1 = (BasicEvent) com1;
			BasicEvent c2 = (BasicEvent) com2;
			return (c1.getOperationName().equalsIgnoreCase(c2.getOperationName())
					&& c1.getSender().equalsIgnoreCase(c2.getSender())
					&& c1.getReceiver().equalsIgnoreCase(c2.getReceiver()));
		}
		return false;
	}



	private void createInteraction(Transition t1, Transition t2, State source, State target, STG stg1, STG stg2){
		BasicEvent com1 = (BasicEvent) t1.getEvent();
		BasicEvent com2 = (BasicEvent) t2.getEvent();
		
		GlobalEvent com = BasicEventFactory.eINSTANCE.createBoundInteraction();
		if (com1 instanceof FreeSending || com2 instanceof FreeSending)
			com = BasicEventFactory.eINSTANCE.createFreeInteraction();
		
		String channel = com1.getOperationName();

		com.setOperationName(channel);
		com.setSender(com1.getSender());
		com.setReceiver(com1.getReceiver());
		
		Variable var = null;
		if (com1.getVariable() != null && (com1 instanceof FreeSending || com1 instanceof BoundSending))
			var = com1.getVariable();
		if (var == null)
			if (com2.getVariable() != null && (com2 instanceof FreeSending || com2 instanceof BoundSending))
				var = com2.getVariable();
		
		if (var != null)
			com.setVariable(cloneVariable(var));
		
		//rename variable on com2 and stg2
		Variable rVar = null;
		if (com1 instanceof Reception)
			rVar = com1.getVariable();
		else if (com2 instanceof Reception)
			rVar = com2.getVariable();
		
		if (rVar != null && var != null)
			stg2.renameVariable(rVar.getName(), var.getName(), t2.source);
		
		target = getLoopState(target);	//Whether a loop
		//target.getFreeVars().add(var);
		//if (com2.getVariable() != null && isContain(target.getFreeVars(), com2.getVariable()) == false) 
		//	target.getFreeVars().add(cloneVariable(com2.getVariable()));
		
		Condition con = BoolExpression.createAnd(t1.getGuard(), t2.getGuard());
		
		Transition t = new Transition(source, target, con, com); 
		sTG.getTransitions().add(t);
	}
	
	private void createTick(Condition guard, State source, State target){
		target = getLoopState(target);
		Transition t = new Transition(source, target, guard, BasicEventFactory.eINSTANCE.createTick()) ;
		sTG.getTransitions().add(t);
	}
	
	private State createState(State[] states){
		String name = "";
		String terms = "";
		List<Variable> vars = new ArrayList<Variable>();
		
		int n = states.length;
		for (int i=0; i<n; i++){
			name += "." + states[i].getName();
			terms += " || (" + states[i].label + ")";
			/*List<Variable> vs = states[i].getFreeVars();
			for (Variable v : vs)
				if (!isContain(vars, v))
					vars.add(cloneVariable(v));
			*/
		}
		
		if (name != "")
			name = name.substring(1);
		if (terms != "")
			terms = terms.substring(3);
		
		State s = new State(name);
		s.label = terms;
		//s.getFreeVars().addAll(vars);
		return s;
	}
	
	private State getLoopState(State s){
		List<State> states = sTG.getStates();
		for (State ss: states)
			if (ss.label.equals(s.label) && ss.getName().equals(s.getName()))
				return ss;
		
		sTG.getStates().add(s);
		return s;
	}
	
	private Variable cloneVariable(Variable v){
		Variable var = ExprFactory.eINSTANCE.createVariable();
		var.setName(v.getName());
		return var;
	}
	
	private boolean isContain(List<Variable> lst, Variable var){
		for (Variable v : lst)
			if (v.equals(var))
				return true;
		return false;
	}
}
