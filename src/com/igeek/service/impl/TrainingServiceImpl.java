package com.igeek.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.igeek.bean.Paging;
import com.igeek.bean.Training;
import com.igeek.dao.TrainingDao;
import com.igeek.dao.impl.TrainingDaoImpl;
import com.igeek.service.TrainingService;

public class TrainingServiceImpl implements TrainingService{
	private final TrainingDao td=new TrainingDaoImpl();
	@Override
	public Paging<Training> selectPaging(int pageSize, int currPage){
		
		Paging<Training> pa=new Paging<Training>(pageSize,currPage);
		int rowscount;
		try {
			rowscount = td.selectCount();
			int pagecount=(int)Math.ceil(rowscount/(double)pageSize);
			int begin=(currPage-1)*pageSize;
			List<Training> list=td.selectTraining(pageSize, begin);
			pa.setRowsCount(rowscount);
			pa.setPageCount(pagecount);
			pa.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return pa;
	}
	@Override
	public Paging<Training> selectId(int staffnumber){
		Paging<Training> pa=new Paging<Training>(1,1);
		List<Training> list;
		try {
			list = td.selectId(staffnumber);
			pa.setRowsCount(1);
			pa.setPageCount(1);
			pa.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return pa;
	}
	@Override
	public Paging<Training> selectName(String name,int pageSize,int currPage){
		Paging<Training> pa=new Paging<Training>(pageSize,currPage);
		int rowscount;
		try {
			rowscount = td.selectNameCount(name);
			int pagecount=(int)Math.ceil(rowscount/(double)pageSize);
			int begin=(currPage-1)*pageSize;
			List<Training> list=td.selectName(name,pageSize, begin);				
			pa.setRowsCount(rowscount);
			pa.setPageCount(pagecount);
			pa.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return pa;
	}
	@Override
	public int deleteTraining(int staffnumber) {
		
		try {
			return td.deleteTraining(staffnumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int insertTraining(int staffnumber, String trainingname, String trainingcontext, String trainingdate,
			String trainingsite) {
		try {
			return td.insertTraining(staffnumber, trainingname, trainingcontext, trainingdate, trainingsite);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
