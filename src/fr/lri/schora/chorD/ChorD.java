package fr.lri.schora.chorD;

import java.io.StringReader;
import java.util.ArrayList;

import fr.lri.schora.chorD.parser.ChorReader;
import fr.lri.schora.chorD.toSTG.Translate;
import fr.lri.schora.stg.STG;

public abstract class ChorD {
	
	public static STG translate2STG(ChorD chor){
		Translate t = new Translate();
		return t.get(chor);
	}
	
	public static ChorD parser(String script) throws fr.lri.schora.util.parser.ParserException {
		return ChorD.parser(script, 0, 0);
	}
	
	/**
	 * parse a script which is a paragraph in a document
	 * @param script
	 * @param shiftLine: beginLine of the paragraph
	 * @param shiftColumn: beginColumn of the paragraph
	 * @return
	 * @throws fr.lri.schora.util.parser.ParserException
	 */
	public static ChorD parser(String script, int shiftLine, int shiftColumn) throws fr.lri.schora.util.parser.ParserException{
		try{
			String str = "";
			for (int i=1; i<shiftLine; i++)
				str += "\n";
			for (int i=1; i<shiftColumn; i++)
				str += " ";
			StringReader f = new StringReader(str + script);
			ChorReader parser = new ChorReader(f);
			return parser.start();
		}catch (fr.lri.schora.chorD.parser.ParseException ex){
			if (fr.lri.schora.util.Debug.isDebug()){
				System.out.println(ex.toString());
			}
			
			fr.lri.schora.chorD.parser.Token ct = ex.currentToken;
			java.util.List<String> expectedImages = new ArrayList<String>();
			for (int i=0; i< ex.expectedTokenSequences.length; i++){
				for (int j=0; j< ex.expectedTokenSequences[i].length; j++){
					expectedImages.add(ex.tokenImage[ex.expectedTokenSequences[i][j]]);
				}
			}
			ex.printStackTrace();
			throw new fr.lri.schora.util.parser.ParserException(ct.beginLine , ct.endLine, ct.beginColumn, ct.endColumn, ct.next.image, expectedImages);
		}
	}
}
