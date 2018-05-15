<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Login On 
</h1>

<form action="/springSecurity/account/login" method="post">
  <h4>First name:</h4> <input type="text" name="_user_name" /></b>
  <h4>password:</h4>   <input type="text" name="_user_password" /></p>
  <input type="submit" value="Submit" />
</form>
</body>
</html>
