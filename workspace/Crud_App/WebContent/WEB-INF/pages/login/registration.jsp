<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="body-content">
	<form:form method="post" action="submit.do"
		modelAttribute="command">
		<table style="width: 75%; margin-left: auto; margin-right: auto;"
			cellspacing="5" cellpadding="5">
			<tr>
				<th colspan="2"> <h1> Welcome to Globacomp sSystem </h1> </th>
			</tr>
			
			<c:if test="${not command.valid}">
				<tr>
					<td class="error" colspan="2"><form:errors path="*"
							cssClass="error" /></td>
				</tr>
			</c:if>
			<tr>
				<td align="right" width="40%">Name</td>
				<td align="left"><form:input path="user.firstName" placeHolder="First Name"/> &nbsp; <form:input path="user.lastName" placeHolder="Last Name"/> </td>
			</tr>
			<tr>
				<td align="right" width="40%">Email</td>
				<td align="left"><form:input path="user.email" placeHolder="Email Id"/>  </td>
			</tr>
			<tr>
				<td align="right" width="40%">Birth Date</td>
				<td align="left"> &nbsp;</td>
			</tr>
			<tr>
				<td align="right" width="40%">Gender</td>
				<td align="left">
					<form:select path="user.gender">
            			<form:option value="male" label="Male"/>
            			<form:option value="female" label="Female"/>
            		</form:select> 
				</td>
			</tr>
			<tr>
				<td align="right" width="40%">Username</td>
				<td align="left"> <form:input path="login.username" placeHolder="Username"/></td>
			</tr>
			<tr>
				<td align="right" width="40%">Password</td>
				<td align="left"> <form:password path="login.password" placeHolder="password"/></td>
			</tr>
			<tr>
				<td align="right" width="40%">Confirm Password</td>
				<td align="left"> <form:password path="confirmPassword" placeHolder="password"/></td>
			</tr>
			<tr>
				<td align="right" width="40%"> <form:checkbox path="agree"/> </td>
				<td align="left"> I agree to <a href="#">Terms &amp; Condition</a> </td>
			</tr>
				<tr>
				<td colspan="2"><button class="button" type="submit">Submit</button></td>
			</tr>
			
		</table>
	</form:form>
</div>