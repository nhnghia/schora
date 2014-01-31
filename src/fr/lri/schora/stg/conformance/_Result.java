/**
 * Apr 9, 2012 11:59:14 PM
 * @author nhnghia
 */
package fr.lri.schora.stg.conformance;

import java.util.ArrayList;
import java.util.List;

import fr.lri.schora.stg.*;
import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.Function;
import fr.lri.schora.expr.Variable;

/**
 * Contain result
 */
class _Result {
	public Condition condition;
	public State s1, s2;
	private List<_Substitution> substitutions;
	
	public _Result(State s1, State s2){
		this(s1, s2, ExprFactory.eINSTANCE.createBTrue(), new ArrayList<_Substitution>());
	}
	
	public _Result(State s1, State s2, Condition con, List<_Substitution> subs){
		this.s1 = s1;
		this.s2 = s2;
		condition = con;
		substitutions = subs;
	}
	
	public String toString(){
		//String str = String.format("(%s, %s)", s1.name, s2.name);
		
		String str = String.format("\n   %s ::= %s", getFunction().toString(), condition.toString());
		
		return str;
	}
	
	public String toLaTEX(){
		String str = String.format("(%s, %s)", s1.name, s2.name);
		
		str += String.format("\n   %s ::= %s", getFunction().toLaTEX(), condition.toLaTEX());
		
		return str;
	}
	
	public Function getFunction(){
		//return value is a function
		Function fun = ExprFactory.eINSTANCE.createFunction();
		//with name
		fun.setName(String.format("R%s_%s", s1.name, s2.name));
		//and set of parameters
		List<Variable> vars = new ArrayList<Variable>();
		for (_Substitution sub : substitutions){
			Variable v = ExprFactory.eINSTANCE.createVariable();
			v.setName(sub.from.getName());
			vars.add(v);
		}
		fun.getVariables().addAll(vars);
		return fun;
	}
}
