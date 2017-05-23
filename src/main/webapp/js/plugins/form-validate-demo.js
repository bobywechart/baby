//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
	highlight: function (element) {
		$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	},
	success: function (element) {
		$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
	},
	errorElement: "span",
	errorPlacement: function (error, element) {
		if (element.is(":radio") || element.is(":checkbox")) {
			error.appendTo(element.parent().parent().parent());
		} else {
			error.appendTo(element.parent());
		}
	},
	errorClass: "help-block m-b-none",
	validClass: "help-block m-b-none"
});

//以下为官方示例
$(function () {

	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules: {
			userid: "required",
			username: {
				required: true,
				minlength: 2
			},
			password: {
				required: true,
				minlength: 5
			},
			email: {
				required: true,
				email: true
			},
			fullname: "required",
			tel: {
				required:true,
				tel:true
			},
			company: "required",
			department: "required",
			num:{
				required:true,
				num:true
			},
			date1:"required",
			userip:{
				required:true,
				userip:true
			},
			date2:"required",
			date3:"required",
		},
		messages: {
			userid: "请输入您的ID",
			username: {
				required: icon + "请输入您的用户名",
				minlength: icon + "用户名必须两个字符以上"
			},
			password: {
				required: icon + "请输入您的密码",
				minlength: icon + "密码必须5个字符以上"
			},
			email: {
				required: icon + "请输入您的E-mail",
				email : icon + "邮箱格式不正确"
			},
			fullname: icon + "请输入您的姓名",
			tel:{
				required: icon + "请输入您的手机或电话",
				tel:icon + "格式不正确"
			},
			company: icon + "请输入您的公司名称",
			department: icon + "请输入您所在的部门",
			num:{
				required: icon + "请输入您登录失败次数",
				num:icon + "您输入的不是数字"
			},
			date1: icon + "请输入您的锁定日期",
			userip:{
				required: icon + "请输入您最后登录IP",
				userip: icon + "您输入IP格式不正确"
			},
			date1: icon + "请输入您的注册日期",
			date1: icon + "请输入您的修改日期",
		}
	});
});








//电话或手机验证规则  
	jQuery.validator.addMethod("tel", function (value, element) {
	    var tel=/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
	    return this.optional(element) || (tel.test(value));
	}, "格式不对");

//数字
	jQuery.validator.addMethod("num", function (value, element) {
		var num = /^[0-9]*$/;
		return this.optional(element) || (num.test(value));
	}, "格式不对");
