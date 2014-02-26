package org.freemoney.model;

public class FundStockDetail {

	private String fundid;
	private int quarter;
	private int serial;
	private String stockid;
	private String stockname;
	private int stocknum;	//持股数量
	private double stockvalue;	//持股价值
	private float ratio;	//净值占比
	
	public FundStockDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public FundStockDetail(String fundid, int quarter, int serial,
			String stockid, String stockname, int stocknum, double stockvalue, float ratio) {
		super();
		this.fundid = fundid;
		this.quarter = quarter;
		this.serial = serial;
		this.stockid = stockid;
		this.stockname = stockname;
		this.stocknum = stocknum;
		this.stockvalue = stockvalue;
		this.ratio = ratio;
	}


	public String getFundid() {
		return fundid;
	}
	public void setFundid(String fundid) {
		this.fundid = fundid;
	}
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
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
	public int getStocknum() {
		return stocknum;
	}
	public void setStocknum(int stocknum) {
		this.stocknum = stocknum;
	}
	
	public double getStockvalue() {
		return stockvalue;
	}

	public void setStockvalue(double stockvalue) {
		this.stockvalue = stockvalue;
	}
	
	public float getRatio() {
		return ratio;
	}
	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	
	
}
