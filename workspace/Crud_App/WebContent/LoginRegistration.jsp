<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib uri ="/struts-tags" 
       prefix ="s"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User Registration</title>
</head>
<body>
<s:form action="loginregisteraction">


            
            
 <s:textfield label= "Username"
             name ="username" key="username"/>
             
            
<s:password label= "Password"
             name ="password" key="password"/>
             
<s:password label= "Confirm Password"
             name ="confirmpassword" key="confirmpassword"/>
             
             
            
<s:submit  label ="OK"/>

<s:reset label = "Cancel"/>    
   
</s:form>
 
</body>
</html>