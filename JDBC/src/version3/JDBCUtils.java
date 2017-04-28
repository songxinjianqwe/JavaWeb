package version3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public final class JDBCUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static DataSource dataSource = null;
	//线程安全的Connection
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	private JDBCUtils() {
	}

	static {
		Properties props = new Properties();
		try {
			props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = props.getProperty("driver2");
			url = props.getProperty("url2");
			username = props.getProperty("username");
			password = props.getProperty("password");
			props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getConn() throws SQLException {
		// 开启事务时，返回同一个连接
		Connection conn = threadLocal.get();
		if (conn != null) {
			return conn;
		} else {
			// 未开启事务时，创建一个新的连接
			return dataSource.getConnection();
		}
	}

	public static void free(ResultSet rs, Statement stmt, Connection c) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (c != null) {
						c.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**共享Connection可能会造成多线程问题
	 * 设置手动提交 dao的多次方法调用需要使用同一个Connection
	 * 
	 * @throws SQLException
	 */
	public static void beginTransaction() throws SQLException {
		Connection conn = threadLocal.get();
		if(conn != null){
			throw new SQLException("Transaction has opened");
		}
		conn = getConn();
		conn.setAutoCommit(false);
		threadLocal.set(conn);
	}
	
	/**
	 * 获取beginTransaction的Connection
	 * 
	 * @throws SQLException
	 */
	public static void commitTransaction() throws SQLException {
		Connection conn = threadLocal.get();
		if(conn == null){
			throw new SQLException("Transaction has not opened");
		}
		conn.commit();
		conn.close();
		conn = null;
		// 下次获取的是一个新的连接
		threadLocal.remove();
	}

	public static void rollbackTransaction() throws SQLException {
		Connection conn = threadLocal.get();
		if(conn == null){
			throw new SQLException("Transaction has not opened");
		}
		conn.rollback();
		conn.close();
		conn = null;
		threadLocal.remove();
	}
	
	public static void releaseConnection(Connection c) throws SQLException{
		Connection conn = threadLocal.get();
		if(conn == null || c != conn){
			c.close();
		}
	}

}
