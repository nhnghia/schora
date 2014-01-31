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

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

import fr.lri.schora.define.COMMUNICATION_MODEL;
import fr.lri.schora.solver.Z3SMT;
import fr.lri.schora.core.Command;
import fr.lri.schora.stg.STG;

public class ProjectionCmd extends Command{
	public COMMUNICATION_MODEL communicationModel;
	public Z3SMT z3Solver;
	public ProjectionCmd(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	
	public String exec(){
		String result = "";
		for (String s : parameters){
			String title = String.format("\n<cmd title=\"%s %s %s\" ", name, s, communicationModel);
			boolean found = false;
			for (STG stg : stgs)
				if (s.equals(stg.name)){
					title += String.format(" type=\"text\" ></cmd>");
					
					HashMap<String, STG> stgs = stg.projection(communicationModel, z3Solver);
					SortedSet<String> keys = new TreeSet<String>(stgs.keySet());
					for (String r : keys) { 
						STG stg1 = stgs.get(r);
						title += String.format("\n<cmd title=\"- %s %s on role %s\" type=\"dot\"><![CDATA[%s\n]]></cmd>", name, s, r, stg1.toDotFormat());
						
					}
						
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
