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
	<script type="text/javascript" src="${base}/js/jquery.js"></script>
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<h5>角色信息</h5>               
			</div>
			<div class="ibox-content">
				<div class="row row-lg">
					<div class="col-sm-12">
						<div class="example-wrap">
							<div class="example">
								<div id="toolbar" class="fixed-table-toolbar" role="group">
									<a class="btn btn-outline btn-primary" href="add.html">
										<i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
									</a>
									<a id="deleteButton" class="btn btn-outline btn-primary" href="javascript:;">
										<i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
									</a>
								</div>
								<table id="listTable" data-toggle="table" data-toolbar="#toolbar" data-page-number="1" data-page-size="20" data-pagination="true" data-search="true" >
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="id">编号</th>
											<th data-field="name">名称</th>
											<th data-field="isSystem">是否内置</th>
											<th data-field="description">角色描述</th>
											<th data-field="createDate">创建时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<#list page.getList() as role>
										<tr>
											<td data-field="state" data-checkbox="true"></td>
											<td data-field="id">${role.id}</td>
											<td>${role.name}</td>
											<td>
												<#if role.isSystem>
												<i class="fa fa-check text-navy"></i>
												<#else>
												<i class="fa fa-times text-warning"></i>
												</#if>
											</td>
											<td>${role.description}</td>
											<td>${role.createDate?string("yyyy-MM-dd HH:mm:ss")}</td>
											<td>
												<a class="btn btn-outline btn-primary btn-xs" href="edit.html?id=${role.id}" role="button">编辑</a>
											</td>
										</tr>
										</#list>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${base}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${base}/js/plugins/bootstrap-table.js"></script>
	<script type="text/javascript" src="${base}/js/plugins/bootstrap-table-zh-CN.js"></script>
	<script type="text/javascript" src="${base}/js/plugins/layer/layer.js"></script>
	<script type="text/javascript" src="${base}/js/list.js"></script>
	<#-- <script type="text/javascript" src="${base}/js/plugins/jquery.metisMenu.js"></script> -->
	<#-- <script type="text/javascript" src="${base}/js/plugins/jquery.slimscroll.min.js"></script> -->
</body>
</html>
