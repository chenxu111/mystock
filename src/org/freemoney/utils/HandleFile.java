package org.freemoney.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HandleFile {

	protected static final Log log = LogFactory.getLog(HandleFile.class.getName());
	
	public static String handleFile(String filename)
	{
		String result = "";
		String fileType = filename.substring(filename.lastIndexOf(".")+1, filename.length());
		if(fileType.equalsIgnoreCase("pdf"))
		{
			result = handlePdf(filename);
		}else if(fileType.equalsIgnoreCase("doc"))
		{
			result = handleDocTable(filename);
		}
		return result;
	}

	private static String handlePdf(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String handleDocTable(String filename) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
	}
}
