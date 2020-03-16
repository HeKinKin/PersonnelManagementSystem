package com.igeek.service;

import com.igeek.bean.File;

public interface FileService {
	
	/**
	 * 查询员工档案全部信息		
	 * 根据staffnumber查询档案 根据staffnumber查询基本信息
	 * @return
	 */
	File selectStaffFileAll(int staffnumber);
	/**
	 * 添加新员工档案			
	 * 插入员工档案
	 * @param file
	 * @return
	 */
	boolean addNewStaffFile(File file);
	/**
	 * 修改员工档案				
	 * 修改员工档案
	 * @param file
	 * @return
	 */
	boolean editStaffFile(File file);
	
}
