/**
 * 编辑普通模板页面 author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listener();
	/* 初始化 */
	init();
});

function listener() {
	// 提交表单
	$("#submit").click(function(e) {
		submitValid(e);
	});
}

function submitValid(e) {
	if($('#tree').treeview('getChecked').length == 0){
        showInfo("请选择角色关联的功能"); 
	    e.preventDefault();
	    return false;
    }
	
	if($("#name").val() == ""){
		showInfo("请填写权限代码"); 
	    e.preventDefault();
	    return false;
	}
	
	if($("#text").val() == ""){
		showInfo("请填写权限名称"); 
	    e.preventDefault();
	    return false;
	}
}

function init() {
	if ($("input[name='id']").val() == "" || $("input[name='id']") == null) {
		$("#rolesEdit").attr("action",getRootPath() + "/authManager/authAdd.html");
	} else {
		$("#rolesEdit").attr("action",getRootPath() + "/authManager/authUpdate.html");
		$.each($("input[name='rm']"), function(i, item) {
			$.each($("input[name='menus']"), function(l, roles) {
				if (item.value == roles.value) {
					roles.checked = true;
				}
			});
		});
	}

	$.post(getRootPath() + "/admin/rms.json", {

	}, function(data) {
		$('#tree').treeview({
			data : data,// 数据源参数
			color : "#428bca",
			showCheckbox : true,
			showBorder : false,
			levels : 2,
			expandIcon : 'glyphicon glyphicon-chevron-right',
			collapseIcon : 'glyphicon glyphicon-chevron-down',
			onNodeChecked : nodeChecked,
			onNodeUnchecked : nodeUnchecked
		});
		
		initTree();
	}, "json");
}

function initTree(){
	var rms = $("input[name='rm']"); 
	if(rms.length > 0){
		$.each($("input[name='rm']"),function(i,val){
			$.each($('#tree').treeview('getUnselected'),function(l,tval){
				if(tval.id == val.value){
					tval['state'] = {checked:true};
				}
			});
		});
		$('#tree').treeview('expandAll', { levels: 4, silent: true });
	}
	
}

var nodeCheckedSilent = false;
function nodeChecked(event, node) {
	if (nodeCheckedSilent) {
		return;
	}
	nodeCheckedSilent = true;
	checkAllParent(node);
	checkAllSon(node);
	nodeCheckedSilent = false;
	initCheck();
}

function initCheck(){
	var menus = $("#checkedMenus");
	menus.html("");
	var ms = "";
	$.each($('#tree').treeview('getChecked'),function(i,val){
		ms += "<input name='menus' type='hidden' value='"+val.id+"'>";
	});
	menus.html(ms);
}

var nodeUncheckedSilent = false;
function nodeUnchecked(event, node) {
	if (nodeUncheckedSilent)
		return;
	nodeUncheckedSilent = true;
	uncheckAllParent(node);
	uncheckAllSon(node);
	nodeUncheckedSilent = false;
	initCheck();
}
// 选中全部父节点
function checkAllParent(node) {
	$('#tree').treeview('checkNode', node.nodeId, {
		silent : true
	});
	var parentNode = $('#tree').treeview('getParent', node.nodeId);
	if (!("nodeId" in parentNode)) {
		return;
	} else {
		checkAllParent(parentNode);
	}
}
// 取消全部父节点
function uncheckAllParent(node) {
	$('#tree').treeview('uncheckNode', node.nodeId, {
		silent : true
	});
	var siblings = $('#tree').treeview('getSiblings', node.nodeId);
	var parentNode = $('#tree').treeview('getParent', node.nodeId);
	if (!("nodeId" in parentNode)) {
		return;
	}
	var isAllUnchecked = true; // 是否全部没选中
	for ( var i in siblings) {
		if (siblings[i].state.checked) {
			isAllUnchecked = false;
			break;
		}
	}
	if (isAllUnchecked) {
		uncheckAllParent(parentNode);
	}
}
// 级联选中所有子节点
function checkAllSon(node) {
	$('#tree').treeview('checkNode', node.nodeId, {
		silent : true
	});
	if (node.nodes != null && node.nodes.length > 0) {
		for ( var i in node.nodes) {
			checkAllSon(node.nodes[i]);
		}
	}
}
// 级联取消所有子节点
function uncheckAllSon(node) {
	$('#tree').treeview('uncheckNode', node.nodeId, {
		silent : true
	});
	if (node.nodes != null && node.nodes.length > 0) {
		for ( var i in node.nodes) {
			uncheckAllSon(node.nodes[i]);
		}
	}
}