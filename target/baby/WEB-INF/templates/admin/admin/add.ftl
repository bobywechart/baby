<!DOCTYPE html>
<html lang="zh-CN">
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
		<link href="${base}/css/bootstrap.min.css" rel="stylesheet">
		<link href="${base}/css/bootstrap-table.css" rel="stylesheet">
		<link href="${base}/css/font-awesome.min.css" rel="stylesheet">
		<link href="${base}/css/animate.css" rel="stylesheet">
		<link href="${base}/css/style.css" rel="stylesheet">
		<link href="${base}/css/iCheck/custom.css" rel="stylesheet">
		<script type="text/javascript" src="${base}/js/jquery.js"></script>
	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>增加管理员信息</h5>               
				</div>
				<div class="ibox-content">
					<form method="post" class="form-horizontal" id="signupForm" action="save.html">
						<div class="form-group">
							<label class="col-sm-1 control-label">用户名：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="username" required />
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						
						<div class="form-group">
							<label class="col-sm-1 control-label">密码：</label>
							<div class="col-sm-6">
								<input id="password" type="password" class="form-control" name="password" required />
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						
						<div class="form-group">
							<label class="col-sm-1 control-label">确认密码：</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" name="rePassword" equalTo='#password' required />
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label">E-mail：</label>
							<div class="col-sm-6">
								<input type="email" class="form-control" name="email" required />
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label">姓名：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="realName" required />
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label">联系方式：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="mobile" required />
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label">公司：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="company" required />
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label">部门：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="department" required />
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label">是否启用：</label>
							<div class="col-sm-6">
								<div class="radio-inline i-checks">
									<label>
										<input type="radio" value="true" name="isEnabled" checked="checked" />
										<i class="fa fa-check text-navy"></i>
									</label>
								</div>
								<div class="radio-inline i-checks">
									<label>
										<input type="radio" value="false" name="isEnabled">
										<i class="fa fa-times text-warning"></i>
									</label>
								</div>
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label">角色：</label>
							<div class="col-sm-6">
								<#list roles as role>
									<label class="checkbox-inline i-checks">
                            			<input type="checkbox" value="${role.id}" name="roleIds" required />${role.name}
                        			</label>
								</#list>
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<button class="btn btn-primary" type="submit">保存</button>
								<button class="btn btn-white" type="reset">取消</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script src="${base}/js/bootstrap.min.js"></script>
		<script src="${base}/js/plugins/iCheck/icheck.min.js"></script>
		<script src="${base}/js/plugins/laydate/laydate.js"></script>
		<script src="${base}/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${base}/js/plugins/validate/messages_zh.min.js"></script>
		<script src="${base}/js/plugins/form-validate-demo.js"></script>
		<script>
			//单选框
			$(document).ready(function () {
				$('.i-checks').iCheck({
					checkboxClass: 'icheckbox_square-green',
					radioClass: 'iradio_square-green',
				});
			});
		</script>
	</body>

</html>
