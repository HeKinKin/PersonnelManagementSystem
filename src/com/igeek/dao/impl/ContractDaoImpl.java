package com.igeek.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.bean.Contract;
import com.igeek.bean.Training;
import com.igeek.dao.ContractDao;
import com.igeek.utils.JDBCUtils;

public class ContractDaoImpl implements ContractDao{
	QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());

	@Override
	public List<Contract> selectContract(int size, int begin) throws Exception {
		String sql="select contractid,t.staffnumber,staffname,contractname,contractcontext,contractdate,expiredate from contract t inner join staff s on t.staffnumber=s.staffnumber limit ?,?;";
		Object[] parms= {begin,size};		
		return qr.query(sql,new BeanListHandler<Contract>(Contract.class),parms);
	}

	@Override
	public List<Contract> selectId(int staffnumber) throws Exception {
		String sql="select contractid,t.staffnumber,staffname,contractname,contractcontext,contractdate,expiredate from contract t inner join staff s on t.staffnumber=s.staffnumber where t.staffnumber=?;";
		return qr.query(sql,new BeanListHandler<Contract>(Contract.class),staffnumber);
	}

	@Override
	public int selectCount() throws Exception {
		String sql="select count(1) from contract;";
		long l=qr.query(sql,new ScalarHandler<Long>());
		return (int)l;
	}

	@Override
	public List<Contract> selectName(String name, int size, int begin) throws SQLException {
		String sql="select contractid,t.staffnumber,staffname,contractname,contractcontext,contractdate,expiredate from contract t inner join staff s on t.staffnumber=s.staffnumber where s.staffname like ? limit ?,?;";
		Object[] parms= {"%"+name+"%",begin,size};
		return qr.query(sql,new BeanListHandler<Contract>(Contract.class),parms);
	}

	@Override
	public int selectNameCount(String name) throws Exception {
		String sql="select count(1) from contract t inner join staff s on t.staffnumber=s.staffnumber where s.staffname like ?;";
		long l=qr.query(sql,new ScalarHandler<Long>(),"%"+name+"%");
		return (int)l;
	}

	@Override
	public int deleteContract(int staffnumber) throws Exception {
		String sql="delete from contract where staffnumber=?;";
		return qr.update(sql,staffnumber);
	}

	@Override
	public int insertContract(int staffnumber, String contractname, String contractcontext, String contractdate,
			String expiredate) throws Exception {
		String sql="insert into Contract(staffnumber,contractname,contractcontext,contractdate,expiredate) values(?,?,?,?,?);";
		Object[] parms= {staffnumber,contractname,contractcontext,contractdate,expiredate};		
		return qr.update(sql,parms);
	}

	@Override
	public int updateContract(int staffnumber, String contractname, String contractcontext, String contractdate,
			String expiredate) throws Exception {
		String sql="update contract set contractname=?,contractcontext=?,contractdate=?,expiredate=? where staffnumber=?;";
		Object[] parms= {contractname,contractcontext,contractdate,expiredate,staffnumber};
		return qr.update(sql,parms);
	}
	
}
