package fr.lri.schora.solver;

import java.util.ArrayList;
import java.util.List;

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

import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.Constance;
import fr.lri.schora.expr.Variable;

public class Z3SMT {
	public Z3Solver z3Solver;
	/**
	 * @param path : path to executable Z3 Solver, e.g. in Mac OS: /Users/toto/soft/z3/bin/z3
	 */
	List<String> declaredVariables;
	int funIndex;		//number of declared functions 
	public Z3SMT(String path) throws Exception{
		z3Solver = new Z3Solver(path);
		declaredVariables = new ArrayList<String>();
		funIndex = 0;
	}

	/**
	 * Verify <code>con</code> is always FALSE or not
	 * @param con : Condition to be verified
	 * @return true if the con is always FALSE, else false
	 */
	public boolean assertFalse(Condition con){
		return assertCondition(con, false);
	}
	
	/**
	 * Verify <code>con</code> is always TRUE or not
	 * @param con : Condition to be verified
	 * @return true if the con is always TRUE, else false
	 */
	public boolean assertTrue(Condition con){
		return assertCondition(con, true);
	}
	
	boolean assertCondition(Condition con, boolean isTrue) {
		z3Solver.start();
			
		z3Solver.execute(new Set_option("print-warning", "false"));
		
		//defineVariable(results);
		List<Variable> vars = con.freeVariables();
		for (Variable v : vars){
			if (declaredVariables.contains(v.getName()))
				continue;
			declaredVariables.add(v.getName());
			z3Solver.execute(createDeclareFun(v.getName()));
		}
		
		//defineConstance
		List<Constance> cons = con.getConstances();
		for (Constance c : cons){
			if (declaredVariables.contains(c.getName()))
				continue;
			declaredVariables.add(c.getName());
			z3Solver.execute(createDeclareFun(c.getName()));
		}
		
		//Define fun corresponds to the condition
		String fun_name = "func" + (++funIndex);
		
		Define_fun fun = new Define_fun(fun_name, "Bool", con.toZ3Format(), new ArrayList<String>());
		z3Solver.execute(fun);
		
		Assert asert;
		//assert the condition of assertedFunction is FALSE
		if (isTrue)
			asert = new Assert(new Expression("(= "+ fun_name +" false)"));
		else
			asert = new Assert(new Expression("(= "+ fun_name +" true)"));
		
		z3Solver.execute(new Push(1));
		z3Solver.execute(asert);
		
		IResponse response = z3Solver.execute(new Check_sat());
		z3Solver.execute(new Pop(1));
		//i.e.: Z3 not found any evaluation of variable for assertedFunction is FALSE
		String str = response.toString().trim();
		
		if (str.endsWith("unsat")){
			return true;
		}
		return false;
	}

	private Declare_fun createDeclareFun(String var){
		Declare_fun fun = new Declare_fun(var, "Int", new ArrayList<String>());
		return fun;
	}	
}