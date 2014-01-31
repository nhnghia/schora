package fr.lri.schora.stg.conformance;

public class Verdict {
	public enum VERDICT{
		PASS, FAIL, MAYBE, INCL
	}
	
	public VERDICT verdict;
	public String explication;
	
	public String toString(){
		return verdict + ":" + explication;
	}
}
