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
package fr.lri.schora.chorD.testCase;

import org.junit.Test;

import fr.lri.schora.chorD.ChorD;
import fr.lri.schora.stg.STG;
import fr.lri.schora.util.parser.ParserException;

public class TestChorD {

	@Test
	public void test() throws ParserException {
		//String str = "(skip ; [true] |>   (request!x | request[a,c]?y) ; [x >y] * (response[a,d].x)) [> cancel[d,a]!resone";
		String str = "Request[c,s].x_1 ; [x_1+2 >= 5] |> LivrExp[s,c] + [x_1 <5] |> Livraison[s,c]\n ! <x>";
		ChorD chor = ChorD.parser(str);
		System.out.println(chor.toString());
		
		STG s = ChorD.translate2STG(chor);
		System.out.println(s.toDotFormat());
	}

}
