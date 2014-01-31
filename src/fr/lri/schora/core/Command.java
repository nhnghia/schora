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
package fr.lri.schora.core;

import java.util.ArrayList;
import java.util.List;

import fr.lri.schora.stg.STG;

public class Command {
	public String name;
	public List<String> parameters;
	public List<STG> stgs;
	
	public Command(String name, List<String> parameters){
		this.name = name;
		this.parameters = parameters;
	}
	
	public Command(String name){
		this.name  = name;
		this.parameters = new ArrayList<String>();
	}
	
	public String exec(){
		return "not yet implement";
	}
	
	public String toString(){
		return String.format("%s %s", name, fr.lri.schora.util.List.toString(parameters, " "));
	}
}
