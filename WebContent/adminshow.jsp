<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理</title>

<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="css/style.css" />

</head>
<body>
	
	
	<div class="page-content">
			<div class="gys_style">

				<div class="Manager_style">
					<div class="title_name">添加管理员</div>
					<a href="zhuceye.jsp"><button type="button" class="btn btn-primary" id="Add_Product_btn">添加管理员</button></a>

				</div>

				<div class="Manager_style">

					<span class="title_name">管理员信息</span>

					<table class="table table-striped table-bordered table-hover">

						<thead>
							<tr>
								<th>管理员序号</th>
								<th>管理员名称</th>
								<th>备注</th>
								<th>操作</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="admin"  items="${paging.data }">
							
				
								<tr>
									<th>
										${admin.adminid}
									</th>
									<th>${admin.adminloginname }</th>
									<th>${admin.power == '1'?'超级管理员':'管理员' }</th>
									<th><a href="Update?name=${admin.adminloginname }">修改</a>&nbsp;&nbsp;&nbsp;<a href="zhuceye.jsp">添加</a>&nbsp;&nbsp;&nbsp;<a href="del?id=${admin.adminid}">删除</a></th>
								</tr>
							</c:forEach>
						</tbody>

					</table>














					<!--  <div class="page_style">
					当前页/总页数: ${paging.curPage}/${paging.pageCount} 总记录数: ${paging.rowsCount}
						
						<a href="indexServlet?curPage=1" class="icon-step-backward page_btn"></a>
						<a href="indexServlet?curPage=${paging.curPage-1 }" class="icon-caret-left page_btn"></a>
						第
						
						共${paging.pageCount}页
						<a href="indexServlet?curPage=${paging.curPage+1 }" class=" icon-caret-right page_btn"></a>
						<a href="indexServlet?curPage=${paging.pageCount }" class="icon-step-forward page_btn"></a>
					</div>
					
					
					-->
					
					
					
					
					
					
					<div class="row" style="text-align: center;">
			<div class="col-md-12">
				<nav aria-label="Page navigation">
				  <ul class="pagination">			    
				    <%-- <c:forEach var="i" begin="1" end="${pag.pageCount }">
				    <li><a href="wage?p=${i}">${i}</a></li>
				    </c:forEach> --%>
				    <c:if test="${paging.curPage>1}">
					    <li>
					      <a href="indexServlet?curPage=${paging.curPage-1}&adminloginname=${Tom.adminloginname }" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					       
					       <li><a href="indexServlet?curPage=${paging.curPage-1}&adminloginname=${Tom.adminloginname }">${paging.curPage-1}</a></li>
					    </li>
				    </c:if>
				   
				    <li class="active"><a href="indexServlet?curPage=${paging.curPage}&adminloginname=${Tom.adminloginname }">${paging.curPage}</a></li>
				   
				    <c:if test="${paging.curPage<paging.pageCount}">
					    <li>
					     <a href="indexServlet?curPage=${paging.curPage+1}&adminloginname=${Tom.adminloginname }">${paging.curPage+1}</a>
					       
					        <a href="indexServlet?curPage=${paging.curPage+1}&adminloginname=${Tom.adminloginname }" aria-label="Previous">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
				    </c:if>
				   
				  </ul>
				</nav>	
			</div>			
		</div>
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				</div>
			</div>
		</div>
	
	
	




</body>
</html>