/**
 * 编辑普通模板页面 author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listener();
	/* 初始化 */
	init();
});

function init(){
	
	initTables();
	
	//初始化用户操作状态
	if($("#info").val() != ""){
		showInfo($("#info").val());
	}
}

function listener(){
	$("#btn_query").click(function(){
		$('#tb_roles').bootstrapTable('refresh');
	});
	
	$("#btn_add").click(function(){
		window.location.href = getRootPath() + '/authManager/authAddPage.html';
	});
	
	$("#btn_del").click(function(){
		var select = $('#tb_roles').bootstrapTable('getSelections');
		if(select.length > 0){
			showChooseInfo("您确定要删除角色【"+select[0].text+"】吗");
		}else{
			showInfo("您没有选择要删除的角色");
		}
	});
	
	$("#btn_edit").click(function(){
		var select = $('#tb_roles').bootstrapTable('getSelections');
		if(select.length > 0){
			window.location.href = getRootPath() + '/authManager/authUpdatePage.html?id=' + select[0].id;
		}else{
			showInfo("您没有选择要修改的用户");
		}
	});
	
}

function primary(){
	var select = $('#tb_roles').bootstrapTable('getSelections');
	window.location.href = getRootPath() + '/userManager/authDel.html?id=' + select[0].id;
}

function initTables(){

	$('#tb_roles').bootstrapTable({
		url : getRootPath() + '/authManager/authList.json', // 请求后台的URL（*）
		method : 'get', // 请求方式（*）
		toolbar : '#toolbar', // 工具按钮用哪个容器
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sortable : false, // 是否启用排序
		sortOrder : "asc", // 排序方式
		singleSelect : true,
		queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求 
			return { 
				limit: params.limit, // 每页要显示的数据条数 
				offset: params.offset, // 每页显示数据的开始行号 
				sort: params.sort, // 要排序的字段 
				sortOrder: params.order, // 排序规则 
				text: $("#text").val(),
				name: $("#name").val()
			} 
		},
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		strictSearch : true,
		showColumns : true, // 是否显示所有的列
		showRefresh : true, // 是否显示刷新按钮
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "ID", // 每一行的唯一标识，一般为主键列
		showToggle : true, // 是否显示详细视图和列表视图的切换按钮
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		columns : [ 
			{checkbox : true}, 
			{field : 'name',title : '代码'}, 
			{field : 'text',title : '角色名称'}, 
		]
	});
};