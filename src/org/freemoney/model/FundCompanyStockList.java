package org.freemoney.model;

public class FundCompanyStockList {
	
	private int quarter;		//季度
	private int companyid;		//基金公司id, 外键关联到fundc
	private String companyname;	//基金公司名称
	private String stockid;		//股票id
	private String stockname;		//股票名称
	private long stocknumber;	//持股数量
	private float circleratio;	//占流通盘比例
	
	
	public FundCompanyStockList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FundCompanyStockList(int quarter, int companyid, String companyname,
			String stockid, String stockname, long stocknumber, float circleratio) {
		super();
		this.quarter = quarter;
		this.companyid = companyid;
		this.companyname = companyname;
		this.stockid = stockid;
		this.stockname = stockname;
		this.stocknumber = stocknumber;
		this.circleratio = circleratio;
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
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getStockid() {
		return stockid;
	}
	public void setStockid(String stockid) {
		this.stockid = stockid;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public long getStocknumber() {
		return stocknumber;
	}
	public void setStocknumber(long stocknumber) {
		this.stocknumber = stocknumber;
	}
	public float getCircleratio() {
		return circleratio;
	}
	public void setCircleratio(float circleratio) {
		this.circleratio = circleratio;
	}

	
}
