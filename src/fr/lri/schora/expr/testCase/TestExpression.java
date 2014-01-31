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
/**
 * Jul 26, 2012 2:47:21 PM
 * @author nhnghia
 */
package fr.lri.schora.expr.testCase;

import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.parser.ParseException;
import fr.lri.schora.expr.parser.Token;
import fr.lri.schora.expr.util.BoolExpression;
import fr.lri.schora.expr.util.DataExpression;

public class TestExpression {

	public static void main(String[] args)  throws Exception{
		try{
			Condition ex = BoolExpression.parser("    x>M and (y>1*3 or x < 2*5+2+1) and x != abs(x)+sqrt(x) or true or no ");
			System.out.println(ex.toString());
			
			fr.lri.schora.expr.Expression e = DataExpression.parser("x +3 - 2");
			System.out.println(e.toString());
			
			e = DataExpression.parser("x +3- 2");
			System.out.println(e.toString());
			
			e = DataExpression.parser("x +3 -2");
			System.out.println(e.toString());
		}catch(ParseException ex){
			Token t = ex.currentToken;
			System.out.println("Error "+ t.image +" at line: " + t.beginLine + " col:" + t.beginColumn);
		}
	}

}
