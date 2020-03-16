package com.igeek.dao;

import com.igeek.bean.File;

public interface FileDao {
	/**
	 * 根据员工号查询
	 * @param staffnumber
	 * @return 档案
	 * @throws Exception 
	 */
	File selectByStaffnumber(int staffnumber) throws Exception;
	
	/**
	 *  插入员工档案
	 * @param file
	 * @return 成功条数
	 */
	
	int insert(File file) throws Exception;
	
	/**
	 * 修改员工档案  根据员工号修改
	 * @param file
	 * @return
	 */

	int updata(File file) throws Exception;
	
	
	
	
}
