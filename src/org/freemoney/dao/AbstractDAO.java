package org.freemoney.dao;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.freemoney.db.DataBaseManager;

public abstract class AbstractDAO {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	protected Connection conn = null;
	
	/**
	 * �����ݿ����ӳػ�ȡ����
	 */
	public void getConnect()
	{
		conn = DataBaseManager.getConnection();
	}
	
	/**
	 * �ͷ����ݿ�����
	 */
	public void releaseConnection()
	{
		DataBaseManager.releaseConnection(conn);
	}
	
	
	
}
