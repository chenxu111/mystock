package org.freemoney.model;

public class StockList {
	
	private int quarter;
	private String stockid;
	private String stockName;
	private long total;
	private float circleRatio;
	
	public StockList(int quarter, String stockid, String stockName, long total,
			float circleRatio) {
		this.quarter = quarter;
		this.stockid = stockid;
		this.stockName = stockName;
		this.total = total;
		this.circleRatio = circleRatio;
	}
	
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public String getStockid() {
		return stockid;
	}
	public void setStockid(String stockid) {
		this.stockid = stockid;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public float getCircleRatio() {
		return circleRatio;
	}
	public void setCircleRatio(float circleRatio) {
		this.circleRatio = circleRatio;
	}
	
	
}
