package com.igeek.dao;

import java.util.List;

import com.igeek.bean.Staff;
import com.igeek.bean.Wage;

public interface WageDao {
	
	Wage selectwageBywageid(int wageid) throws Exception;//通过工资表编号查询工资	
	Staff selectBystaffnumber(int staffnumber)throws Exception;//根据员工工号查询	员工信息（添加时）
	int insertwage(Wage wage) throws Exception;//工资表添加
	int updatewage(Wage wage)throws Exception;//工资表的修改
	int deletewage(int staffnumber) throws Exception;//工资表的删除
	int selectwageCount(String staffnumber, String departmentname) throws Exception;//查询出工资表中记录的数量(分页显示)	
	List<Wage> selectAllWage(int begin,int size) throws Exception;//查询出工资表所有的记录集合
	List<Wage> selectCondition(int index, int pageSize, String staffnumber, String departmentname) throws Exception;
	
}
