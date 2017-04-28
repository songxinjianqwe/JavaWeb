package version2;

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
	private JDBCUtils() {}

	static {
		Properties props = new Properties();
		try {
			props.load(JDBCUtils.class.getClassLoader().getResourceAsStream(
					"db.properties"));
			driver = props.getProperty("driver2");
			url = props.getProperty("url2");
			username = props.getProperty("username");
			password = props.getProperty("password");
			props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
				dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	

	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
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
} 

