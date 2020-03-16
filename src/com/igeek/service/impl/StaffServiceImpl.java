package com.igeek.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.igeek.bean.Paging;
import com.igeek.bean.Staff;
import com.igeek.dao.StaffDao;
import com.igeek.dao.impl.StaffDaoImpl;
import com.igeek.service.StaffService;

public class StaffServiceImpl implements StaffService{
    StaffDao dao=new StaffDaoImpl();
	@Override
	public Staff searchBystaffnumber(int staffnumber) {
		try {
		return	dao.selectBystaffnumber(staffnumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public   List<Staff> searchBydepartmentid(int departmentid) {
		try {
		return	dao.selectBydepartmentid(departmentid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addStaffmsg(Staff staff) {
		try {
			return dao.insertStaffmsg(staff)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editStaffmsg(Staff staff) {
		try {
			 return  dao.updateStaffmsg(staff)>0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public Paging<Staff> paging(int curPage, int pageSize) {
		Paging<Staff> paging =new Paging<Staff>(pageSize,curPage);
		try {
		 int rowCount =dao.selectrowCount();
		 int pageCount=(int)  Math.ceil(  rowCount/(double)pageSize);
		   int begin=(curPage-1)*pageSize;
		   List<Staff> data = dao.selectAllStaffMsg(begin, pageSize);
		   paging.setRowsCount(rowCount);
		   paging.setPageCount(pageCount);
		   paging.setData(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paging;
	}

	@Override
	public List<Staff> searchBypositionid(int positionid) {
		try {
			return dao.selectByPositionId(positionid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Paging<Staff> pagingBystaffname(int curPage, int pageSize,String staffname) {
		Paging<Staff> paging =new Paging<Staff>(pageSize,curPage);
		try {
		   int rowCount =dao.selectrowCount1(staffname);
		   int pageCount=(int)  Math.ceil(  rowCount/(double)pageSize);
		   int begin=(curPage-1)*pageSize;
		   List<Staff> data = dao.selectBystaffname(begin, pageSize,staffname);
		   paging.setRowsCount(rowCount);
		   paging.setPageCount(pageCount);
		   paging.setData(data);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return paging;
	}


	

}
