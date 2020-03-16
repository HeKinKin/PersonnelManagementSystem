package com.igeek.service;

import java.util.List;

import com.igeek.bean.Paging;
import com.igeek.bean.Staff;
import com.igeek.bean.Wage;


public interface WageService {

	//新增工资表S
	boolean add(Wage wage);
	//根据wageid查询	
	Wage searchWageBywageid(int wageid);
	//通过员工工号查询员工信息(新增时需要)
	Staff searchWageBystaffnumber(int staffnumber);
	//更新
	boolean update(Wage wage);
	//删除
	boolean delete(int staffnumber);
	//分页查询
	//Paging<Wage> search(int pageSize,int currPage);
	//通过查询条件查询工资表（分页）
	Paging<Wage>  select(int pageSize, int currPage,String staffnumber,String departmentname);
}
