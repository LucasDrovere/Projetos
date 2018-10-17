
<%@page import="forum.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
		Usuario us = (Usuario) session.getAttribute("usuarios");
		
	
	%>
	
	<nav class="navbar fixed-top navbar-dark bg-dark">
 		 <a class="navbar-brand" style="color: white;">Olá, <%=us.getNome() %></a>
	</nav>
	
	<div class="container  span7  col-md-11 col-md-offset-3" style="margin: 0 auto; margin-top:125px; marginfloat: none; border: 1px solid gray">
		<fieldset>
		<legend>Cadastrar | Editar | Visualizar Crítica</legend>
		<form class="col-md-6" action="/forum/Upload-img" method="post" enctype="multipart/form-data">
		  <div class="form-group" >
		    <label for="titulo">Titulo</label>
		    <input type="text" class="form-control" name="titulo" required>
		  </div>
		  
		  <div class="form-group">
		    <label>Descrição</label>
		    <textarea type="text" class="form-control" name="descricao" required></textarea>

		  </div>

		  <div class="form-group">
		    <label>Arquivo</label>
		    <input type="file" class="form-control" name="file" required/>
		    <img alt="" src="">
		  </div>
		  
		  <a href='/forum/listar-criticas.jsp?numPagina=1' type="submit" class="btn btn-primary" style="margin-bottom: 10px">Voltar</a>
		  <input type="submit" class="btn btn-primary" value="Salvar" style="margin-bottom: 10px;">
		  
		</form>
		</fieldset>
	</div>
	
	
</body>
</html>