<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
  <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
  <link rel="stylesheet" href="assets/css/ace.min.css" />
  <link rel="stylesheet" href="css/style.css"/>
  <script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
<title>考勤信息管理</title> 
</head>
<body>
<div class="page-content">
<!--待确认订单样式-->
<div class="Inquiryproject_style">
 <div class="row">
   <div class="col-md-12">
	<h3 class="header smaller lighter blue">考勤信息管理</h3>
	<div class="table-header"></div>
    <div class="search_style">
      <div class="title_names">搜索查询</div>
      <form action="searchAttendance.do" method="get">
	      <ul class="search_content clearfix">
	       <li><label class="lf" >员工工号</label><input name="staffnumber" id="staffnumber" type="text"  class="text_add"/></li>
	       <li><label class="lf" >部门号</label><input name="departmentid" id="departmentid" type="text"  class="text_add"/></li>
	       <li><label class="lf" name="attendancedays" id="attendancedays">时间</label><input  type="date" name="attendancedays" id="attendancedays" style=" margin-left:10px;"></li>
	       <li style="width:90px;"><button type="submit" class="btn_search">查询</button></li>
	      </ul>
	      
	      
	      <!-- 关键词显示 -->
	      	 <script type="text/javascript">
	      		$(function(){
	      			$("#staffnumber").val('${staffnumber}');
	      			$("#departmentid").val('${departmentid}');
	      			$("#attendancedays").val('${attendancedays}');
	      		})
	      	</script> 
      </form>
    </div>
	<div >
	  <table id="sample-table-2" class="table table-striped table-bordered table-hover">
      <thead>
       <tr>
        <th>序号</th>
        <th>员工工号</th>
        <th>时间</th>
        <th>出勤天数</th>
        <th>迟到早退天数</th>
        <th>部门号</th>
       </tr>
      </thead>
         <tbody>
	         <c:forEach items="${pagging.data }" var="attendance" varStatus="vs">
		          <tr>
		           <td>${vs.count }</td>
		           <td>${attendance.staffnumber}</td>
		           <td>${attendance.attendancedate}</td>
		           <td>${attendance.attendancedays}</td>
		           <td >${attendance.lateandleaveearly}</td>
		           <td>${attendance.departmentid}</td>
		          </tr>
	          </c:forEach> 
      </tbody>

      
      <tfoot>
       <div class="page_style">
			  <select id="pageSize" size="1">
			    <option value="10">10</option>
			    <option value="20">20</option>
			    <option value="30">30</option>
			  </select>
			  
			 <c:if test="${empty departmentid && empty staffnumber && empty attendancedays}">
				  <script type="text/javascript">
				  	$(function(){
				  		$("#pageSize").change(function(){
				  			var pageSize = $(this).val();
				  			window.location.href = "${pageContext.request.contextPath }/searchAllAttendance.do?pageSize="+pageSize;
				  		});
				  	});
				  </script>
			  </c:if>
			  
			   <c:if test="${!empty departmentid||!empty staffnumber||!empty attendancedays }">
				  <script type="text/javascript">
				  	$(function(){
				  		$("#pageSize").change(function(){
				  			var pageSize = $(this).val();
				  			window.location.href = "${pageContext.request.contextPath }/searchAttendance.do?pageSize="+pageSize+"&departmentid=${departmentid}"+"&staffnumber=${staffnumber}"+"&attendancedays=${attendancedays}";
				  		});
				  	});
				  </script>
			  </c:if>
			  
			  
			  
			   <!-- 选中当前页显示的条数 -->
	       <script>
		       $(function(){
		           $("#pageSize option[value=${pagging.pageSize}]").prop("selected","selected");
	           })
	       </script>
			  
			   <c:if test="${1!=pagging.curPage }">
			  <a href="${pageContext.request.contextPath }/searchAllAttendance.do?curPage=${pagging.curPage-1}" class="icon-step-backward page_btn" ></a>
			  </c:if>
			   <c:if test="${1==pagging.curPage }">
			  <a href="javascript:void(0)" class="icon-step-backward page_btn" ></a>
			  </c:if>
			  第
			  <select name="currentPage" id="currentPage" size="1">
			   <c:forEach begin="1" end="${pagging.pageCount }" var="page">
			   	 <option value="${page }" href="javascript:void(0)">${page }</option>
			    </c:forEach>
			  </select>
			  共${pagging.pageCount }页
			  <!--  -->
			  
	        <!-- 选中当前页 -->
	       <script>
		       $(function(){
		           $("#currentPage option[value=${pagging.curPage}]").prop("selected","selected");
	           })
	           
	           $(function(){
	        	   $("#currentPage").change(function(){
	        		   var curPage = $(this).val();
	        		   window.location.href = "${pageContext.request.contextPath }/searchAllAttendance.do?curPage="+curPage+"&pageSize=${pagging.pageSize}";
	        	   })
	           })
	       </script>
			  
			  <c:if test="${pagging.pageCount!=pagging.curPage }">
			   <a href="${pageContext.request.contextPath }/searchAllAttendance.do?curPage=${pagging.curPage+1}&pageSize=${pagging.pageSize}" class="icon-step-forward page_btn"></a>
		     </c:if>
		      <c:if test="${pagging.pageCount==pagging.curPage }">
			   <a href="javascript:void(0)" class="icon-step-forward page_btn"></a>
		     </c:if>
		 </div>
      </tfoot>
  </table>
</div>
</div>
</div>
</div>
</div>
<!--[if !IE]> -->
<script src="assets/js/jquery.min.js"></script>
		<!-- <![endif]-->
		<!--[if !IE]> -->
		<script type="text/javascript">window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");</script>
		<!-- <![endif]-->
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<script src="assets/layer/layer.js" type="text/javascript" ></script>
<script src="assets/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript">//日期显示
laydate({
	elem: '#attendancedays', //目标元素'
	event: 'focus' //响应事件。
});
//弹出一个iframe层
$('.Inquiry_btn').on('click', function() {
	layer.open({
		type: 2,
		title: '询价项目详细',
		maxmin: true,
		shadeClose: true, //点击遮罩关闭层
		area: ['980px', '400px'],
		content: '询价项目详细.html'
	});
});</script>
</body>
</html>
