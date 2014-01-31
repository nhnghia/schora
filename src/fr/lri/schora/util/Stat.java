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
 * Jan 10, 2013 5:56:26 AM
 * @author nhnghia
 */
package fr.lri.schora.util;

public class Stat {
	static long time = System.currentTimeMillis();
	public static void start(){
		time = System.currentTimeMillis();
	}
	
	public static void end(){
		long t2 = System.currentTimeMillis();
		long m = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		float mm = (float) (m / (1024.0 * 1024));
		
		System.out.println(String.format("\n\nTime usage: %.3f (seconds), Memory usage: %.2f (Mega Bytes)", (t2-time)/1000.0, mm));
		System.out.flush();
	}
}
