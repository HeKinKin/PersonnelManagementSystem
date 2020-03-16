package com.igeek.service.impl;

import java.util.List;

import com.igeek.bean.Contract;
import com.igeek.bean.Paging;
import com.igeek.bean.Training;
import com.igeek.dao.ContractDao;
import com.igeek.dao.impl.ContractDaoImpl;
import com.igeek.service.ContractService;


public class ContractServiceImpl implements ContractService{
	private final ContractDao td=new ContractDaoImpl();
	@Override
	public Paging<Contract> selectPaging(int pageSize, int currPage){
		Paging<Contract> pa=new Paging<Contract>(pageSize,currPage);
		int rowscount;
		try {
			rowscount = td.selectCount();
			int pagecount=(int)Math.ceil(rowscount/(double)pageSize);
			int begin=(currPage-1)*pageSize;
			List<Contract> list=td.selectContract(pageSize, begin);
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
	public Paging<Contract> selectId(int staffnumber) {
		Paging<Contract> pa=new Paging<Contract>(1,1);
		List<Contract> list;
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
	public Paging<Contract> selectName(String name, int pageSize, int currPage) {
		Paging<Contract> pa=new Paging<Contract>(pageSize,currPage);
		int rowscount;
		try {
			rowscount = td.selectNameCount(name);
			int pagecount=(int)Math.ceil(rowscount/(double)pageSize);
			int begin=(currPage-1)*pageSize;
			List<Contract> list=td.selectName(name,pageSize, begin);				
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
	public int deleteContract(int staffnumber) {
		try {
			return td.deleteContract(staffnumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int insertContract(int staffnumber, String contractname, String contractcontext, String contractdate,
			String expiredate) {
		try {
			return td.insertContract(staffnumber, contractname, contractcontext, contractdate, expiredate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int updateContract(int staffnumber, String contractname, String contractcontext, String contractdate,
			String expiredate) {
		try {
			return td.updateContract(staffnumber, contractname, contractcontext, contractdate, expiredate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
