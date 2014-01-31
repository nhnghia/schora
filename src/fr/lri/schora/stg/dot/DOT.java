package fr.lri.schora.stg.dot;

import java.util.ArrayList;
import java.util.List;

import fr.lri.schora.util.parser.ParserToken;

public class DOT {
	public List<String> states; 	//name
	public List<String> stateLabels;
	public List<String> startStates;
	public List<String> endStates;
	public List<ParserToken> labels;
	
	public DOT(){
		states = new ArrayList<String>();
		stateLabels = new ArrayList<String>();
		startStates = new ArrayList<String>();
		endStates = new ArrayList<String>();
		labels = new ArrayList<ParserToken>();
	}
	
	public void print(){
		int n = states.size();
		for (int i=0; i<n; i++)
			System.out.println(states.get(i) + " [" + stateLabels.get(i) + "]");
		n = startStates.size();
		for (int i=0; i<n; i++){
			System.out.println(startStates.get(i) + " -> " + endStates.get(i) + " [" +labels.get(i) + "]");
		}
	}
}
