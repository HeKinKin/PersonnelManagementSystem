package com.igeek.bean;
 /* 员工类: 对应员工表中的staff
  *  private  int staffid;
     private  int staffnumber;
     private  String staffname;
     private  String stafftel;
     private  String staffemail;
     private  int  departmentid;
     private int positionid;
     private String workingstate;
  * 
  * 
  * */
public class Staff {
     private  int staffid;
     private  int staffnumber;
     private  String staffname;
     private  String stafftel;
     private  String staffemail;
     private  int  departmentid;
     private int positionid;
     private String workingstate;
     private Department dep;
     private Positionn pos;
	public Department getDep() {
		return dep;
	}
	public void setDep(Department dep) {
		this.dep = dep;
	}
	public Positionn getPos() {
		return pos;
	}
	public void setPos(Positionn pos) {
		this.pos = pos;
	}
	
	public Staff() {
		super();
	}
	
	public Staff(int staffid, int staffnumber, String staffname, String stafftel, String staffemail, int departmentid,
			int positionid, String workingstate, Department dep, Positionn pos) {
		super();
		this.staffid = staffid;
		this.staffnumber = staffnumber;
		this.staffname = staffname;
		this.stafftel = stafftel;
		this.staffemail = staffemail;
		this.departmentid = departmentid;
		this.positionid = positionid;
		this.workingstate = workingstate;
		this.dep = dep;
		this.pos = pos;
	}
	
	@Override
	public String toString() {
		return "Staff [staffid=" + staffid + ", staffnumber=" + staffnumber + ", staffname=" + staffname + ", stafftel="
				+ stafftel + ", staffemail=" + staffemail + ", departmentid=" + departmentid + ", positionid="
				+ positionid + ", workingstate=" + workingstate + ", dep=" + dep + ", pos=" + pos + "]";
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public int getStaffnumber() {
		return staffnumber;
	}
	public void setStaffnumber(int staffnumber) {
		this.staffnumber = staffnumber;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getStafftel() {
		return stafftel;
	}
	public void setStafftel(String stafftel) {
		this.stafftel = stafftel;
	}
	public String getStaffemail() {
		return staffemail;
	}
	public void setStaffemail(String staffemail) {
		this.staffemail = staffemail;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public int getPositionid() {
		return positionid;
	}
	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}
	public String getWorkingstate() {
		return workingstate;
	}
	public void setWorkingstate(String workingstate) {
		this.workingstate = workingstate;
	}
     
}
