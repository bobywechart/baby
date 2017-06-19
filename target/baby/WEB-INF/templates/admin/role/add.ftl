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
					<h5>增加角色</h5>               
				</div>
				<div class="ibox-content">
					<form class="form-horizontal" id="signupForm" action="save.html" method="post" >
						<div class="form-group">
							<label class="col-sm-1 control-label">角色名称：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="name" required />
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label">是否内置：</label>
							<div class="col-sm-6">
								<div class="radio-inline i-checks">
									<label>
										<input type="radio" value="true" name="isSystem">
										 <i class="fa fa-check text-navy"></i>
									</label>
								</div>
								<div class="radio-inline i-checks">
									<label>
										<input type="radio" checked="checked" value="false" name="isSystem">
										<i class="fa fa-times text-warning"></i>
									</label>
								</div>
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						
						<div class="form-group">
							<label class="col-sm-1 control-label">角色描述：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="description" />
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label">权限管理：</label>
							<div class="col-sm-6">
								<label class="checkbox-inline i-checks">
                                    <input type="checkbox" value="admin:admin" name="authorities" required />管理员管理
                                </label>
                                <label class="checkbox-inline i-checks">
                                    <input type="checkbox" value="admin:role" name="authorities" />角色管理
                                </label>
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
		<script src="${base}/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${base}/js/plugins/validate/messages_zh.min.js"></script>
		<script src="${base}/js/plugins/form-validate-demo.js"></script>
		<script src="${base}/js/contabs.js"></script>
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
