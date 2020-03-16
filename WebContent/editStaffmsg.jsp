<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="css/style.css"/>
<title>无标题文档</title>
</head>
   

 <%--  <form action="editStaffServlet" method="post" >
    员工编号: <input type="text" name="staffnumber" value="${StaffMsg. staffnumber}" readonly="readonly"><br>
    员工姓名:   <input type="text" name="staffname" value="${StaffMsg. staffname}" ><br>
    员工电话:   <input type="tel" name="stafftel"  value="${StaffMsg. stafftel}"><br>
    员工邮箱:   <input type="email" name="staffemail"  value="${StaffMsg. staffemail}"><br>
    部门编号:    <input type="number" name="departmentid" value="${StaffMsg. departmentid}"><br>
    职位编号:   <input type="number" name="positionid" value="${StaffMsg. positionid}"><br>
    状态:   <input type="text" name="workingstate" value="${StaffMsg. workingstate}">
    
 <button > 提交</button>       
    
  </form> --%>
  <h2  >${msg }</h2>
  <form class="form-horizontal" action="editStaffServlet" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label" >  员工编号</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="staffnumber" readonly="readonly" required="required" style="width:50%" value="${StaffMsg. staffnumber}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label"> 员工姓名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="staffname" placeholder="请输入员工姓名" required="required" style="width:50%" value="${StaffMsg. staffname}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label"> 员工电话</label>
    <div class="col-sm-10">
      <input type="tel" class="form-control" name="stafftel" placeholder="请输入员工联系电话" required="required" style="width:50%" value="${StaffMsg. stafftel}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label"> 员工邮箱</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" name="staffemail" placeholder="请输入员工邮箱" style="width:50%" value="${StaffMsg. staffemail}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label"> 编号</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="departmentid" placeholder="请输入员工部门编号" style="width:50%" value="${StaffMsg. departmentid}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">职位编号</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="positionid" placeholder="请输入员工职位编号" style="width:50%" value="${StaffMsg. positionid}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">状态</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="workingstate" placeholder="状态" style="width:50%" value="${StaffMsg. workingstate}">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">修改</button>
    </div>
  </div>
</form>		
			
</body>
</html>




