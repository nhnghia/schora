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
package fr.lri.schora.basicEvent.testCase;

import fr.lri.schora.basicEvent.Event;
import fr.lri.schora.basicEvent.parser.*;
import fr.lri.schora.util.parser.ParserException;

import org.junit.Test;

public class TestEventParser {

	@Test
	public void testParserString() throws ParserException {
		Event e = EventReader.parser("request [a,b]");
		System.out.println(e.toString());
	}

}
