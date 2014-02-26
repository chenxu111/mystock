package org.freemoney.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.freemoney.db.DataBaseManager;
import org.freemoney.model.FundCompanyStockList;
import org.freemoney.model.FundCompanyStockListKey;

public class FundCompanyStockListDAO extends AbstractDAO {

	public FundCompanyStockListDAO()
	{
		super();
	}
	
	/**
	 * 
	 * @param record
	 * @throws SQLException
	 */
	public void insert(FundCompanyStockList record) throws SQLException
	{
		PreparedStatement pStmt = null;
		String sql = "insert into fcstocklist values(?,?,?,?,?,?,?)";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, record.getQuarter());		//季度
			pStmt.setInt(2, record.getCompanyid());		//基金公司id
			pStmt.setString(3, record.getCompanyname());
			pStmt.setString(4, record.getStockid());
			pStmt.setString(5, record.getStockname());
			pStmt.setLong(6, record.getStocknumber());
			pStmt.setFloat(7, record.getCircleratio());	//流通盘占比
			pStmt.execute();
			log.info(sql);
		} catch (SQLException e) {
			log.error("insert fail:", e);
			e.printStackTrace();
			throw e;
		}finally
		{
			DataBaseManager.closeStatement(pStmt);
			DataBaseManager.releaseConnection(conn);
		}
	}
	
	/**
	 * 批量插入数据
	 * @param records
	 * @throws SQLException
	 */
	public void insertBatch(List<FundCompanyStockList> records) throws SQLException
	{
		PreparedStatement pStmt = null;
		
		String sql = "insert into fcstocklist values()?,?,?,?,?,?,?";
		try {
			pStmt = conn.prepareStatement(sql);
			int count = 0;
			for(FundCompanyStockList record: records)
			{
				pStmt.setInt(1, record.getQuarter());		//季度
				pStmt.setInt(2, record.getCompanyid());		//基金公司id
				pStmt.setString(3, record.getCompanyname());
				pStmt.setString(4, record.getStockid());
				pStmt.setString(5, record.getStockname());
				pStmt.setLong(6, record.getStocknumber());
				pStmt.setFloat(7, record.getCircleratio());	//流通盘占比
				pStmt.addBatch();
				count++;
				
				if(count>=1000)
				{
					pStmt.executeBatch();
					pStmt.clearBatch();
					count=0;
				}
			}
			log.info(sql);
			
			//解决不足1000个的剩余记录，否则容易出错
			if(count!=0)
			{
				pStmt.executeBatch();
				pStmt.clearBatch();
			}
		} catch (SQLException e) {
			log.error("insert insertBatch fail: ",e);
			e.printStackTrace();
			throw e;
		}finally
		{
			DataBaseManager.closeStatement(pStmt);
			DataBaseManager.releaseConnection(conn);
		}
	}
	
	/**
	 * 删除季度记录
	 * @param quarter(年月)
	 * @throws SQLException
	 */
	public void delete(int quarter) throws SQLException
	{
		PreparedStatement pStmt = null;
		String sql = "delete from fcstocklist where quarter=?";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, quarter);		//季度
			pStmt.execute();			
			log.info(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("delete fail:",e);
			e.printStackTrace();
			throw e;
		}finally
		{
			DataBaseManager.closeStatement(pStmt);
//			DataBaseManager.releaseConnection(conn);
		}
	}
	
	/**
	 * 查询基金公司的所有季度股票持仓情况
	 * @param quarter
	 * @return
	 */
	public Map<FundCompanyStockListKey, FundCompanyStockList> getFcStockList(int quarter)
	{
		Map<FundCompanyStockListKey, FundCompanyStockList> fcStockList = new HashMap<FundCompanyStockListKey, FundCompanyStockList>();
		
		Statement stmt = null;
		
		String sql = "select * from fcstocklist where quarter="+quarter;
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			log.info(sql);
			
			while(rs.next())
			{
				FundCompanyStockList record = new FundCompanyStockList();
				record.setQuarter(quarter);
				record.setCompanyid(rs.getInt("companyid"));
				record.setCompanyname(rs.getString("companyname"));
				record.setStockid(rs.getString("stockid"));
				record.setStockname(rs.getString("stockname"));
				record.setStocknumber(rs.getLong("stocknumber"));
				record.setCircleratio(rs.getFloat("circleratio"));
				
				FundCompanyStockListKey key = new FundCompanyStockListKey(quarter, record.getCompanyid(), record.getStockid());
				fcStockList.put(key, record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DataBaseManager.closeStatement(stmt);
		}
		
		return fcStockList;
	}
}