package com.igeek.bean;

public class File {
	
	private int fileid;
	private int staffnumber;
	private String staffimg;
	private String staffsex;
	private String nationality;
	private String politicalstatus;
	private String staffbirthday;
	private String entrytime;
	private String staffeducation;
	private String graduatedschool;
	private String staffaddress;
	private Staff staff;
	
	
	public File() {
		
	}


	public File(int fileid, int staffnumber, String staffimg, String staffsex, String nationality,
			String politicalstatus, String staffbirthday, String entrytime, String staffeducation,
			String graduatedschool, String staffaddress, Staff staff) {
		super();
		this.fileid = fileid;
		this.staffnumber = staffnumber;
		this.staffimg = staffimg;
		this.staffsex = staffsex;
		this.nationality = nationality;
		this.politicalstatus = politicalstatus;
		this.staffbirthday = staffbirthday;
		this.entrytime = entrytime;
		this.staffeducation = staffeducation;
		this.graduatedschool = graduatedschool;
		this.staffaddress = staffaddress;
		this.staff = staff;
	}


	public int getFileid() {
		return fileid;
	}


	public void setFileid(int fileid) {
		this.fileid = fileid;
	}


	public int getStaffnumber() {
		return staffnumber;
	}


	public void setStaffnumber(int staffnumber) {
		this.staffnumber = staffnumber;
	}


	public String getStaffimg() {
		return staffimg;
	}


	public void setStaffimg(String staffimg) {
		this.staffimg = staffimg;
	}


	public String getStaffsex() {
		return staffsex;
	}


	public void setStaffsex(String staffsex) {
		this.staffsex = staffsex;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getPoliticalstatus() {
		return politicalstatus;
	}


	public void setPoliticalstatus(String politicalstatus) {
		this.politicalstatus = politicalstatus;
	}


	public String getStaffbirthday() {
		return staffbirthday;
	}


	public void setStaffbirthday(String staffbirthday) {
		this.staffbirthday = staffbirthday;
	}


	public String getEntrytime() {
		return entrytime;
	}


	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}


	public String getStaffeducation() {
		return staffeducation;
	}


	public void setStaffeducation(String staffeducation) {
		this.staffeducation = staffeducation;
	}


	public String getGraduatedschool() {
		return graduatedschool;
	}


	public void setGraduatedschool(String graduatedschool) {
		this.graduatedschool = graduatedschool;
	}


	public String getStaffaddress() {
		return staffaddress;
	}


	public void setStaffaddress(String staffaddress) {
		this.staffaddress = staffaddress;
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}


	@Override
	public String toString() {
		return "File [fileid=" + fileid + ", staffnumber=" + staffnumber + ", staffimg=" + staffimg + ", staffsex="
				+ staffsex + ", nationality=" + nationality + ", politicalstatus=" + politicalstatus
				+ ", staffbirthday=" + staffbirthday + ", entrytime=" + entrytime + ", staffeducation=" + staffeducation
				+ ", graduatedschool=" + graduatedschool + ", staffaddress=" + staffaddress + ", staff=" + staff + "]";
	}
	
	
	
	
}
