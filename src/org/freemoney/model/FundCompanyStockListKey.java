package org.freemoney.model;

public class FundCompanyStockListKey {

	private int quarter;		//����
	private int companyid;		//����˾id
	private String stockid;		// ��Ʊ����
	
	public FundCompanyStockListKey()
	{
		super();
	}
	
	public FundCompanyStockListKey(int quarter, int companyid, String stockid) {
		super();
		this.quarter = quarter;
		this.companyid = companyid;
		this.stockid = stockid;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public String getStockid() {
		return stockid;
	}

	public void setStockid(String stockid) {
		this.stockid = stockid;
	}
	
	
	
}
