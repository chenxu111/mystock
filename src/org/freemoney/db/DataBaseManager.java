package org.freemoney.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataBaseManager {

	protected static final Log log = LogFactory.getLog(DataBaseManager.class
			.getName());

	private static DataBaseManager _instance = null;

	private static DataSource ds;

	public static DataBaseManager getInstance() {
		if (_instance == null) {
			_instance = new DataBaseManager();
		}
		return _instance;
	}

	static {
		Properties prop = new Properties();
		InputStream is = DataBaseManager.class.getClassLoader()
				.getResourceAsStream("dbcp.properties");
		try {
			prop.load(is);
			ds = BasicDataSourceFactory.createDataSource(prop);
			log.info("databasepool init success!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			throw new ExceptionInInitializerError("databasepool init error");
		}
	}

	/**
	 * 从连接池获取一个连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			log.info("getConnection fail:", e);
		}
		return null;
	}

	/**
	 * 释放连接
	 * 
	 * @param conn
	 */
	public static void releaseConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.info("releaseConnection fail", e);
		}
	}

	/**
	 * 关闭statement
	 * @param stmt
	 * @param resultSet
	 * @throws SQLException
	 */
	public static void closeStatement(Statement stmt, ResultSet resultSet)
			throws SQLException {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			log.error("closeStatment error", e);
			e.printStackTrace();
		}

		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			log.error("closeStatement fail:", e);
			e.printStackTrace();
		}
	}
	/**
	 * 关闭statement
	 * @param stmt
	 * @throws SQLException
	 */
	public static void closeStatement(Statement stmt) {	
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			log.error("closeStatement fail:", e);
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String sql)
	{
		ResultSet rs = null;
		Statement _stmt = null;
		
		Connection conn = getConnection();
		
		try {
			_stmt = conn.createStatement();
			rs = _stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("executequery fail:",e);
			e.printStackTrace();
		}finally{
			closeStatement(_stmt);
			releaseConnection(conn);
		}
		return rs;
	}
	
	public void updateDb(String sql)
	{
		Connection conn = getConnection();
		Statement _stmt = null;
		try {
			_stmt = conn.createStatement();
			_stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("updateDb",e);
			e.printStackTrace();
		}finally{
			closeStatement(_stmt);
			releaseConnection(conn);
		}
		
		
	}
}