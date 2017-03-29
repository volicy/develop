<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv=Content-Type content="text/html;charset=utf-8">
		<meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
		<meta content=always name=referrer>  
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta property="qc:admins" content="24530273213633466654" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>帐号登录 账号登录</title>
        <link type="text/css" rel="stylesheet" href="./css/bootstrap.css" />
        <link type="text/css" rel="stylesheet" href="./css/login.css" />
        <link type="text/css" rel="stylesheet" href="./css/weixinqr.css" />
        <!-- <script src="./js/ga.js"></script> -->
         <!-- <script src="./js/jquery.js"></script> --> 
         <script src="./js/require.js" data-main="./js/main" ></script>
         
        <script src="https://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>
        <!-- <script src="./js/login.js"></script> -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript">
            requirejs(["jquery","login"], function(jquery,login) {
            
               login.init();
            });
        </script>
    </head>
    <body>
        <div id="hidebg"></div>
        <div id="hidebox">
            <div id="close" onClick="hide();"></div>
            <div id="wxqr" class="wxqr"></div>
        </div>
        <script type="text/javascript">
  		/*var protocol = window.location.protocol;
  		document.write(' <script type="text/javascript" src="' +protocol+ '//csdnimg.cn/pubfooter/js/repoAddr2.js?v=' + Math.random() + '"></'+'script>');*/
        </script>
        <div class="header"></div>
        <div class="main" >
            <div class="container container-custom">
                <div class="row wrap-login">
                    <div class="login-banner col-sm-6 col-md-7 col-lg-7 hidden-xs">
                        <a href="#" target="_blank">
                            <img src=./image/login-banner.png class="img-responsive">
                        </a>
                    </div>
                    <div class="login-user col-xs-12 col-sm-6 col-md-5 col-lg-5">
                        <div class="login-part">
                            <h3> 
                                帐号登录
                                <!-- <a href="#">手机快捷登录</a> -->
                            </h3>
                            <div class="user-info">
                                <div class="user-pass">
                                    <form id="fm1"  commandName="${commandName}"  method="post">
                                        <input id="username" name="username" tabindex="1" placeholder="输入用户名/邮箱" class="user-name" type="text" value=""/>
                                        <input id="password" name="password" tabindex="2" placeholder="输入密码" class="pass-word" type="password" value="" autocomplete="off"/>
                                        <div class="error-mess" style="display:none;">
                                            <span class="error-icon"></span>
                                            <span id="error-message"></span>
                                            <form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false" />
                                        </div>
                                        <div class="row forget-password">
                                            <span class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                <input type="checkbox" name="rememberMe" id="rememberMe" value="true" class="auto-login" tabindex="4"/>
                                                <label for="rememberMe">下次自动登录</label>
                                            </span>
                                            <span class="col-xs-6 col-sm-6 col-md-6 col-lg-6 forget tracking-ad" data-mod="popu_26" style="margin-top: 5;">
                                                <a href="/account/fpwd?action=forgotpassword&service=" tabindex="5">忘记密码</a>
                                            </span>
                                        </div>
                                        <!-- 该参数可以理解成每个需要登录的用户都有一个流水号。只有有了webflow发放的有效的流水号，用户才可以说明是已经进入了webflow流程。否则，没有流水号的情况下，webflow会认为用户还没有进入webflow流程，从而会重新进入一次webflow流程，从而会重新出现登录界面。 -->
                                        <input type="hidden" name="lt" value="${loginTicket}" />
        								<input type="hidden" name="execution" value="${flowExecutionKey}" />
                                        <input type="hidden" name="_eventId" value="submit" />
                                        <input class="logging" accesskey="l" value="<spring:message code="screen.welcome.button.login" />" tabindex="6" type="button" />
                                   		
                                    </form>
                                </div>
                            </div>
                            <div class="line"></div>
                            <div class="third-part tracking-ad" data-mod="popu_27">
                                <!-- <span>第三方帐号登录</span> -->
                                <span>
                                    <font color="red">  </font>
                                </span>
                                <!-- <a href="https://api.weibo.com/oauth2/authorize?client_id=2601122390&response_type=code&redirect_uri=https%3A%2F%2Fpassport.csdn.net%2Faccount%2Flogin%3Foauth_provider%3DSinaWeiboProvider" class="sina"></a>
                                <a id="linkedinAuthorizationUrl" href="https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id=75fvsy4v01jw1s&redirect_uri=https%3A%2F%2Fpassport.csdn.net%2Faccount%2Flogin%3Foauth_provider%3DLinkedInProvider&state=DCEEFWF45453sdffef424" class="linkin"></a>
                                <a id="baiduAuthorizationUrl" href="https://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id=cePqkUpKCBrcnQtARTNPxxQG&redirect_uri=https%3A%2F%2Fpassport.csdn.net%2Faccount%2Flogin%3Foauth_provider%3DBaiduProvider" class="baidu"></a>
                                <a id="qqAuthorizationUrl" href="https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=100270989&redirect_uri=https%3A%2F%2Fpassport.csdn.net%2Faccount%2Flogin%3Foauth_provider%3DQQProvider&state=test" class="qq"></a>
                                <a id="githubAuthorizationUrl" href="https://github.com/login/oauth/authorize?client_id=4bceac0b4d39cf045157&redirect_uri=https%3A%2F%2Fpassport.csdn.net%2Faccount%2Flogin%3Foauth_provider%3DGitHubProvider" class="github"></a>
                                <a id="wechatAuthorizationUrl" href="javascript:void(0)" onClick="show();" class="wechat" target="_parent"></a> -->
                               <!--  <script src="/js/weixinqr.js"></script> -->
                                <div class="register-now">
                                    <span>还没有blog帐号？</span>
                                    <span class="register tracking-ad" data-mod="popu_28">
                                        <a href="" >立即注册</a>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer"></div>
        <!-- <script src="./js/bootstrapValidator.js"></script> -->
        <!-- <script data-main="/js/login-config.js" src="/js/require.js"></script> -->
        <script type="text/javascript">
		//document.write('<script type="text/javascript" src="./js/publib_footer.js?' + Math.floor(new Date()/120000).toString(36) + '="></'+'script>');
        </script>
    </body>
</html>