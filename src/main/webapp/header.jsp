<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="<c:url value="/minicurso.css" />" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="site">
<h1 id="h1-marca">
<a href="http://www.vraptor.org"><img src="<c:url value="/images/logo.png" />"/></a>
</h1>

<c:if test="${not empty errors}">
	<div id="error-box">
		<ul>
		<c:forEach items="${errors}" var="error">
			<li>${error.category } - ${error.message }</li>			
		</c:forEach>
		</ul>
	</div>
</c:if>