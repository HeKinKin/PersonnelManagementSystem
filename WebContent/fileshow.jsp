<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<span class="title_name">员工档案详情</span>

		<form action="#"  method="post">

			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<td colspan="8">员工档案</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2" rowspan="3"><img src="imgs/${file.staffimg }"
							style="height: 200px; width: 150px;" /></td>
						<td>员工号</td>
						<td>${file.staff.staffnumber }</td>
						<td>姓名</td>
						<td>${file.staff.staffname }</td>
						<td>民族</td>
						<td>${file.nationality }</td>
					</tr>
					<tr>
						<td>生日</td>
						<td>${file.staffbirthday }</td>
						<td>性别</td>
						<td>${file.staffsex }</td>
						<td>政治面貌</td>
						<td>${file.politicalstatus }</td>
					</tr>
					<tr>
						<td>学历</td>
						<td>${file.staffeducation }</td>
						<td>邮箱</td>
						<td>${file.staff.staffemail }</td>
						<td>电话</td>
						<td>${file.staff.stafftel }</td>
					</tr>

					<tr>
						<td>部门</td>
						<td>${file.staff.dep.departmentname }</td>
						<td>职位</td>
						<td>${file.staff.pos.positionname }</td>
						<td>入职时间</td>
						<td>${file.entrytime }</td>
						<td>毕业院校</td>
						<td colspan="2">${file.graduatedschool }</td>
					</tr>
					<tr>
						<td>在职状态</td>
						<td>${file.staff.workingstate }</td>
						<td>住址</td>
						<td colspan="5">${file.staffaddress }</td>
					</tr>
				</tbody>
			</table>
		</form>
		<form action="eidtFile.jsp" method="POST">
			<button style="float: right; margin-right: 80px; width: 80px;">修改</button>
		</form>
	</div>




</body>
</html>