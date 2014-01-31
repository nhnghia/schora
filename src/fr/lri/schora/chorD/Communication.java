package fr.lri.schora.chorD;

import fr.lri.schora.basicEvent.BasicEvent;

public class Communication extends ChorDBasicEvent {
public BasicEvent event;
	public String toString(){
		return event.toString();
	}
}
