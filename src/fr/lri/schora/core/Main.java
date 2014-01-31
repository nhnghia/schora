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
package fr.lri.schora.core;

import fr.lri.schora.util.parser.ParserException;


public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			if (args.length != 2){
				System.out.println("<rs><cmd title=\"Input Error!\" type=\"error\"/></rs>");
				return;
			}
			String script = args[0];
			String z3path = args[1];
			Main m = new Main();
			m.process(script, z3path);
		}catch (Exception ex){
			System.out.println("<cmd title=\"Error!\" type=\"error\">\n<![CDATA[");
			ex.printStackTrace();
			System.out.println("]]>\n</cmd>");
		}
	}
	
	public void process(String script, String z3path){
		String out="";
		try{
			InterruptTimer timer = new InterruptTimer(10000);
			if (!fr.lri.schora.util.Debug.isDebug()){
				timer.start();
			}
			SchoraDocument doc = SchoraDocument.parser(script);
			out = doc.exec(z3path);
			
			timer.release();
			
			System.out.println(out);
			System.out.flush();
    		System.exit(0);
			
		}catch(ParserException ex){
			System.out.println("<cmd title=\"Syntax Error!\" type=\"error\">\n<![CDATA[" + ex.getMessage() + "]]>\n</cmd>");
		}catch (Exception ex){
			//System.out.println("<cmd title=\"Error!\" type=\"error\">\n<![CDATA[" + ex.getMessage() + "]]>\n</cmd>");
			System.out.println("<cmd title=\"Error!\" type=\"error\">\n<![CDATA[");
			ex.printStackTrace();
			System.out.println("]]>\n</cmd>");
		}
	}
	
	class InterruptTimer extends Thread{
		int miliseconds;
	    public InterruptTimer(int miliseconds) {
	        this.miliseconds = miliseconds;
	        isRelease = false;
	    }
	    boolean isRelease;
	    public void release(){
	    	isRelease = true;
	    }
	    @Override
	    public void run() {
	    	try {
				Thread.sleep(miliseconds);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
	    	if (!isRelease){
	    		System.out.println("<cmd title=\"Error!\" type=\"error\">\n<![CDATA[Timeout!\n Due to protect our system, we limit execution time of SChorA.\n If you want to test big choreography, please download the desktop version then test the choreography in your local machine.]]>\n</cmd>");
	    		System.out.flush();
	    		System.exit(MAX_PRIORITY);
	    	}
	    }
	}
}
