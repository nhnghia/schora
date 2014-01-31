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
