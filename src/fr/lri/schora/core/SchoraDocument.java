package fr.lri.schora.core;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import fr.lri.schora.chorD.ChorD;
import fr.lri.schora.solver.Z3SMT;
import fr.lri.schora.core.cmd.GetReachableSTGCmd;
import fr.lri.schora.core.cmd.ProjectionCmd;
import fr.lri.schora.core.parser.MyCoraDocument;
import fr.lri.schora.core.parser.MyParserComponent;
import fr.lri.schora.core.parser.MyParserComponent.COMPONENT_TYPE;
import fr.lri.schora.core.parser.SchoraReader;
import fr.lri.schora.stg.Production;
import fr.lri.schora.stg.STG;

public class SchoraDocument {
	
	public List<STG> stgs;
	public List<Command> commands;
	public SchoraDocument(){
		stgs = new ArrayList<STG>();
		commands = new ArrayList<Command>();
	}
	
	
	/**
	 * parse a document
	 * @param script
	 * @return
	 * @throws fr.lri.schora.util.parser.ParserException
	 */
	public static SchoraDocument parser(String script) throws fr.lri.schora.util.parser.ParserException, Exception{
		try{
			StringReader f = new StringReader(script);
			SchoraReader parser = new SchoraReader(f);
			MyCoraDocument mdoc = parser.document();
			SchoraDocument doc = new SchoraDocument();
			List<MyParserComponent> products = new ArrayList<MyParserComponent>();
			
			for (MyParserComponent mcom : mdoc.components){
				STG stg = null;
				if (mcom.type == COMPONENT_TYPE.STG){
					stg = STG.parser(mcom.content.getScript());
				}
				else if (mcom.type == COMPONENT_TYPE.CHORD){
					//product
					if (mcom.content.script.contains("||")){
						products.add(mcom);
					}else{
						ChorD chor = ChorD.parser(mcom.content.getScript());
						stg = ChorD.translate2STG(chor);
					}
				}
				if (stg != null){
					stg.name = mcom.name;
					doc.stgs.add(stg);
				}
			}
			
			for (MyParserComponent mcom : products){
				String[] strs = mcom.content.script.split("\\|\\|");
				
				List<STG> stgs = new ArrayList<STG>();
				for (int i=0; i<strs.length; i++){
					strs[i] = strs[i].trim();
					
					boolean found = false;
					for (STG stg : doc.stgs)
						if (stg.name.equals(strs[i])){
							stgs.add(stg);
							found = true;
							break;
						}
					if (!found){
						throw new fr.lri.schora.util.parser.ParserException(mcom.content.beginLine, strs[i], "Not found the definition of component");
					}
				}
				STG stg = new Production().product(stgs);
				stg.name = mcom.name;
				doc.stgs.add(stg);
			}
			
			doc.commands = mdoc.commands;
			
			return doc;
		}catch (fr.lri.schora.core.parser.ParseException ex){
			fr.lri.schora.core.parser.Token ct = ex.currentToken;
			java.util.List<String> expectedImages = new ArrayList<String>();
			for (int i=0; i< ex.expectedTokenSequences.length; i++){
				for (int j=0; j< ex.expectedTokenSequences[i].length; j++){
					expectedImages.add(ex.tokenImage[ex.expectedTokenSequences[i][j]]);
				}
			}
			throw new fr.lri.schora.util.parser.ParserException(ct.beginLine, ct.endLine, ct.beginColumn, ct.endColumn, ct.next.image, expectedImages);
		}
	}
	
	public String exec(String z3path) throws Exception{
		String str ="";
		
		for (Command cmd : commands){
			//restart Z3 for each verification
			Z3SMT z3Solver = new Z3SMT(z3path);
			try{
				if (cmd instanceof ProjectionCmd){
					((ProjectionCmd)cmd).z3Solver = z3Solver;
				}
				if (cmd instanceof GetReachableSTGCmd){
					((GetReachableSTGCmd)cmd).z3Solver = z3Solver;
				}
				cmd.stgs = stgs;
				str += cmd.exec();
			}catch (Exception ex){
				str += String.format("\n<cmd title=\"%s\" type=\"error\">\n ERROR: %s</cmd>", cmd.toString(), ex.getMessage());
				if (fr.lri.schora.util.Debug.isDebug())
					ex.printStackTrace();
			}
		}
		return str;
	}
}
