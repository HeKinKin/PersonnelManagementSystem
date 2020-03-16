package com.igeek.service.impl;

import com.igeek.bean.File;
import com.igeek.bean.Staff;
import com.igeek.dao.FileDao;
import com.igeek.dao.StaffDao;
import com.igeek.dao.impl.FileDaoImpl;
import com.igeek.dao.impl.StaffDaoImpl;
import com.igeek.service.FileService;

public class FileServiceImpl implements FileService {

	private FileDao filedao=new FileDaoImpl();
	private StaffDao staffdao=new StaffDaoImpl();
	/**
	 * 查询员工档案全部信息		
	 * 根据staffnumber查询档案 根据staffnumber查询基本信息
	 * @return
	 */
	
	
	@Override
	public File selectStaffFileAll(int staffnumber) {
		File file=new File();
		try {
			Staff staff=staffdao.selectBystaffnumber(staffnumber);
			file=filedao.selectByStaffnumber(staffnumber);
			file.setStaff(staff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
	/**
	 * 添加新员工档案			
	 * 插入员工档案
	 * @param file
	 * @return
	 */

	@Override
	public boolean addNewStaffFile(File file) {
		int count=0;
		try {
			count=filedao.insert(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0?true:false;
	}

	/**
	 * 修改员工档案				
	 * 修改员工档案
	 * @param file
	 * @return
	 */
	
	@Override
	public boolean editStaffFile(File file) {
		int count=0;
		try {
			count=filedao.updata(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0?true:false;
	}

}
