<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib uri ="/struts-tags" 
       prefix ="s"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secure Login</title>
</head>
<body>

<s:form action="loginaction"> 
<s:textfield key="username"
             />
             
<s:password key= "password"
             />
<s:submit  label ="OK"/>

<s:reset label = "Cancel"/>          
   
</s:form>


</body>
</html>