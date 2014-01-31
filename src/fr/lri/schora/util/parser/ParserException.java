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

import fr.lri.schora.util.List;

/**
 * Exception using for javacc parser
 * @author nhnghia
 */
public class ParserException extends Exception {
	private static final long serialVersionUID = 1L;
	public int beginLine, endLine, beginColumn, endColumn;
	public String currentString;
	public java.util.List<String> expectedStrings;
	
	public ParserException(int beginLine, int endLine, int beginColumn, int endColumn, String currentImage, java.util.List<String> expectedImages){
		super(initialise(beginLine, endLine, beginColumn, endColumn, currentImage, expectedImages));
		
		this.beginLine = beginLine;
		this.beginColumn = beginColumn;
		this.endLine = endLine;
		this.endColumn = endColumn;
		this.currentString = currentImage;
		this.expectedStrings = expectedImages;
	}

	public ParserException(int line, String currentImage, String cause){
		super("Encountered: \"" + currentImage + "\" at line: " + line + "\n    " +cause);
		beginLine = line;
		this.currentString = currentImage;
	}
	private static String initialise(int beginLine, int endLine, int beginColumn, int endColumn, String currentImage, java.util.List<String> expectedImages){
	    String eol = System.getProperty("line.separator", "\n");
	    String retval = "Encountered \"" + currentImage + "\"";
	    retval += " at line " + beginLine + ", column " + beginColumn;
	    retval += "." + eol;
	    if (expectedImages.size() == 1) {
	      retval += "Will expecting: ";
	    } else {
	      retval += "Will expecting one of: ";
	    }
	    String expected = List.toString(expectedImages, ", ");
	    retval += expected;
	    return retval;
	  }
}
