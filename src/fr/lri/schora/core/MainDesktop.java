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

import java.io.IOException;

import fr.lri.schora.util.parser.ParserException;


public class MainDesktop {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 2){
			System.out.println("Invalidate parameters! Using:");
			System.out.println(" java -jar " + fr.lri.schora.util.File.getJarFolder(MainDesktop.class) + " scriptFile z3Solverpath");
			return;
		}
		String script = args[0];
		try {
			script = fr.lri.schora.util.File.readFile(script);
		} catch (IOException e) {
			System.out.println("Error: Cannot read file " + script);
			return;
		}
		String z3path = args[1];
		
		String out="";
		try{
			SchoraDocument doc = SchoraDocument.parser(script);
			out = doc.exec(z3path);
			System.out.println(out);
			
		}catch(ParserException ex){
			System.out.println("<cmd title=\"Syntax Error!\" type=\"error\">\n<![CDATA[" + ex.getMessage() + "]]>\n</cmd>");
		}catch (Exception ex){
			System.out.println("<cmd title=\"Error!\" type=\"error\">\n<![CDATA[" + ex.getMessage() + "]]>\n</cmd>");
			ex.printStackTrace();
		}
	}
}
