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
package fr.lri.schora.core.parser;

import fr.lri.schora.stg.STG;
import fr.lri.schora.util.parser.ParserException;
import fr.lri.schora.util.parser.ParserToken;


public class MyParserComponent {
	public enum COMPONENT_TYPE{
		STG, CHORD
	};
	
	public COMPONENT_TYPE type;
	public String name;
	public ParserToken content;
	
	public MyParserComponent(String name, String type, ParserToken content){
		this.name = name;
		if (type.equals("STG"))
			this.type = COMPONENT_TYPE.STG;
		else
			this.type = COMPONENT_TYPE.CHORD;
		this.content = content;
	}
	
	/**
	 * If component is an STG then parse it, else return null
	 * @return
	 * @throws ParserException
	 */
	public STG getDotSTG() throws ParserException{
		if (type != COMPONENT_TYPE.STG)
			return null;
		STG stg = STG.parser(content.script, content.beginLine, content.beginColumn);
		return stg;
	}
	
	public String toString(){
		return String.format("name: %s,  type:%s, content: %s", name, type, content);
	}
}
