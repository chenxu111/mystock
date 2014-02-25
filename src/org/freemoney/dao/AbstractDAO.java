package org.freemoney.dao;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.freemoney.db.DataBaseManager;

public abstract class AbstractDAO {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	protected Connection conn = null;
	
	/**
	 * 从数据库连接池获取连接
	 */
	public void getConnect()
	{
		conn = DataBaseManager.getConnection();
	}
	
	/**
	 * 释放数据库连接
	 */
	public void releaseConnection()
	{
		DataBaseManager.releaseConnection(conn);
	}
	
	
	
}
