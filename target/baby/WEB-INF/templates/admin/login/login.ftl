<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<!--[if lt IE 9]>
	<meta http-equiv="refresh" content="0;ie.html" />
	<![endif]-->
	<title>Wechat Admin</title>
	<link href="${base}/img/favicon.png" rel="shortcut icon" type="image/png" />
	<link href="${base}/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${base}/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${base}/css/animate.css" rel="stylesheet" />
	<link href="${base}/css/style.css" rel="stylesheet" />
	<link href="${base}/css/login.css" rel="stylesheet" />
	<script type="text/javascript" src="${base}/js/jquery.js"></script>
	<script type="text/javascript" src="${base}/js/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${base}/js/common.js"></script>
	<script type="text/javascript" src="${base}/js/jsbn.js"></script>
	<script type="text/javascript" src="${base}/js/prng4.js"></script>
	<script type="text/javascript" src="${base}/js/rng.js"></script>
	<script type="text/javascript" src="${base}/js/rsa.js"></script>
	<script type="text/javascript" src="${base}/js/base64.js"></script>
	<script type="text/javascript">
		$().ready(function() {
			var $loginForm = $("#loginForm");
			var $username = $("#username");
			var $password = $("#password");
			var $enPassword = $("#enPassword");
			var $isRememberUsername = $("#isRememberUsername");
			var $submit = $(":submit");
			
			<#if failureMessage != "">
			$("#identifier").modal("show");
			</#if>
			
			//记住用户名
			if(getCookie("adminUsername") != null){
				$isRememberUsername.prop("checked", true);
				$username.val(getCookie("adminUsername"));
				$password.focus();
			}else{
				$isRememberUsername.prop("checked", false);
				$username.focus();
			}
			
			// 表单验证
			$loginForm.submit( function() {
				if ($username.val() == "") {
					$(".modal-body").text("用户名必填");
					$("#identifier").modal("show");
					return false;
				}
				if ($password.val() == "") {
					$(".modal-body").text("密码必填");
					$("#identifier").modal("show");
					return false;
				}
				if ($isRememberUsername.prop("checked")) {
					addCookie("adminUsername", $username.val(), {expires: 7 * 24 * 60 * 60});
				} else {
					removeCookie("adminUsername");
				}
				
				var rsaKey = new RSAKey();
				rsaKey.setPublic(b64tohex("${modulus}"), b64tohex("${exponent}"));
				var enPassword = hex2b64(rsaKey.encrypt($password.val()));
				$enPassword.val(enPassword);
			});

		});    	
	</script>
</head>

<body class="signin">
	<div class="signinpanel">
		<div class="row">
			<div class="col-sm-7">
				<div class="signin-info">
					<div class="logopanel m-b">
						<h1>[Wechat Admin]</h1>
					</div>
					<div class="m-b"></div>
					<h4><strong>Welcome to Wechat Admin!</strong></h4>
					<ul class="m-b"></ul>
				</div>
			</div>
			<div class="col-sm-5">
				<form id="loginForm" action="index.html" method="post">
					<input type="hidden" id="enPassword" name="enPassword" />
					<h4 class="no-margins">Login In：</h4>
					<p class="m-t-md">Login to access your account.</p>
					<input type="text" id="username" name="username" class="form-control uname" placeholder="用户名" required />
					<input type="password" id="password" name="password" class="form-control pword m-b" placeholder="密码" autocomplete="off" required />
					<div class="pull-left">
						<input type="checkbox" id="isRememberUsername" name="isRememberUsername" checked="checked" />
						<small>记住我</small>
					</div>
					<div class="pull-right">
						<small><a href="">忘记密码</a></small>
					</div>
					<button type="submit" class="btn btn-primary btn-block">登录</button>
				</form>
			</div>
		</div>
		<div class="signup-footer">
			<div class="pull-left">
				&copy; 2015 All Rights Reserved. Wechat
			</div>
			<div class="pull-right">
				Created By: <a href="http://themepixels.com/" target="_blank">ThemePixels</a>
			</div>
		</div>
	</div>
	<div class="modal fade" id="identifier" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
						<span class="sr-only">Close</span>
					</button>
				</div>
				<div class="modal-body" style="color:red;">${failureMessage}</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
