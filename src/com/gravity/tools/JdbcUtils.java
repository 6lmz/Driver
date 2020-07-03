package com.gravity.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
	private JdbcUtils() {}
	
	private static String jdbcDriver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql:///driver?useSSL=false";
	private static String user="root";
	private static String password="111111";
	
	/**
	 * 获取数据连接对象
	 */
	
	public static Connection getConnection() {
		try {
			Class.forName(jdbcDriver);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;		
	}
	
	/**
	 * 关闭数据库资源
	 */
	
	public static void closeDB(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}		
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
	}
}



























