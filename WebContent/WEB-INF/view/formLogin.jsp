<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url value="/entrada" var="LinkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form action="LinkEntradaServlet" method="post">
		Login: <input type="text" name="login"/>
		Senha: <input type="password" name="senha"/>
		
		<input type="hidden" name="acao" value="Login"/>
		
		<input type="submit"/>

	</form>

</body>
</html>