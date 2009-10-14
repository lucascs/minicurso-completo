<%@ include file="/header.jsp" %>

<h2>Professores encontrados:</h2>
<ul>
	<c:forEach items="${professorList}" var="professor">
		<li>${professor.nome }</li>
	</c:forEach>
</ul>

<%@ include file="/footer.jsp" %>