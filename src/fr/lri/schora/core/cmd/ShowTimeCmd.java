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
