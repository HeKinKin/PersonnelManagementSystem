package com.igeek.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.igeek.bean.File;
import com.igeek.dao.FileDao;
import com.igeek.utils.JDBCUtils;

public class FileDaoImpl implements FileDao{

	private QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	
	/**
	 * 根据员工号查询
	 * @param staffnumber
	 * @return 档案
	 * @throws Exception 
	 */
	
	@Override
	public File selectByStaffnumber(int staffnumber) throws Exception {
		
		String sql="select * from file where staffnumber = ?";
		Object [] params = {staffnumber};
		File file=qr.query(sql,new BeanHandler<File>(File.class),params);
		return file;
	}

	/**
	 *  插入员工档案
	 * @param file
	 * @return 成功条数
	 */
	
	@Override
	public int insert(File file) throws Exception{
		String sql="INSERT INTO `file`(staffnumber,staffimg,staffsex,nationality,politicalstatus,staffbirthday,entrytime,staffeducation,graduatedschool,staffaddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object [] params = {file.getStaffnumber(),file.getStaffimg(),file.getStaffsex(),file.getNationality(),file.getPoliticalstatus(),file.getStaffbirthday(),file.getEntrytime(),file.getStaffeducation(),file.getGraduatedschool(),file.getStaffaddress()};
		int count=qr.update(sql,params);
		return count;
	}

	/**
	 * 修改员工档案    根据员工号修改
	 * @param file
	 * @return
	 */
	
	@Override
	public int updata(File file) throws Exception {
		String sql="UPDATE `file` SET staffsex=?,nationality=?,politicalstatus=?,staffbirthday=?,staffeducation=?,graduatedschool=?,staffaddress=? WHERE staffnumber=? ";
		Object [] params = {file.getStaffsex(),file.getNationality(),file.getPoliticalstatus(),file.getStaffbirthday(),file.getStaffeducation(),file.getGraduatedschool(),file.getStaffaddress(),file.getStaffnumber()};
		int count=qr.update(sql,params);
		return count;
	}

}
