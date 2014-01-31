package fr.lri.schora.stg;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


import fr.lri.schora.basicEvent.BasicEvent;
import fr.lri.schora.basicEvent.BasicEventFactory;
import fr.lri.schora.basicEvent.BoundEvent;
import fr.lri.schora.basicEvent.Event;
import fr.lri.schora.basicEvent.FreeEvent;
import fr.lri.schora.basicEvent.Tau;
import fr.lri.schora.basicEvent.parser.EventReader;
import fr.lri.schora.define.COMMUNICATION_MODEL;
import fr.lri.schora.solver.Z3SMT;
import fr.lri.schora.expr.BTrue;
import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.Variable;
import fr.lri.schora.expr.util.BoolExpression;
import fr.lri.schora.stg.dot.DOT;
import fr.lri.schora.stg.dot.parser.STGReader;
import fr.lri.schora.util.parser.ParserException;
import fr.lri.schora.util.parser.ParserToken;

public class STG{
	public String name;
	public List<State> states;
	public State initialState;
	public List<Transition> transitions;
	/**
	 * Set of free variables at each state
	 */
	public HashMap<State, Set<Variable>> freeVariables;
	
	public STG(){
		states = new ArrayList<State>();
		transitions = new ArrayList<Transition>();
		freeVariables = new HashMap<State, Set<Variable>>();
	}
	
	public STG(List<State> s, List<Transition> t){
		this.states = s;
		this.transitions = t;
		updateFreeVariableList();
	}
	
	/**
	 * Parse an STG from a DOT script
	 * @param script
	 * @return
	 * @throws fr.lri.schora.util.parser.ParserException
	 */
	public static STG parser(String script) throws fr.lri.schora.util.parser.ParserException{
		return STG.parser(script, 0, 0);
	}
	
	/**
	 * parse a script which is a paragraph in a document
	 * @param script
	 * @param shiftLine: beginLine of the paragraph
	 * @param shiftColumn: beginColumn of the paragraph
	 * @return
	 * @throws fr.lri.schora.util.parser.ParserException
	 */
	public static STG parser(String script, int shiftLine, int shiftColumn) throws fr.lri.schora.util.parser.ParserException{
		try{
			StringReader f = new StringReader(script);
			STGReader parser = new STGReader(f);
			DOT dot = parser.parser();
			STG stg = new STG();
			
			//create state
			stg.states = new ArrayList<State>();
			int n = dot.states.size();
			for (int i=0; i<n; i++){
				stg.states.add(new State(dot.states.get(i), dot.stateLabels.get(i)));
			}
			
			stg.initialState = stg.states.get(0);
			
			//create transition
			stg.transitions = new ArrayList<Transition>();
			n=dot.startStates.size();
			for (int i=0; i<n; i++){
				ParserToken label = dot.labels.get(i);
				int line = label.beginLine + shiftLine;
				int col  = label.beginColumn + shiftColumn;
				
				String str = dot.startStates.get(i);
				State ss = stg.getState(str);
				if (ss == null)
					throw new ParserException(line, str, "Not found state: " + str);
				str = dot.endStates.get(i);
				State se = stg.getState(str);
				if (se == null)
					throw new ParserException(line, str, "Line: " + line + ", not found state: " + str);
				
				str = label.script;
				Condition guard = ExprFactory.eINSTANCE.createBTrue();
				int d = 0;
				if (str.trim().startsWith("[")){	//has a guard
					d = str.indexOf("]");
					if (d < 0){						//the guard is not well-form
						List<String> expected = new ArrayList<String>();
						expected.add("]");
						throw new ParserException(line, 0, col, 0, "", expected);
					}
					String str1 = str.substring(1, d);
					guard = BoolExpression.parser(str1, line, col + label.script.indexOf("["));
					
					d ++;
					str = str.substring(d);		//event
				}
				
				Event event = EventReader.parser(str, line, col + d);
				
				stg.transitions.add(new Transition(ss, se, guard, event));
			}
			
			stg.updateFreeVariableList();
			return stg;
		}catch (fr.lri.schora.stg.dot.parser.ParseException ex){
			fr.lri.schora.stg.dot.parser.Token ct = ex.currentToken;
			java.util.List<String> expectedImages = new ArrayList<String>();
			for (int i=0; i< ex.expectedTokenSequences.length; i++){
				for (int j=0; j< ex.expectedTokenSequences[i].length; j++){
					expectedImages.add(ex.tokenImage[ex.expectedTokenSequences[i][j]]);
				}
			}
			throw new fr.lri.schora.util.parser.ParserException(ct.beginLine + shiftLine, ct.endLine + shiftLine, ct.beginColumn+shiftColumn, ct.endColumn+shiftColumn, ct.next.image, expectedImages);
		}
	}
	
	
	List<State> _visitedStates;
	/**
	 * update list of freevariables at each state
	 */
	public void updateFreeVariableList(){
		_visitedStates = new ArrayList<State>();
		getFreeVariables(initialState);
	}
	
	Set<Variable> getFreeVariables(State s){
		if (_visitedStates.contains(s)){
			if (freeVariables.containsKey(s))
				return freeVariables.get(s);
			else
				return new HashSet<Variable>();
		}
		
		_visitedStates.add(s);
		
		Set<Variable> lst = new HashSet<Variable>();
		List<Transition> trans = getOutgoingTransitions(s);

		for (Transition t : trans){
				lst.addAll(t.event.getFreeVariables());
				lst.addAll(t.guard.freeVariables());
				
				Set<Variable> list = getFreeVariables(t.destination);
				//list is a pointer which point to set of variables of the previous state
				//if we remove a variable x on "list" ==> set of variables of the previous state will remove also "x"
				//==> we need to create a new set
				list = new HashSet<Variable>(list);
				list.removeAll(t.event.getBoundVariables());
				
				lst.addAll(list);
		}
		
		List<Variable> set = new ArrayList<Variable>();
		for (Variable v : lst)
			if (!set.contains(v))
				set.add(v);
		
		freeVariables.put(s, new HashSet<Variable>(set));
		return lst;
	}
	
	/**
	 * add variables, which do not appear (exist a variable having same name) in lst, from lst2 to lst
	 * @param lst
	 * @param lst2
	 * @return
	 */
	List<Variable> _addVariable(List<Variable> lst, List<Variable> lst2){
		for (Variable v : lst2)
			if (lst.contains(v))
				continue;
			else
				lst.add(v);
		return lst;
	}
	List<Variable> _removeVariable(List<Variable> lst, List<Variable> lst2){
		for (Variable v : lst2)
			if (lst.contains(v))
				lst.remove(v);
		return lst;
	}
	
	
	/**
	 * @return list of role names taking part in this STG
	 */
	public List<String> getRoles(){
		List<String> lst = new ArrayList<String>();
		for (Transition t : transitions){
			if (t.event instanceof BasicEvent){
				BasicEvent e = (BasicEvent) t.event;
				if (!lst.contains(e.getSender()))
					lst.add(e.getSender());
				if (!lst.contains(e.getReceiver()))
					lst.add(e.getReceiver());
			}
		}
		Collections.sort(lst);
		return lst;
	}
	
	
	/**
	 * @param s : state
	 * @return list of role names participate in a part of this STG after state "s"
	 */
	public Set<String> getRoles(State s){
		_roles = new HashMap<State, Set<String>>();
		_getRoles(s);
		return _roles.get(s);
	}
	
	HashMap<State, Set<String>> _roles;
	Set<String> _getRoles(State s){
		Set<String> lst = new HashSet<String>();
		if (_roles.containsKey(s))
			return _roles.get(s);
		
		_roles.put(s, lst);
			
		List<Transition> trans = getOutgoingTransitions(s);
		for (Transition t : trans){
			if (t.event instanceof BasicEvent){
				BasicEvent be = (BasicEvent) t.event;
				lst.add(be.getSender());
				lst.add(be.getReceiver());
			}
			lst.addAll(_getRoles(t.destination));
		}
		return lst;
	}
	
	/**
	 * @param s
	 * @return List of outgoing transitions from state s
	 */
	public List<Transition> getOutgoingTransitions(State s){
		List<Transition> lst = new ArrayList<Transition>();
		for (Transition t : transitions)
			if (t.source.equals(s))
				lst.add(t);
		return lst;
	}
	
	/**
	 * Get a list of incoming transitions to state s
	 * @param s
	 * @return
	 */
	public List<Transition> getIncomingTransitions(State s){
		List<Transition> lst = new ArrayList<Transition>();
		for (Transition t : transitions)
			if (t.destination.equals(s))
				lst.add(t);
		return lst;
	}
	
	/**
	 * get a state with given name
	 * @param name
	 * @return null if not found else the sate which have the name
	 */
	public State getState(String name){
		for (State s : states){
			if (s.name.equals(name))
				return s;
		}
		return null;
	}
	

	public STG getReachableSTG(Z3SMT z3Solver){
		_ReachableSTG re = new _ReachableSTG(z3Solver);
		return re.getReachableSTG(this);
	}
	
	//
	_Projection proj = null;
	public STG getRealizableSTG(COMMUNICATION_MODEL com, Z3SMT z3Solver){
		if (proj == null){
			proj = new _Projection(this, z3Solver, com);
		}
		return proj.getRealizableSTG();
	}
	
	
	public HashMap<String, STG> projection(COMMUNICATION_MODEL com, Z3SMT z3Solver){
		if (proj == null){
			proj = new _Projection(this, z3Solver, com);
		}
		return proj.projection();
	}
	
	/**
	 * rename a variable on STG
	 * @param vfrom	 : variable to be renamed
	 * @param newName: new name of variable
	 * @param s		 : state from which variable will be renamed until end of STG
	 */
	public void renameVariable(String vfrom, String newName, State s){
		if (vfrom.equals(newName))
			return;
		_visitedStates = new ArrayList<State>();
		_renameVariable(vfrom, newName, s);
	}
	
	void _renameVariable(String vfrom, String newName, State s){
		if (_visitedStates.contains(s))
			return;
		_visitedStates.add(s);
		List<Transition> trans = getOutgoingTransitions(s);
		for (Transition t : trans){
			//change variable name on guard
			List<Variable> vars = t.guard.variables();
			for (Variable v : vars)
				if (v.getName().equals(vfrom))
					v.setName(newName);
			
			//change variable name on event 
			if (t.event instanceof BasicEvent){
				BasicEvent e = (BasicEvent) t.event;
				if (e.getVariable() != null && e.getVariable().equals(vfrom))
					e.getVariable().setName(newName);
			}
			_renameVariable(vfrom, newName, t.destination);
		}
	}
	
	/**
	 * clone "states" and "transitions" of stg<br>
	 * the "guard" and "event" of each transition are not cloned
	 */
	public STG clone(){
		STG stg = new STG();
		stg.name = name;
		for (State s: states){
			stg.states.add(new State(s.name, s.label));
		}
		stg.initialState = stg.getState(initialState.name);
		
		for (Transition t : transitions)
			stg.transitions.add(new Transition(stg.getState(t.source.name), 
					stg.getState(t.destination.name), t.guard.clone(), t.event));
		return stg;
	}
	
	/**
	 * @return DOT format of this STG
	 */
	public String toDotFormat(){
		HashMap<String, String> nodes = new HashMap<String, String>();

		String dotScript = "";
		dotScript += "\n digraph "+ name +"{";
		dotScript += "\n 	rankdir = LR;";
		dotScript += "\n 	nodesep = 0.5;";
		dotScript += "\n 	margin = 0.2;";
		dotScript += "\n 	node [ fontname=Arial, fontcolor=blue, fontsize=11];";
		dotScript += "\n 	edge [ fontname=Helvetica, fontcolor=black, fontsize=10 ];";
		
		//initState
		dotScript += "\n 	node [shape = circle, style=filled, width=0.2, fixedsize=true, fillcolor=gray, fontcolor=blue];";
		nodes.put(initialState.name, "1");
		
		SortedSet<String> keys = new TreeSet<String>();
		Set<Variable> lst = freeVariables.get(initialState);
		for (Variable v : lst)
			keys.add(v.getName());
				
		dotScript += "\n 	1 [label=\"\\n " + initialState.label + "\\n{" + fr.lri.schora.util.List.toString(new ArrayList<String>(keys), ",") + "}\"];";
		
		
		dotScript += "\n    node [shape = circle, style=solid, width=0.2, fixedsize=true, fontcolor=blue];";
		int i = 1;
		for (State s : states) {
			if (s.equals(initialState))
				continue;
			String str = String.format("%d", ++i);
			nodes.put(s.name, str);
			
			lst = freeVariables.get(s);
			keys.clear();
			if (lst != null)
			for (Variable v : lst)
				keys.add(v.getName());
			if (s.label == null)
				s.label = "-";
			
			dotScript += "\n   " + str + " [label=\" \\n " + s.label+ "\\n{" + fr.lri.schora.util.List.toString(new ArrayList<String>(keys), ",") + "}\"];";
		}

		dotScript += "\n";

		String label;
		if (transitions != null)
		for (Transition t : transitions) {
			Condition b = t.guard;

			label = "";
			if ((!(b instanceof BTrue)) && (b != null)) {
					label = "[" + b.toString() + "] ";
			}

			if (t.event != null) {
					label += t.event.toDotFormat();
			}
			
			dotScript += "\n " + nodes.get(t.source.name) + "->"
					+ nodes.get(t.destination.name) + 
					"  [label=\"" + label + "\"];";
		}
		dotScript += "\n }";

		return dotScript;
	}
	
	
	public String stat(){
		int nRoles  = getRoles().size();
		int nStates = states.size();
		int nTrans  = transitions.size();
		Set<String> lst = new HashSet<String>();
		for (Transition t : transitions){
			if (t.event instanceof BasicEvent){
				BasicEvent ev = (BasicEvent) t.event;
				lst.add(String.format("%s[%s,%s]", ev.getOperationName(), ev.getSender(), ev.getReceiver()));
			}else{
				lst.add(t.event.toString());
			}
		}
		return String.format("  - number of roles      : %d\n" +
				             "  - number of operations : %d\n" +
				             "  - number of states     : %d\n" +
				             "  - number of transitions: %d", nRoles, lst.size(), nStates, nTrans);
	}
	
	public String toString(){
		return toDotFormat();
	}

	private List<State> visitedState;
	private State stateSource;
	
	/**
	 * get a list of tauStar transitions from <b>stateSource</b>
	 * @param stateSource
	 * @return
	 */
	public List<Transition> getOutgoingTauStarTransitions(State stateSource) {
		visitedState = new BasicEList<State>();
		this.stateSource = stateSource;
		return _getOutgoingTauStarTransitions(stateSource, ExprFactory.eINSTANCE.createBTrue());
	}
	
	private List<Transition> _getOutgoingTauStarTransitions(State state, Condition guard) {
		
		if (visitedState.contains(state))		//remove a tau loop
			return new BasicEList<Transition>();
		
		visitedState.add(state);
		
		
		List<Transition> transLst = this.getOutgoingTransitions(state);
		List<Transition> tauStarLst = new BasicEList<Transition>();
		for(Transition trans:transLst){
			if (!(trans.event instanceof Tau))
				continue;	
			
				//Create a new tauStar Transition
			Transition tt = new Transition(stateSource, trans.destination, BoolExpression.createAnd(guard, trans.guard), BasicEventFactory.eINSTANCE.createTau());
			
			List<Transition> lst = _getOutgoingTauStarTransitions(tt.destination, tt.guard);
			if (lst.size() == 0)
				tauStarLst.add(tt);
			else
				tauStarLst.addAll(lst);
		}
		return tauStarLst;	
	}

	public List<State> getStates() {
		return states;
	}

	public void setInitialState(State s) {
		initialState = s;
	}

	public State getInitialState() {
		return initialState;
	}

	public void setName(String str) {
		name = str;
	}
	
	public String getName(){
		return name;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}
}
