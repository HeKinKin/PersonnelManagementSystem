<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
  <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
  <link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:400,300" />
  <link rel="stylesheet" href="assets/css/ace.min.css" />
  <link rel="stylesheet" href="css/style.css"/>
   <script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>

<body>
<div>

</div>
<div class="page-content">
  <div class="Inquiryproject_style">
	
		<div class="row">
			<div class="col-md-12">
		
				<form action="wage" method="get">
					 <div class="search_style">
				      <div class="title_names">搜索查询</div>
				      <ul class="search_content clearfix">
				       <li><label class="lf">员工工号</label><input name="staffnumber" id="staffnumber" type="text" value="" class="text_add"/></li>
				       <li><label class="lf">部门</label><input name="departmentname" id="departmentname" type="text" value="" class="text_add"/></li>
				      
				       <li style="width:90px;"><button type="submit" class="btn_search">查询</button></li>
				      </ul>
				    </div>
				    <!-- 关键词显示 -->
			      	 <script type="text/javascript">
			      		$(function(){
			      			$("#staffnumber").val('${staffnumber}');
			      			$("#departmentname").val('${departmentname}');
			      		})
			      	</script> 
				</form>
				<p style="color:gray;text-align: center;">${Err}</p>
			<c:if test="${not empty pag.data}">
				<div>
					<table class="table table-striped table-bordered table-hover">
						   	<thead>
								 <tr>
							
								   	<td>员工ID</td>	
								   	<td>姓名</td>
								   	<td>部门</td>
								   	<td>日期</td>
								   	<td>基本工资</td>	
								   	<td>奖金</td>
								   	<td>五险一金</td>
								   	<td>罚款</td>
								   	<td>应发工资</td>
								   	<td>实发工资</td>
								   	<td>操作</td>	
								</tr>
							</thead>
							   	
							<tbody>
								<c:forEach var="wage" items="${pag.data}">		
									<tr>
									   	
									   	<td>${wage.staffnumber}</td>
									   	<td>${wage.staff.staffname}</td>
									   	<td>${wage.staff.dep.departmentname}</td>
									   	<td>${wage.wagedate}</td>
									   	<td>${wage.basicwage}</td>	
									   	<td>${wage.bonusgrant}</td>
									   	<td>${wage.insurance}</td>
									   	<td>${wage.fine}</td>
									   	<td>${wage.payable}</td>
									   	<td>${wage.realwage}</td>
									   	<td>
										   	<a href="addwage?staffnumber=${wage.staffnumber}">新增</a>
										   	|
										   	<a href="editwage?wageid=${wage.wageid}">修改</a>
									   	</td>	
									</tr>
								</c:forEach>
							</tbody>				
								
						</table>
					</div>
					<div class="row" style="text-align: center;">
						<div class="col-md-12">
							<nav aria-label="Page navigation">
							  <ul class="pagination">			    
							   <%--  <c:forEach var="i" begin="1" end="${pag.pageCount }">
							    <li><a href="wage?p=${i}">${i}</a></li>
							    </c:forEach> --%>
							    <!-- 判断 -->
							    <c:if test="${pag.curPage>1}">
								    <li >
								      <a href="wage?pa=${pag.curPage-1}&staffnumber=${staffnumber}&departmentname=${departmentname}" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								       
								       <a href="wage?pa=${pag.curPage-1}&staffnumber=${staffnumber}&departmentname=${departmentname}">${pag.curPage-1}</a>
								    </li>
							    </c:if>
							   
							    <li class="active"><a href="wage?pa=${pag.curPage}">${pag.curPage}</a></li>
							   
							    <c:if test="${pag.curPage<pag.pageCount}">
								    <li>
								     <a href="wage?pa=${pag.curPage+1}&staffnumber=${staffnumber}&departmentname=${departmentname}">${pag.curPage+1}</a>
								       
								        <a href="wage?pa=${pag.curPage+1}&staffnumber=${staffnumber}&departmentname=${departmentname}" aria-label="Previous">
								        <span aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
							    </c:if>
							   
							  </ul>
							</nav>	
						</div>			
					</div>
					
		
				</c:if>
			</div>
		</div>
		
	
</div>
</div>
</body>
</html>