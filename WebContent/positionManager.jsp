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
  <link rel="stylesheet" href="assets/css/jquery-ui-1.10.3.full.min.css">
  <link rel="stylesheet" href="assets/css/ace.min.css" />
  <link rel="stylesheet" href="css/style.css"/>
<title>职位管理</title>
</head>

<body>
<div class="page-content">
<!--菜单管理-->

<div class="Menu_Manager">
 <div class="add_menu">
  <div id="Adding_menu" style="display:none">
  <div class="page-content">
     <table cellpadding="0" cellspacing="0" width="100%">
      <tr><td class="label_name">职位名称</td><td><input name="职位名称" type="text"  class="addtext"  style="width:300px"/></td></tr>
     
     </table>
    </div>
 </div>
 </div>
 <div class="Menu Manager_style">
  <span class="title_name">职位列表</span>
  <div class="table_menu_list">
   <table id="Menu_list" cellpadding="0" cellspacing="0" class="table table-striped table-bordered table-hover">
    <thead>
     <tr>
     <th>序号</th>
     <th>职位名称</th>
     </tr>
    </thead>
    <tbody>
	<c:forEach items="${positionList }" var="position" varStatus="vs">
	     <tr>
		     <td>${vs.count }</td>
		     <td class="atxt_name">${position.positionname }</td>
	     </tr>
     </c:forEach>  
    </tbody>
   </table>
  </div> 
 </div>
</div>
</div>
	<script src="assets/js/jquery.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
	<script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
/***判断用户添加文本**/
//  $("#submit").click(function(){
//	// var num=0;
//     var str="";
//     $("input[type$='text'],select").each(function(n){
//          if($(this).val()=="")
//          {
//              // num++;
//			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
//                title: '提示框',				
//				icon:0,							
//          }); 
//             // layer.msg(str+=""+$(this).attr("name")+"不能为空！\r\n");
//         return;
//          }
//		  else{			  
//			  layer.alert('修改成功！',{
//               title: '提示框',				
//			icon:1,		
//			  }); 
//			  return;        
//		  }		  
//     });
//	  layer.close(index); 
//})
 //弹出图层
 $('.Adding_menu_btn').on('click', function(){
    layer.open({
        type: 1,
        title: '修改菜单',
		shadeClose: true, //点击遮罩关闭层
        area : ['500px' , ''],
        content:$('#Adding_menu'),
		btn: ['修改','关闭'],
	    yes: function(index, layero){
		  var str="";			
		   $(".addtext").each(function(n){
			if($(this).val()=="")
             {
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
               title: '提示框',				
			   icon:0,					
               }); 
        
          }
		 else{			  
			  layer.alert('修改成功！',{
               title: '提示框',				
			icon:1,		
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
