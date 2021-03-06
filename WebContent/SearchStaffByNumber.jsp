<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="assets/css/jquery-ui-1.10.3.full.min.css">
	<link rel="stylesheet" href="assets/css/ace.min.css" />
	<link rel="stylesheet" href="css/style.css" />
	<title>员工信息</title>
</head>

<body>
	<div class="page-content">
		<!--菜单管理-->

		<div class="row">
			<div class="col-xs-12">
				<h3 class="header smaller lighter blue">员工信息管理</h3>
				<div class="table-header"></div>
				<div class="search_style">

					<form action="SearchByStaffNumber" method="get">
						<div class="title_names">搜索查询</div>
						<ul class="search_content clearfix">

							<li><label class="lf">员工工号</label><input name="staffnumber"
								type="text" required="required" /></li>

							<li style="width: 90px;"><button type="submit"
									class="btn_search">查询</button></li>
						</ul>
				</div>
				</form>

				<div class="Menu_Manager">
					
					<div class="Menu Manager_style">
						<span class="title_name">员工信息</span>
						<div class="table_menu_list">
							<table id="Menu_list" cellpadding="0" cellspacing="0"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>员工工号</th>
										<th>员工姓名</th>
										<th>员工电话</th>
										<th>员工邮箱</th>
										<th>所在部门</th>
										<th>所属职位</th>
										<th>状态</th>

									</tr>
								</thead>
							
								
										<tbody>
											
											
											
											<tr>
												<td>${staffnumber.staffnumber }</td>
												<td>${staffnumber.staffname }</td>
												<td>${staffnumber.stafftel }</td>
												<td>${staffnumber.staffemail }</td>
												<td>${staffnumber.dep.departmentname }</td>
												<td>${staffnumber.pos.positionname }</td>
												<td>${staffnumber.workingstate }</td>
												
														
											</tr>


										</tbody>
									
							</table>
						</div>
					</div>
				</div>
			</div>
			<script src="assets/js/jquery.min.js"></script>

			

			<script type="text/javascript">
				window.jQuery
						|| document
								.write("<script src='assets/js/jquery-2.0.3.min.js'>"
										+ "<"+"/script>");
			</script>

		

			<script type="text/javascript">
				if ("ontouchend" in document)
					document
							.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
									+ "<"+"/script>");
			</script>
			<script src="assets/js/bootstrap.min.js"></script>
			<script src="assets/layer/layer.js" type="text/javascript"></script>
			<script type="text/javascript">
				
				$('.Adding_menu_btn').on(
						'click',
						function() {
							layer.open({
								type : 1,
								title : '修改菜单',
								shadeClose : true, //点击遮罩关闭层
								area : [ '500px', '' ],
								content : $('#Adding_menu'),
								btn : [ '修改', '关闭' ],
								yes : function(index, layero) {
									var str = "";
									$(".addtext").each(
											function(n) {
												if ($(this).val() == "") {
													layer.alert(str += ""
															+ $(this).attr(
																	"name")
															+ "不能为空！\r\n", {
														title : '提示框',
														icon : 0,
													});

												} else {
													layer.alert('修改成功！', {
														title : '提示框',
														icon : 1,
													});
													layer.close(index);
												}
											});

								}
							});

						});
			</script>
</body>
</html>
