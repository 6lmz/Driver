package com.gravity.service;

import com.gravity.dao.UserDao;
import com.gravity.impl.UserDaoImpl;

import java.sql.SQLException;

import com.gravity.beam.Upart;


public class UserService {
	UserDao ud = new UserDaoImpl();
	
	/**
	 * 用户添加数据的控制层
	 * @return 
	 */

	
	public boolean addtoUser(Upart user) throws SQLException{
	
		return ud.addtoUser(user);
	}
	/**
	 * 根据用户对象查询数据库中是否有对应的数据
	 */
	public boolean queryUserWith(Upart user) throws SQLException{
		return ud.queryUserWith(user);
	}
	/**
	 * @param user
	 * @return
	 */

}
