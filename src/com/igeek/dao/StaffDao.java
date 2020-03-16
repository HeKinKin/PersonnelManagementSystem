package com.igeek.dao;

import java.sql.SQLException;
import java.util.List;

import com.igeek.bean.Staff;

public interface StaffDao {
   Staff   selectBystaffnumber(int staffnumber) throws SQLException;
   List<Staff> selectBystaffname(int begin,int pageSize,String staffname) throws SQLException;
   List<Staff>   selectBydepartmentid(int departmentid) throws SQLException;
   int    insertStaffmsg(Staff staff) throws SQLException;
   int    updateStaffmsg(Staff staff) throws SQLException; 
   int    selectrowCount()throws SQLException;
   int    selectrowCount1(String name)throws SQLException;
   List<Staff>  selectByPositionId(int positionid)throws SQLException;
   List<Staff> selectAllStaffMsg(int begin,int pageSize) throws SQLException;
}
