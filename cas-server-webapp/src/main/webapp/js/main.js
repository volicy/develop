require.config({      
    paths: {  
      //"jquery" : ["http://libs.baidu.com/jquery/2.0.3/jquery", "js/jquery"],
      "jquery":"./js/jquery",
      "login"  : "./js/login",
      "publib_footer":"./js/publib_footer",
      "head": ["https://cdnjs.cloudflare.com/ajax/libs/headjs/1.0.3/head.min","head.min"],
		"drag":"./js/drag"
    //"cas":"${casJavascriptFile}"
    }  
});
//require(['./js/login'], function(login) {login.init()});
this.addEventListener("mouseover", hoverListener, false);
function hoverListener(event) {
	event.target.addEventListener("mouseout", function() {
		clearTimeout(t);
	}, false);
	var t = setTimeout(function() {
		
	}, 1000); 
	 
}
window.document.onkeydown = disableRefresh;
function disableRefresh(evt) {
	evt = (evt) ? evt : window.event
	if (evt.keyCode) {
		
	}
}