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

	<nav class="navbar fixed-top navbar-dark bg-dark"> <a
		class="navbar-brand" style="color: white;">Cadastro de Filme</a> </nav>

	<div class="container  span7 col-md-4 col-md-offset-3"
		style="margin: 0 auto; margin-top: 125px; marginfloat: none; border: 3px solid light">
		<form action="/crud_filme_array/cad" method="post">

			<div class="form-group">
				<label>Nome</label> <input type="text" class="form-control"
					name="nomeParameter" placeholder="Nome do filme" required>
			</div>

			<label>Genero</label>
			<div class="form-group">
				<select name="generoParameter" class="form-control">
					<option value="">Selecione o genero</option>
					<option value="Ação">Ação</option>
					<option value="Animação">Animação</option>
					<option value="Aventura">Aventura</option>
					<option value="Comédia">Comédia</option>
					<option value="Documentário">Documentário</option>
					<option value="Drama">Drama</option>
					<option value="Ficção_científica">Ficção científica</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Suspense">Suspense</option>
					<option value="Terror">Terror</option>
				</select>
			</div>

			<div class="form-group">
				<label>Duracao</label> <input type="text" class="form-control"
					name="duracaoParameter" placeholder="Duração do filme" required>
			</div>

			<div class="form-group">
				<label>Diretor</label> <input type="text" class="form-control"
					name="diretorParameter" placeholder="Nome do diretor" required>
			</div>

			<div class="form-group">
				<label>Ano</label> <input type="text" class="form-control"
					name="anoParameter" placeholder="Ano do filme" required>
			</div>

			<div align="center">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>

		</form>
	</div>

</body>
</html>