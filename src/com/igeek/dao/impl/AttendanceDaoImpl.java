package com.igeek.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.bean.Attendance;
import com.igeek.dao.AttendanceDao;
import com.igeek.utils.JDBCUtils;

public class AttendanceDaoImpl implements AttendanceDao{
	
	private final QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

	@Override
	/**
	  *  查询id查询员工的考勤状况
	 */
	public Attendance selectAttendanceByStaffnumber(int staffnumber) throws SQLException {
		String sql = "select * from attendance where staffnumber = ?";
		Attendance attendance = runner.query(sql, new BeanHandler<>(Attendance.class),staffnumber);
		return attendance;
	}

	@Override
	/**
	 * 查询部门的考勤信息
	 */
	public List<Attendance> selectAllAttendanceByDepartmentid(int departmentid) throws SQLException {
		String sql = "select * from attendance where departmentid = ?";
		List<Attendance> list = runner.query(sql, new BeanListHandler<Attendance>(Attendance.class), departmentid);
		return list;
	}

	@Override
	/**
	 * 根据月份查询员工的考勤信息
	 */
	public List<Attendance> selectAllAttendanceByMonth(String month) throws SQLException {
		String sql = "select * from attendance where attendancedate = ? ";
		List<Attendance> list = runner.query(sql, new BeanListHandler<>(Attendance.class), month);
		return list;
	}

	@Override
	public int insertStaffNumberAndDepartentidToAttendance(int staffnumber, int departmentid) throws SQLException {
		String sql = "insert into attendance(attendanceid,staffnumber,departmentid) values(null,?,?)";
		int i = runner.update(sql, staffnumber,departmentid);
		return i;
	}

	@Override
	public List<Attendance> selectAllAttendance(int index, int pageSize) throws SQLException {
		String sql = "select * from attendance order by attendancedate limit ?,?";
		List<Attendance> list = runner.query(sql, new BeanListHandler<>(Attendance.class),index,pageSize);
		return list;
	}

	@Override
	public int selectTotalCount() throws SQLException {
		String sql = "select count(1) from attendance";
		Long rows = (Long)runner.query(sql, new ScalarHandler());
		return rows.intValue();
	}

	@Override
	/**
	 * 根据关键词进行搜索
	 */
	public List<Attendance> selectAttendance(int index, int pageSize, String staffnumber, String departmentid,
			String attendancedays) throws SQLException {
		String sql = "select * from attendance where 1=1 ";
		if(staffnumber.trim() != "") {
			sql =sql + " and staffnumber="+staffnumber;
		}
		if(departmentid.trim() != "") {
			sql = sql +" and departmentid="+departmentid;
		}
		if(attendancedays.trim() != "") {
			sql = sql +" and attendancedate='"+attendancedays+"'";
		}
		sql = sql + " limit ?,?";
		/*System.out.println(sql);*/
		List<Attendance> attendanceList = runner.query(sql, new BeanListHandler<Attendance>(Attendance.class),index,pageSize);
		return attendanceList;
	}

	@Override
	public int selectAttendanceTotalCount(String staffnumber, String departmentid, String attendancedays)
			throws SQLException {
		String sql = "select count(1) from attendance where 1=1 ";
		if(staffnumber.trim() != "") {
			sql =sql + " and staffnumber="+staffnumber;
		}
		if(departmentid.trim() != "") {
			sql = sql +" and departmentid="+departmentid;
		}
		if(attendancedays.trim() != "") {
			sql = sql +" and attendancedate="+attendancedays;
		}
		
		Long rows = (Long)runner.query(sql, new ScalarHandler());
		return rows.intValue();
	}

}
