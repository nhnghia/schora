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
