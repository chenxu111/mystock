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
	 * �Ӽ����ļ��н���������ֲ���ϸ�����
	 * @param path �ļ�·��
	 * @param quarter ����
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
