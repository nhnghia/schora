package fr.lri.schora.core.cmd;

import fr.lri.schora.core.Command;
import fr.lri.schora.stg.STG;

public class ShowSTGCmd extends Command {

	public ShowSTGCmd(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String exec(){
		String result = "";
		for (String s : parameters){
			String title = String.format("\n<cmd title=\"%s %s\" ", name, s);
			boolean found = false;
			for (STG stg : stgs)
				if (s.equals(stg.name)){
					title += String.format(" type=\"dot\" >\n<![CDATA[%s\n]]></cmd>", stg.toDotFormat());
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
