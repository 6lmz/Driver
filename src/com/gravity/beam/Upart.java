package com.gravity.beam;

public class Upart {
	/**
	 * 管理员用户类
	 * 存放账号，密码
	 */
	String name;
	String password;
	
	public Upart(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
