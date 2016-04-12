<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>欢迎使用人事考勤系统</title>
<link href="<c:url value='/lib/bootstrap/css/bootstrap.min.css' />"   rel="stylesheet">
<script type="text/javascript" src="<c:url value='/lib/jquery-1.8.3.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/lib/respond.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/lib/bootstrap/js/bootstrap.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/lib/koala-ui.plugin.js' />"></script>	
<script type="text/javascript" src="<c:url value='/lib/validate.js' />"></script>
<style type="text/css">
@charset "UTF-8";
/* CSS Document */
*   .* {
	margin: 0;
	padding: 0;
}

body {
	margin: 0;
	padding: 0;
	font-family: 微软雅黑!important;
	overflow:hidden;
}
h4{
	padding-left: 10px;
}
.head {
	height: 40px;
	width: 100%;
	padding: 0;
	margin: 0;
}

.logo {
	height: 90px;
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
	clear: both;
}

.logo img {
	height: 64px;
	width: 200px;
        margin-top:10px;
	overflow: hidden;
	float: left;
}

.logo div {
	font-size: 24px;
	color: #666;
	height: 40px;
	float: left;
	line-height: 60px;
	margin: 20px 10px;
	padding: 10px;
	border-left: 1px solid #d2d2d2;
}

.login_con {
	width: 960px;
	height: 332px;
	margin: 10px auto;
	clear: both;
}

.login_con_L {
	float: left;
	width: 568px;
	height: 332px;
	overflow: hidden;
}

.login_con_R {
	float: left;
	width: 376px;
	height: 332px;
	border: 1px solid #dce7f4;
}

.login_con_R h4 {
	background: #F2F2F2;
	line-height: 36px;
	width: 376px;
	padding: 0px 20px;
	border: 1px solid #fff;
	border-bottom: 1px solid #d4d4d4;
	margin-top: 0px;
}

.login_con_R  form {
	position: relative;
	padding-top: 14%;
	padding-left: 7%;
	padding-right: 7%;
}
.login_con_R .input-group {
    width: 80%;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 25px!important;
}
.checkCode {
	position: absolute;
	top: 54%;
	left: 56%;
	height: 50px;
}
.btn-login {
	width: 100%;
	margin-left: auto;
    margin-right: auto;
    font-size: 17px;
    font-weight: bold;
    letter-spacing: 5px;
}

.login_footer {
	clear: both;
	margin: 8% auto 0;
	width: 300px;
	color: inherit;
    font-size: 21px;
    font-weight: 200;
    line-height: 2.14286;
}
.login_con_L img{
	width:570px;
	height:340px;
	opacity: 0;

}
.image-wrap {
	position: relative;
	opacity: 0.9;
}
 
.image-wrap:after  {
	position: absolute;
	content: ' ';
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
 
	background: -webkit-gradient(radial, 50% 50%, 100, 50% 50%, 700, from(rgba(255,255,255,0)), to(rgba(255,255,255,1)));
	background: -moz-radial-gradient(50% 50%, circle, rgba(255,255,255,0) 50px, rgba(255,255,255,1) 70px);
}
.blur {   

    -webkit-filter: blur(10px); /* Chrome, Opera */

       -moz-filter: blur(10px);

        -ms-filter: blur(10px);   

            filter: blur(10px);   

}
</style>
<script type="text/javascript">
	function refreshCode(){
		$('#checkCode').attr('src',"jcaptcha.jpg?time="+new Date().getTime());
	}
</script>
</head>
<body>
	<div class="head"></div>
	<div class="logo">
		<img src="images/logo.png" />
		<div>人事考勤系统</div>
	</div>
	<div class="login_con">
		<div class="login_con_L" style="box-shadow: 0px 0px 50px #ccc;">
			<span class="image-wrap" style="position:relative;display:inline-block;background:url(images/background/login-bg.jpg) no-repeat center center; background-size:570px 340px; width: 570px; height: 340px;">
			<img src="images/background/login-bg.jpg"/>
                   </span>
		</div>
		<div class="login_con_R" style="box-shadow: 0px 0px 50px #ccc;background-color: #fff;opacity: 0.89;">
			<h4>登录</h4>
			<FORM id="loginFormId" method=post action="j_spring_security_check" class="form-horizontal">
				<div class="form-group input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input type="text" class="form-control" placeholder="用户名"  name="j_username" id="j_username" value="${j_username }">
				</div>
                <div class="form-group input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input type="password" name="j_password" id="j_password" class="form-control" placeholder="密码" value="${j_password }"/>
                </div>
				<div class="form-group input-group" style="margin-top: 45px;">
					<button type="button"  class="btn btn-primary btn-block" id="loginBtn">登录</button>
				</div>
			</FORM>
		</div>
	</div>
	<video autoplay="autoplay" loop="loop" src="http://192.168.1.35:82/testll/video/LandingLoop.webm" style="width: 100%;position: fixed;top: 0;z-index: -1000;height: auto"></video>
	<div class="login_footer">Acetec Copyright © 2014</div>
	<script>
    $(function(){
     	var btnLogin = $('#loginBtn');
    	var form = $('#loginFormId');
        $('body').keydown(function(e) {
            if (e.keyCode == 13) {
            	dologin();
            }
        });btnLogin.on('click',function(){
	   dologin();
	});

	    var dologin = function() {
	        var userNameElement = $("#j_username");
	        var passwordElement = $("#j_password");
	        var username = userNameElement.val();
	        var password = passwordElement.val();
	        if (!Validation.notNull($('body'), userNameElement, username, '用户名不能为空')) {
	            return false;
	        }
	        if (!Validation.notNull($('body'), passwordElement, password, '密码不能为空')) {
	            return false;
	        }
	        btnLogin.attr('disabled', 'disabled').html('正在登录...');
	        form.submit();
	    }
    });
	</script>
	<c:if test="${param.login_error == '1' }">
     	<script>
     		$('.login_con_R').message({
				type: 'error',
				content: '用户名错误!'
			});
     		$('#j_username').focus();
     		$('#j_username').selectAll();
     	</script>
    </c:if>
    
	<c:if test="${param.login_error == '2' }">
      	<script>
     		$('.login_con_R').message({
				type: 'error',
				content: '密码错误!'
			});
     		$('#j_password').focus();
     		$('#j_password').selectAll();
     	</script>
	</c:if>
	
	<c:if test="${param.login_error == '3' }">
      	<script>
     		$('.login_con_R').message({
				type: 'error',
				content: '验证码错误!'
			});
     		$('#jcaptcha').focus();
     	</script>
	</c:if>
	
	<c:if test="${param.login_error == '4' }">
      	<script>
     		$('.login_con_R').message({
				type: 'error',
				content: '该用户已被禁用!'
			});
     	</script>
	</c:if>
</body>
</html>
