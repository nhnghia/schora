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
package fr.lri.schora.core.testCase;

import java.io.StringReader;

import org.junit.Test;

import fr.lri.schora.core.parser.SchoraReader;
import fr.lri.schora.core.parser.MyCoraDocument;
import fr.lri.schora.core.parser.ParseException;
import fr.lri.schora.core.parser.Token;

public class TestSchoraDocument {

	@Test
	public void testDocument() {
		try{
			String str = fr.lri.schora.util.File.readFile("bin/fr/lri/schora/core/testCase/randTest.txt");
			System.out.println(str);
			StringReader f = new StringReader(str);
			SchoraReader parser = new SchoraReader(f);
			MyCoraDocument doc = parser.document();
			
			System.out.println(doc.commands);
			System.out.println(fr.lri.schora.util.List.toString(doc.components, "\n"));
			
		}catch (ParseException ex){
			Token t = ex.currentToken;
			System.out.println(String.format("Line: %d, Column: %d, Encountered: %s",
					t.beginLine, t.beginColumn, t.image));
			ex.printStackTrace();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
