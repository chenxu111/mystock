package org.freemoney.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
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
	 *  从连接池获取一个连接
	 * @return
	 */
	public static Connection getConnection()
	{
		try
		{
			Connection conn = ds.getConnection();
			return conn;
		}catch(Exception e)
		{
			log.info("getConnection fail:", e);
		}
		return null;
	}
	
	/**
	 * 释放连接
	 * @param conn
	 */
	public static void releaseConnection(Connection conn)
	{
		try {
			if(conn != null && !conn.isClosed())
			{
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.info("releaseConnection fail",e);
		}
	}
}