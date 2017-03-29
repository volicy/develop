;(function () {
protocol = location.protocol.substr(0, 4) === 'http' ? '' : 'http:';
document.write("<link rel='stylesheet' type='text/css' href='./css/pub_footer.css' />");
document.write("<div class='pub_fo'>");
document.write("<div id='pub_footerall' class='pub_footer_new'>");
document.write("<dl>");
document.write("<dt></dt>");
document.write(" <dd class='foot_sub_menu'><a href='http://www.csdn.net/company/about.html' target='_blank'>公司简介</a><span>|</span><a href='#' target='_blank'>广告服务</a><span>|</span><a href='/company/contact.html' target='_blank'>联系方式</a><span>|</span><a href='/company/statement.html' target='_blank'>版权声明</a><span>|</span><a href='mailto:fashionbrot@163.com'>问题报告</a><span>|</span><a target='_blank' href='/friendlink.html'>合作伙伴</a></dd>");
document.write("<dd class='foot_contact'><a href='#' target='_blank' class='qq qqcustomer_s'>网站客服</a><a href='http://wpa.qq.com/msgrd?v=3&uin=960885984&site=qq&menu=yes' target='_blank' class='qq'>杂志客服</a><a href='#' target='_blank' class='weibo'>微博客服</a><a href='mailto:fashionbrot@163.com' class='email' title='联系邮箱'>fashionbrot@163.com</a><span class='phone' title='服务热线'>17600382908</span><span class='interval'>|</span><span>有限公司 版权所有</span><span class='interval'></span></dd>");
document.write("<dd  class='foot_copyright'><span>京&nbsp;ICP&nbsp;证&nbsp;123456&nbsp;号</span><span class='interval'>|</span><span>Copyright &copy; 2006-2017, myblog, All Rights Reserved&nbsp;</span><a href='#' target='_blank'><img src='' alt='Logo' alt='' title='' /></a></dd>");
document.write("</dl>");
document.write("</div>");
document.write("</div>");
document.write('<script id="noticeScript" type="text/javascript"  btnId="header_notice_num" wrapId="note1" count="5" subcount="5" src=""></script>');

var head = document.getElementsByTagName('head')[0]
	, s, ss = [
		protocol + '//csdnimg.cn/pubfooter/js/tracking.js?v=' + Math.random()
		//, protocol + '//csdnimg.cn/rabbit/tracking-ad/main.js?75eacd6'
		, protocol + '//csdnimg.cn/rabbit/tracking-ad/main.js?75eacd8'
	]
	;

for(var i = 0; i < ss.length; i ++){
	s = document.createElement('script')
	s.type = 'text/javascript';
	s.charset = 'utf-8';
	s.src = ss[i];
	head.insertBefore(s, null);
}
}());
// add QQ customer service
$(function(){
	$(".qqcustomer_s").click(function(event){
		var qqs = [960885984, 940866289];
		var qq = (new Date().getDay() == 0 || new Date().getDay() == 6) ? qqs[0] : qqs[Math.floor(Math.random() * qqs.length)];;
		$(this).attr('href','http://wpa.qq.com/msgrd?v=3&uin='+qq+'&site=qq&menu=yes');
	});
});