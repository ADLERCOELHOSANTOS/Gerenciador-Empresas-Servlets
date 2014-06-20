<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seja Bem Vindo</title>
</head>
<body>
	
	Bem vindo ao nosso gerenciador de empresas!
	<hr/><br/>
	
	<c:if test="${usuarioLogado.email != null}">
	    <b>Você está logado como ${usuarioLogado.email}</b>
	    <br/>	<br/>
	</c:if>

	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="NovaEmpresa"/>
		Nome: <input type="text" name="nome" />
		<input type="submit" value="Enviar" />
	</form>
	
	<h3>Formulario de Login</h3><hr/>
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="Login" />
	    Email: <input type="text" name="email" value="guilherme.silveira@alura.com.br"/><br/>
	    Senha: <input type="password" name="senha" value="silveira"/><br/>
	    <input type="submit" value="Login" />
	</form>	
	
	<br/>
	
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="Logout" />
    	<input type="submit" value="Logout" />
	</form>
</body>
</html>