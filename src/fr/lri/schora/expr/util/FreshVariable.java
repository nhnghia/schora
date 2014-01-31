package fr.lri.schora.expr.util;

import fr.lri.schora.expr.*;

public class FreshVariable {
	public static void resetCounter(){
		index = 0;
	}
	private static int index = 0;
	public static Variable create(){
		Variable var = ExprFactory.eINSTANCE.createVariable();
		var.setName(String.format("Z_%d", index++));
		return var;
	}
}
