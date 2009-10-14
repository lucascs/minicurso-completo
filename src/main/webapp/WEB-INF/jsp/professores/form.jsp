<%@ include file="/header.jsp" %>

<form action="adiciona" method="post">
	<fieldset>
		<legend>Cadastro de Professor</legend>
		<label for="nome">Nome:</label>
		<input type="text" id="nome" name="professor.nome"/>
		<label for="email">Email:</label>
		<input type="text" id="email" name="professor.email"/>
		<label for="senha">Senha:</label>
		<input type="password" id="senha" name="professor.senha"/>
		<label for="materias">Matérias (separado por vírgula):</label>
		<input type="text" id="materias" name="professor.materias"/>
		<label for="salario">Salário:</label>
		<input type="text" id="salario" name="professor.salario"/>
		<input type="submit" value="Salvar"/>
	</fieldset>
</form>

<%@ include file="/footer.jsp" %>