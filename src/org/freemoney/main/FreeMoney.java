package org.freemoney.main;

import java.util.Properties;

import org.freemoney.service.DataDumpService;

public class FreeMoney {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printHeader();
		
		DataDumpService service = new DataDumpService();
		
		Properties props = new Properties(System.getProperties());
		String userDir = props.getProperty("user.dir");
		
		boolean run = true;
		while(run)
		{
			
		}
		printMenu();
	}


	private static void printHeader() {
		// TODO Auto-generated method stub
		
	}
	
	private static void printMenu() {
		// TODO Auto-generated method stub
		
	}


}
