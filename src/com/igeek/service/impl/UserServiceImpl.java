package com.igeek.service.impl;

import java.util.List;

import com.igeek.bean.Paging;
import com.igeek.bean.User;
import com.igeek.dao.UserDao;
import com.igeek.dao.impl.UserDaoImpl;
import com.igeek.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userdao;

	public UserServiceImpl() {
		userdao = new UserDaoImpl();
	}

	@Override
	public User login(String adminloginname, String adminpassword) {
		try {
			return userdao.selectByLoginNameAndPassword(adminloginname, adminpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		try {
			return userdao.insertUser(user) > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User checking(String adminloginname) {

		try {
			return userdao.selectByName(adminloginname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean amendUser(User user) {
		try {
			return userdao.updateUser(user) > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * 分页查询
	 */
	@Override
	public Paging<User> searchAllUser(int pageSize, int curPage) {
		Paging<User> paging = new Paging<>(pageSize,curPage);
		try {
			int rowsCount = userdao.selectUserCount();
			int pageCount = (int) Math.ceil(rowsCount / (double) pageSize);
			int begin = (curPage - 1) * pageSize;
			List<User> list = userdao.selectAllUser(begin, pageSize);
			// 封装
			paging.setRowsCount(rowsCount);
			paging.setPageCount(pageCount);
			paging.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return paging;
	}

	@Override
	public boolean deleteUserById(int adminid) {
		try {
			return userdao.deleteUser(adminid) > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkUsername(String adminloginname) {
		//UserDao userDao = new UserDaoImpl();
		int row = 0;
		try {
			row = userdao.checkUserName(adminloginname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row > 0 ? true : false;
	}

	@Override
	public User checkPower(String adminloginname) {
		User user =null;
		try {
			user = userdao.checkUserPower(adminloginname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
