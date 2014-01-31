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
package fr.lri.schora.stg;


public class State {
	public String name;
	public String label;
	public State(String name, String label){
		this.name = name;
		this.label = label;
	}

	public State(String name){
		this.name = name;
		this.label = name;
	}
	
	public String toString(){
		return String.format("%s.%s", name, label);
	}
	
	public boolean equals(Object s){
		if (!(s instanceof State))
			return false;
		return name.equals(((State)s).name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name2) {
		name = name2;
	}
}
