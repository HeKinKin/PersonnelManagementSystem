package com.igeek.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.bean.User;
import com.igeek.dao.UserDao;
import com.igeek.utils.JDBCUtils;

public class UserDaoImpl implements UserDao{
	
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	
	/*
	 * 根据id查询
	 */
	@Override
	public User selectById(int adminid) throws Exception {
		String sql = "select * from admin where adminid = ?";
		Object [] params = {adminid};
		return qr.query(sql, new BeanHandler<>(User.class),params);
	}
	/*
	 * 根据登录名和密码查询（登录）
	 */
	@Override
	public User selectByLoginNameAndPassword(String adminloginname, String adminpassword) throws Exception {
		String sql ="select * from admin where adminloginname = ? and adminpassword = ?";
		Object [] params = {adminloginname,adminpassword};
		return qr.query(sql, new BeanHandler<>(User.class),params);
	}
/*
 * 插入（注册）
 */
	@Override
	public int insertUser(User user) throws Exception {
		String sql ="insert into admin(adminloginname,adminpassword) values(?,?)";
		Object [] params = {user.getAdminloginname(),user.getAdminpassword()};
		return qr.update(sql,params);
	}
/*
 * 根据登录名查询
 */
	@Override
	public User selectByName(String adminloginname) throws Exception {
		String sql ="select * from admin where adminloginname =?";
		Object [] params = {adminloginname};
		return qr.query(sql, new BeanHandler<>(User.class),params);
	}
/*
 * 根据登录名修改密码（修改）
 */
	@Override
	public int updateUser(User user) throws Exception {
		String sql ="update admin set adminpassword=? where adminloginname = ?";
		Object [] params = {user.getAdminpassword(),user.getAdminloginname()};
		return qr.update(sql,params);
	}
	/*
	 * 分页（有多条）
	 */
	@Override
	public int selectUserCount() throws Exception {
		String sql ="select count(1) from admin";
		long count =qr.query(sql, new ScalarHandler<>());
		return (int)count;
	}
	/*
	 * 分页（总记录数）
	 */
	@Override
	public List<User> selectAllUser(int begin, int size) throws Exception {
		//所有留言集合  order by adminid desc limit
		String sql ="select adminid,adminloginname,power from admin order by adminid asc limit ?,?";
		Object [] params = {begin,size};
		List <User> list= qr.query(sql, new BeanListHandler<>(User.class),params);
		
		
		return list;
	}
	@Override
	public int deleteUser(int adminid) throws Exception {
		String sql ="delete from admin where adminid = ?";
		Object [] params = {adminid};
		return qr.update(sql,params);
	}
	@Override
	public int checkUserName(String adminloginname) throws Exception {
		String sql ="select Count(*) from admin where adminloginname = ?";
		Object [] params = {adminloginname};
		long bb = (long) qr.query(sql, new ScalarHandler<>(),params);
		return (int)bb;
	}
	@Override
	public User checkUserPower(String adminloginname) throws Exception {
		String sql ="select * from admin where adminloginname =?";
		Object [] params = {adminloginname};
		return qr.query(sql, new BeanHandler<>(User.class),params);
		
	}
	

}
