package com.igeek.dao;

import java.sql.SQLException;
import java.util.List;

import com.igeek.bean.Paging;
import com.igeek.bean.Training;

public interface TrainingDao {
	List<Training> selectTraining(int size,int begin)throws Exception;
	List<Training> selectId(int staffnumber)throws Exception;
	int selectCount()throws Exception;
	List<Training> selectName(String name,int size,int begin)throws SQLException;
	int selectNameCount(String name)throws Exception;
	int deleteTraining(int staffnumber)throws Exception;
	int insertTraining(int staffnumber,String trainingname,String trainingcontext,String trainingdate,String trainingsite)throws Exception;
}
