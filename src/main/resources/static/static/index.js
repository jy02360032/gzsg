/**
 * 首页js
 * author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listener();
	/* 初始化 */
	init();
});

function listener(){

}

function init(){
	
}

function jump(i){
	alert(123)
	$("#body").attr("src","www.baidu.com") ;
}

function setIframeHeight(iframe) {
	if (iframe) {
		var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
		if (iframeWin.document.body) {
			iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
		}
	}
};

function login(){
	window.location.href = getRootPath()+"/config/fordLogin.html"
}