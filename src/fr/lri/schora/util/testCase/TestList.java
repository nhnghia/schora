/**
 * Jun 29, 2012 11:07:05 AM
 * @author nhnghia
 */
package fr.lri.schora.util.testCase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestList {

	@Test
	public final void test() {
		List<String> lst = new ArrayList<String>();
		lst.add("A");
		lst.add("B");
		lst.add("C");
		assertTrue(fr.lri.schora.util.List.toString(lst, ",").equals("A,B,C"));
	}

}
