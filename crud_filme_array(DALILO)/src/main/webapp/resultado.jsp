<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="crud_filme_array.Controller.FilmeController"%>
<%@page import="crud_filme_array.Entidade.Filme"%>
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
	<%
		FilmeController filmeController = new FilmeController();
		List<Filme> filmes = filmeController.buscarFilmes();
	%>

	<div style="margin-top: 10px; margin-left: 55px">
		<table class="table table-striped table-active col-md-11 ">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Genero</th>
					<th>Duração</th>
					<th>Diretor</th>
					<th>Ano</th>

					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Filme f : filmes) {
				%>
				<tr>
					<td><%=f.getNome()%></td>
					<td><%=f.getGenero()%></td>
					<td><%=f.getDuracao()%></td>
					<td><%=f.getDiretor()%></td>
					<td><%=f.getAno()%></td>


					<td><a
						href='/crud_filme_array/alterar.jsp?idParameter=<%=f.getId()%>'
						class="btn btn-secondary" style="color: white;">Editar</a> <a
						href='/crud_filme_array/excluir?idParameter=<%=f.getId()%>'
						class="btn btn-danger" style="color: white;">Excluir</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div align="center">
		<a href='/crud_filme_array/cadastro.jsp' type="submit"
			class="btn btn-primary">Voltar</a>
	</div>
</body>
</html>
