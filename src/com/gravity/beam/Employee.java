package com.gravity.beam;

import java.util.Date;

public class Employee {
	/**
	 * 雇员类 
	 * 存放雇员信息
	 */

	int id;
	String name;
	int tel;
	String sex;
	String carType;
	String carnum;
	String nowstate;
	Date joinTime;
	
	public Employee(int id, String name, int tel, String sex, String carType, String carnum, String nowstate,
			Date joinTime) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.sex = sex;
		this.carType = carType;
		this.carnum = carnum;
		this.nowstate = nowstate;
		this.joinTime = joinTime;
	}
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", tel=" + tel + ", sex=" + sex + ", carType=" + carType
				+ ", carnum=" + carnum + ", nowstate=" + nowstate + ", joinTime=" + joinTime + "]";
	}
	public String getnowstate() {
		return nowstate;
	}
	
	public void setnowstate(String nowstate) {
		this.nowstate = nowstate;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getTel() {
		return tel;
	}
	
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getCarType() {
		return carType;
	}
	
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public String getCarnum() {
		return carnum;
	}
	
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	
	
	public Date getJoinTime() {
		return joinTime;
	}
	
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
}
