package com.igeek.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.igeek.bean.Attendance;
import com.igeek.bean.Paging;
import com.igeek.dao.AttendanceDao;
import com.igeek.dao.impl.AttendanceDaoImpl;
import com.igeek.service.AttendanceService;

public class AttendanceServiceImpl implements AttendanceService {

	private final AttendanceDao dao = new AttendanceDaoImpl();

	@Override
	/**
	 * 根据员工staffnumber找到员工的考勤信息
	 */
	public Attendance findAttendanceByAttendanceid(int staffnumber) {
		Attendance attendance = null;
		try {
			attendance = dao.selectAttendanceByStaffnumber(staffnumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attendance;
	}

	@Override
	public List<Attendance> findAllAttendanceByDepartmentid(int departmentid) {
		try {
			return dao.selectAllAttendanceByDepartmentid(departmentid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Attendance> findAllAttendanceByMonth(String month) {
		try {
			return dao.selectAllAttendanceByMonth(month);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/**
	 * 添加员工
	 */
	public boolean addStaff(int staffnumber, int departmentid) {
		int row = 0;
		try {
			row = dao.insertStaffNumberAndDepartentidToAttendance(staffnumber, departmentid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row>0;
	}

	

	@Override
	public Paging<Attendance> findPagging(int curPage, int pageSize) {
		Paging<Attendance> pagging = new Paging<Attendance>();
		//封装当前页
		pagging.setCurPage(curPage);
		//封装每页显示的条数
		pagging.setPageSize(pageSize);
		//索引
		int index = (curPage-1)*pageSize;
		int rowscount = 0;
		int pagecount = 0;
		List<Attendance> data = null;
		try {
			rowscount = dao.selectTotalCount();
			pagecount= (int) Math.ceil((double)rowscount/pageSize);
			data = dao.selectAllAttendance(index, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//封装总条数
		pagging.setRowsCount(rowscount);
		//封装总页数
		pagging.setPageCount(pagecount);
		//封装每页显示的数据
		pagging.setData(data);
		
		//封装总页数
		return pagging;
	}

	@Override
	/**
	 * 根据关键词进行搜索
	 */
	public Paging<Attendance> findAttendance(int curPage, int pageSize, String staffnumber, String departmentid,
			String attendancedays) {
		Paging<Attendance> pagging = new Paging<Attendance>();
		//封装当前页
		pagging.setCurPage(curPage);
		//封装每页显示的条数
		pagging.setPageSize(pageSize);
		//索引
		int index = (curPage-1)*pageSize;
		int rowscount = 0;
		int pagecount = 0;
		List<Attendance> data = null;
		try {
			rowscount = dao.selectAttendanceTotalCount(staffnumber,departmentid,attendancedays);
			pagecount= (int) Math.ceil((double)rowscount/pageSize);
			data = dao.selectAttendance(index, pageSize,  staffnumber,  departmentid, attendancedays);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//封装总条数
		pagging.setRowsCount(rowscount);
		//封装总页数
		pagging.setPageCount(pagecount);
		//封装每页显示的数据
		pagging.setData(data);
		
		//封装总页数
		return pagging;
	}

}
