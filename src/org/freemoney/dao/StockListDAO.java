package org.freemoney.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.freemoney.model.StockList;

public class StockListDAO extends AbstractDAO {

	public StockListDAO()
	{
		super();
	}
	
	public void insert(StockList record)
	{
		PreparedStatement pStmt = null;
		try
		{
			String insertSql = "insert into stocklist values(?,?,?,?,?)";
			pStmt = conn.prepareStatement(insertSql);
			pStmt.setInt(1, record.getQuarter());
			pStmt.setString(2, record.getStockid());
			pStmt.setString(3, record.getStockName());
			pStmt.setLong(4, record.getTotal());
			pStmt.setFloat(5, record.getCircleRatio());
			pStmt.execute();			
			log.info(insertSql);
		}catch(SQLException e)
		{
			log.error("StockListDAO insert fail",e);
			e.printStackTrace();
		}
	}
	
	
}
