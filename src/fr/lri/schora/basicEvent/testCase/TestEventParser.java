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
