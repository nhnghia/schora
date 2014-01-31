package fr.lri.schora.chorD;

public class Choice extends BiComposition {
	public String toString(){
		return spec.toString() + " + " + rightSpec.toString();
	}

}
