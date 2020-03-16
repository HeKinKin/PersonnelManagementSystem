package com.igeek.dao;

import java.util.List;

import com.igeek.bean.User;

public interface UserDao {
	/*
	 * 按照id查询
	 */
	User selectById(int adminid)throws Exception;
	/*
	 * 按照登录名和密码查询(登录)
	 */
	User selectByLoginNameAndPassword(String adminloginname,String adminpassword)throws Exception;
	/*
	 * 插入新用户(查询)
	 */
	int insertUser(User user)throws Exception;
	/*
	 * 根据adminloginname查询
	 */
	User selectByName(String adminloginname)throws Exception;
	/*
	 * 根据 adminloginname修改密码
	 */
	int updateUser(User user)throws Exception;
	/*
	 * 查询出数量
	 */
	int selectUserCount()throws Exception;
	/*
	 * 查询出的记录集合
	 */
	List<User> selectAllUser(int begin,int size)throws Exception;
	/*
	 * 根据id删除管理员
	 */
	int deleteUser(int adminid)throws Exception;
	/*
	 *查重
	 */
	int checkUserName(String adminloginname)throws Exception;
	/*
	 *权限
	 */
	User checkUserPower(String adminloginname)throws Exception;
	
}
