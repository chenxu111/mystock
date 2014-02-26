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
			pStmt.setInt(1, record.getQuarter());		//����
			pStmt.setInt(2, record.getCompanyid());		//����˾id
			pStmt.setString(3, record.getCompanyname());
			pStmt.setString(4, record.getStockid());
			pStmt.setString(5, record.getStockname());
			pStmt.setLong(6, record.getStocknumber());
			pStmt.setFloat(7, record.getCircleratio());	//��ͨ��ռ��
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
	 * ������������
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
				pStmt.setInt(1, record.getQuarter());		//����
				pStmt.setInt(2, record.getCompanyid());		//����˾id
				pStmt.setString(3, record.getCompanyname());
				pStmt.setString(4, record.getStockid());
				pStmt.setString(5, record.getStockname());
				pStmt.setLong(6, record.getStocknumber());
				pStmt.setFloat(7, record.getCircleratio());	//��ͨ��ռ��
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
			
			//�������1000����ʣ���¼���������׳���
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
	 * ɾ�����ȼ�¼
	 * @param quarter(����)
	 * @throws SQLException
	 */
	public void delete(int quarter) throws SQLException
	{
		PreparedStatement pStmt = null;
		String sql = "delete from fcstocklist where quarter=?";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, quarter);		//����
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
	 * ��ѯ����˾�����м��ȹ�Ʊ�ֲ����
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