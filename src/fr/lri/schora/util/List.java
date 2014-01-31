/**
 * Jun 29, 2012 11:04:08 AM
 * @author nhnghia
 */
package fr.lri.schora.util;

public class List {
	public static String toString(@SuppressWarnings("rawtypes") java.util.List lst, String delim){
		if (lst == null)
			return "";
		String str = "";
		for (Object obj : lst){
			if (obj == null || obj.toString() == "" || obj.toString().length() == 0)
				continue;
			
			str += delim + obj.toString();
		}
		if (str.length() > 0)
			str = str.substring(delim.length());
		return str;
	}
}
