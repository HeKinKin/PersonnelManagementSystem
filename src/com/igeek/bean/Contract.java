package com.igeek.bean;

public class Contract {
	private int contractid;
	private int staffnumber;
	private String staffname;
	private String contractname;
	private String contractcontext;
	private String contractdate;
	private String expiredate;
	public Contract() {
		
	}
	public Contract(int contractid, int staffnumber,String staffname,String contractname, String contractcontext, String contractdate,
			String expiredate) {
		super();
		this.contractid = contractid;
		this.staffnumber = staffnumber;
		this.contractname = contractname;
		this.contractcontext = contractcontext;
		this.contractdate = contractdate;
		this.expiredate = expiredate;
		this.staffname=staffname;
	}
	
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public int getContractid() {
		return contractid;
	}
	public void setContractid(int contractid) {
		this.contractid = contractid;
	}
	public int getStaffnumber() {
		return staffnumber;
	}
	public void setStaffnumber(int staffnumber) {
		this.staffnumber = staffnumber;
	}
	public String getContractname() {
		return contractname;
	}
	public void setContractname(String contractname) {
		this.contractname = contractname;
	}
	public String getContractcontext() {
		return contractcontext;
	}
	public void setContractcontext(String contractcontext) {
		this.contractcontext = contractcontext;
	}
	public String getContractdate() {
		return contractdate;
	}
	public void setContractdate(String contractdate) {
		this.contractdate = contractdate;
	}
	public String getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(String expiredate) {
		this.expiredate = expiredate;
	}
	
}
