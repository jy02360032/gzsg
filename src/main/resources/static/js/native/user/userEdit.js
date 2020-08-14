/**
 * 编辑普通模板页面 author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listener();
	/* 初始化 */
	init();
});

function listener(){
	
	$("#cancel").click(function(){
		window.local.href = "/userManager/userList.html"
	})
	
	//提交表单
	$("#userInfoEdit").submit(function(e){
		submitValid(e);
	});
	//密码重置操作
	$("#isPass").click(function(){
		if($("#isPass").get(0).checked){
			$("#passType").show();
		}else{
			$("#passType").hide();
			$("#password").val("");
			$("#repassword").val("");
		}
	});
	
	$("#btn_query").click(function(){
		$('#tb_roles').bootstrapTable('refresh');
	});
}

function submitValid(e){
	var count = 0;
	$("input[name='roles']").each(function(){
		count ++;
	});
	if(count == 0){
        showInfo("请选择用户角色"); 
	    e.preventDefault();
	    return false;
    }
	if($("#isPass").get(0).checked){
		if($("#password").val() == "" || $("#repassword").val() == ""){
            showInfo("密码不能为空");
		    e.preventDefault();
		    return false;
		}
		if($("#password").val() != $("#repassword").val()){
            showInfo("两次密码输入不一致");
		    e.preventDefault();
			return false;
		}
		if($("#password").val().length <6 || $("#password").val().length >20){
            showInfo("密码长度为6--20位"); 
		    e.preventDefault();
            return false;
		}
	}
}

function init(){
	if($("input[name='id']").val() == "" || $("input[name='id']") == null){
		$("#isPassDiv").hide();
		$("#isPass").attr("checked",true);
		$("#passType").show();
		$("#userInfoEdit").attr("action",getRootPath() + "/userManager/userAdd.html");
	}else{
		$("#userInfoEdit").attr("action",getRootPath() + "/userManager/userUpdate.html");
//		$('#username').attr("disabled",true);
		$('#username').attr("readonly",true);  
		$.each($("input[name='rs']"),function(i,item){
			$.each($("input[name='roles']"),function(l,roles){
				if(item.value == roles.value){
					roles.checked = true;
				}
			});
		});
	}
	initRoles();
}


function initRoles(){

	$('#tb_roles').bootstrapTable({
		url : getRootPath() + '/userManager/userAddPageRoles.json', // 请求后台的URL（*）
		method : 'get', // 请求方式（*）
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sortable : false, // 是否启用排序
		sortOrder : "asc", // 排序方式
		singleSelect : true,
		search : true,
		striped: true,
		queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求 
			return { 
				limit: params.limit, // 每页要显示的数据条数 
				offset: params.offset, // 每页显示数据的开始行号 
				sort: params.sort, // 要排序的字段 
				sortOrder: params.order, // 排序规则 
				text: $("#text").val(),
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
		onDblClickRow: function (row) {
			  showRoles(row.id,row.text);
		},
		columns : [ 
			{field : 'text',title : '角色名称'}, 
		]
	});
};

function showRoles(id,text){
	var isInsert = true;
	$.each($("input[name='roles']"), function(i,item){  
		console.log(item.value)
		console.log(item.value == id)
		if(item.value == id){
			
			isInsert = false;
		}
	});  
	
	if(isInsert){
		var html = "<div class='alert alert-info' style='width: 7%;float: left;'>";
		html += "<a class='close' data-dismiss='alert'>×</a>";
		html += "<input type='hidden' name='roles' value='" + id + "' >";
		html += "<p>" + text + "</p>";
		html += "</div>";
		$("#roles").append(html);
	}
}


