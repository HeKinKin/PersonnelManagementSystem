<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改档案</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="Manager_style">
				<span class="title_name">员工档案详情修改</span>
				<form action="fileEidtServlet" method="post" >
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<td colspan="8">员工档案详情修改</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2" rowspan="3"><img src="imgs/${file.staffimg }" style="height: 200px; width: 150px;"/></td>
								<td>员工号</td>
								<td><input type="text" name="staffnumber" value="${file.staff.staffnumber }"/></td>
								<td>姓名</td>
								<td><input type="text" name="staffname" value="${file.staff.staffname }"/></td>
								<td>民族</td>
								<td><input type="text" name="nationality" value="${file.nationality }"/></td>
							</tr>
							<tr>
								<td>生日</td>
								<td><input type="date" name="staffbirthday" value="${file.staffbirthday }"/></td>
								<td>性别</td>
								<td>
									男<input type="radio" name="staffsex" ${file.staffsex =='男' ?'checked' :''  } value="男"/>
									女<input type="radio" name="staffsex" ${file.staffsex =='女' ?'checked' :'' } value="女"/>
								</td>
								<td>政治面貌</td>
								<td>
									<select name="politicalstatus">
    	  								<option value="党员" ${file.politicalstatus == '党员' ?'selected' :'' }>党员</option>
        								<option value="预备党员" ${file.politicalstatus == '预备党员' ?'selected' :'' }>预备党员</option>
        								<option value="团员" ${file.politicalstatus == '团员' ?'selected' :'' }>团员</option>
        								<option value="群众" ${file.politicalstatus == '群众' ?'selected' :'' }>群众</option>
        							</select>
								</td>
							</tr>
							<tr>
								<td>学历</td>
								<td>
									<select name="staffeducation">
    	  								<option value="本科" ${file.staffeducation == '本科' ?'selected' :'' }>本科</option>
        								<option value="大专" ${file.staffeducation == '大专' ?'selected' :'' }>大专</option>
        								<option value="高中" ${file.staffeducation == '高中' ?'selected' :'' }>高中</option>
        								<option value="初中及以下" ${file.staffeducation == '初中及以下' ?'selected' :'' }>初中及以下</option>
        							</select>
								</td>
								<td>邮箱</td>
								<td><input type="email" name="staffemail" value="${file.staff.staffemail }"/></td>
								<td>电话</td>
								<td><input type="number" name="stafftel" value="${file.staff.stafftel }"/></td>
							</tr>
							<tr>
								<td>部门</td>
								<td>
									<select name="departmentid">
										<c:forEach var="dep" items="${department }">
    	  									<option value="${dep.departmentid }"  ${dep.departmentname == file.staff.dep.departmentname ?'selected' :'' }> ${dep.departmentname}</option>
    	  								</c:forEach>
        							</select>
								</td>
								
								<td>职位</td>
								<td>
									<select name="positionid">
    	  								<c:forEach var="pos" items="${position }">
    	  									<option value="${pos.positionid }"  ${pos.positionname == file.staff.pos.positionname ?'selected':'' }> ${pos.positionname}</option>
    	  								</c:forEach>
        							</select>
								</td>
								<td >毕业院校</td>
								<td colspan="4"><input type="text" name="graduatedschool" value="${file.graduatedschool }"/></td>
							</tr>
							<tr>
								<td>在职状态</td>
								<td><input type="text" name="workingstate" value="${file.staff.workingstate }"/></td>
								<td>住址</td>
								<td colspan="5"><input type="text" name="staffaddress" value="${file.staffaddress }"/></td>
							</tr>
						</tbody>
					</table>
					<button style="float: right; margin-right: 80px; width: 80px;">修改</button>
				</form>
			</div>
</body>
</html>