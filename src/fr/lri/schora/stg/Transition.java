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

import fr.lri.schora.basicEvent.Event;
import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.ExprFactory;

public class Transition {
	public State source, destination;
	public Condition guard;
	public Event event;
	
	public Transition(State src, State dst,  Event event){
		this.source =src;
		this.destination = dst;
		this.guard = ExprFactory.eINSTANCE.createBTrue();
		this.event = event;
	}
	
	public Transition(State src, State dst, Condition guard, Event event){
		this.source =src;
		this.destination = dst;
		this.guard = guard;
		this.event = event;
	}
	
	public String toString(){
		return String.format("%s --[%s]-%s--> %s", source.name, guard, event, destination.name);
	}

	public Condition getGuard() {
		return guard;
	}

	public Event getEvent() {
		return event;
	}
	
}
