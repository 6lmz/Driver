package com.gravity.beam;

public class User extends Upart{
	int phone;

	String email;
	String newpassword;
	public User(String name, String password, int phone, String email, String newpassword) {
		super(name, password);
		this.phone = phone;
		this.email = email;
		this.newpassword = newpassword;
	}
	

	@Override
	public String toString() {
		return "User [phone=" + phone + ", email=" + email + ", newpassword=" + newpassword + ", name=" + name
				+ ", password=" + password + "]";
	}

	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
}
