package com.igeek.service;

import java.util.List;

import com.igeek.bean.Positionn;

public interface PositionService {
	/**
	  * 根据id查询员工所处的职位
	 */
	public String findPositionByPositionid(int positionid);

	/**
	 * 查询全部职位
	 */
	public List<Positionn> findAllPosition();
}
