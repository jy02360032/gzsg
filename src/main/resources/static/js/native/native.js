/**
 * 基础公用JS
 * @author 梁雪峰
 */
/*获取根目录*/
function getRootPath(){
    //获取当前网址，如： http://localhost:8088/test/test.jsp
    var curPath=window.document.location.href;
    //获取主机地址之后的目录，如： test/test.jsp
    var pathName=window.document.location.pathname;
    var pos=curPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8088
    var localhostPaht=curPath.substring(0,pos);
    //获取带"/"的项目名，如：/test
    var projectName=pathName.substring(0,pathName.substr(1).indexOf("/")+1);
    return(localhostPaht);
}

function setHtml(){
	$.ajaxSetup({  
		contentType : "text/html;charset=UTF-8"  
	}); 
}

function setJson(){
	$.ajaxSetup({  
		contentType : "application/json;charset=UTF-8"  
	});  
}

function showInfo(titleInfo){
    $("#errorInfo").html("");
    $("#errorInfo").html(titleInfo);
    $('#errors').modal({
        show: true,
        backdrop:'static'
    });
}

function showChooseInfo(titleInfo){
    $("#chooseInfo").html("");
    $("#chooseInfo").html(titleInfo);
    $('#choose').modal({
        show: true,
        backdrop:'static'
    });
}
