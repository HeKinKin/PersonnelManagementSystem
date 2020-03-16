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
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="Manager_style">
				<span class="title_name">员工档案详情添加</span>
				<form action="fileAddServlet" enctype="multipart/form-data" method="post">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<td colspan="8">员工档案添加</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2" rowspan="3"><input type="file" name="staffimg" /></td>
								<td>员工号</td>
								<td><input type="text" name="staffnumber"/></td>
								<td>姓名</td>
								<td><input type="text" name="staffname"/></td>
								<td>民族</td>
								<td><input type="text" name="nationality"/></td>
							</tr>
							<tr>
								<td>生日</td>
								<td><input type="date" name="staffbirthday"/></td>
								<td>性别</td>
								<td>
									男<input type="radio" checked="checked" name="staffsex" value="男"/>
									女<input type="radio" name="staffsex" value="女"/>
								</td>
								<td>政治面貌</td>
								<td>
									<select name="politicalstatus">
    	  								<option value="党员">党员</option>
        								<option value="预备党员">预备党员</option>
        								<option value="团员">团员</option>
        								<option value="群众">群众</option>
        							</select>
								</td>	
							</tr>
							<tr>
								<td>学历</td>
								<td>
									<select name="staffeducation">
    	  								<option value="本科">本科</option>
        								<option value="大专">大专</option>
        								<option value="高中">高中</option>
        								<option value="初中及以下">初中及以下</option>
        							</select>
								</td>
								<td>邮箱</td>
								<td><input type="email" name="staffemail"/></td>
								<td>电话</td>
								<td><input type="text" name="stafftel"/></td>
							</tr>
							<tr>
								<td>部门</td>
								<td>
									<select name="departmentid" id="departmentid">
    	  								<c:forEach var="dep" items="${department }">
    	  									<option value="${dep.departmentid }"> ${dep.departmentname}</option>
    	  								</c:forEach>
        							</select>
								</td>
								<td>职位</td>
								<td>
									<select name="positionid" id="positionid">
    	  								<c:forEach var="pos" items="${position }">
    	  									<option value="${pos.positionid }"> ${pos.positionname}</option>
    	  								</c:forEach>
        							</select>
								</td>
								<td>入职时间</td>
								<td><input type="date" name="entrytime"/></td>
								<td >毕业院校</td>
								<td colspan="2"><input type="text" name="graduatedschool"/></td>
							</tr>
							<tr>
								<td>住址</td>
								<td colspan="7"><input type="text" name="staffaddress"/></td>
							</tr>
						</tbody>
					</table>
					<button style="float: right; margin-right: 80px; width: 80px;">添加</button>					
				</form>
			</div>
</body>
</html>