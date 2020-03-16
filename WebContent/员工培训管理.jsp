<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="assets/css/ace.min.css" />
  <link rel="stylesheet" href="css/style.css"/>
  
  
</head>
<body>

 <div class="page-content">
      <div class="search_style" style="margin-top:5px;margin-bottom:0;padding-top:30px;padding-bottom:10px">
   <div class="title_names" >培训查询</div>
  
      <form action="search.do" method="get">
      <ul class="search_content clearfix">
       <li><label class="lf">员工姓名</label><input name="name" type="text"  class="text_add"/></li>      
       <li style="width:90px;"><button id="btn_search" type="submit" class="btn_search">查询</button></li>
      </ul>
      </form>
      <form action="search.do" method="get">
      <ul class="search_content clearfix">     
        <li><label class="lf">员工工号</label><input name="number" type="text" required="required"  class="text_add"/></li>
       <li style="width:90px;"><button id="btn_search" type="submit" class="btn_search">查询</button></li>
      </ul>
      </form>
    
    </div>
   <div class="Manager_style" style="margin-top:20px;padding-bottom:0px">
    <div class="title_name" style="padding-bottom:0">培训列表</div>
    <button  type="button" class="btn btn-primary"  id="Add_Roles_btn" style="margin-bottom:10px;">添加</button>
     <div id="Add_Roles_style"  style="display:none">
     <div class="user_Manager_style ">
     <div class="add_user_style">
       <ul class="clearfix staffList">
      <li><label class="label_name">员工工号</label> <input name="员工工号" type="text"  class="text_add1"/></li>
      <li><label class="label_name">培训名称</label><input name="培训名称" type="text"  class="text_add2"/></li>
      <li><label class="label_name">培训内容</label> <input name="培训内容" type="text"  class="text_add3"/></li>
      <li><label class="label_name">培训时间</label><input name="培训时间" type="text"  class="text_add4"/></li>
      <li><label class="label_name">培训地点</label><input name="培训地点" type="text"  class="text_add5"/></li>
      </ul>    
     
    </div> 
     </div>
      </div>
  <table id="" class="table table-striped table-bordered table-hover">
   <thead>
    <tr><th style="width:90px">员工工号</th><th>员工姓名</th><th>培训名称</th><th>培训内容</th><th>培训时间</th><th>培训地点</th><th>操作</th></tr>
   </thead>
   <tbody style="font-size:18px">
			<c:forEach var="training" items="${paging.data}">
				<tr>
					
					<td>${training.staffnumber}</td>
					<td>${training.staffname}</td>
					<td>${training.trainingname}</td>
					<td>${training.trainingcontext}</td>
					<td>${training.trainingdate}</td>
					<td>${training.trainingsite}</td>
					<td class="User_Action_btn" style="width:50px"> 
					<button value="${training.staffnumber}"  id="btn" type="button"
					 class="btn btn-pink reset_Password" 
					  style="margin-left:6px">删除</button></td> 
					
				</tr>
			 </c:forEach>
   </tbody>
   </table>      
   <ul class="pagination" style="margin-top:0;margin-left:450px;">
   <!-- 上一页  -->  
   <c:if test="${paging.curPage>1}">
   <li>
   <a href="search.do?p=${paging.curPage-1}&name=${name}"aria-lable="上一页">
   <span aria-hidden="true">&laquo;</span>
   </a>
   </li>
   </c:if>
    <!-- 循环显示页码 -->
     <c:if test="${paging.rowsCount>6}">
    <c:forEach var="i" begin="1" end="${paging.pageCount}">
    <li  ${i==paging.curPage? 'class="active"' : '' }><a href="search.do?p=${i}&name=${name}">${i}</a></li>
    </c:forEach>
    </c:if>
    <!--   下一页  -->
     <c:if test="${paging.curPage<paging.pageCount}">
     <li>
     <a href="search.do?p=${paging.curPage+1}&name=${name}" aria-label="下一页">
     <span aria-hidden="true">&raquo;</span>
     </a>
     </li>
     </c:if>    
     <h5 style="margin-top:12px;margin-left:400px">当前页/总页数: ${paging.curPage}/${paging.pageCount},总记录数:${paging.rowsCount}</h5>
     </ul>
     </div> 
     </div>
    
     <script src="js/jquery-1.8.3.min.js" ></script>
    <script src="assets/js/jquery.min.js"></script> 
 <script type="text/javascript" src="assets/layer/layer.js"></script>
<script type="text/javascript">
  $('.reset_Password').on('click', function(){
		layer.confirm('是否删除该员工培训项', {
	  btn: ['删除','取消'] //按钮
	}, function(){
	var value= $("#btn").val();
	
	layer.msg('删除成功！', {time: 1000,icon: 1});
	window.location.href="${pageContext.request.contextPath}/TrainingDeleteWeb?value="+value;
	}); 
	});
  
   
  
  $('#Add_Roles_btn').on('click', function(){
	    layer.open({
	        type: 1,
	        title: '添加培训用户',
			maxmin: true, 
			shadeClose: true, //点击遮罩关闭层
	        area : ['660px' , ''],
	        content:$('#Add_Roles_style'),
			btn:['提交','取消'],
			yes:function(index,layero){	
			 var num=0;
			 var str="";
	     $(".staffList input[type$='text']").each(function(n){
	          if($(this).val()=="")
	          {
				    layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
	                title: '提示框',				
					icon:0,	
								
	          }); 
			     num++;
	             return false;            
	          }  
	          
	        
	          
	     });
			  if(num>0)
	     {
	        
	          return false;
	     }
	          else{
				 var value1=$(".text_add1").val();
				 var value2=$(".text_add2").val();
				 var value3=$(".text_add3").val();
				 var value4=$(".text_add4").val();
				 var value5=$(".text_add5").val();
				
				  layer.alert('添加成功！',{
	               title: '提示框',				
				icon:1,		
				  });
				   layer.close(index);
				   window.location.href="${pageContext.request.contextPath}/TrainingInsertWeb?value1="+value1+"&value2="+value2+"&value3="+value3+"&value4="+value4+"&value5="+value5;
			  }		  		     				
			}
	    });
	});
  </script>
</body>
</html>