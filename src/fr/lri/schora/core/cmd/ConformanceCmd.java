package fr.lri.schora.core.cmd;

import fr.lri.schora.stg.STG;
import fr.lri.schora.stg.conformance.Conformance;

public class ConformanceCmd extends GetReachableSTGCmd {

	public ConformanceCmd(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String exec(){
		STG spec = null, impl = null;
		if (parameters.size() != 2){
			return String.format("\n<cmd title=\"%s\" type=\"error\">\n need only 2 parameters</cmd>", super.toString());
		}
		String s1 = this.parameters.get(0);
		String s2 = this.parameters.get(1);
		String title = String.format("\n<cmd title=\"%s %s %s\" ", name, s1, s2);
		for (STG stg : stgs){
			if (s1.equals(stg.name)){
				impl = stg;
			}
			if (s2.equals(stg.name)){
				spec = stg;
			}
		}
		if (impl==null  || spec == null){
			title += String.format(" type=\"error\">\n not found component(s): \"%s %s\"</cmd>", (impl==null)? s1 : "", (spec==null)? s2:"");
			return title;
		}
		
		try {
			String str = " type=\"text\"><![CDATA[\n ";
			str += Conformance.conform(impl, spec, z3Solver.z3Solver).toString();
			title += str + "\n ]]> </cmd>";
		} catch (Exception e) {
			title += " type=\"error\"><![CDATA[\n ERROR: ";
			title += e.getMessage();
			title += "\n ]]> </cmd>";
			e.printStackTrace();
		}
		return title;
	}
}
