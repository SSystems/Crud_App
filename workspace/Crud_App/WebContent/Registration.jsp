<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib uri ="/struts-tags" 
       prefix ="s"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<s:form action="registeraction">


            
            
 <s:textfield label= "Username"
             name ="name" key="name"/>
             
            
<s:textfield label= "Password"
             name ="password" key="password"/>
             
 <s:textfield label= "Email id"
             name ="email" key="email"/>
             
 <s:textfield label= "Cost to company"
             name ="ctc" key="ctc"/>
             
            
<s:submit  label ="OK"/>

<s:reset label = "Cancel"/>    
   
</s:form>
 
</body>
</html>