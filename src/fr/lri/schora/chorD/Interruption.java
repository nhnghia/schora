package fr.lri.schora.chorD;

public class Interruption extends BiComposition {
	public String toString(){
		return spec.toString() + " [> " + rightSpec.toString();
	}
}
