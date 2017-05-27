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
					<h5>增加管理员</h5>               
				</div>
				<div class="ibox-content">
					<form method="get" class="form-horizontal" id="signupForm">
						<div class="form-group">
							<label class="col-sm-3 control-label">用户名：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="username" name="username" required="">
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label">密码：</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" name="password" required="">
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label">E-mail：</label>
							<div class="col-sm-6">
								<input type="email" class="form-control" id="email" name="email" required="">
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label" for="fullname">姓名：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="fullname" name="fullname" required="">
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label">联系方式：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="tel" name="tel" required="">
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label">公司：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="company" name="company" required="">
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label">部门：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="department" name="department" required="">
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label">是否启用：</label>
							<div class="col-sm-6">
								<div class="radio-inline i-checks">
									<label>
										<input type="radio" value="option1" name="enable">
										 <i class="fa fa-check text-navy"></i>
									</label>
								</div>
								<div class="radio-inline i-checks">
									<label>
										<input type="radio" checked="" value="option2" name="enable">
										<i class="fa fa-times text-warning"></i>
									</label>
								</div>
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label">是否锁定：</label>
							<div class="col-sm-6">
								<div class="radio-inline i-checks">
									<label>
										<input type="radio" value="option1" name="locked">
										 <i class="fa fa-check text-navy"></i>
									</label>
								</div>
								<div class="radio-inline i-checks">
									<label>
										<input type="radio" checked="" value="option2" name="locked">
										<i class="fa fa-times text-warning"></i>
									</label>
								</div>
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label">角色：</label>
							<div class="col-sm-6">
								<select class="form-control m-b" name="account">
									<option>管理员</option>
								</select>
							</div>
						</div>

						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<button class="btn btn-primary" type="submit">保存内容</button>
								<button class="btn btn-white" type="submit">取消</button>
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
