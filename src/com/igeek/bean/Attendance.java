package com.igeek.bean;
/**
  * 考勤表信息
 * @author 小 k 
 * @date 2018年10月30日 上午9:23:33 
 *
 */
public class Attendance {
	/**
	 * 	考勤id			attendanceid
	 *	员工工号			staffnumber
	 *	时间（年月）		attendancedate
	 *	出勤天数			attendancedays
	 *	迟到早退			lateandleaveearly
	 *	部门好			departmentid
	 */
	private int attendanceid;
	private int staffnumber;
	private String attendancedate;
	private int attendancedays;
	private int lateandleaveearly;
	private int departmentid;
	
	public Attendance() {
	}
	
	public Attendance(int attendanceid, int staffnumber,  String attendancedate, int attendancedays,
			int lateandleaveearly, int departmentid) {
		this.attendanceid = attendanceid;
		this.staffnumber = staffnumber;
		this.attendancedate = attendancedate;
		this.attendancedays = attendancedays;
		this.lateandleaveearly = lateandleaveearly;
		this.departmentid = departmentid;
	}
	public int getAttendanceid() {
		return attendanceid;
	}
	public void setAttendanceid(int attendanceid) {
		this.attendanceid = attendanceid;
	}
	public int getStaffnumber() {
		return staffnumber;
	}
	public void setStaffnumber(int staffnumber) {
		this.staffnumber = staffnumber;
	}
	public String getAttendancedate() {
		return attendancedate;
	}
	public void setAttendancedate(String attendancedate) {
		this.attendancedate = attendancedate;
	}
	public int getAttendancedays() {
		return attendancedays;
	}
	public void setAttendancedays(int attendancedays) {
		this.attendancedays = attendancedays;
	}
	public int getLateandleaveearly() {
		return lateandleaveearly;
	}
	public void setLateandleaveearly(int lateandleaveearly) {
		this.lateandleaveearly = lateandleaveearly;
	}
	
	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	@Override
	public String toString() {
		return "Attendance [attendanceid=" + attendanceid + ", staffnumber=" + staffnumber + ", attendancedate=" + attendancedate + ", attendancedays=" + attendancedays + ", lateandleaveearly="
				+ lateandleaveearly + ", departmentid=" + departmentid + "]";
	}
	
	
}
