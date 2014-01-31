package fr.lri.schora.chorD;

public class If extends Guard {
	public String toString(){
		return "[" + guard.toString() + "] |> " + spec.toString();
	}

}
