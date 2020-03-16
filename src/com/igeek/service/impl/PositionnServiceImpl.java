package com.igeek.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.igeek.bean.Positionn;
import com.igeek.dao.PositionnDao;
import com.igeek.dao.impl.PositionnDaoImpl;
import com.igeek.service.PositionService;

public class PositionnServiceImpl implements PositionService{
	
	private  final PositionnDao dao = new PositionnDaoImpl();

	@Override
	/**
	 * 根据员工id查询员工所处的职位
	 */
	public String findPositionByPositionid(int positionid) {
		Positionn positionn =null;
		try {
			positionn = dao.selectPositionnByPositionid(positionid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return positionn.getPositionname();
	}

	@Override
	/**
	 * 查询所有的职位名称
	 */
	public List<Positionn> findAllPosition() {
		List<Positionn> allPositionn = null;
		try {
			allPositionn = dao.selectAllPositionn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allPositionn;
	}

}
