package com.igeek.service;

import java.util.List;

import com.igeek.bean.Department;

public interface DepartmentService {
	/*
	 * 查全部
	 */
	List<Department> Searchall();
	/*
	 * 根据id查
	 */
	Department SearchId(int departmentid);
}
