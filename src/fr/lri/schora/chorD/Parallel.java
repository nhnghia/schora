package fr.lri.schora.chorD;

public class Parallel extends BiComposition {
	public String toString(){
		return spec.toString() + " | " + rightSpec.toString();
	}
}
