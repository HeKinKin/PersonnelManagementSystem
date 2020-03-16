<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="css/style.css"/>
<title>无标题文档</title>
</head>
		
        <style type="text/css">
         html { overflow-x:hidden; }
        </style>
<body >
					<div class="page-content" id="tt">
						<div class="page-header">
							<h1>员工信息管理<small></small></h1>
							<p style="color: red; text-align: center;">${err }</p>
						</div><!-- /.page-header -->
						<div class="row">
							<div class="col-xs-12">							
                               <div class="index_style">
                                
                                 <div class="frame ddgl_style">
                                 <span  class="title_name">员工信息</span>
                                 <div class="content" ">
                                 
                                     
                                    <a href="SearchStaffByName.jsp" style="color:blue;font-weight:bolder;margin:50px">按名字模糊查询</a>
                                    <a href="SearchStaffByDepartmentId.jsp" style="color:blue;font-weight:bolder;margin:50px">按部门编号查询</a>
                                    <a href="SearchStaffByPositionId.jsp" style="color:blue;font-weight:bolder;margin:50px">按部门职位查询</a>
                                    <a href="SearchStaffByNumber.jsp" style="color:blue;font-weight:bolder;margin:50px">按员工工号查询</a>
                                   
                                 </div>
                                 </div>
                                 
                               </div>
                              	
							</div>
						</div>
               
					</div>
</body>
</html>