package com.igeek.bean;

public class Wage {

	private int wageid; //工资表ID
	private int staffnumber;  //员工工号
	private int departmentid;
	private String wagedate;  //工资的日期
	private double basicwage; //基本工资
	private double bonusgrant;	//奖金补助
	private double insurance;	//五险一金
	private double fine;	//罚款
	private double payable;		//应发工资
	private double realwage;	//实发工资
	private Staff staff;
	
	public Wage() {
	
	}
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getWageid() {
		return wageid;
	}
	public void setWageid(int wageid) {
		this.wageid = wageid;
	}
	public int getStaffnumber() {
		return staffnumber;
	}
	public void setStaffnumber(int staffnumber) {
		this.staffnumber = staffnumber;
	}
	
	public String getWagedate() {
		return wagedate;
	}
	public void setWagedate(String wagedate) {
		this.wagedate = wagedate;
	}
	public double getBasicwage() {
		return basicwage;
	}
	public void setBasicwage(double basicwage) {
		this.basicwage = basicwage;
	}
	public double getBonusgrant() {
		return bonusgrant;
	}
	public void setBonusgrant(double bonusgrant) {
		this.bonusgrant = bonusgrant;
	}
	public double getInsurance() {
		return insurance;
	}
	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public double getPayable() {
		return payable;
	}
	public void setPayable(double payable) {
		this.payable = payable;
	}
	public double getRealwage() {
		return realwage;
	}
	public void setRealwage(double realwage) {
		this.realwage = realwage;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	
}
