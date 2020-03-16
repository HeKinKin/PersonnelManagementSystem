package com.igeek.service;


import com.igeek.bean.Contract;
import com.igeek.bean.Paging;
import com.igeek.bean.Training;

public interface ContractService {
	Paging<Contract> selectPaging(int pageSize,int currPage);
	Paging<Contract> selectId(int staffnumber);
	Paging<Contract> selectName(String name,int pageSize,int currPage);
	int deleteContract(int staffnumber);
	int insertContract(int staffnumber,String contractname,String contractcontext,String contractdate,String expiredate);
	int updateContract(int staffnumber,String contractname,String contractcontext,String contractdate,String expiredate);
}
