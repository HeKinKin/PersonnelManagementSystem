package com.igeek.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.bean.Department;
import com.igeek.bean.Staff;
import com.igeek.bean.Wage;
import com.igeek.dao.WageDao;
import com.igeek.utils.JDBCUtils;

public class WageDaoImpl implements WageDao{

	//dbutils工具
		private  QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	
	
	
	// 按照员工工号 模糊查询
	@Override
	public Staff selectBystaffnumber(int staffnumber) throws Exception {
		String sql = "select * from staff where staffnumber=?";
		Object [] params = {staffnumber};
		BeanHandler<Staff> handler=new BeanHandler<>(Staff.class);
		Staff staff=qr.query(sql, handler,params);
		return staff;
	}

	//新增
	@Override
	public int insertwage(Wage wage) throws Exception {
		String  sql="insert into wage(staffnumber,departmentid,wagedate,basicwage,bonusgrant,insurance,fine,payable,realwage) values(?,?,?,?,?,?,?,?,?)";
		Object [] params= {wage.getStaffnumber(),wage.getDepartmentid(),wage.getWagedate(),wage.getBasicwage(),wage.getBonusgrant(),wage.getInsurance(),wage.getFine(),wage.getPayable(),wage.getRealwage()};
		return qr.update(sql, params);
	}

	//修改工资表相关信息
	@Override
	public int updatewage(Wage wage) throws Exception {
		String sql="update wage set basicwage=?,bonusgrant=?,insurance=?,fine=?,payable=?,realwage=? where wageid=?";
		Object [] params= {wage.getBasicwage(),wage.getBonusgrant(),wage.getInsurance(),wage.getFine(),wage.getPayable(),wage.getRealwage(),wage.getWageid()};
		return qr.update(sql, params);
	}

	//删除不需要的工资表
	@Override
	public int deletewage(int staffnumber) throws Exception {
		String sql="delete from wage where staffnumber=?";
		Object [] params= {staffnumber};
		return qr.update(sql, params);
		
	}

	//查询出工资表中记录的数量(分页显示)	
	@Override
	public int selectwageCount(String staffnumber, String departmentname) throws Exception {
		String sql="select count(1) from wage where 1=1";
		if(staffnumber!= null&&departmentname!=null) {
			if(staffnumber.trim() != "") {
				sql =sql + " and staffnumber="+staffnumber;
			}
			//System.out.println(sql);
			if(departmentname.trim() != "") {
				String name = departmentname.trim();
				//找到部门号				
				Department department=qr.query("select * from department where departmentname like ?",
						new BeanHandler<>(Department.class),"%"+name+"%");
				int departmentid=department.getDepartmentid();
				sql =sql + " and departmentid="+departmentid;
			}
		}
		
		long count=(long) qr.query(sql, new ScalarHandler());		
		return (int) count;
	}

	


	//通过工资表编号查询工资(修改时需要数据)
	@Override
	public Wage selectwageBywageid(int wageid) throws Exception {
		String sql = "select * from wage where wageid = ?";
		Object [] params = {wageid};
		BeanHandler<Wage> handler = new BeanHandler<>(Wage.class);
		Wage w = qr.query(sql, handler,params);
		return w;
	}

	
	
	@Override
	// 根据关键词进行搜索
	 
	public List<Wage> selectCondition(int begin, int size, String staffnumber, String departmentname) throws Exception {	
		
		//查工资表
		String sql = "select * from wage where 1=1 ";
		
		//添加条件
		/*System.out.println("staffnumber:"+staffnumber);
		String a = staffnumber.trim();
		System.out.println("a"+a);*/
		if(staffnumber!= null&&departmentname!=null) {
			if(staffnumber.trim() != "") {
				sql =sql + " and staffnumber="+staffnumber;
			}
			
			if(departmentname.trim() != "") {
				String name = departmentname.trim();
				//找到部门号
				//String sqls="select departmentid from department where departmentname like ?";
				Department department=qr.query("select * from department where departmentname like ?",
						new BeanHandler<>(Department.class),"%"+name+"%");
				System.out.println();
				int departmentid=department.getDepartmentid();
				//int departmentid = qr.query(sqls, new ScalarHandler<>(),departmentname);
				sql =sql + " and departmentid="+departmentid;
			}
		}
		
		sql = sql + " limit ?,?";
		
		
		List<Wage> list = qr.query(sql, new BeanListHandler<Wage>(Wage.class),begin,size);	
	
		for (Wage wage : list) {
			int number = wage.getStaffnumber();
			Staff staff = qr.query("select * from staff where staffnumber = ?", 
					new BeanHandler<>(Staff.class),number); 
		
			Department department=qr.query("select * from department where departmentid = ?",
					new BeanHandler<>(Department.class), staff.getDepartmentid());
		
			staff.setDep(department);
			wage.setStaff(staff);
		}
		
		return list;
	}
	
	
	//查询出工资表所有的记录集合
		@Override
		public List<Wage> selectAllWage(int begin, int size) throws Exception {
			String sql="select * from wage limit ?,?";
			Object [] params = {begin,size};
			List<Wage> list = qr.query(sql, new BeanListHandler<>(Wage.class),params);
			for(Wage wage:list) {
				int staffnumber = wage.getStaffnumber();
				//根据员工id找到员工信息
				Staff staff = qr.query("select * from staff where staffnumber = ?", 
						new BeanHandler<>(Staff.class),staffnumber); 
				//根据部门id找到部门
				Department department=qr.query("select * from department where departmentid = ?",
						new BeanHandler<>(Department.class), staff.getDepartmentid());
				staff.setDep(department);
				wage.setStaff(staff);
			}		
			return list;
		}
	
}



