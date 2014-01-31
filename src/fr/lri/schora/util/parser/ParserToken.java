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
package fr.lri.schora.util.parser;

public class ParserToken {
	public int beginLine, beginColumn;
	public String script;
	
	public ParserToken(int beginLine, int beginColumn, String script){
		this.beginLine = beginLine;
		this.beginColumn = beginColumn;
		this.script = script;
	}
	
	public ParserToken(String script){
		this.beginLine = 0;
		this.beginColumn = 0;
		this.script = script;
	}
	
	public String toString(){
		return script;
	}
	
	/**
	 * @return script with inserting "beginLine" \n and "beginColumn" of spaces 
	 */
	public String getScript(){
		String s = "";
		for (int i=1; i<beginLine; i++)
			s += "\n";
		for (int i=1; i<beginColumn; i++)
			s += " ";
		s += script;
		return s;
	}
}
