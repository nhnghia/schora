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
