package fr.lri.schora.chorD;

public class Loop extends Guard {
	public String toString(){
		return "[" + guard.toString() + "] * " + spec.toString();
	}
}
