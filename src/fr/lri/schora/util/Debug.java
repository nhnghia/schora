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
package fr.lri.schora.util;

/** This class provides some debugging support. 
 */
public final class Debug {
    public static final int NO_DEBUG = 0;
    public static final int DEBUG_EXCEPTIONS = 1;
    public static final int MIN_DEBUG = 2;
    public static final int FULL_DEBUG = 3;
    public static final int level = DEBUG_EXCEPTIONS;
//    public static final int level = MIN_DEBUG;
//    public static final int level = FULL_DEBUG;
   
    static boolean isInitial = false;
    static boolean isDebuging = false;
    
    public static boolean isDebug(){
    	if (!isInitial){
    		isDebuging = java.lang.management.ManagementFactory.getRuntimeMXBean().
		    getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
		    isInitial = true;
    	}
		    return isDebuging;
    }
    public static void print(String str) {
    	if (isDebug()){	    
            System.err.print(Thread.currentThread().getName() +
                             ": " + str);
            System.err.flush();
    	}
    }
    public static void println(String str) {
    	print(str + "\n");
    }
    public static void print(Exception e) {
    	if (isDebug()){
            System.err.print(Thread.currentThread().getName() + ": ");
            e.printStackTrace();
            System.err.flush();
    	}
    }

    public static String getUniqueId() {
       // No need to wrap this call in a synchronized block since java
       // language guarantees the int increment to be thread-safe.
        return String.valueOf(uniqueId++);
    }
    private static int uniqueId = 0;
}
