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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.lri.schora.basicEvent.BasicEvent;
import fr.lri.schora.basicEvent.BasicEventFactory;
import fr.lri.schora.basicEvent.BoundEvent;
import fr.lri.schora.basicEvent.BoundInteraction;
import fr.lri.schora.basicEvent.Event;
import fr.lri.schora.basicEvent.FreeInteraction;
import fr.lri.schora.basicEvent.GlobalEvent;
import fr.lri.schora.basicEvent.Tick;
import fr.lri.schora.define.COMMUNICATION_MODEL;
import fr.lri.schora.solver.Z3SMT;
import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.Variable;
import fr.lri.schora.expr.util.BoolExpression;

class _Projection {
	
	COMMUNICATION_MODEL comModel;
	
	static int extraStateIndex;
	static State createExtraState(){
		String str = String.format("_%d", ++extraStateIndex);
		return new State(str, str);
	}
	
	_FirstEventOfRole firstEvent;
	List<AddInteraction> addIntersLst;
	
	Boolean isRealizable;
	public _Projection(STG s, Z3SMT z3, COMMUNICATION_MODEL com){
		this.stg = s.getReachableSTG(z3);
		this.z3 = z3;
		addIntersLst = new ArrayList<_Projection.AddInteraction>();
		
		roles = stg.getRoles();
		comModel = com;
		extraStateIndex = 0;	//using to create extra states
		
		firstEvent = new _FirstEventOfRole(this.stg);
		isRealizable = false;
	}
	
	Z3SMT z3;
	STG stg;
	HashMap<String, STG> localSTGs;
	List<String> roles;
	/**
	 * project stg on each local role
	 * @return list of STG corresponding with role set of stg
	 */
	public HashMap<String,STG> projection(){
		localSTGs = new HashMap<String, STG>(roles.size());
		
		conFac = ExprFactory.eINSTANCE;
		
		makeRealizableSTG();
		
		firstEvent = new _FirstEventOfRole(this.stg);
		
		for (String r : roles)
			localSTGs.put(r, projectionSTGOnRole(r));
		
		return localSTGs;
	}
	
	public STG getRealizableSTG(){
		makeRealizableSTG();
		stg.updateFreeVariableList();
		return stg;
	}
	
	STG projectionSTGOnRole(String role){
		STG localSTG = new STG();
		localSTG.initialState = stg.initialState;
		localSTG.name = stg.name + "_" + role;
		
		visitedStates = new ArrayList<State>();
		_projection(null, localSTG.initialState, localSTG.initialState, role, localSTG);
		
		_ReduireTau rd = new _ReduireTau(localSTG);
		localSTG = rd.reduire();
		
		localSTG.updateFreeVariableList();
		return localSTG;
	}
	List<Transition> conditionalBranchLst;	//List of transitions which are in conditional branching
	/**
	 * 
	 * @param lastEvent
	 * @param lastState: last state of tau transition
	 * @param currentState: the state is currently visited
	 * @param role
	 * @param localSTG
	 */
	void _projection(Event lastEvent, State lastState, State currentState, String role, STG localSTG){
		if (visitedStates.contains(currentState))
			return;
		visitedStates.add(currentState);
		List<Transition> trans = stg.getOutgoingTransitions(currentState);
		
		for (Transition t : trans){
			boolean isConditional = conditionalBranchLst.contains(t);
			State newLastState = lastState;
			Event e = projection(t.event, role);
			{
				Transition tt;
				if (!isConditional && t.event instanceof BasicEvent && 
						role.equals(((BasicEvent) t.event).getReceiver()))
					tt = new Transition(lastState, t.destination,  e);
				else{
					if (firstEvent.isFirstEventsOfRoleIsReceiverAfterState(role, currentState))
						tt = new Transition(lastState, t.destination,  e);
					else
						tt = new Transition(lastState, t.destination, t.guard, e);
				}
				localSTG.transitions.add(tt);
				if (!localSTG.states.contains(tt.source))
					localSTG.states.add(tt.source);
				if (!localSTG.states.contains(tt.destination))
					localSTG.states.add(tt.destination);
				
				newLastState = tt.destination;
			}
			_projection(e, newLastState, t.destination, role, localSTG);
		}
	}
	
	ExprFactory conFac;
	List<State> visitedStates;
	
	/**
	 * make STG become realizable
	 */
	void makeRealizableSTG(){
		if (isRealizable)
			return;
		isRealizable = true;
		
		addIntersLst = new ArrayList<_Projection.AddInteraction>();
		
		conditionalBranchLst = new ArrayList<Transition>();
		
		//owner and causality are checked before branching
		//since we have "conditional branching" when 
		// - all participants of a branching know their guards (no AddInteraction for "owner") 
		// - and this branching satisfies the "causality" (no AddInteraction for "causality") 
		visitedStates = new ArrayList<State>();
		
		//variable --> list of role names
		HashMap<String, List<String>> owners = new HashMap<String, List<String>>();
		List<String> lst = getRoles(stg.getOutgoingTransitions(stg.initialState));
		
		Set<Variable> vars = stg.getFreeVariables(stg.initialState);
		for(Variable v : vars){
			owners.put(v.getName(), lst);
		}
		correctDataOwner(owners, stg.initialState);
		
		visitedStates = new ArrayList<State>();
		correctBranching(stg.initialState);
		
		removeDuplicateAddInteractions();
		//Now add these AddInteraction to STG
		for (AddInteraction inter : addIntersLst)
			inter.addThisTransitionToSTG(stg);
		
		addIntersLst = new ArrayList<_Projection.AddInteraction>();
		//check causality again, since it may be loss by some additional interactions
		visitedStates = new ArrayList<State>();
		correctCausality(null, stg.initialState);
		
		for (AddInteraction inter : addIntersLst)
			inter.addThisTransitionToSTG(stg);
	}

	void removeDuplicateAddInteractions(){
		//remove duplicates if any
		ArrayList<AddInteraction> l2 = new ArrayList<AddInteraction>();

		Iterator<AddInteraction> iterator = addIntersLst.iterator();
        while (iterator.hasNext())
        {
        	AddInteraction o = iterator.next();
            if(!l2.contains(o)) 
            	l2.add(o);
        }
        addIntersLst = l2;
	}
	
	/**
	 * each free variable must be known by its owner before using (freeInteraction/guard)
	 * @param owners : at the current state "s", a variable "x" is known by a set of roles
	 * @param s : the state is currently visited
	 */
	void correctDataOwner(HashMap<String, List<String>> owners, State s){
		if (visitedStates.contains(s))
			return;
		visitedStates.add(s);
		
		List<AddInteraction> addLst = new ArrayList<_Projection.AddInteraction>();
		
		List<Transition> trans = stg.getOutgoingTransitions(s);
		for (Transition t: trans){
			if (!(t.event instanceof BasicEvent))
				continue;
			BasicEvent ev = (BasicEvent) t.event;
			
			Set<Variable> vars = new HashSet<Variable>(t.guard.freeVariables());
			
			
			for (Variable v : vars){
				List<String> lst = owners.get(v.getName());
				if (lst != null && lst.contains(ev.getReceiver()))
					continue;	//OK, variable is known
				
				if (firstEvent.isFirstEventsOfRoleIsReceiverAfterState(ev.getReceiver(), s))
					break;
				
				//Add transitions
				//in the case of conditional branching, the guard also exist at receiver
				AddInteraction iter = new AddInteraction(t);
				iter.eventName = "+cbr";
				iter.senders = lst;
				iter.receivers.add(ev.getReceiver());
				iter.variable = v;
				iter.isAddOnlyForConditionalBranching = true;
				addLst.add(iter);
			}
			
			vars.addAll(ev.getFreeVariables());
			for (Variable v : vars){
				if (v == null)
					continue;
				List<String> lst = owners.get(v.getName());
				if (lst != null && lst.contains(ev.getSender()))
					continue;	//OK, variable is known
				
				//Add transitions
				AddInteraction iter = new AddInteraction(t);
				iter.eventName = "+data";
				iter.senders = lst;
				iter.receivers.add(ev.getSender());
				iter.variable = v;
				addLst.add(iter);
			}
			
			addLst = _sortAddInteractionLst(addLst, ev);
			
			/*
			//Add aditional interactions to the "stg"
			if (addLst.size() > 0){	//we have to add some transitions
				for (AddInteraction adInter : addLst){
					adInter.addThisTransitionToSTG(stg);
				}
			}
			*/
			
			HashMap<String, List<String>> newOwners = new HashMap<String, List<String>>();
			newOwners.putAll(owners);
			// now, after adding AddInteraction, the sender knows the variable
			List<String> lst = new ArrayList<String>();
			lst.add(ev.getSender());
			for (AddInteraction iter : addLst){
				_updateNewRolesknownVariable(iter.variable, lst, newOwners);
			}
			
			// if "ev" is a boundEvent ==> after this event, only its sender and receiver know the bound variable of "ev"
			if (ev instanceof BoundEvent){
				lst = new ArrayList<String>();
				lst.add(ev.getReceiver());
				lst.add(ev.getSender());
				newOwners.put(ev.getVariable().getName(), lst);
			}else if (ev instanceof FreeInteraction){
				//the receiver knows also the variable
				lst = new ArrayList<String>();
				lst.add(ev.getReceiver());
				_updateNewRolesknownVariable(ev.getVariable(), lst, newOwners);
			}
			
			correctDataOwner(newOwners, t.destination);
		}
		addIntersLst.addAll(addLst);
	}
	
	
	List<AddInteraction> _sortAddInteractionLst(List<AddInteraction> addLst, BasicEvent last){
		//change order of AddInteraction of "addLst" such that the last one concerns to the next events (if it's possible)
		try{
			int n = addLst.size();
			if (n>1){
				String s2 = last.getSender();
				String r2 = last.getReceiver();
				List<String> lst = new ArrayList<String>();		//this is just used in condition;
				search:
				for (int i=0; i<n; i++){
					AddInteraction inter = addLst.get(i);
					for (String s1 : inter.senders)
						for (String r1 : inter.receivers)
							if (!isNeedExtraInteraction(s1, r1, s2, r2, lst, lst)){
								//change this AddInter to last position;
								AddInteraction tmp = addLst.get(n-1);
								addLst.set(i, tmp);
								addLst.set(n-1, inter);
								break search;
							}
				}
				
				//change two consecutive AddInteractions respect ASYNC_DISJOINT (the strongest) ==> no need AddInteraction for causality
				if (comModel != COMMUNICATION_MODEL.SYNC){
					AddInteraction tmp = addLst.get(0);
					for (int i=1; i<n; i++){
						addLst.get(i).senders = tmp.receivers;
						tmp = addLst.get(i);
					}
				}
			}
			return addLst;
		}catch (Exception ex){
			return addLst;
		}
	}
	
	/**
	 * update set of "roles" which know the variable "v"
	 * @param v
	 * @param roles
	 * @param owners
	 * @return
	 */
	void _updateNewRolesknownVariable(Variable v, List<String> roles, HashMap<String, List<String>> owners){
		if (v == null)
			return;
		List<String> lst = owners.get(v.getName());
		if (lst == null)
			lst = new ArrayList<String>();
		lst.addAll(roles);
		owners.put(v.getName(), lst);
	}
	
	/**
	 * correct the causality of two consecutive events
	 * @param s
	 */
	void correctCausality(Event lastEvent, State s){
		if (visitedStates.contains(s))
			return;
		visitedStates.add(s);
		
		List<Transition> trans = stg.getOutgoingTransitions(s);
		for (Transition t: trans){
			if (lastEvent != null){ 	//not is initialstate
				List<AddInteraction> lst = getAddInteractionOrder(lastEvent, t);
				/*
				if (lst.size() > 0){	//we have to add some transitions
					for (AddInteraction adInter : lst){
						adInter.addThisTransitionToSTG(stg);
					}
				}
				*/
				addIntersLst.addAll(lst);
			}
			correctCausality(t.event, t.destination);
		}
	}
	
	
	_STGDataOwner dataOwners;
	/**
	 * verify whether a state, which has outgoing transitions lst, is conditional branching 
	 * @param lst
	 * @return
	 */
	boolean isConditionalBranching(List<Transition> lst){
		if (! iGuardsExclusive(lst))
			return false;
		
		//"addIntersLst" is determined by checking the "causality" before
		for (AddInteraction inter : addIntersLst)
			if (inter.variable == null)		//the dataOwner is traited after
				if (lst.contains(inter.transition))	//there exist one transition we must add a new AddInteraction
					return false;
		
		for (AddInteraction inter : addIntersLst)
			if (inter.variable != null)		//the dataOwner is traited after
				if (lst.contains(inter.transition)){
					inter.addForConditionalBranching = true;
				}
		
		conditionalBranchLst.add(lst.get(0));
		return true;
	}
	
	
	boolean iGuardsExclusive(List<Transition> lst){
		int n = lst.size();
		Condition c = ExprFactory.eINSTANCE.createBTrue();
		for (int i=0; i<n; i++)
				 c = BoolExpression.createAnd(lst.get(i).guard, c);
		if (z3.assertFalse(c))
			return true;
		return false;
	}
	
	/**
	 * Get list of receivers that appear in STG from the transition t
	 * @param t
	 * @return
	 */
	Set<String> getReceivers(Transition t){
		_visitedTrans = new ArrayList<Transition>();
		return _getReceivers(t, stg);
	}
	
	Set<String> _getReceivers(Transition t, STG s){
		Set<String> lst = new HashSet<String>();
		if (_visitedTrans.contains(t)){
			return lst;
		}
		_visitedTrans.add(t);
		
		lst.add(getReceiver(t.event));
		List<Transition> trans = s.getOutgoingTransitions(t.destination);
		for (Transition tt : trans){
			lst.addAll(_getReceivers(tt, s));
		}
		return lst;
	}
	
	/**
	 * get list of senders & receivers that appear in STG from the transition t
	 * @param t
	 * @param s
	 * @return
	 */
	List<Transition> _visitedTrans;
	Set<String> getRoles(Transition t){
		_visitedTrans = new ArrayList<Transition>();
		return _getRoles(t, stg);
	}
	Set<String> _getRoles(Transition t, STG s){
		Set<String> lst = new HashSet<String>();
		if (_visitedTrans.contains(t)){
			return lst;
		}
		_visitedTrans.add(t);
		
		lst.add(getReceiver(t.event));
		lst.add(getSender(t.event));
		List<Transition> trans = s.getOutgoingTransitions(t.destination);
		for (Transition tt : trans){
			lst.addAll(_getRoles(tt, s));
		}
		return lst;
	}
	
	/**
	 * Get list of roles that participate in a list of transitions
	 * @param trans
	 * @return
	 */
	List<String> getRoles(List<Transition> trans){
		List<String> lst = new ArrayList<String>();
		for (Transition t : trans){
			if (t.event instanceof BasicEvent){
				BasicEvent v = (BasicEvent) t.event;
				String str = v.getReceiver();
				if (!lst.contains(str)){
					lst.add(str);
				}
				str = v.getSender();
				if (!lst.contains(str)){
					lst.add(str);
				}
			}
		}
		return lst;
	}
	
	String getReceiver(Event e){
		if (e instanceof BasicEvent){
			return ((BasicEvent) e).getReceiver();
		}
		return null;
	}
	
	String getSender(Event e){
		if (e instanceof BasicEvent){
			return ((BasicEvent) e).getSender();
		}
		return null;
	}
	
	void correctBranching(State s){
		if (visitedStates.contains(s))
			return;
		visitedStates.add(s);
		
		List<Transition> trans = stg.getOutgoingTransitions(s);
		if (trans.size() <= 1){
			//return new ArrayList<_Projection.AddInteraction>();
		}else if (isConditionalBranching(trans)){
			
		}else{
			List<AddInteraction> lst = getAddInteractionUnconditionalBranching(trans);
			/*if (lst.size() > 0){	//we have to add some transitions
				for (AddInteraction adInter : lst){
					adInter.addThisTransitionToSTG(stg);
				}
			}
			*/
			addIntersLst.addAll(lst);
		}
		
		for (Transition t : trans){
			correctBranching(t.destination);
		}
	}
	
	/**
	 * return a list of additional interactions from the dominant role to other roles which does not appear in "trans" 
	 * @param trans
	 * @return
	 */
	List<AddInteraction> getAddInteractionUnconditionalBranching(List<Transition> trans){
		String dominantRole = getDominantRole(trans);
		List<String> roles = stg.getRoles();
		Collections.sort(roles, Collections.reverseOrder());
		
		List<AddInteraction> lst = new ArrayList<_Projection.AddInteraction>();
		
		//the roles (sender+receiver) appear after Transition t
		Set<String> subRoles = new HashSet<String>();
		for (Transition t : trans){
			subRoles.addAll(getRoles(t));
		}
		
		int index = 0;
		for (Transition t : trans){
			if (!(t.event instanceof GlobalEvent))
				continue;
			GlobalEvent ge = (GlobalEvent) t.event;
			index ++;
			List<AddInteraction> addLst = new ArrayList<_Projection.AddInteraction>();
			
			Set<String> receivers = getReceivers(t);
			for (String r : roles){
				//this role is terminated, it does not participate the choreography any more
				if (subRoles.contains(r) == false)
					continue;
				
				if (r.equals(dominantRole))	//it does not send to itself 
					continue;
				
				//no need to create a new AddInter if there exist one interaction from dominant to it
				if ((ge.getSender().equals(dominantRole) && ge.getReceiver().equals(r))){
					continue;
				}
				
				//if it will know this branch (in the future) by receiving the signal from other roles 
				if (receivers.contains(r)){
					continue;
				}
				
				AddInteraction inter = new AddInteraction(t);
				inter.senders.add(dominantRole);
				inter.receivers.add(r);
				inter.eventName = "+br" + index;
				addLst.add(inter);
			}
			addLst = _sortAddInteractionLst(addLst, ge);
			lst.addAll(addLst);
		}
		return lst;
	}
	
	/**
	 * @param trans
	 * @return a role which most frequently appear in "trans"
	 */
	String getDominantRole(List<Transition> trans){
		//find dominant role
		ArrayList<String> roles = new ArrayList<String>();
		int counts[] = new int[trans.size()];
		for (int i=0; i<counts.length; i++)
			counts[i] = 0;
		
		for (Transition t : trans){
			if (t.event instanceof BasicEvent){
				BasicEvent v = (BasicEvent) t.event;
				String str = v.getSender();
				if (!roles.contains(str)){
					roles.add(str);
				}
				
				int i = roles.indexOf(str);
				counts[i] ++;
			}
		}
		
		//find max element in "counts"
		int max = 0, j=0;
		for (int i=0; i<counts.length; i++){
			if (counts[i] > max){
				max = counts[i];
				j = i;
			}
		}
		if (roles.size() == 0)
			return null;
		
		//OK, I found it
		String dominantRole = roles.get(j);
		return dominantRole;
	}
	
	
	List<AddInteraction> getAddInteractionConditionalBranching(List<Transition> trans){
		return null;
	}
	
	/**
	 * the additional interactions having to add in order to ensure the causality between "event" and "nextEvent"
	 * This depends on the communication model 
	 * @param event
	 * @param nextEvent
	 * @return
	 */
	List<AddInteraction> getAddInteractionOrder(Event event, Transition tran){
		List<AddInteraction> lst = new ArrayList<_Projection.AddInteraction>();
		Event nextEvent = tran.event;
		if (!(event instanceof BasicEvent) || !(nextEvent instanceof BasicEvent))
			return lst;
		
		String s1 = ((BasicEvent) event)    .getSender();
		String s2 = ((BasicEvent) nextEvent).getSender();
		String r1 = ((BasicEvent) event)    .getReceiver();
		String r2 = ((BasicEvent) nextEvent).getReceiver();
		
		AddInteraction addInter = new AddInteraction(tran);
		addInter.eventName = "+ord";
		
		if (isNeedExtraInteraction(s1, r1, s2, r2, addInter.senders, addInter.receivers)){
			lst.add(addInter);
		}
		
		return lst;
	}
	
	boolean isNeedExtraInteraction(String s1, String r1, String s2, String r2, List<String>senders, List<String> receivers){
		switch (comModel){
		case SYNC:
			if (s1.equals(s2) == false 
				&& s1.equals(r2) == false
				&& r1.equals(s2) == false
				&& r1.equals(r2) == false){
				senders.add(s1);
				senders.add(r1);
				receivers.add(s2);
				receivers.add(r2);
				return true;
			}
			break;
		case ASYNC_SENDER:
			if (s1.equals(s2) == false && r1.equals(s2) == false){
				senders.add(s1);
				senders.add(r1);
				receivers.add(s2);
				return true;
			}
			break;
		case ASYNC_RECEIVER:
			if (r1.equals(s2) == false && r1.equals(r2) == false){
				senders.add(r1);
				receivers.add(r2);
				receivers.add(s2);
				return true;
			}
			break;
		case ASYNC_DISJOINT:
			if (r1.equals(s2) == false){
				senders.add(r1);
				receivers.add(s2);
				return true;
			}
			break;
		};
		return false;
	}
	
	/**
	 * natural projection of event "e" on role "roleId"
	 * @param e
	 * @param roleId
	 * @return
	 */
	public Event projection (Event e, String roleId){
		BasicEventFactory fac = BasicEventFactory.eINSTANCE; 
		if (e instanceof GlobalEvent){
			GlobalEvent ge = (GlobalEvent) e;
			
			BasicEvent be = null;
			if (roleId.equals(ge.getSender())){
				if (e instanceof BoundInteraction){
					be = fac.createBoundSending();
				}else{
					be = fac.createFreeSending();
				}
			}else if (roleId.equals(ge.getReceiver())){
				be = fac.createReception();
			}
			if (be != null){
				be.setSender(ge.getSender());
				be.setReceiver(ge.getReceiver());
				be.setOperationName(ge.getOperationName());
				if (ge.getVariable() != null){
					Variable v = ExprFactory.eINSTANCE.createVariable();
					v.setName(ge.getVariable().getName());
					be.setVariable(v);
				}
				return be;
			}
		}
		if (e instanceof Tick)
			return e;
		
		return fac.createTau();
	}
	
	
	/**
	 * the original "transition": s --[guard] event---> s1 <br>
	 * we will add a new transition as following: s --[true] e---> s' ---- [guard] event ---> s1 <br>
	 * with event "e" is a GlobalEvent from one of "senders" to one of "receivers" 
	 * @author nhnghia
	 */
	class AddInteraction{
		public List<String> senders;
		public List<String> receivers;
		public Transition transition;	
		public Variable variable;
		public String eventName;
		
		public boolean addForConditionalBranching;
		public boolean isAddOnlyForConditionalBranching;
		
		public AddInteraction(Transition t){
			senders = new ArrayList<String>();
			receivers = new ArrayList<String>();
			transition = t;
			variable = null;
			
			addForConditionalBranching = false;
			isAddOnlyForConditionalBranching = false;
		}
		
		/**
		 * create a freeInteraction with sender/receiver is the first element of "senders"/"receivers"
		 * @param var
		 * @return
		 */
		FreeInteraction createAddInteraction(){
			FreeInteraction e = BasicEventFactory.eINSTANCE.createFreeInteraction();
			e.setSender(senders.get(0));
			e.setReceiver(receivers.get(0));
			if (eventName != null)
				e.setOperationName(eventName);
			else
				e.setOperationName("-extra");
			if (variable != null)
				e.setVariable(variable);
			return e;
		}
		
		void addThisTransitionToSTG(STG stg){

			if (isAddOnlyForConditionalBranching && ! addForConditionalBranching)
				return;
			
			State newState = _Projection.createExtraState();
			
			Transition tt = new Transition(transition.source, newState, createAddInteraction());
			
			//dataOwner
			if (addForConditionalBranching){
				List<Transition> trans = stg.getOutgoingTransitions(tt.source);
				for (Transition t : trans)
					t.source = newState;
			}
			else
			{	//when dataOwner is corrected, some Order may be added for causality
				if (conditionalBranchLst.contains(transition)){
					tt.guard = transition.guard;
					transition.guard = ExprFactory.eINSTANCE.createBTrue();
				}
			}
			
			transition.source = newState;
			stg.transitions.add(tt);
			stg.states.add(newState);
		}
		
		@Override
		public boolean equals(Object obj){
			if (!(obj instanceof AddInteraction))
				return false;
			AddInteraction ad = (AddInteraction) obj;
			if (senders.get(0).equals(ad.senders.get(0))
					&& receivers.get(0).equals(ad.receivers.get(0))
					&& transition.source.equals(ad.transition.source)
					&& transition.destination.equals(ad.transition.destination))
				return true;
			return false;
		}
	}
	
}
