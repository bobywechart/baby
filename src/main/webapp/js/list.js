$().ready( function() {
	var $listTable = $("#listTable");
	var $deleteButton = $("#deleteButton");
	$listTable.bootstrapTable('hideColumn', 'id');
	
	$deleteButton.click(function () {
		var $this = $(this);
		if ($this.hasClass("disabled")) {
			return false;
		}
		var $checkedIds = $.map($listTable .bootstrapTable('getSelections'), function (row) {
			return row.id;
		});
		if($checkedIds.length == 0){
			layer.msg('请选择要删除的数据', {icon: 7, time: 2000, offset: 't', shade: 0.5, anim: 4});
			return false;
		}
		layer.confirm('确定删除吗？', {
			offset: 't',
			closeBtn: false,
			shade: 0.5,
			anim: 4,
			btn: ['确定', '取消'],
		}, function(index, layero){
			$.ajax({
				url: "delete.html",
				type: "POST",
				dataType: "text",
				data: "id="+$checkedIds,
				cache: false,
				success: function(data) {
					$listTable.bootstrapTable('remove', {
						field: 'id',
						values: $checkedIds
					});
					layer.msg('删除成功', {icon: 6, time: 2000, offset: 't', shade: 0.5, anim: 4});
				},
				error: function(xhr) {
					layer.msg(xhr.statusText, {icon: 5, time: 2000, offset: 't', shade: 0.5, anim: 4});
					setTimeout(function(){ 
						location.reload(true);
					}, 2000);
				}
			});
		}, function(index, layero){
			layer.close(index);
		});
	});
	
});