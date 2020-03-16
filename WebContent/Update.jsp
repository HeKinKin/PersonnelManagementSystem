<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改页</title>

<link href="css/login.css" rel="stylesheet" type="text/css" />

</head>

<body class="login">
	<div class="login_logo" style="margin-top:68px;"><h1 style="color: #721C24;">人才人力管理系统</h1></div>


<form action="Update" method="post">

<div class="login_m">
	<div class="login_boder">
		<div class="login_padding">
			<h2>修改密码</h2>
			<h1 style="color: green">${Err}</h1>
			当前用户：${Tom.adminloginname}<br />
			<label>
				<input type="text" id="username" class="txt_input txt_input2" name="name" readonly="readonly" value="${Eite.adminloginname}" />          
			</label>
			<h2>输入新的密码：</h2>
			<label>
				<input type="password" name="pwd" id="userpwd" class="txt_input" placeholder="密码" />
			</label>
			<div class="rem_sub">
				
				
				<div class="rem_sub_l" style="margin-left: 90px">
					
					<input type="submit" class="sub_button" name="button" id="button" value="修改" style="opacity: 1.7;" />
					
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