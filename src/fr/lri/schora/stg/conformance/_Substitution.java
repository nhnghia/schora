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
 * Apr 9, 2012 11:58:12 PM
 * @author nhnghia
 */
package fr.lri.schora.stg.conformance;

import fr.lri.schora.expr.Variable;

class _Substitution {
	public Variable from, to;
	
	public _Substitution(Variable from, Variable to){
		this.from = from;
		this.to = to;
	}
}
