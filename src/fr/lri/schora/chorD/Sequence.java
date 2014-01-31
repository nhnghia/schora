package fr.lri.schora.chorD;

public class Sequence extends BiComposition {
	public String toString(){
		return spec.toString() + " ; " + rightSpec.toString();
	}
}
