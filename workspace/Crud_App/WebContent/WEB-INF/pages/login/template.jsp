<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="CONTENT-TYPE" content="text/html; charset=UTF-8"/>
	<meta http-equiv="PRAGMA" content="NO-CACHE"/>
	<meta http-equiv="CACHE-CONTROL" content="NO-CACHE"/>
	<meta http-equiv="EXPIRES" content="-1"/>
	<link rel="SHORTCUT ICON" href="<c:url value='/ui/images/favicon.ico'/>"/>
	<link type="text/css" rel="stylesheet" href="<c:url value='/ui/css/application-stylesheet.css'/>"/>
	<script type="text/javascript" src="<c:url value='/ui/js/jquery-2.1.1.min.js'/>"></script>
	<title><tiles:getAsString name="title" /></title>
</head>
<body>
<div id="page-layout">
	<div id="header-panel">
		<tiles:insertAttribute name="header"/>
	</div>
	<div style="margin: 0px auto; padding:0; min-height: 600px;">
		<tiles:insertAttribute name="body"/>
	</div>	
	<div id="footer-panel">
		<tiles:insertAttribute name="footer"/>
	</div>	
</div>
</body>
</html>