package com.igeek.service;

import com.igeek.bean.Paging;
import com.igeek.bean.User;


public interface UserService {
	//登录
	User login(String adminloginname,String adminpassword);
	//注册
	boolean register(User user); 
	//查重复
	User checking(String adminloginname);
	//修改密码
	boolean amendUser(User user);
	//分页查询
	Paging<User> searchAllUser(int pageSize,int currPage);
	//移除管理员
	boolean deleteUserById(int adminid);
	//查重
	boolean checkUsername(String adminloginname);
	//权限
	User checkPower(String adminloginname);
}
