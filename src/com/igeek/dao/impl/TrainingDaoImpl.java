package com.igeek.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.bean.Paging;
import com.igeek.bean.Training;
import com.igeek.dao.TrainingDao;
import com.igeek.utils.JDBCUtils;

public class TrainingDaoImpl implements TrainingDao{
    QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public List<Training> selectTraining(int size,int begin)throws Exception {
		String sql="select t.staffnumber,staffname,trainingname,trainingcontext,trainingdate,trainingsite from training t inner join staff s on t.staffnumber=s.staffnumber limit ?,?;";
		Object[] parms= {begin,size};		
		return qr.query(sql,new BeanListHandler<Training>(Training.class),parms);
	}

	@Override
	public List<Training> selectId(int staffnumber)throws Exception {
		String sql="select trainingid,t.staffnumber,staffname,trainingname,trainingcontext,trainingdate,trainingsite from training t inner join staff s on t.staffnumber=s.staffnumber where t.staffnumber=?;";		
		return qr.query(sql,new BeanListHandler<Training>(Training.class),staffnumber);
	}

	@Override
	public int selectCount() throws Exception {
		String sql="select count(1) from training;";
		long l=qr.query(sql,new ScalarHandler<Long>());
		return (int)l;
	}

	@Override
	public List<Training> selectName(String name,int size,int begin) throws SQLException {
		String sql=" select trainingid,t.staffnumber,staffname,trainingname,trainingcontext,trainingdate,trainingsite from training t inner join staff s on t.staffnumber=s.staffnumber where s.staffname like ? limit ?,?;";		
		Object[] parms= {"%"+name+"%",begin,size};
		return qr.query(sql,new BeanListHandler<Training>(Training.class),parms);
	}

	@Override
	public int selectNameCount(String name) throws Exception {
		String sql="select count(1) from training t inner join staff s on t.staffnumber=s.staffnumber where s.staffname like ?;";
		long l=qr.query(sql,new ScalarHandler<Long>(),"%"+name+"%");
		return (int)l;
	}

	@Override
	public int deleteTraining(int staffnumber) throws Exception {
		String sql="delete from training where staffnumber=?;";
		return qr.update(sql,staffnumber);
	}

	@Override
	public int insertTraining(int staffnumber, String trainingname, String trainingcontext, String trainingdate,
			String trainingsite) throws Exception {
		String sql="insert into training(staffnumber,trainingname,trainingcontext,trainingdate,trainingsite) values(?,?,?,?,?);";
		Object[] parms= {staffnumber,trainingname,trainingcontext,trainingdate,trainingsite};		
		return qr.update(sql,parms);
	}

}
