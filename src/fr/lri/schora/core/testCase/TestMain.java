package fr.lri.schora.core.testCase;

import org.junit.Test;

import fr.lri.schora.core.Main;

public class TestMain {

	@Test
	public void testDocument() {
		try{
			String str = fr.lri.schora.util.File.readFile("bin/fr/lri/schora/core/testCase/examples/Loop.txt");
			String args[] = {str, "/Users/nhnghia/soft/z3/bin/z3"};
			Main.main(args);
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
