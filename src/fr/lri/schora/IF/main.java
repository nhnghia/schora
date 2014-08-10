package fr.lri.schora.IF;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.lri.schora.basicEvent.BasicEvent;
import fr.lri.schora.basicEvent.GlobalEvent;
import fr.lri.schora.core.SchoraDocument;
import fr.lri.schora.define.COMMUNICATION_MODEL;
import fr.lri.schora.solver.Z3SMT;
import fr.lri.schora.stg.STG;
import fr.lri.schora.stg.Transition;
import fr.lri.schora.util.parser.ParserException;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			if (args.length > 2 || args.length == 0){
				System.out.println("Usage: Chor2IF file [g]");
				System.out.println("  - file    : path to ChorD file");
				System.out.println("  - z3Solver: generate only global description to IF by projecting them on local using Z3SMT");
				return;
			}
			//String fileName = "bin/fr/lri/schora/IF/testCase/exam.txt";
			String fileName = args[0];
			boolean genOnlyGlobal = args.length == 2;
			String str = fr.lri.schora.util.File.readFile(fileName);
			SchoraDocument doc = SchoraDocument.parser(str);
			
			fileName = new File(fileName).getName();
			if (fileName.contains("."))
				fileName = fileName.substring(0, fileName.indexOf("."));
			print("system " + fileName.toUpperCase() + ";\n");
			
			
			printSignals(doc.stgs);
			
			Z3SMT z3Solver = null;
			if (genOnlyGlobal)
				z3Solver = new Z3SMT(args[1]); 
			STG2IF trans = new STG2IF();
			for (STG stg : doc.stgs){
				boolean b = isGlobal(stg);
				
				if (genOnlyGlobal){
					if (b){
						HashMap<String, STG> stgs = stg.projection(COMMUNICATION_MODEL.SYNC, z3Solver);
						Set<String> keys = stgs.keySet();
						for (String k : keys){
							STG s = stgs.get(k);
							s.name = k;
							print(trans.toIFSpecification(s));
						}
					}
				}else{
					if (!b )
						print(trans.toIFSpecification(stg) + "\n");
				}
			}
			print("endsystem;\n\n");
			
			if (genOnlyGlobal)
				return;
			
			STG2OBV trans2 = new STG2OBV();
			for (STG stg : doc.stgs){
				if (isGlobal(stg))
					print(trans2.toIFObserver(stg));
			}

		}catch (ParserException ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	static void print(String s){
		System.out.print(s);
	}
	
	static void printSignals(List<STG> stgs){
		List<String> chans = new ArrayList<>();
		Map<String, List<String>> maps = new HashMap<>();
		boolean hasVar = false;
		String signalStr = "";
		for (STG stg : stgs){
			for (Transition t : stg.transitions){
				if (t.event instanceof BasicEvent){
					BasicEvent ev = (BasicEvent) t.event;
					
					String s = String.format("%s_%s_%s", ev.getOperationName(), ev.getSender(), ev.getReceiver());
					
					if (chans.contains(s))
							continue;
					chans.add(s);
					
					if (ev.getVariable() != null){
						signalStr += String.format("signal %s(INT);\n", ev.getOperationName());
						hasVar = true;
					}
					else
						signalStr += (String.format("signal %s();\n", ev.getOperationName()));
					
					List<String> lst;
					s = String.format("%s to %s", ev.getSender(), ev.getReceiver());
					if (maps.containsKey(s)){
						lst = maps.get(s);
					}else 
						lst = new ArrayList<>();
					if (!lst.contains(ev.getOperationName())){
						lst.add(ev.getOperationName());
						maps.put(s, lst);
					}
				}
			}
		}
		if (hasVar){
			print("type INT = range 1..10;\n");
		}
		print(signalStr);
		Set<String> keys = maps.keySet();
		for (String k : keys){
			print(String.format("signalroute %s(1)\n  from %s\n  with %s;\n",
					k.replace(" ", "_"),
					k,
					fr.lri.schora.util.List.toString(maps.get(k), ",")));
		}
		
	}
	
	static boolean isGlobal(STG stg){
		for (Transition t : stg.transitions)
			if (t.event instanceof GlobalEvent){
				return true;
			}
		return false;
	}
}
