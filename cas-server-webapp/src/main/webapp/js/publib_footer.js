define( ['jquery'],function () {
	
	function init(){
		$(".qqcustomer_s").click(function(event){
			var qqs = [960885984, 940866289];
			var qq = (new Date().getDay() == 0 || new Date().getDay() == 6) ? qqs[0] : qqs[Math.floor(Math.random() * qqs.length)];;
			$(this).attr('href','http://wpa.qq.com/msgrd?v=3&uin='+qq+'&site=qq&menu=yes');
		});
	}
	//// add QQ customer service

	return {
		init:init
	}
});

