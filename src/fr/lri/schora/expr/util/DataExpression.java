/**
 * Jul 26, 2012 3:22:16 PM
 * @author nhnghia
 */
package fr.lri.schora.expr.util;

import java.io.StringReader;
import java.util.ArrayList;

import fr.lri.schora.expr.Expression;
import fr.lri.schora.expr.parser.ExpressionReader;
import fr.lri.schora.expr.parser.ParseException;
import fr.lri.schora.expr.parser.Token;

public class DataExpression {
	public static Expression parser(String str) throws ParseException{
		StringReader f = new StringReader(str);
		ExpressionReader parser = new ExpressionReader(f);
		return parser.expression();
	}
	
	/**
	 * parse a script which is a paragraph in a document
	 * @param script
	 * @param shiftLine: beginLine of the paragraph
	 * @param shiftColumn: beginColumn of the paragraph
	 * @return
	 * @throws fr.lri.schora.util.parser.ParserException
	 */
	public static Expression parser(String script, int shiftLine, int shiftColumn) throws fr.lri.schora.util.parser.ParserException{
		try{
			StringReader f = new StringReader(script);
			ExpressionReader parser = new ExpressionReader(f);
			Expression dot = parser.expression();
			return dot;
		}catch (ParseException ex){
			Token ct = ex.currentToken;
			java.util.List<String> expectedImages = new ArrayList<String>();
			for (int i=0; i< ex.expectedTokenSequences.length; i++){
				for (int j=0; j< ex.expectedTokenSequences[i].length; j++){
					expectedImages.add(ex.tokenImage[ex.expectedTokenSequences[i][j]]);
				}
			}
			throw new fr.lri.schora.util.parser.ParserException(ct.beginLine + shiftLine, ct.endLine + shiftLine, ct.beginColumn+shiftColumn, ct.endColumn+shiftColumn, ct.image, expectedImages);
		}
	}
}
