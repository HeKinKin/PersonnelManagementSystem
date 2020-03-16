package com.igeek.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.bean.Department;
import com.igeek.dao.DepartmentDao;
import com.igeek.utils.JDBCUtils;

public class DepartmentDaoImpl implements DepartmentDao{
private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public List<Department> selectall() throws Exception {
		String sql ="select * from department";
		return qr.query(sql,new BeanListHandler<>(Department.class));
	}

	@Override
	public Department selectById(int departmentid) throws Exception {
		String sql ="select * from department where departmentid = ?";
		Object [] params = {departmentid};
		return qr.query(sql, new BeanHandler<>(Department.class),params);
	}

}
