package com.igeek.dao;

import java.util.List;

import com.igeek.bean.Department;

public interface DepartmentDao {
	/*
	 * 查全部
	 */
	List<Department> selectall()throws Exception;
	/*
	 * 根据id查
	 */
	Department selectById(int departmentid)throws Exception;
}
