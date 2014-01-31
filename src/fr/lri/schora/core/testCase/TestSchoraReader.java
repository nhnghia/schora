package fr.lri.schora.core.testCase;

import org.junit.Test;

import fr.lri.schora.core.SchoraDocument;
import fr.lri.schora.util.parser.ParserException;

public class TestSchoraReader {

	@Test
	public void testDocument() {
		try{
			String str = fr.lri.schora.util.File.readFile("bin/fr/lri/schora/core/testCase/exam.txt");
			SchoraDocument doc = SchoraDocument.parser(str);
			
			System.out.println(doc.commands);
			System.out.println(fr.lri.schora.util.List.toString(doc.stgs, "\n"));
			

			System.out.println("EXEC");
			doc.exec("/Users/nhnghia/soft/z3/bin/z3");
		}catch (ParserException ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
