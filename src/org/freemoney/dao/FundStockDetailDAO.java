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
	 * 添加数据
	 * @param record
	 * @throws SQLException
	 */
	public void insert(FundStockDetail record) throws SQLException {
		PreparedStatement pStmt = null;

		String sql = "insert into fundstockdetail values(?,?,?,?,?,?,?,?)";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, record.getFundid()); // 基金号
			pStmt.setInt(2, record.getQuarter()); // 季度
			pStmt.setInt(3, record.getSerial()); // 序号
			pStmt.setString(4, record.getStockid()); // 股票代码
			pStmt.setString(5, record.getStockname()); // 股票名称
			pStmt.setLong(6, record.getStocknum()); // 持股数量
			pStmt.setDouble(7, record.getStockvalue()); // 持股价值
			pStmt.setFloat(8, record.getRatio()); // 占净值比例
			pStmt.execute();
			log.info(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("insert fail:", e);
			e.printStackTrace();
			throw e;
		} finally {
			DataBaseManager.closeStatement(pStmt);// 必须释放statement
		}
	}

	/**
	 * 按照季度清理数据
	 * @param quarter季度(年月)
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
