<%@page import="crud_filme_array.Entidade.Filme"%>
<%@page import="crud_filme_array.Controller.FilmeController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora do Dalilão</title>
</head>
<body class="p-3 mb-2 bg-light text-dark">

	<%
		Integer id = Integer.parseInt(request.getParameter("idParameter"));

		FilmeController filmeController = new FilmeController();
		Filme f = filmeController.buscarPorId(id);
	%>

	<nav class="navbar fixed-top navbar-dark bg-dark"> <a
		class="navbar-brand" style="color: white;">Alterar Filme</a> </nav>

	<div class="container  span7 col-md-4 col-md-offset-3"
		style="margin: 0 auto; margin-top: 125px; marginfloat: none; border: 3px solid light">

		<form action="/crud_filme_array/alterar?idParameter=<%=f.getId()%>"
			method="post">

			<div class="form-group">
				<label>Nome</label> <input type="text" class="form-control"
					name="nomeParameter" value="<%=f.getNome()%>"
					placeholder="Nome do filme" required>
			</div>

			<div class="form-group">
				<label>Genero</label> <input type="text" class="form-control"
					name="generoParameter" value="<%=f.getGenero()%>"
					placeholder="Tipo do genero" required>
			</div>

			<div class="form-group">
				<label>Duracao</label> <input type="text" class="form-control"
					name="duracaoParameter" value="<%=f.getDuracao()%>"
					placeholder="Duração do filme" required>
			</div>

			<div class="form-group">
				<label>Diretor</label> <input type="text" class="form-control"
					name="diretorParameter" value="<%=f.getDiretor()%>"
					placeholder="Nome do diretor" required>
			</div>

			<div class="form-group">
				<label>Ano</label> <input type="text" class="form-control"
					name="anoParameter" value="<%=f.getAno()%>"
					placeholder="Ano do filme" required>
			</div>

			<div align="center">
				<a href='/crud_filme_array/resultado.jsp' type="submit"
					class="btn btn-primary">Voltar</a>
				<button type="submit" class="btn btn-primary">Alterar</button>

			</div>

		</form>
	</div>

</body>
</html>