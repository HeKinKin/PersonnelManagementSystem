package com.igeek.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.bean.Department;
import com.igeek.bean.Positionn;
import com.igeek.bean.Staff;
import com.igeek.dao.StaffDao;
import com.igeek.utils.JDBCUtils;
/* StaffDaoImpl:实现StaffDao接口
 * 
 * 
 * */
public class StaffDaoImpl implements StaffDao{
    QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	@Override
	
	/*
	 * 按照员工的编号查询
	 * */
	public Staff selectBystaffnumber(int staffnumber) throws SQLException {
		String sql="SELECT * FROM staff WHERE staffnumber=?;";
		
		Staff staff = qr.query(sql, new BeanHandler<Staff>(Staff.class),staffnumber);
		String sql1="SELECT * FROM positionn  WHERE positionid=?;";
		if(staff!=null) {
			Positionn pos = qr.query(sql1, new BeanHandler<Positionn>(Positionn.class),staff.getPositionid());
			 String sql2="SELECT * FROM department  WHERE departmentid=?;";
			 Department dep = qr.query(sql2, new BeanHandler<Department>(Department.class),staff.getDepartmentid());
			 staff.setDep(dep);
			 staff.setPos(pos);
		}
		 
		 return staff;
	}
    /*
     * 按照员工的姓名模糊查询
     * */
	@Override
	public List<Staff> selectBystaffname(int begin,int pageSize,String staffname) throws SQLException {
		String sql="SELECT * FROM staff WHERE staffname LIKE ? LIMIT ?,?";
		 List<Staff> list = qr.query(sql, new BeanListHandler<Staff>(Staff.class),"%"+staffname+"%",begin,pageSize);
		 for (Staff staff : list) {
			String sql1="SELECT * FROM positionn  WHERE positionid=?;";
			 Positionn pos = qr.query(sql1, new BeanHandler<Positionn>(Positionn.class),staff.getPositionid());
			 String sql2="SELECT * FROM department  WHERE departmentid=?;";
			 Department dep = qr.query(sql2, new BeanHandler<Department>(Department.class),staff.getDepartmentid());
			 staff.setDep(dep);
			 staff.setPos(pos);
		}
		return list;
	}
    
	/*
	 * 按照部门的id查询
	 * 
	 * */
	
	@Override
	public List<Staff> selectBydepartmentid(int departmentid) throws SQLException {
		String sql="SELECT * FROM staff WHERE departmentid=?";
		List<Staff> list = qr.query(sql, new BeanListHandler<Staff>(Staff.class),departmentid);
		
		for (Staff staff2 : list) {
			 String sql1="SELECT * FROM positionn  WHERE positionid=?;";
			 Positionn pos = qr.query(sql1, new BeanHandler<Positionn>(Positionn.class),staff2.getPositionid());
			 String sql2="SELECT * FROM department  WHERE departmentid=?;";
			 Department dep = qr.query(sql2, new BeanHandler<Department>(Department.class),staff2.getDepartmentid());
			 staff2.setDep(dep);
			 staff2.setPos(pos);
		}
		
		 return list;
	}
    /*
     * 增添一条员工信息:通过员工对象
     * 
     * */
	@Override
	public int insertStaffmsg(Staff staff) throws SQLException {
		String sql=" INSERT INTO staff(staffnumber,staffname,stafftel,staffemail,departmentid,positionid,workingstate)\r\n" + 
				" \r\n" + 
				" VALUES(?,?,?,?,?,?,?);";
		return  qr.update(sql,staff.getStaffnumber(),staff.getStaffname(),staff.getStafftel(),staff.getStaffemail(),staff.getDepartmentid(),staff.getPositionid(),staff.getWorkingstate());
	}

	@Override
	public int updateStaffmsg(Staff staff) throws SQLException {
		String sql="UPDATE staff SET staffname=?,stafftel=?,staffemail=?,departmentid=?,positionid=?, workingstate=?\r\n" + 
				"WHERE staffnumber=?;";
		return qr.update(sql,staff.getStaffname(),staff.getStafftel(),staff.getStaffemail(),staff.getDepartmentid(),staff.getPositionid(),staff.getWorkingstate(),staff.getStaffnumber());
	}
	@Override
	/*查询总记录数
	 *供后面分页使用
	 * 
	 * 
	 * 
	 * */
	public int selectrowCount() throws SQLException {
		String sql=" SELECT COUNT(*) FROM staff;";
		long count =(long)  qr.query(sql, new ScalarHandler());
		return  (int) count;
	}
	@Override
	public List<Staff> selectAllStaffMsg(int begin,int pageSize) throws SQLException {
		String sql=" SELECT * FROM staff LIMIT ?,?";
		List<Staff> list = qr.query(sql, new BeanListHandler<Staff>(Staff.class),begin,pageSize);
		 for (Staff staff : list) {
			String sql1="SELECT * FROM positionn  WHERE positionid=?;";
			 Positionn pos = qr.query(sql1, new BeanHandler<Positionn>(Positionn.class),staff.getPositionid());
			 String sql2="SELECT * FROM department  WHERE departmentid=?;";
			 Department dep = qr.query(sql2, new BeanHandler<Department>(Department.class),staff.getDepartmentid());
			 staff.setDep(dep);
			 staff.setPos(pos);
		}
		return list;
		
	}
	@Override
	public List<Staff> selectByPositionId(int positionid) throws SQLException {
		String sql="SELECT * FROM staff WHERE positionid=?";
		List<Staff> list = qr.query(sql, new BeanListHandler<Staff>(Staff.class),positionid);
		for (Staff staff : list) {
			String sql1="SELECT * FROM positionn  WHERE positionid=?;";
			 Positionn pos = qr.query(sql1, new BeanHandler<Positionn>(Positionn.class),staff.getPositionid());
			 String sql2="SELECT * FROM department  WHERE departmentid=?;";
			 Department dep = qr.query(sql2, new BeanHandler<Department>(Department.class),staff.getDepartmentid());
			 staff.setDep(dep);
			 staff.setPos(pos);
		}
		return list;
	}
	@Override
	public int selectrowCount1(String name) throws SQLException {
		String sql="SELECT COUNT(*) FROM staff WHERE staffname LIKE ?;";
		long count =(long)  qr.query(sql, new ScalarHandler(),"%"+name+"%");
		return  (int) count;
	}

}
