<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib uri ="/struts-tags" 
       prefix ="s"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Operations Secure Login</title>
</head>
<body>
<h1> Data Operations </h1>

<h3>Welcome: <s:property value="username"/></h3>
<br>
<a href= "<s:url action='Registration'/>">
          Add New User
</a>
<br>
<a href= "<s:url action='uploadfile'/>">
          Upload Document
</a>
<br>


</body>
</html>