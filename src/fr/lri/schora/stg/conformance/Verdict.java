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

public class Verdict {
	public enum VERDICT{
		PASS, FAIL, MAYBE, INCL
	}
	
	public VERDICT verdict;
	public String explication;
	
	public String toString(){
		return verdict + ":" + explication;
	}
}
