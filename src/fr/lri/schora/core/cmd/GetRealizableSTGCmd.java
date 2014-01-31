package fr.lri.schora.core.cmd;

import fr.lri.schora.basicEvent.BasicEvent;
import fr.lri.schora.stg.STG;
import fr.lri.schora.stg.Transition;

public class GetRealizableSTGCmd extends ProjectionCmd{
	public GetRealizableSTGCmd(String name) {
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
					STG stg1 = stg.getRealizableSTG(communicationModel, z3Solver);
					title += String.format("type=\"dot\">\n<![CDATA[%s\n]]></cmd>", stg1.toDotFormat());
					title += String.format("\n<cmd type=\"text\" title=\"realizability stat\">\n%s\n</cmd>", getStat(stg1));
					found = true;
					break;
				}
			if (!found)
				title += String.format("type=\"error\">\n not found component \"%s\"</cmd>", s);
			result += title;
		}
		return result;
	}
	
	String getStat(STG stg){
		int nReorder = 0;
		int nData = 0;
		int nBranches = 0;
		for (Transition t : stg.transitions){
			if (t.event instanceof BasicEvent){
				String op = ((BasicEvent)t.event).getOperationName();
				if (op.startsWith("+br"))
					nBranches ++;
				else if (op.startsWith("+da")  || op.startsWith("+cbr"))
					nData ++;
				else if (op.startsWith("+or"))
					nReorder ++;
			}
		}
		int total = (nBranches + nReorder + nData);
		if (total == 0){
			return "REALIZABLE";
		}
		
		String str = "UNREALIZABLE\n"; 
		str += "\n" +	stg.stat();
		str += "\n ADDITIONAL INTERACTION: ";
		str += "\n   +branching = " + nBranches;
		str += "\n   +ordering  = " + nReorder;
		str += "\n   +data      = " + nData;
		str += "\n        total = " + (nBranches + nReorder + nData);
		return str;
	}
}
