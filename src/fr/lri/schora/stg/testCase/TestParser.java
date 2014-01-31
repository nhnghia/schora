package fr.lri.schora.stg.testCase;


import java.io.StringReader;
import java.util.ArrayList;

import org.junit.Test;

import fr.lri.schora.solver.Z3SMT;
import fr.lri.schora.stg.STG;
import fr.lri.schora.stg.State;
import fr.lri.schora.stg.dot.DOT;
import fr.lri.schora.stg.dot.parser.*;

public class TestParser {

	//@Test
	public void test() {
		try{
			String str = fr.lri.schora.util.File.readFile("bin/testCases/STG.dot");
			System.out.println(str);
			StringReader f = new StringReader(str);
			STGReader parser = new STGReader(f);
			DOT dot = parser.parser();
			System.out.println("DOT");
			dot.print();
		}catch (ParseException ex){
			Token t = ex.currentToken;
			System.out.println(String.format("Line: %d, Column: %d, Encountered: %s",
					t.beginLine, t.beginColumn, t.image));
			ex.printStackTrace();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	@Test
	public void testDotSGT(){
		String str;
		try {
			str = fr.lri.schora.util.File.readFile("bin/testCases/STG.dot");
			STG d = STG.parser(str);
			System.out.println("STG");
			System.out.println(fr.lri.schora.util.List.toString(d.states, ", "));
			System.out.println(fr.lri.schora.util.List.toString(d.transitions, ","));
			System.out.println(d.toDotFormat());
			
			System.out.println("Reachable");
			Z3SMT z3Solver = new Z3SMT("/Users/nhnghia/soft/z3/bin/z3");
			STG s = d.getReachableSTG(z3Solver);
			System.out.println(s.toDotFormat());
			
			System.out.println(d.getRoles(new State("3","2")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
