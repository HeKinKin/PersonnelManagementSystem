package com.igeek.service.impl;

import java.util.List;

import com.igeek.bean.Paging;
import com.igeek.bean.Staff;
import com.igeek.bean.Wage;
import com.igeek.dao.WageDao;
import com.igeek.dao.impl.WageDaoImpl;
import com.igeek.service.WageService;
public class WageServiceImpl implements WageService{

	private WageDao wagedao;
	
	public WageServiceImpl() {
		wagedao=new WageDaoImpl();
	}
	//新增工资表
	
	@Override
	public boolean add(Wage wage) {
		try {
			return wagedao.insertwage(wage)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//通过员工工号查询员工信息(新增时需要)
	@Override
	public Staff searchWageBystaffnumber(int staffnumber) {
			try {
				return wagedao.selectBystaffnumber(staffnumber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	//更新
	@Override
	public boolean update(Wage wage) {
		try {
			return wagedao.updatewage(wage)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//删除
	@Override
	public boolean delete(int staffnumber) {
		try {
			return wagedao.deletewage(staffnumber)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/*//分页
	@Override
	public Paging<Wage> search(int pageSize, int currPage) {
		Paging<Wage> paging =new Paging<>(pageSize, currPage);
		try {
			int rowsCount=wagedao.selectwageCount();
			int pageCount=(int) Math.ceil(rowsCount/(double)pageSize);
			int begin=(currPage-1)*pageSize;
			List<Wage> list=wagedao.selectAllWage(begin, pageSize);
			
			//封装
			paging.setRowsCount(rowsCount);
			paging.setPageCount(pageCount);
			paging.setData(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(paging);
		return paging;
		
	}*/

	//通过工资表编号查询工资(修改时需要)
	@Override
	public Wage searchWageBywageid(int wageid) {
		try {
			return wagedao.selectwageBywageid(wageid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//员工工号及部门查询(分页)
	@Override
	public Paging<Wage> select(int pageSize, int currPage,String staffnumber, String departmentname) {
		Paging<Wage> paging =new Paging<>(pageSize,currPage);
		List<Wage> data = null;
		try {
			int rowsCount=wagedao.selectwageCount(staffnumber,departmentname);
			
			if(rowsCount<1) {
				paging.setData(data);
				return paging;
			}
			int pageCount=(int) Math.ceil(rowsCount/(double)pageSize);
			int begin=(currPage-1)*pageSize;
			List<Wage> list=wagedao.selectCondition(begin,pageSize,staffnumber, departmentname);
		
			//封装
			paging.setRowsCount(rowsCount);
			paging.setPageCount(pageCount);
			paging.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paging;
	}

	
	

}
