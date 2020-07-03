package com.gravity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gravity.tools.JdbcUtils;
import com.gravity.beam.Upart;

import com.gravity.dao.UserDao;

public  class UserDaoImpl implements UserDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	
	public boolean addtoUser(Upart user) throws SQLException{//添加用户到数据库用户表
		try {
			
			conn = JdbcUtils.getConnection();
			String sql = "insert into upart values(?,?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			int row = ps.executeUpdate();
			return row >0 ? true:false;
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtils.closeDB(conn, ps, null);
		}
			
	}
	
	public boolean queryUserWith(Upart user) throws SQLException{//和数据库的用户信息进行对比
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from upart where name=? and password=?;";
			ps = conn.prepareStatement(sql);
			//设置参数
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtils.closeDB(conn, ps, rs);
		}
	}

}
