<%@ include file="/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content" class="blue-box">
	<h1>Professores</h1>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Matérias</th>
				<th>Salario</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${professorList}" var="professor" varStatus="s">
				<tr class="${s.index % 2 == 0? 'odd': 'even'}">
					<td><a href="visualiza?id=${professor.id }">${professor.nome }</a></td>
					<td>${professor.email }</td>
					<td>${professor.materias }</td>
					<td>${professor.salario }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="/footer.jsp" %>