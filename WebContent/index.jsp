<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
	Logado com ${usuarioLogado.email} <br/>
</c:if>

<h2>Nova Empresa</h2>

<form action="genericController" method="post" >
	<input type="hidden" name="tarefa" value="NovaEmpresa">
	Nome: <input type="text" name="nome"/>
	<input type="submit" value="Enviar"/>
</form>

<br/>
<br/>

<h2>Login</h2>

<form action="genericController" method="post">
	<input type="hidden" name="tarefa" value="Login">
	Email: <input type="email" name="email"/>
	Senha: <input type="password" name="senha"/>
	<input type="submit" value="Enviar"> 
</form>

<br/>
<br/>

<h2>Logout</h2>

<form action="genericController" method="post">
	<!-- Parametros -->
	<input type="hidden" name="tarefa" value="Logout">
	<input type="submit" value="Deslogar">
</form>

</body>
</html>