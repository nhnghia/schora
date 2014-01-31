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
package fr.lri.schora.core.cmd;

import fr.lri.schora.solver.Z3SMT;
import fr.lri.schora.core.Command;
import fr.lri.schora.stg.STG;

public class GetReachableSTGCmd extends Command{
	public Z3SMT z3Solver;
	public GetReachableSTGCmd(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	
	public String exec(){
		String result = "";
		for (String s : parameters){
			String title = String.format("\n<cmd title=\"%s %s\"  ", name, s);
			boolean found = false;
			for (STG stg : stgs)
				if (s.equals(stg.name)){
					title += String.format("type=\"dot\">\n<![CDATA[%s\n]]></cmd>", stg.getReachableSTG(z3Solver).toDotFormat());
					found = true;
					break;
				}
			if (!found)
				title += String.format("type=\"error\">\n not found component \"%s\"</cmd>", s);
			result += title;
		}
		return result;
	}
}
