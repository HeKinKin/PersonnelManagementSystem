package com.igeek.service;

import java.util.List;

import com.igeek.bean.Attendance;
import com.igeek.bean.Paging;

public interface AttendanceService {
	/**
	  * 根据员工id查询员工的考勤状况
	 */
	public Attendance findAttendanceByAttendanceid(int staffnumber);
	
	/**
	  * 根据部门号查询考勤信息
	 *
	 */
	public List<Attendance> findAllAttendanceByDepartmentid(int departmentid);
	
	/**
	 * 根据月份查询考勤信息
	 */
	public List<Attendance> findAllAttendanceByMonth(String month);	
	
	/**
	 * 添加出勤表员工信息
	 */
	public boolean addStaff(int staffnumber, int departmentid );
	
	
	/**
	 * 封装pagging对象
	 */
	public Paging<Attendance> findPagging(int curPage, int pageSize);

	public Paging<Attendance> findAttendance(int curPage, int pageSize, String staffnumber, String departmentid,
			String attendancedays);

}
