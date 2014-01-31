package fr.lri.schora.stg.conformance.testCase;
import static org.junit.Assert.*;

import org.junit.Test;

import xsmt.solver.z3.Z3Solver;
import fr.lri.schora.chorD.*;
import fr.lri.schora.stg.STG;
import fr.lri.schora.stg.conformance.Conformance;

/**
 * Apr 5, 2012 11:57:44 PM
 * @author nhnghia
 */

public class ConformanceChorDTest {

	//@Test
	public void test1() {
		String implStr = "request[a,b].y1 ; [y1 = 0] |> skip";
		String specStr = "request[a,b].x1 ; [x1 > 0]*request[a,c].x1 ; [x1 = 0] |> skip";
		
		assertTrue(verif(implStr, specStr));
	}
	
	@Test
	public void test2() {
		String implStr = "request[a,b].y1 ; request[a,c].y2  + request[a,c].y2 ; request[a,b].y1";
		String specStr = "request[a,b].x1 | request[a,c].x2";
		
		assertTrue(verif(implStr, specStr));
	}
	
//	
//	//@Test
//	public void test3() {
//		String implStr = "request[a,b].y1 ; request[a,b].y2  ; request[a,b].y3 ; request[a,b].y4";
//		String specStr = "request[a,b].x1 ; [x1 > 0] * request[a,c].x1";
//		
//		assertTrue(verif(implStr, specStr));
//	}
//
//	//@Test
//	public void test4() {
//		String implStr = "Request[c,a].x1 ; (Hotel[a,c].x2  | (Vol[a,c].x3 + Train[a,c].x4))";
//		String specStr = "request[a,b].x1 ; [x1 > 0] * request[a,c].x1";
//		
//		assertTrue(verif(implStr, specStr));
//	}
//	
//	
//	//@Test
//	public void test5() {
//		String specStr = "req.x_1 ; ([x_1 > 5] |> vol. + [x_1 <= 5] |> train.)";	
//		String implStr = "req.y_1 ; ([y_1 > 5] |> vol. + reg. ; [y_1 <= 5] |>train.)";
//		assertTrue(verif(implStr, specStr));
//	}
//	
//	//@Test
//	public void test6() {
//		String specStr = "req.x_1 ; ([x_1 > 5] |> vol. + [x_1 <= 5] |> train.)";	
//		String implStr = "req.y_1 ; ([y_1 > 5] |> vol. + [y_1 <= 5] |> (reg.y ; [y >= 45] |>train.))";
//		assertTrue(verif(implStr, specStr));
//	}
//	
//	@Test
//	public void testUpdateFreeVariable() {
//		String implStr = "req1.x_1 ; resp0.x_2 ; [x_1 > 0] |> resp.x3 ; resp2.x4; resp3 ; resp.x5 ; [x_2 > 0] * resp4";	
//		String specStr = "req1.y_1 ; resp.y3; resp2. ; resp4";
//		assertTrue(verif(implStr, specStr));
//	}
	
	private boolean verif(String implStr, String specStr){
		System.out.println("\n");
		{
			try {
				ChorD implC = ChorD.parser(implStr);
				ChorD specC = ChorD.parser(specStr);
				
				System.out.println(implC.toString());
				System.out.println(specC.toString());
				
				STG implSTG = ChorD.translate2STG(implC);
				STG specSTG = ChorD.translate2STG(specC);
				Z3Solver z3Solver = new Z3Solver("/Users/nhnghia/soft/z3/bin/z3");
				String str = Conformance.conform(implSTG, specSTG, z3Solver).toString();
				System.out.println(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	}
}
