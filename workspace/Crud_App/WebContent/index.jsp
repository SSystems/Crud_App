<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Globacom</title>
</head>
<body>
	<h1> This is Welcome Page</h1>
	Click here to <a href="<c:url value='/login/init.do'/>"> continue</a>
</body>
</html>