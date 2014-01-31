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
package fr.lri.schora.stg.testCase;

import java.util.HashMap;

import org.junit.Test;

import fr.lri.schora.define.COMMUNICATION_MODEL;
import fr.lri.schora.solver.Z3SMT;
import fr.lri.schora.stg.STG;

public class TestProjection {

	@Test
	public void testCorrectCausality() {
		try{
			String str = fr.lri.schora.util.File.readFile("bin/testCases/Causality.stg");
			STG stg = STG.parser(str);
			System.out.println(stg.toDotFormat());
			
			
			Z3SMT z3Solver = new Z3SMT("/Users/nhnghia/soft/z3/bin/z3");
			
			System.out.println("==realizable===");
			System.out.println(stg.getRealizableSTG(COMMUNICATION_MODEL.SYNC, z3Solver));
			System.out.println("==realizable===");
			
			HashMap<String, STG> localSTGs = stg.projection(COMMUNICATION_MODEL.ASYNC_RECEIVER, z3Solver);
			java.util.Iterator<String> iters = localSTGs.keySet().iterator();
			while (iters.hasNext()){
				String r = iters.next();
				STG s = localSTGs.get(r);
				System.out.println("=============\n" + r + "\n" + s.toDotFormat());
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
