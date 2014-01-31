package fr.lri.schora.expr.util;

import java.io.StringReader;
import java.util.ArrayList;

import fr.lri.schora.expr.*;
import fr.lri.schora.expr.parser.ExpressionReader;
import fr.lri.schora.expr.parser.ParseException;
import fr.lri.schora.expr.parser.Token;

public class BoolExpression {
	private static boolean isDeduce = true;
	
	public static Condition parser(String str) throws ParseException{
		StringReader f = new StringReader(str);
		ExpressionReader parser = new ExpressionReader(f);
		return parser.condition();
	}
	
	
	
	/**
	 * parse a script which is a paragraph in a document
	 * @param script
	 * @param shiftLine: beginLine of the paragraph
	 * @param shiftColumn: beginColumn of the paragraph
	 * @return
	 * @throws fr.lri.schora.util.parser.ParserException
	 */
	public static Condition parser(String script, int shiftLine, int shiftColumn) throws fr.lri.schora.util.parser.ParserException{
		try{
			StringReader f = new StringReader(script);
			ExpressionReader parser = new ExpressionReader(f);
			Condition dot = parser.condition();
			return dot;
		}catch (ParseException ex){
			Token ct = ex.currentToken;
			java.util.List<String> expectedImages = new ArrayList<String>();
			for (int i=0; i< ex.expectedTokenSequences.length; i++){
				for (int j=0; j< ex.expectedTokenSequences[i].length; j++){
					expectedImages.add(ex.tokenImage[ex.expectedTokenSequences[i][j]]);
				}
			}
			throw new fr.lri.schora.util.parser.ParserException(ct.beginLine + shiftLine, ct.endLine + shiftLine, ct.beginColumn+shiftColumn, ct.endColumn+shiftColumn, ct.image, expectedImages);
		}
	}
	
	public static Condition createAnd(Condition c1, Condition c2) {
		if (isDeduce) {
			if (c1.toString().equals(c2.toString()))
				return c1;
			else if (c1.equals(c2))
				return c1;
			else if (c1 instanceof BTrue)
				return c2;
			else if (c2 instanceof BTrue)
				return c1;
			else if (c1 instanceof BFalse)
				return c1;
			else if (c2 instanceof BFalse)
				return c2;
		}
		And c = ExprFactory.eINSTANCE.createAnd();
		c.setExpr(c1);
		c.setExpr2(c2);
		return c;
	}

	public static Condition createOr(Condition c1, Condition c2) {
		if (isDeduce) {
			if (c1.toString().equals(c2.toString()))
				return c1;
			else if (c1.equals(c2))
				return c1;
			else if (c1 instanceof BTrue)
				return c1;
			else if (c2 instanceof BTrue)
				return c2;
			else if (c1 instanceof BFalse)
				return c2;
			else if (c2 instanceof BFalse)
				return c1;
		}
		Or c = ExprFactory.eINSTANCE.createOr();
		c.setExpr(c1);
		c.setExpr2(c2);
		return c;
	}

	/*
	 * public static Condition createEqual(Expression c1, Expression c2){ if
	 * (c1.toString().compareTo(c2.toString()) == 0) return
	 * ExprFactory.eINSTANCE.createBTrue(); else if (c1 instanceof BTrue)
	 * return c2; else if (c2 instanceof BTrue) return c1; else if (c1
	 * instanceof BFalse) return createNot(c2); else if (c2 instanceof BFalse)
	 * return createNot(c1);
	 * 
	 * RelationalCondition c =
	 * ExprFactory.eINSTANCE.createRelationalCondition(); c.setLeft(value)
	 * return c; }
	 */

	public static Condition createNot(Condition c) {
		if (isDeduce) {
			if (c instanceof BTrue)
				return ExprFactory.eINSTANCE.createBFalse();
			else if (c instanceof BFalse)
				return ExprFactory.eINSTANCE.createBTrue();
		}

		Not not = ExprFactory.eINSTANCE.createNot();
		not.setExpr(c);
		return not;
	}

	/**
	 * <code>c1</code> implies <code>c2</code>
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static Condition createImply(Condition c1, Condition c2) {
		if (isDeduce) {
			//if (c1.equals(c2))
			//	return ExprFactory.eINSTANCE.createBTrue(); //false imples false = false (not true)
			//else 
				if (c1 instanceof BTrue)
				return c2;
			else if (c2 instanceof BTrue)
				return c2;
			else if (c1 instanceof BFalse)
				return ExprFactory.eINSTANCE.createBTrue();
			else if (c2 instanceof BFalse)
				return createNot(c1);
		}
		Imply imply = ExprFactory.eINSTANCE.createImply();
		imply.setExpr(c1);
		imply.setExpr2(c2);
		return imply;
	}
	
	public static Condition createForAll(Variable var, Condition expr){
		if (isDeduce){
			if (expr instanceof BTrue)
				return expr;
			else if (expr instanceof BFalse)
				return expr;
		}
		ForAll forall = ExprFactory.eINSTANCE.createForAll();
		forall.setExpr(createBracket(expr));
		forall.getVariables().add(var);
		
		return forall;
	}
	
	
	public static Condition createBracket(Condition expr){
		if (isDeduce){
			if (expr instanceof BTrue)
				return expr;
			else if (expr instanceof BFalse)
				return expr;
		}
		Bracket bracket = ExprFactory.eINSTANCE.createBracket();
		bracket.setExpr(expr);
		return bracket;
	}
}
