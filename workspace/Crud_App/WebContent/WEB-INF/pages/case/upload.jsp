<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="body-content">
	
	<form:form method="post" action="upload.do"
		modelAttribute="command" enctype="multipart/form-data">
		<table style="width: 50%; margin-left: auto; margin-right: auto;"
			cellspacing="5" cellpadding="5">
			<tr>
				<th colspan="2">Upoad New file</th>
			</tr>
			<c:if test="${not command.valid}">
				<tr>
					<td class="error" colspan="2"><form:errors path="*"
							cssClass="error" /></td>
				</tr>
			</c:if>
			<tr>
				<td align="right" width="40%">Upload</td>
				<td align="left"><input type="file" name="file" ></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="Upload"> </td>
			</tr>
			
		</table>
	</form:form>
</div>