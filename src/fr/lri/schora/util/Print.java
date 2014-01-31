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
 * Dec 31, 2012 2:57:17 PM
 * @author nhnghia
 */
package fr.lri.schora.util;

public class Print {
	public static void error(String str){
    	System.err.println("ERROR: " + str);
    	System.err.flush();
    }
	
	public static void println(String str){
		System.out.println(str);
	}
}
