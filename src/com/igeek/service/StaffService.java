package com.igeek.service;

import java.util.List;

import com.igeek.bean.Paging;
import com.igeek.bean.Staff;

public interface StaffService {
   Staff  searchBystaffnumber(int staffnumber);
   
   List<Staff> searchBydepartmentid(int departmentid);
   boolean addStaffmsg(Staff staff);
   boolean editStaffmsg(Staff staff);
   List<Staff> searchBypositionid(int positionid);
   Paging<Staff> pagingBystaffname(int curPage,int pageSize,String staffname);
   Paging<Staff> paging(int curPage,int pageSize);
}
