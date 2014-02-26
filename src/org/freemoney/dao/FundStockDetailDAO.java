package org.freemoney.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.freemoney.db.DataBaseManager;
import org.freemoney.model.FundStockDetail;

public class FundStockDetailDAO extends AbstractDAO {

	public FundStockDetailDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * �������
	 * @param record
	 * @throws SQLException
	 */
	public void insert(FundStockDetail record) throws SQLException {
		PreparedStatement pStmt = null;

		String sql = "insert into fundstockdetail values(?,?,?,?,?,?,?,?)";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, record.getFundid()); // �����
			pStmt.setInt(2, record.getQuarter()); // ����
			pStmt.setInt(3, record.getSerial()); // ���
			pStmt.setString(4, record.getStockid()); // ��Ʊ����
			pStmt.setString(5, record.getStockname()); // ��Ʊ����
			pStmt.setLong(6, record.getStocknum()); // �ֹ�����
			pStmt.setDouble(7, record.getStockvalue()); // �ֹɼ�ֵ
			pStmt.setFloat(8, record.getRatio()); // ռ��ֵ����
			pStmt.execute();
			log.info(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("insert fail:", e);
			e.printStackTrace();
			throw e;
		} finally {
			DataBaseManager.closeStatement(pStmt);// �����ͷ�statement
		}
	}

	/**
	 * ���ռ�����������
	 * @param quarter����(����)
	 * @throws SQLException
	 */
	public void delete(int quarter) throws SQLException {
		PreparedStatement pStmt = null;

		String sql = "delete from funstockdetail where quarter=?";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, quarter);
			pStmt.execute();
			log.info(sql);
		} catch (SQLException e) {
			log.error("delete error:", e);
			e.printStackTrace();
			throw e;
		} finally {
			DataBaseManager.closeStatement(pStmt);
		}
	}

}
