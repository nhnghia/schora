package fr.lri.schora.chorD;
import fr.lri.schora.expr.*;
public class Assign extends ChorDBasicEvent {
	public Variable variable;
	public Expression expression;
	
	public String toString(){
		return variable.toString() + " := " + expression.toString();
	}
}
