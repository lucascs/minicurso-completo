<%@ include file="/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content" class="blue-box">
	<h1>Professor ${professor.nome }</h1>
	
	<p><strong>Email:</strong> ${professor.email }</p>
	<p><strong>Matérias:</strong> ${professor.materias }</p>
	<p><strong>Salário:</strong> ${professor.salario }</p>
</div>
<%@ include file="/footer.jsp" %>