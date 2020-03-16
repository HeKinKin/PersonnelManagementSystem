<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="css/style.css" />
<title>人资管理系统</title>
</head>

<body>
	<div class="page-content">
		<h3 class="header smaller lighter blue">分页查询员工信息</h3>
		

		<div class="">
			<table id="" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>员工编号</th>
						<th>员工工号</th>
						<th>员工姓名</th>
						<th>员工电话</th>
						<th>员工邮箱</th>
						<th>员工所在部门</th>
						<th>员工所在职位</th>
						<th>员工状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<c:if test="${ not empty  paging}">
					<c:forEach var="msg" items="${paging.data}">
						<tbody>
							<tr>
								<td>${ msg.staffid}</td>
								<td>${ msg.staffnumber }</td>
								<td>${ msg.staffname}</td>
								<td>${ msg.stafftel}</td>
								<td>${msg.staffemail }</td>
								<td>${msg.dep.departmentname }</td>
								<td>${ msg.pos.positionname}</td>
								<td>${ msg.workingstate}</td>
								<td><a href="fileShowServlet?staffnumber=${msg.staffnumber}">员工档案信息</a> 
						|
	<a href="editStaffServlet?id=${msg.staffnumber}">修改员工信息</a></td>
							</tr>

						</tbody>
					</c:forEach>
				</c:if>
			</table>
			
	   <div style="text-align: center;">
			<ul class="pagination">
			<c:if test="${paging.curPage>1 }">
				<li class="disabled"><a href="pagingServlet?p=${paging.curPage-1 }" aria-label="上一页">
				<span  aria-hidden="true">&laquo;</span></a></li>
			</c:if>		
				<c:forEach var="i" begin="1" end="${paging.pageCount }" >
				<li ${i==paging.curPage? 'class="active"' : '' }><a href="pagingServlet?p=${i }">${i }</a></li>
				</c:forEach>
			<c:if test="${ paging.curPage<paging.pageCount}">			
				<li><a href="pagingServlet?p=${paging.curPage+1 }" aria-label="下一页"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>	
			</ul>
		</div>
	

     <h5>当前页码:${paging.curPage}总共:${paging.pageCount }页</h5>
		</div>
	</div>
	<!--[if !IE]> -->
	<script src="assets/js/jquery.min.js"></script>
	<!-- <![endif]-->
	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>
	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/layer/layer.js" type="text/javascript"></script>
	<script src="assets/laydate/laydate.js" type="text/javascript"></script>
	<script type="text/javascript">
		//弹出一个iframe层

		//$('.gys_bz').on('click', function(){
		//    layer.open({
		//        type: 2,
		//        title: '供应商项目报价',
		//        maxmin: true,
		//        shadeClose: true, //点击遮罩关闭层
		//        area : ['980px' , '400px'],
		//        content: '供应商报价.html'
		//    });
		//});

		laydate({
			elem : '#start',
			event : 'focus'
		});
		/***判断用户添加文本**/
		jQuery(document).ready(
				function() {

					$("#btn_search").click(
							function() {
								// var num=0;
								var str = "";
								$("input[type$='text'],select").each(
										function(n) {
											if ($(this).val() == "") {
												// num++;
												layer.alert(str += ""
														+ $(this).attr("name")
														+ "不能为空！\r\n", {
													title : '提示框',
													icon : 0,
												});
												// layer.msg(str+=""+$(this).attr("name")+"不能为空！\r\n");
												layer.close(index);
											}

						});

					});
				});
	</script>
</body>
</html>
