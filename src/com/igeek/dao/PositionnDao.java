package com.igeek.dao;
/**
   * 职位 接口
 * @author 小 k 
 * @date 2018年10月30日 上午10:33:48 
 *
 */

import java.sql.SQLException;
import java.util.List;

import com.igeek.bean.Positionn;

public interface PositionnDao {
	/**
	 * 查询全部职位
	 */
	public  List<Positionn> selectAllPositionn() throws SQLException;
	
	/**
	  * 根据positionid 查询
	 */
	public Positionn selectPositionnByPositionid(int positionid) throws SQLException;
}
