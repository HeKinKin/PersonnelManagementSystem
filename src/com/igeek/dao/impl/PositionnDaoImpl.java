package com.igeek.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.bean.Positionn;
import com.igeek.dao.PositionnDao;
import com.igeek.utils.JDBCUtils;

public class PositionnDaoImpl implements PositionnDao{

    private final QueryRunner runner =  new QueryRunner(JDBCUtils.getDataSource());
	@Override
	/**
	 * 查询所有的职位
	 */
	public List<Positionn> selectAllPositionn() throws SQLException {
		String sql = "select * from positionn";
		List<Positionn> positionnList = runner.query(sql, new BeanListHandler<>(Positionn.class));
		return positionnList;
	}

	@Override
	/**
	 * 根据id查询职位
	 */
	public Positionn selectPositionnByPositionid(int positionid) throws SQLException {
		String sql = "select * from positionn where positionid = ?";
		Positionn positionn = runner.query(sql, new BeanHandler<>(Positionn.class), positionid);
		return positionn;
	}
	

}
