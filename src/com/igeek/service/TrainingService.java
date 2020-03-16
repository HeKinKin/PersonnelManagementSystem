package com.igeek.service;


import java.sql.SQLException;
import java.util.List;

import com.igeek.bean.Paging;
import com.igeek.bean.Training;

public interface TrainingService {
	Paging<Training> selectPaging(int pageSize,int currPage);
	Paging<Training> selectId(int staffnumber);
	Paging<Training> selectName(String name,int pageSize,int currPage);
	int deleteTraining(int staffnumber);
	int insertTraining(int staffnumber,String trainingname,String trainingcontext,String trainingdate,String trainingsite);
}
