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
/**
 * Jun 20, 2012 5:40:40 PM
 * @author nhnghia
 */
package fr.lri.schora.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {
	/**
	 * Verify if "fileName" exists in $PATH, if yes, return its absolutePath
	 * @param fileName
	 * @return
	 */
	public static String getFullPath(String fileName) {
		String variable = System.getenv("PATH");
		// System.out.println(variable);
		String[] folders = variable.split(String.format("%c",
				java.io.File.pathSeparatorChar));
		// String folder;
		for (String folder : folders) {
			// System.out.println(folder);
			java.io.File f = new java.io.File(folder, fileName);
			if (f.exists() && f.isFile())
				return f.getAbsolutePath();
		}
		return null;
	}
	
	/**
	 * Return Jar folder name which contains class cls 
	 * @param cls
	 * @return
	 */
	public static String getJarFolder(Class cls) {
		    String name = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
		    Debug.print(name);
		    name = name.substring(name.lastIndexOf(java.io.File.separatorChar)+1);
		    return name;
		  } 

	/**
	 * Read file content to a string
	 * @param fileName
	 * @return content of file
	 * @throws IOException
	 */
	public static String readFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
}
