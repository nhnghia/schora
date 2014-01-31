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
package fr.lri.schora.solver.testCase;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.util.BoolExpression;
import fr.lri.schora.solver.Z3SMT;

public class TestZ3SMT {

	@Test
	public void test() throws Exception {
		String str = "x*x+1>0 and x-x <3";
		Condition con = BoolExpression.parser(str);
		System.out.println(con.toString());
		Z3SMT z3 = new Z3SMT("/Users/nhnghia/soft/z3/bin/z3");
		boolean b = z3.assertTrue(con);
		assertTrue(b);
	}

}
