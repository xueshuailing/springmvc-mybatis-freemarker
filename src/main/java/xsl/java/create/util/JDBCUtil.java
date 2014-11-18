package xsl.java.create.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import xsl.java.create.view.main.db.DbType;

public class JDBCUtil {
	private static Connection conn = null;

	private static Connection _getConn() {
		String url = "jdbc:mysql://192.168.1.25:3306/ydyx";
		// String url = "jdbc:oracle:thin:@192.168.1.8:1521:orcl";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("获取连接成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 获取数据库连接
	 * 
	 * @param dbType
	 * @param url
	 * @param dbUser
	 * @param dbPass
	 * @return
	 */
	public static Connection getConn(DbType dbType, String url, String dbUser, String dbPass) {
		DriverManager.setLogWriter(new PrintWriter(System.out));
		
		// String url = "jdbc:oracle:thin:@192.168.1.8:1521:orcl";
			try {
				switch (dbType) {
				case MYSQL:
					url = "jdbc:mysql://" + url;
					Class.forName("com.mysql.jdbc.Driver");
					break;
				case ORACLE:
//					url = "jdbc:oracle:thin:@"+url+":1521:orcl";
//					Class.forName("oracle.jdbc.OracleDriver");
					break;
				case SQLSERVER:
				//	url="jdbc:sqlserver://localhost:1433; DatabaseName=UniversityDB";
//					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				default:
				// url = "jdbc:mysql://" + url;
				//		Class.forName("com.mysql.jdbc.Driver");
					break;
				}
				conn = DriverManager.getConnection(url, dbUser, dbPass);
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return conn;
	}


	public static void free(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void free(Statement pstmt, Connection conn) {
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void free(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void free(ResultSet rs, Statement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
	}
}
