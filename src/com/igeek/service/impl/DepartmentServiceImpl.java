package com.igeek.service.impl;

import java.util.List;

import com.igeek.bean.Department;
import com.igeek.dao.DepartmentDao;
import com.igeek.dao.impl.DepartmentDaoImpl;
import com.igeek.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentDao departmentDao;
	public DepartmentServiceImpl() {
		departmentDao = new  DepartmentDaoImpl();
	}
	
	
	
	@Override
	public List<Department> Searchall() {
		try {
			return departmentDao.selectall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Department SearchId(int departmentid) {
		try {
			return departmentDao.selectById(departmentid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
