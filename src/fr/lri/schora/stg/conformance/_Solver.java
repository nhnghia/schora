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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xsmt.command.Assert;
import xsmt.command.Check_sat;
import xsmt.command.Declare_fun;
import xsmt.command.Define_fun;
import xsmt.command.Pop;
import xsmt.command.Push;
import xsmt.command.Set_option;
import xsmt.expression.Expression;
import xsmt.response.IResponse;
import xsmt.solver.z3.Z3Solver;

import fr.lri.schora.stg.State;
import fr.lri.schora.expr.BFalse;
import fr.lri.schora.expr.BTrue;
import fr.lri.schora.expr.Constance;
import fr.lri.schora.expr.Function;
import fr.lri.schora.expr.Variable;

class _Solver {
	/**
	 * List of declared functions, variables, constances
	 */
	static Set<String> declaredFuntions = new HashSet<String>();
	
	/**
	 * Verify <code>assertedFunction</code> is always TRUE or FALSE or not
	 * @param results : List of conditions, which are resulted from conformance verification,
	 * @param z3SolverPath : path to executable Z3 Solver, e.g. in Mac OS: /Users/toto/soft/z3/bin/z3
	 * @return 1 if assertedFunction = TRUE<br/>
	 * -1  if assertedFunction = FALSE<br/>
	 * 0 Otherwise
	 */
	public int isSatisfy(List<_Result> results, State s1, State s2, Set<Variable> freeVars, Z3Solver z3Solver) throws Exception{
		if (results.size() == 1){
			_Result rs = results.get(0);
			if (rs.condition instanceof BTrue)
				return 1;
			else if (rs.condition instanceof BFalse)
				return -1;
		}
		
		try {
			z3Solver.start();
			z3Solver.execute(new Set_option("print-warning", "false"));
			z3Solver.execute(new Push(0));
			
			ArrayList<String> params = new ArrayList<String>();
			
			//defineVariable(results);
			for (Variable v : freeVars){
				params.add(v.getName());
				
				if (_Solver.declaredFuntions.contains(v.getName()))
					;
				else{
					_Solver.declaredFuntions.add(v.getName());
					z3Solver.execute(createDeclareFun(v.getName()));
				}
			}
			
			Set<Constance> cons = new HashSet<Constance>();
			for (_Result rs : results){
				cons.addAll(rs.condition.getConstances());
			}
			//define constance
			for (Constance c : cons){
				if (_Solver.declaredFuntions.contains(c.getName()))
					;
				else{
					_Solver.declaredFuntions.add(c.getName());
					z3Solver.execute(createDeclareFun(c.getName()));
				}
			}
			
			for (_Result rs : results){
				//Define fun corresponds to result
				z3Solver.execute(createDefineFun(rs));
			}
			
			int d = 0;
			
			//assert the condition of assertedFunction is FALSE
			String assertedFunction = String.format("R%s_%s", s1.name, s2.name);
			z3Solver.execute(new Push(1));
			z3Solver.execute(createAssert(assertedFunction, false));
			
			IResponse response = z3Solver.execute(new Check_sat());
			//i.e.: Z3 not found any evaluation of variable for assertedFunction is FALSE
			if (response.toString().trim().endsWith("unsat")){
				d = 1;
			}
			else {
				//Show a value of variables
				/*
				if (response.toString().trim().endsWith("sat")){
					if (params.size() > 0)
						z3Solver.execute(new Get_value(params));
				}
				*/
				
				z3Solver.execute(new Pop(1));
				z3Solver.execute(createAssert(assertedFunction, true));
				
				response = z3Solver.execute(new Check_sat());
				//i.e.: Z3 not found any evaluation of variable for assertedFunction is TRUE
				if (response.toString().trim().equalsIgnoreCase("unsat"))
					d = -1;
				
				else if (response.toString().trim().equalsIgnoreCase("sat")){
					d = 0;
					
//					if (params.size() > 0)
//						z3Solver.execute(new Get_value(params));
					
				}else{
					throw new Exception("Timeout");
				}
			}
			
			z3Solver.execute(new Pop(0));
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
		}
		return 0;
	}

	private Define_fun createDefineFun(_Result rs){
		Function f = rs.getFunction();
		List<Variable> vars = f.getVariables();
		ArrayList<String> params = new ArrayList<String>();
		for (Variable v : vars)
			params.add(v.getName() + " Int");
		
		Define_fun fun = new Define_fun(f.getName(), "Bool", rs.condition.toZ3Format(), params);
		return fun;
	}
	
	private Declare_fun createDeclareFun(String var){
		Declare_fun fun = new Declare_fun(var, "Int", new ArrayList<String>());
		return fun;
	}
	
	private Assert createAssert(String assertedFunction, boolean val){
		String str = String.format("(= %s %s)", assertedFunction, (val?"true":"false"));
		return new Assert(new Expression(str));
	}
}
