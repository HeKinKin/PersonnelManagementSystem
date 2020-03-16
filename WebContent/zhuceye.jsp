<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册页</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">

		//自定义校验规则
		$.validator.addMethod(
			//规则的名称
			"checkUsername",
			//校验的函数
			function(value,element,params){
				
				//定义一个标志
				var flag = false;
				
				//value:输入的内容
				//element:被校验的元素对象
				//params：规则对应的参数值
				//目的：对输入的username进行ajax校验
				$.ajax({
					"async":false,
					"url":"${pageContext.request.contextPath}/checkUsername",
					"data":{"username":value},
					"type":"POST",
					"dataType":"json",
					"success":function(data){
						flag = data.isExit;
					}
				});
				
				//返回false代表该校验器不通过
				return !flag;
			}
			
		);
		

	$(function() {
		
		
		 $("#myForm").validate({
			rules: {
				username: {
					required: true,
					"checkUsername":true
				},
				password: {
					required: true
				},
				repassword: {
					required: true,
					equalTo: "[name='password']"
				}
			},
			messages: {
				username: {
					required: "用户名不能为空",
					"checkUsername":"用户名已存在"
				},
				password: {
					required: "密码不能为空"
				},
				repassword: {
					required: "确认密码不能为空!",
					equalTo: "两次输入密码不一致!"
				}
				
			}
		});
	});

</script>
<!-- 
<script>


		var pw1 = false;
		var pw2 = false;
	
		function checkAll(){
			if (pw1&&pw2){
				return true;
			} else {
				return false;
			}
		}
			window.onload = function(){
			var passwordInput = document.getElementById("password");
			passwordInput.onkeyup=check;
			
			var mima2 = document.getElementById("mima2");
	      		var kuang = document.getElementById("kuang");
	      		mima2.onblur = why;
	      		
		}
		
		
		function check(){
			var password = document.getElementById("password").value;//得到密码
			var level = checkpass(password);//计算密码强度
			var td1 = document.getElementsByTagName("td")[0];//弱
			var td2 = document.getElementsByTagName("td")[1];//中
			var td3 = document.getElementsByTagName("td")[2];//强
			switch (level){
				case 0 : td1.style.backgroundColor="#017D29";
						td2.style.backgroundColor="#017D29";
						td3.style.backgroundColor="#017D29";
					break;
					case 1 : td1.style.backgroundColor="red";
						td2.style.backgroundColor="#017D29";
						td3.style.backgroundColor="#017D29";
					break;
					case 2 : td1.style.backgroundColor="#017D29";
						td2.style.backgroundColor="red";
						td3.style.backgroundColor="#017D29";
					break;
					case 3 : td1.style.backgroundColor="#017D29";
						td2.style.backgroundColor="#017D29";
						td3.style.backgroundColor="red";
					break;
			}
		}
		function checkpass(pass){
			if (pass.length<1) {
				pw1=false;
				return 0;
				
			} else if(pass.length<6){
				pw1=true;
				return 1;
			} else if(pass.length>6&&pass.match(/\d/)&&pass.match(/[a-z]/i)){
				pw1=true;
				return 3;
			} else{
				pw1=true;
				return 2;
			}
		}
		
		function why(){
	      	var passwordvalue = document.getElementById("password").value;
	      	var mimavalue2 = document.getElementById("mima2").value;
	      	if (passwordvalue==mimavalue2) {
	      		kuang.innerHTML = "密码正确";
	      		kuang.style.color = "blue";
	      		pw2 = true;
	      	} else{
	      		kuang.innerHTML = "密码错误"
	      		kuang.style.color = "red";
	      		pw2 = false;
	      		}
	      	}
			
			
			
		</script> -->
<!-- <script type="text/javascript">  

		
		//第一步：  
/*XMLHTTPRequest是AJAX应用中的核心API，它被js调用以向服务器发送请求，并异步接收服务器返回的数据后，更新局部页面。使用AJAX功能时，首先要在js中创建XMLHTTPRequest对象：*/  
  /*  var request;//异步请求对象  
    function createXMLHttpRequest() {  
        if (window.ActiveXObject) {//IE浏览器  
            request = new ActiveXObject("Microsoft.XMLHTTP");  
        } else if (window.XMLHttpRequest) {//FireFox，netscape等等浏览器  
            request = new XMLHttpRequest();  
        } else {  
            window.alert("你的浏览器不支持XMLHTTPRequest，将无使用AJAX功能！");  
        }  
    }  */
/*现在我们有了请求对象，接下来要考虑的是，XMLHTTPRequest对象发送了请求后，服务器返回的结果应如何处理，即AJAX中的回调方法。*/  
    //回调函数[响应之后执行的函数]  
  /*  function processResult() {  
        if ((request.readyState == 4) && (request.status == 200)) {  
            var str = request.responseText;//获得返回数据  
            if(str=="true"){  
                //显示到指定的组件中  
                document.getElementById("msg").innerText ="<span style='color:#00cc00'>该用户名可以使用</span>" ;  
            }else{  
                //显示到指定的组件中  
                document.getElementById("msg").innerText ="<span style='color:#cc0000'>该用户名已经被注册！</span>" ;  
            }  
              
        }  
    }  */
  
    //发送请求,绑定回调方法  
   /* function sendRequest() {  
        //创建XMLHTTPRequest对象  
        createXMLHttpRequest();  
        //绑定回调方法（因为是异步请求，这句代码指示了请求结果返回后，由那个js函数接收处理），  
        request.onreadystatechange = processResult;  
        //获得输入框中的内容  
        var username = document.getElementById("username").value;  
          
        //发送get请求  
        // request.open("GET", "AccountCheckServlet?username="+username, true);   
        //发送Post请求  
        request.open("POST", "AccountCheckServlet", true);  
        request.setRequestHeader("Content-Type",  
                "application/x-www-form-urlencoded");  
        //将userName做为请求参数发送上去  
        request.send("username=" + username);  
        //request.send(null);  
    } */
    
    $(function(){
		//为输入框绑定事件
/* 		$("#username").blur(function(){
			//1.失去焦点获得输入框的内容
			var usernameInput = $(this).val();
			//2.去服务器校验该用户名是否存在--ajax
			$.post(
				"${pageContext.request.contextPath}/CheckUsernameServlet",
				{"username":usernameInput},
				function(data){
					//接收到CheckUsernameServlet返回的值
					var isExist = data.isExist;
					//3.根据返回的isExist动态显示
					var uesrnameInfo = "";
					if(isExist){//对返回的值进行判断
						usernameInfo = "该用户名已经存在";
						$("#usernameInfo").css("color","red");//设置提示文本的显示颜色
					}else{
						usernameInfo = "该用户名可以使用";
						$("#usernameInfo").css("color","green");
					}
					//将提示信息写到用户名框后面
					$("#usernameInfo").html(usernameInfo);
				},
				"json"
			);
		});
	}); */

	
	

    
</script>   -->


<style  type="text/css">
label .error{
	color: red
}
</style>
</head>

<body class="login">
	
	<div class="login_logo" style="margin-top:68px;"><h1 style="color: #721C24;">人才人力管理系统</h1></div>


<form action="Register" method="get" id="myForm" >

<div class="login_m" style="width: 500px;height: 320px">
	
	<div class="login_boder" >
		<div class="login_padding" >
			<h2>用户名</h2>
			
			<label>
				<input type="text" id="username" name="username" class="txt_input txt_input2" style="height: 25px; width: 200px; " onblur="sendRequest()" />
				<span id="usernameInfo" style="color: red" ></span>
			</label>
			
			<h2>密码</h2>
			<label>
				<input type="password" name="password" id="password" class="txt_input" style="height: 25px; width: 200px; " />
				<table style="display: inline-table;">
				<!-- <tr><td>弱</td><td>中</td><td>强</td></tr> -->
				</table><br />
			</label>
			
			<h2>确认密码</h2>
			<label>
				<input type="password" name="repassword" id="repassword" class="txt_input" style="height: 25px; width: 200px;" />
			<span id="kuang" style="color: red" ></span>
			</label>
			
			<div class="rem_sub">			
				<div class="rem_sub_l1" style="margin-right: 190px;">
					<input type="submit" class="sub_button" name="button1" id="button1" value="添加管理员" style="opacity: 1.7;" />
				</div>
				
			</div> 
		</div>
	</div><!--login_boder end-->
</div><!--login_m end-->

</form>

<br />
<br />

<p align="center">版权所有：人才人力资源有限公司</p>

</body>
</html>