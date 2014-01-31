package fr.lri.schora.chorD.parser;
import java.io.StringReader;
import java.util.ArrayList;

import fr.lri.schora.basicEvent.BasicEvent;
import fr.lri.schora.basicEvent.Event;
import fr.lri.schora.basicEvent.parser.EventReader;
import fr.lri.schora.chorD.Communication;
import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.util.BoolExpression;
//import fr.lri.schora.util.parser.ParserException;

class _ParserTool {
	static Condition parser(String script) throws ParseException {
		try {
			if (fr.lri.schora.util.Debug.isDebug()){
				System.out.println(script);
			}
			return BoolExpression.parser(script);
		} catch (fr.lri.schora.expr.parser.ParseException ex) {
			if (fr.lri.schora.util.Debug.isDebug()){
				System.out.println(ex.toString());
			}
			
			fr.lri.schora.expr.parser.Token ct = ex.currentToken;
			java.util.List<String> expectedImages = new ArrayList<String>();
			for (int i=0; i< ex.expectedTokenSequences.length; i++){
				for (int j=0; j< ex.expectedTokenSequences[i].length; j++){
					expectedImages.add(ex.tokenImage[ex.expectedTokenSequences[i][j]]);
				}
			}
			Token currentTokenVal = new Token(ct.kind, ct.image);
			Token t = currentTokenVal;
			t.beginColumn = ct.beginColumn;
			t.beginLine = ct.beginLine;
			t.endColumn = ct.endColumn;
			t.endLine = ct.endLine;
			while (ct.next != null){
				ct = ct.next;
				t.next = new Token(ct.kind, ct.image);
				t = t.next;
				t.beginColumn = ct.beginColumn;
				t.beginLine = ct.beginLine;
				t.endColumn = ct.endColumn;
				t.endLine = ct.endLine;
			}
			
			throw new ParseException(currentTokenVal , ex.expectedTokenSequences, ex.tokenImage);
		}
	}
	static Communication parserEvent(String script) throws ParseException {
		try {
			if (fr.lri.schora.util.Debug.isDebug()){
				System.out.println(script);
			}
			Communication com = new Communication();
			StringReader f = new StringReader(script);
            EventReader parser = new EventReader(f);
            Event ev = parser.parser();
			if (ev instanceof BasicEvent)
				com.event = (BasicEvent)ev;
			else{
				//???
			}
            return com;
		} catch (fr.lri.schora.basicEvent.parser.ParseException ex) {
			if (fr.lri.schora.util.Debug.isDebug()){
				System.out.println(ex.toString());
			}
			
			fr.lri.schora.basicEvent.parser.Token ct = ex.currentToken;
			java.util.List<String> expectedImages = new ArrayList<String>();
			for (int i=0; i< ex.expectedTokenSequences.length; i++){
				for (int j=0; j< ex.expectedTokenSequences[i].length; j++){
					expectedImages.add(ex.tokenImage[ex.expectedTokenSequences[i][j]]);
				}
			}
			Token currentTokenVal = new Token(ct.kind, ct.image);
			Token t = currentTokenVal;
			t.beginColumn = ct.beginColumn;
			t.beginLine = ct.beginLine;
			t.endColumn = ct.endColumn;
			t.endLine = ct.endLine;
			while (ct.next != null){
				ct = ct.next;
				t.next = new Token(ct.kind, ct.image);
				t = t.next;
				t.beginColumn = ct.beginColumn;
				t.beginLine = ct.beginLine;
				t.endColumn = ct.endColumn;
				t.endLine = ct.endLine;
			}
			throw new ParseException(currentTokenVal , ex.expectedTokenSequences, ex.tokenImage);
		}
	}
}
