package com.igeek.dao;

import java.sql.SQLException;
import java.util.List;
import com.igeek.bean.Contract;
import com.igeek.bean.Training;

public interface ContractDao {
	List<Contract> selectContract(int size,int begin)throws Exception;
	List<Contract> selectId(int staffnumber)throws Exception;
	int selectCount()throws Exception;
	List<Contract> selectName(String name,int size,int begin)throws SQLException;
	int selectNameCount(String name)throws Exception;
	int deleteContract(int staffnumber)throws Exception;
	int insertContract(int staffnumber,String contractname,String contractcontext,String contractdate,String expiredate)throws Exception;
    int updateContract(int staffnumber,String contractname,String contractcontext,String contractdate,String expiredate)throws Exception;
}

