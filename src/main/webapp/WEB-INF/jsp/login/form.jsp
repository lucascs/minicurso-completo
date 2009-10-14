<%@ include file="/header.jsp" %>

<form action="<c:url value="/login/login"/>" method="post">
	<fieldset>
		<legend>Login</legend>
		<label for="email">Email:</label>
		<input type="text" id="email" name="email"/>
		<label for="senha">Senha:</label>
		<input type="password" id="senha" name="senha"/>
		<input type="submit" value="Login"/>
	</fieldset>
</form>

<%@ include file="/footer.jsp" %>