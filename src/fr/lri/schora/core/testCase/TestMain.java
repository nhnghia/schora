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
