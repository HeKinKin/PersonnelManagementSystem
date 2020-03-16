package com.igeek.bean;

public class User {
	private int adminid;
	private String adminloginname;
	private String adminpassword;
	private int power;
	
	public User(int adminid, String adminloginname, String adminpassword, int power) {
		super();
		this.adminid = adminid;
		this.adminloginname = adminloginname;
		this.adminpassword = adminpassword;
		this.power = power;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminloginname() {
		return adminloginname;
	}
	public void setAdminloginname(String adminloginname) {
		this.adminloginname = adminloginname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "User [adminid=" + adminid + ", adminloginname=" + adminloginname + ", adminpassword=" + adminpassword
				+ ", power=" + power + "]";
	}
	
	
}
