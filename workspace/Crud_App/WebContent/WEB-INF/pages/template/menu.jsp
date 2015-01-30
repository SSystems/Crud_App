<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<body>
	<div id="body-content">
	Menu Items
	</div>
	
	<table style="width: 100%;">
		<tr>
			<td> Home
			</td>
		</tr>
		<tr>
			<td> <a href="<c:url value='/case/new.do'/>" >New Case </a> 
			</td>
		</tr>
		<tr>
			<td> <a href="<c:url value='/case/list.do'/>" >List Cases </a> 
			</td>
		</tr>
	</table>
</body>
</html>