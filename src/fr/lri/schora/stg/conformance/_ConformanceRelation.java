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
import java.util.Set;

import fr.lri.schora.basicEvent.*;
import fr.lri.schora.stg.*;
import fr.lri.schora.expr.*;
import fr.lri.schora.expr.util.BoolExpression;
import fr.lri.schora.expr.util.FreshVariable;


/**
 * Implementation conformance Relation of two STGs in the paper
 */
class _ConformanceRelation {
	ExprFactory factory;
	
	STG impl, spec;
	List<_Result> results;
	List<String> visitedNodes;
	
	void debug(String str){
		System.out.println(str);
	}
	
	/**
	 * Verify whether an implementation <code>impl</code> conforms to a specification <code>spec</code>
	 * Note that: there are only TAU-transition in <code>impl</code>
	 * @param impl : STG of implementation
	 * @param spec : STG of specification
	 * @return a list of boolean expressions corresponding the condition of each couple nodes
	 */
	public  List<_Result> conform(STG impl, STG spec){
		this.impl = impl;
		this.spec = spec;
		
		factory = ExprFactory.eINSTANCE;
		FreshVariable.resetCounter();
		
		results = new ArrayList<_Result>();
		visitedNodes = new ArrayList<String>();
		
		close(impl.initialState, spec.initialState, new ArrayList<_Substitution>());
		
		return results;
	}
	
	
	
	Condition close(State s1, State s2, List<_Substitution> sigma){
		String key = String.format("%s-%s,%s-%s", s1.name, s1.label,
				s2.name, s2.label);

		//this pair is visited
		if (!visitedNodes.contains(key)){
			visitedNodes.add(key);
			
			Condition con = match(s1, s2, sigma);

			_Result rs = new _Result(s1, s2, con, sigma);
			results.add(rs);
		}

		//return value is a function
		//A trick to change Function to Condition: (Function() = true)
		Function fun = factory.createFunction();
		//with name
		fun.setName(String.format("R%s_%s", s1.name, s2.name));
		//and set of parameters
		List<Variable> vars = new ArrayList<Variable>();
		for (_Substitution sub : sigma){
			Variable v = factory.createVariable();
			v.setName(sub.to.getName());
			vars.add(v);
		}
		fun.getVariables().addAll(vars);
		
		RelationalCondition ex = factory.createRelationalCondition();
		ex.setLeft(fun);
		ex.setOp("=");
		ex.setRight(factory.createBTrue());
			
		return ex;
	}
	
	
	Condition match(State s1, State s2, List<_Substitution> sigma){
		List<TauStarTransitions> trans1 = getTransitions(s1, impl);
		List<TauStarTransitions> trans2 = getTransitions(s2, spec);
		
		//Two states are leaves
		if ((trans1.size() == 0) && (trans2.size() == 0))
			return factory.createBTrue();
		
		//get list of Ticks and channel names
		Hashtable<String, List<TauStarTransitions>> group1 = classifyTransition(trans1);
		Hashtable<String, List<TauStarTransitions>> group2 = classifyTransition(trans2);

		Condition conPartial = factory.createBTrue();
		
		//System.out.println(String.format("\n considering %s %s", s1.name, s2.name));
		
		//trait event which appear from s1 but not s2
		Set<String> keys1 = group1.keySet();
		for (String k : keys1){
			if (group2.containsKey(k))
				continue;
			//System.out.println(String.format("\n not in %s : %s", s2.name, k));
			List<TauStarTransitions> lst = group1.get(k);
			for (TauStarTransitions t : lst)
				conPartial = BoolExpression.createAnd(conPartial, 
						BoolExpression.createNot(t.tran2.guard));
								//BoolExpression.createAnd(t.getGuard1(), t.tran2.guard)));
		}
		
		//trait event which appear from s2 but not s1
		Set<String> keys2 = group2.keySet();
		for (String k : keys2){
			if (group1.containsKey(k))
				continue;
			//System.out.println(String.format("\n not in %s : %s", s1.name, k));
			List<TauStarTransitions> lst = group2.get(k);
			for (TauStarTransitions t : lst)
				conPartial = BoolExpression.createAnd(conPartial,
						BoolExpression.createNot(t.tran2.guard));
								//BoolExpression.createAnd(t.getGuard1(), t.tran2.guard)));
		}
		
		
		Set<String> keys = group2.keySet();
		//trait event (Tick, interaction) which appear both from s1 and s2
		List<Condition> conds = new ArrayList<Condition>();
		
		for (String k : keys){
			List<TauStarTransitions> tr1 = group1.get(k);
			if (tr1 == null)
				continue;
			
			List<TauStarTransitions> tr2 = group2.get(k);
			if (tr2 == null)
				continue;
			
			//System.out.println(String.format("\n in %s and %s : %s", s1.name, s2.name, k));
			
			if (k == "TICK"){
				Condition c = matchTick(tr1, tr2, sigma);
				conds.add(c);
			}else if (k.startsWith("bound")){
				Condition c = matchBound(tr1, tr2, sigma);
				conds.add(c);
			}else{// if (k.startsWith("bound")){
				Condition c = matchFree(tr1, tr2, sigma);
				conds.add(c);
			}
		}
		
		Condition con = factory.createBTrue();
		for (Condition c : conds){
			con = BoolExpression.createAnd(con, c);
		}
		
		
		return BoolExpression.createAnd(con, conPartial);
	}
	
	/**
	 * 
	 * @param trans1
	 * @param trans2 : List of TICK-Transition
	 * @param sigma
	 * @return
	 */
	Condition matchTick(List<TauStarTransitions> trans1, List<TauStarTransitions> trans2, List<_Substitution> sigma){
		int m = trans1.size();
		int n = trans2.size();
		//Get list of guards of spec
		Condition[] phi2 = new Condition[n];
		int i=0;
		for (TauStarTransitions t : trans2)
			if (t.isExistTrans1())
				phi2[i++] = t.getGuard1();
			else
				phi2[i++] = t.tran2.guard;		

		//List of guards of impl
		Condition[] phi1 = new Condition[m];
		int j=0;
		for (TauStarTransitions t : trans1)
			//phi1[j++] = BoolExpression.createAnd(t.getGuard1(), t.tran2.guard);
			if (t.isExistTrans1())
				phi1[j++] = t.getGuard1();
			else
				phi1[j++] = t.tran2.guard;
		
		//Rho_ij
		Condition[][] rho = new Condition[n][m];
		i=-1;
		for (TauStarTransitions t2 : trans2){
			i++;
			j=-1;
			State u = t2.tran2.source;			//partial
			for (TauStarTransitions t1 : trans1){
				j++;
				Condition c;
				if (t1.isExistTrans1()){
					 c = close(t1.tran1.destination, u, sigma);
				}else{
					c = factory.createBTrue();
				}
				rho[i][j] = c;
			}
		}
		
		//Left side of returned value
		Condition left = factory.createBTrue();
		for (i=0; i<n; i++){
			Condition con = factory.createBFalse();
			for (j=0; j<m; j++)
				con = BoolExpression.createOr(con, 
						BoolExpression.createAnd(phi1[j], rho[i][j]));
			
			left = BoolExpression.createAnd(left,
					BoolExpression.createImply(phi2[i], con)
					);
		}
		
		//Right side
		Condition right = factory.createBTrue();
		for (j=0; j<m; j++){
			Condition con = factory.createBFalse();
			for (i=0; i<n; i++)
				con = BoolExpression.createOr(con, 
						BoolExpression.createAnd(phi2[i], rho[i][j]));
			
			right = BoolExpression.createAnd(right,
						BoolExpression.createImply(phi1[j], con)
					);
		}
		
		return BoolExpression.createAnd(left, right);
			
	}
	
	/**
	 * 
	 * @param trans1
	 * @param trans2
	 * @return
	 */
	Condition matchBound(List<TauStarTransitions> trans1, List<TauStarTransitions> trans2, List<_Substitution> sigma){
		int m = trans1.size();
		int n = trans2.size();
		//Get list of guards of spec
		Condition[] phi2 = new Condition[n];
		int i=0;
		for (TauStarTransitions t : trans2)
			phi2[i++] = t.tran2.guard;		//parital (symmetric: need t.getGuard1() as phi1)

		//List of guards of impl
		Condition[] phi1 = new Condition[m];
		boolean hasTransTau[] = new boolean[m];
		int j=0;
		for (TauStarTransitions t : trans1)
			//phi1[j++] = BoolExpression.createAnd(t.getGuard1(), t.tran2.guard);
			if (t.isExistTrans1()){
				hasTransTau[j] = true;
				phi1[j++] = t.getGuard1();
			}
			else{
				hasTransTau[j] = false;
				phi1[j++] = t.tran2.guard;
			}
		
		//Rho_ij
		Variable z = null;
		Condition[][] rho = new Condition[n][m];
		i=-1;
		for (TauStarTransitions t2 : trans2){
			i++;
			j=-1;
			State u = t2.tran2.source;			//partial
			for (TauStarTransitions t1 : trans1){
				j++;
				
				BasicEvent com1 = (BasicEvent) t1.tran2.event;
				BasicEvent com2 = (BasicEvent) t2.tran2.event;
				
				//RHO
				if (t1.isExistTrans1()){
					 rho[i][j] = close(t1.tran1.destination, u, sigma);
				}else{
				
				
					//update sigma
					List<_Substitution> sigma2 = new ArrayList<_Substitution>();
					Set<Variable> freeVars = spec.freeVariables.get(t2.tran2.destination);
					freeVars.addAll(impl.freeVariables.get(t1.tran2.destination));
					
					for (_Substitution s : sigma){
						if (isContains(freeVars, s.from))
							sigma2.add(new _Substitution(s.from, s.to));
					}
					boolean hasForAll = false;
					
					Variable v1 = com1.getVariable();
					if (v1 != null && isContains(freeVars, v1)){
						if (z == null)
							z = FreshVariable.create();
						
						updateSubstitution(sigma2, v1, z);
						hasForAll = true;
					}
					
					Variable v2 = com2.getVariable();
					if (v2 != null && isContains(freeVars, v2)){
						if (z == null)
							z = FreshVariable.create();
						updateSubstitution(sigma2, v2, z);
						hasForAll = true;
					}
					
					if (hasForAll){
						sigma2.add(new _Substitution(copyVariable(z), copyVariable(z)));		//a trick to transfer z to next condition RHO_x_y
					}
					
					//RHO2
					Condition rho2;
					//loop
					if (t1.tran2.source.equals(t1.tran2.destination))
						rho2 = factory.createBTrue();
					else
						rho2 = close(t1.tran2.destination, t2.tran2.destination, sigma2);
				
					if (hasForAll){
						rho[i][j] = BoolExpression.createForAll(z, rho2);
					}else
						rho[i][j] = rho2;
				}
			}
		}
		
		
		//for (j=0; j<m; j++)
		//phi2[j] = 
		
		//Left side of returned value
		Condition left = factory.createBTrue();
		for (i=0; i<n; i++){
			Condition con = factory.createBFalse();
			for (j=0; j<m; j++){
				Condition exp = BoolExpression.createAnd(phi1[j], rho[i][j]);
				
				if (hasTransTau[j] == false)
					exp = BoolExpression.createImply(phi2[i], exp);
				//else
				//	con = BoolExpression.createImply(TRUE, con);
				
				con = BoolExpression.createOr(con, exp);
			}
			
			left = BoolExpression.createAnd(left, con);
		}
		
		//Right side
		Condition right = factory.createBTrue();
		for (j=0; j<m; j++){
			Condition con = factory.createBFalse();
			if (hasTransTau[j] == false)
				for (i=0; i<n; i++){
					con = BoolExpression.createOr(con, 
						BoolExpression.createAnd(phi2[i], rho[i][j]));
				}
			else
				for (i=0; i<n; i++){
					con = BoolExpression.createOr(con, rho[i][j]);
				}
			right = BoolExpression.createAnd(right,
						BoolExpression.createImply(phi1[j], con)
					);
		}
		
//System.out.println("left : " + left.toString());
//System.out.println("right: " + right.toString());

		return BoolExpression.createAnd(left, right);
	}
	
	Condition matchFree(List<TauStarTransitions> trans1, List<TauStarTransitions> trans2, List<_Substitution> sigma){
		int m = trans1.size();
		int n = trans2.size();
		//Get list of guards of spec
		Condition[] phi2 = new Condition[n];
		int i=0;
		Variable vars1[] = new Variable[n];
		for (TauStarTransitions t : trans2){
			vars1[i] = ((BasicEvent) t.tran2.event).getVariable();
			phi2[i++] = t.tran2.guard;		//parital (symmetric: need t.getGuard1() as phi1)
		}

		//List of guards of impl
		Condition[] phi1 = new Condition[m];
		Variable vars2[] = new Variable[m];
		boolean hasTransTau[] = new boolean[m];
		
		int j=0;
		for (TauStarTransitions t : trans1)
			//phi1[j++] = BoolExpression.createAnd(t.getGuard1(), t.tran2.guard);
			if (t.isExistTrans1()){
				hasTransTau[j] = true;
				phi1[j++] = t.getGuard1();
			}
			else{
				vars2[j] = ((BasicEvent) t.tran2.event).getVariable();
				hasTransTau[j] = false;
				phi1[j++] = t.tran2.guard;
			}
		
		//Rho_ij
		Condition[][] rho = new Condition[n][m];
		i=-1;
		for (TauStarTransitions t2 : trans2){
			i++;
			j=-1;
			State u = t2.tran2.source;			//partial
			for (TauStarTransitions t1 : trans1){
				j++;
				
				//RHO
				if (t1.isExistTrans1()){
					//loop
					if (t1.tran1.destination.equals(t1.tran1.source))
						rho[i][j] = factory.createBTrue();
					else	
						rho[i][j] = close(t1.tran1.destination, u, sigma);
				}else{
					if (t1.tran2.destination.equals(t1.tran2.source))
						rho[i][j] = factory.createBTrue();
					else
						rho[i][j] = close(t1.tran2.destination, t2.tran2.destination, sigma);
				}
			}
		}
		
		
		//for (j=0; j<m; j++)
		//phi2[j] = 
		
		//Left side of returned value
		Condition left = factory.createBTrue();
		for (i=0; i<n; i++){
			Condition con = factory.createBFalse();
			for (j=0; j<m; j++){
				Condition exp = BoolExpression.createAnd(phi1[j], 
								BoolExpression.createAnd(
										createEqual(vars1[i], vars2[j]),
										rho[i][j]));
				if (hasTransTau[j] == false)
					exp = BoolExpression.createImply(phi2[i], exp);
				//else no need imply
				//	con = BoolExpression.createImply(TRUE, con);
				con = BoolExpression.createOr(exp, con);
			}
			left = BoolExpression.createAnd(left, con);
		}
		
		// Right side
		Condition right = factory.createBTrue();
		for (j = 0; j < m; j++) {
			Condition con = factory.createBFalse();
			if (hasTransTau[j] == false) {
				for (i = 0; i < n; i++)
					con = BoolExpression.createOr(con, BoolExpression
							.createImply(phi1[j], BoolExpression.createAnd(
									phi2[i], BoolExpression.createAnd(
											createEqual(vars1[i], vars2[j]),
											rho[i][j]))));
			} else {
				for (i = 0; i < n; i++) {
					con = BoolExpression.createOr(con,
							BoolExpression.createImply(phi1[j], BoolExpression
									.createAnd(createEqual(vars1[i], vars2[j]),
											rho[i][j])));
				}
			}
			
			right = BoolExpression.createAnd(right, con);
		}
		
		return BoolExpression.createAnd(left, right);
	}
	
	
	Condition createEqual(Variable v1, Variable v2){
		if (v1 == null || v2 == null)
			return factory.createBTrue();
		RelationalCondition b = factory.createRelationalCondition();
		b.setLeft(copyVariable(v1));
		b.setOp("=");
		b.setRight(copyVariable(v2));
		return b;
	}
	
	boolean isContains(Set lst, Object obj){
		for (Object o : lst)
			if (o.equals(obj))
				return true;
		return false;
	}
	
	void updateSubstitution(List<_Substitution> sigma, Variable from, Variable to){
		for (_Substitution s : sigma)
			if (s.equals(from)){
				s.to = copyVariable(to);
				return;
			}
		if (from != null)
			sigma.add(new _Substitution(copyVariable(from), copyVariable(to)));
	}
	
	/**
	 * clone variable
	 * @param v
	 * @return a copy of <b>v</b>
	 */
	Variable copyVariable(Variable v){
		Variable var = ExprFactory.eINSTANCE.createVariable();
		var.setName(v.getName());
		return var;
	}
	
	/**
	 * Classify a list of TauStarTransitions <code>trans</code> into groups: Tick, c.<br/>
	 * Each group contains a set of events which have the same type and the same control part (c[a,b].)
	 * @param trans
	 * @return
	 */
	Hashtable<String, List<TauStarTransitions>> classifyTransition(List<TauStarTransitions> trans){
		Hashtable<String, List<TauStarTransitions>> group = new Hashtable<String, List<TauStarTransitions>>();
		for (TauStarTransitions t : trans){
			Event ev = t.tran2.event;
			String key = "";
			if (ev instanceof Tick)
				key = "TICK";
			else if (ev instanceof BoundEvent){
				BasicEvent com = (BasicEvent) ev;
				if (ev instanceof BoundInteraction)
					key = ".";
				else if (ev instanceof BoundSending)
					key = "!";
				else	//reception
					key = "?";
				key = String.format("bound-%s[%s, %s]%s ",  
							com.getOperationName(), com.getSender(), com.getReceiver(), key);
			}
			else if (ev instanceof FreeEvent){
				BasicEvent com = (BasicEvent) ev;
				if (ev instanceof FreeInteraction)
					key = ".";
				else if (ev instanceof FreeSending)
					key = "!";
				key = String.format("free-%s[%s, %s]%s ",  
							com.getOperationName(), com.getSender(), com.getReceiver(), key);
			}
			
			if (group.containsKey(key)){
				group.get(key).add(t);
			}else{
				List<TauStarTransitions> lst = new ArrayList<TauStarTransitions>();
				lst.add(t);
				group.put(key, lst);
			}
		}
		return group;
	}
	
	
	/**
	 * Get a list of 2-transitions from state <code>s</code> of STG <code>stg</code><br/>
	 * 2-transition is in form TAU-STAR ===>alpha, where alpha is Tick or Communication (alpha != Tau)
	 * @param s
	 * @param stg
	 * @return
	 */
	List<TauStarTransitions> getTransitions(State s, STG stg){
		List<TauStarTransitions> t3Trans = new ArrayList<TauStarTransitions>();
		
		//Firstly, consider s===>TAU-STAR===>alpha
		List<Transition> transTau = stg.getOutgoingTauStarTransitions(s);
		for (Transition t1 : transTau){
			List<Transition> transAlpha = stg.getOutgoingTransitions(t1.destination);
			for (Transition t2 : transAlpha){
				t3Trans.add(new TauStarTransitions(t1, t2));
			}
		}
		//Now consider only s===>NULL ===>alpha
		List<Transition> trans = stg.getOutgoingTransitions(s);
		for (Transition t1 : trans){
			if (t1.event instanceof Tau){
				continue;	//on a dŽjˆ vu au-dessus
			}else{
				t3Trans.add(new TauStarTransitions(null, t1));
			}
		}
		
		return t3Trans;
	}
	
	/**
	 * Create transition with TAU_STAR==>Interaction
	 */
	private class TauStarTransitions{
		Transition tran1, tran2;
		public TauStarTransitions(Transition t1, Transition t2){
			tran1 = t1;
			tran2 = t2;
		}
		
		/**
		 * TAU_STAR===>Interaction
		 * @return true if the TAU_STAR contains at least one TAU transition <br/>
		 * false otherwise
		 */
		public boolean isExistTrans1(){
			return tran1 != null;
		}
		
		/**
		 * TAU_STAR===>Interaction
		 * @return if the TAU_STAR is a TAU transition then return its guard<br/>
		 * BTrue otherwise
		 */
		public Condition getGuard1(){
			if (tran1 == null)
				return factory.createBTrue();
			else
				return tran1.guard;
		}
		
		public String toString(){
			return String.format("%s-%s", tran1, tran2);
		}
	}
}
