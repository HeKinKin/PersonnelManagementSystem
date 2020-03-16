<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
  <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
  <link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:400,300" />
  <link rel="stylesheet" href="assets/css/ace.min.css" />
  <link rel="stylesheet" href="css/style.css"/>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
		<form action="addwage" method="post">
		<fieldset>
			<legend>新增员工工资单</legend>	
			
		
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">员工ID</label>
		    <div class="col-sm-10">
		      <input type="text" readonly="readonly" class="form-control" name="staffnumber"  value="${add.staffnumber}" id="inputloginName" >
		    </div>
		 </div>	
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">员工姓名</label>
		    <div class="col-sm-10">
		      <input type="text" readonly="readonly" class="form-control" name="staffname"  value="${add.staffname}" id="inputloginName" >
		    </div>
		 </div>	
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">部门号</label>
		    <div class="col-sm-10">
		      <input type="text" readonly="readonly" class="form-control" name="departmentid"  value="${add.departmentid}" id="inputloginName" >
		    </div>
		 </div>	
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">日期</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="wagedate" id="inputloginName" >
		    </div>
		 </div>	
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">基本工资</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="basicwage"  value="0" id="inputloginName" >
		    </div>
		 </div>	
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">奖金</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="bonusgrant"  value="0" id="inputloginName" >
		    </div>
		 </div>	
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">五险一金</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="insurance"  value="0" id="inputloginName" >
		    </div>
		 </div>	
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">罚款</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="fine"  value="0" id="inputloginName">
		    </div>
		 </div>	
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">应发工资</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="payable"  value="0" id="inputloginName">
		    </div>
		 </div>	
		 <div class="form-group">
		    <label for="inputloginName" class="col-sm-2 control-label">实发工资</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="realwage"  value="0" id="inputloginName">
		    </div>
		 </div>	
		<div class="form-group">
		    <div class="col-sm-offset-3 col-sm-9">
		      <button type="submit" class="btn btn-primary">提交</button>
		    </div>
	    </div>
	   <p style="color:red;text-align: center;">${Err}</p>
	    </fieldset>
	    	</form>
	</div></div></div>
</body>
</html>