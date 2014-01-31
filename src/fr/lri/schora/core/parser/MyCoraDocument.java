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

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import fr.lri.schora.core.Command;



public class MyCoraDocument{
	public List<MyParserComponent> components;
	public List<Command> commands;
	
	public MyCoraDocument(){
		components = new ArrayList<MyParserComponent>();
		commands = new ArrayList<Command>();
	}
	
	public MyCoraDocument(List<MyParserComponent> components, List<Command> commands){
		this.commands = commands;
		this.components = components;
	}
	
	public static MyCoraDocument parser(String script) throws fr.lri.schora.util.parser.ParserException{
		return MyCoraDocument.parser(script, 0, 0);
	}
	
	/**
	 * parse a script which is a paragraph in a document
	 * @param script
	 * @param shiftLine: beginLine of the paragraph
	 * @param shiftColumn: beginColumn of the paragraph
	 * @return
	 * @throws fr.lri.tools.parser.ParserException
	 */
	public static MyCoraDocument parser(String script, int shiftLine, int shiftColumn) throws fr.lri.schora.util.parser.ParserException{
		try{
			StringReader f = new StringReader(script);
			SchoraReader parser = new SchoraReader(f);
			MyCoraDocument dot = parser.document();
			return dot;
		}catch (fr.lri.schora.core.parser.ParseException ex){
			fr.lri.schora.core.parser.Token ct = ex.currentToken;
			java.util.List<String> expectedImages = new ArrayList<String>();
			for (int i=0; i< ex.expectedTokenSequences.length; i++){
				for (int j=0; j< ex.expectedTokenSequences[i].length; j++){
					expectedImages.add(ex.tokenImage[ex.expectedTokenSequences[i][j]]);
				}
			}
			throw new fr.lri.schora.util.parser.ParserException(ct.beginLine + shiftLine, ct.endLine + shiftLine, ct.beginColumn+shiftColumn, ct.endColumn+shiftColumn, ct.image, expectedImages);
		}
	}
}
