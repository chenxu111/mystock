package org.freemoney.service;

import org.freemoney.dao.FundStockDetailDAO;

public class DataDumpService extends AbstractService {

	private FundStockDetailDAO fundStockDetailDAO;
	
	public DataDumpService() {
		// TODO Auto-generated constructor stub
		super();
		fundStockDetailDAO = new FundStockDetailDAO();
	}
	
	/**
	 * 从季报文件中解析出基金持仓明细并入库
	 * @param path 文件路径
	 * @param quarter 季度
	 */
	public void createFundStock(String path, int quarter)
	{
		log.info("createFundStock");
	}

	public FundStockDetailDAO getFundStockDetailDAO() {
		return fundStockDetailDAO;
	}

	public void setFundStockDetailDAO(FundStockDetailDAO fundStockDetailDAO) {
		this.fundStockDetailDAO = fundStockDetailDAO;
	}
}
