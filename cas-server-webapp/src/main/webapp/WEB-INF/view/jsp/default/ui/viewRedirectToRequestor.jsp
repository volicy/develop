<%--   
    Document   : redirect  
    Created on : 2011-1-11, 17:42:09  
    Author     : Kenny  
--%>  
  
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
  
        <script type="text/javascript">  
            var defLoginURL = '/login.jsp';  
            function redirect(){  
                var _window = top.location != self.location? window.parent.window : window;  
                var serviceURL = getParam('service', _window);  
                if(!serviceURL){  
                    serviceURL = defLoginURL;  
                }
               // alert('login?service='+serviceURL)
                _window.location.href = serviceURL;  
            }  
            function getParam(name, _window) {  
                _window ? _window : window;  
                var queryString = _window.location.search;  
                var param = queryString.substr(1, queryString.length - 1).split("&");  
                for (var i = 0; i < param.length; i++) {  
                    var keyValue = param[i].split("=");  
                    if (keyValue[0] == name) return keyValue[1];  
                }  
                return null;  
            }  
        </script>  
    </head>  
    <body onload="redirect()">  
  
    </body>  
</html> 