package org.freemoney.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.freemoney.service.DataDumpService;
import org.freemoney.utils.Constant;


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
			try
			{
				int quarter = 0;
				String squarter = null;
				String stockId = null;
				String input = printMenu();
				switch (Integer.parseInt(input)) {
				case 1:
					squarter = inputQuarter();
					if(! squarter.isEmpty())
					{
						quarter = Integer.parseInt(squarter);
					}else
					{
						break;
					}
					String path = userDir + File.separator + Constant.DOCPATH + File.separator
							+ squarter;
					service.createFundStock(path, quarter);
					break;
				case 0:
					run =false;
					break;
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}


	private static void printHeader() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("FreeMoney - free your money.\n");
		sb.append("Copyright (c) 2009-2012 freemoney.org\n");
		System.out.println(sb.toString());
	}
	
	private static String printMenu() throws IOException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("\n---------------------主菜单-----------------------\n");
		sb.append("1.按季度生成基金股票持仓明细\n");
		sb.append("2.按季度生成股票持仓总计\n");
		sb.append("3.按季度生成基金公司股票持仓总计\n");
		sb.append("4.生成股票增减仓表格\n");
		sb.append("5.生成基金公司股票增减仓表格\n");
		sb.append("6.某只股票基金持有情况查询\n");
		sb.append("8.连续执行1、2、3菜单功能\n");
		sb.append("9.按季度删除所有数据\n");
		sb.append("0.退出系统\n");
		sb.append("-----------------------------------------------------\n");
		System.out.println(sb.toString());
		System.out.println("请输入选择：");
		return inputKeyboard();
	}


	private static String inputKeyboard() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		String input = new String();
		try
		{
			input = reader.readLine();
		}catch(IOException ioe)
		{
			System.out.println("I/O error:" + ioe);
			throw ioe;
		}
		return input.trim();
	}
	
	private static String inputQuarter() throws IOException {
		System.out.println("请输入季度:");
		return inputKeyboard();
	}


}
