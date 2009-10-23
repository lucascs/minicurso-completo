<%@ include file="/header.jsp" %>

<h2>Professores encontrados:</h2>
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

<%@ include file="/footer.jsp" %>