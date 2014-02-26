package org.freemoney.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.freemoney.db.DataBaseManager;
import org.freemoney.model.StockList;

public class StockListDAO extends AbstractDAO {

	public StockListDAO()
	{
		super();
	}
	
	/**
	 * 插入某条记录
	 * @param record
	 */
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
		}finally
		{
			DataBaseManager.closeStatement(pStmt);
		}
	}
	
	/**
	 * 删除季度记录
	 * @param quarter
	 */
	public void delete(int quarter)
	{
		PreparedStatement pStmt = null;
		try
		{			
			String sql = "delete from stocklist where quarter=?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, quarter);
			pStmt.execute();
			log.info("delete "+sql + "success!");
		}catch(SQLException e)
		{
			log.error("StockListDAO insert fail",e);
			e.printStackTrace();
		}
		finally
		{
			DataBaseManager.closeStatement(pStmt);
		}
	}
	
	
}
