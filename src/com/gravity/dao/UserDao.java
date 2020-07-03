package com.gravity.dao;

import java.sql.SQLException;

import com.gravity.beam.Upart;


public interface UserDao {
	/**
	 * 添加用户到数据库的方法
	 * @param user
	 * @return 
	 */
	public boolean addtoUser(Upart user) throws SQLException;//添加用户到数据库用户表
	
	public boolean queryUserWith(Upart user) throws SQLException;//和数据库的用户信息进行对比
}
