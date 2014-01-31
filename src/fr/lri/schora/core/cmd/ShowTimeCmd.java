package fr.lri.schora.core.cmd;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.lri.schora.core.Command;

public class ShowTimeCmd extends Command {

	public ShowTimeCmd(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public String exec(){
		String str = "yyyy/MM/dd hh:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		Date d = new Date();
		str = sdf.format(d);
		return String.format("\n<cmd title=\""+name+"\" type=\"text\"> %s (%s)</cmd>", str, d.getTime());
	}
}
