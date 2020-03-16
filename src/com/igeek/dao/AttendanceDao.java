package com.igeek.dao;

import java.sql.SQLException;
import java.util.List;

import com.igeek.bean.Attendance;

public interface AttendanceDao {
	/**
	 * 查询员工staffnumber查询员工的考勤状况
	 */
	public Attendance selectAttendanceByStaffnumber(int staffnumber) throws SQLException;
	
	/**
	  * 根据部门号查询该部门的考勤信息
	 */
	public List<Attendance> selectAllAttendanceByDepartmentid(int departmentid) throws SQLException;
	
	/**
	  * 根据月份查询考勤信息
	 * @throws SQLException 
	 */
	public List<Attendance> selectAllAttendanceByMonth(String month) throws SQLException;
	
	/**
	 * 添加员工工号及部门号到出勤表
	 */
	public int  insertStaffNumberAndDepartentidToAttendance(int staffnumber,int departmentid) throws SQLException;
	
	/**
	 * 查询所有的考勤信息
	 * @param pageSize 
	 * @param index 
	 */
	public List<Attendance> selectAllAttendance(int index, int pageSize) throws SQLException;
	
	/**
	 * 查询共有多少条数据
	 */
	public int selectTotalCount() throws SQLException;

	public List<Attendance> selectAttendance(int index, int pageSize, String staffnumber, String departmentid,
			String attendancedays) throws SQLException;

	public int selectAttendanceTotalCount(String staffnumber, String departmentid, String attendancedays)throws SQLException;
}
