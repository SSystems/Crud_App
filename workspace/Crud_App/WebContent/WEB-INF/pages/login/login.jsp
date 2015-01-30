<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="body-content">
	
	<form:form method="post" action="authenticate.do"
		modelAttribute="command">
		<table style="width: 50%; margin-left: auto; margin-right: auto;"
			cellspacing="5" cellpadding="5">
			<tr>
				<th colspan="2">Login</th>
			</tr>
			<c:if test="${not command.valid}">
				<tr>
					<td class="error" colspan="2"><form:errors path="*"
							cssClass="error" /></td>
				</tr>
			</c:if>
			<tr>
				<td align="right" width="40%">Username</td>
				<td align="left"><form:input path="username" /></td>
			</tr>
			<tr>
				<td align="right" width="40%">Password</td>
				<td align="left"><form:password path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><button class="button" type="submit">Login</button></td>
			</tr>
			<tr>
				<td colspan="2"> <a href="<c:url value='/signup/form.do'/>" >Sign Up</a> 
				</td>
			</tr>
			<tr>
				<td colspan="2"> <a href="#" >Forgot Password ?</a> </td>
			</tr>
		</table>
	</form:form>
</div>