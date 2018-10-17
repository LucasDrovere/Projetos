<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body class="p-3 mb-2 bg-light text-dark">

	<nav class="navbar fixed-top navbar-dark bg-dark">
 		 <a class="navbar-brand" style="color: white;">Cadastro de Usuario</a>
	</nav>

	<div class="container  span7 col-md-4 col-md-offset-3" style="margin: 0 auto; margin-top:125px; marginfloat: none; border: 3px solid light">
	 <form action="/forum/Cadastrar" method="post">
	 	  <div class="form-group">
		    <label>Nome</label>
		    <input type="text" class="form-control" name="nome" placeholder="Nome do Usuario" required>
		  </div>
		  <div class="form-group">
		    <label>Username</label>
		    <input type="text" class="form-control" name="usuario" placeholder="Enter username" required>
		  </div>
		  <div class="form-group">
		    <label>Password</label>
		    <input type="password" class="form-control" name="senha" placeholder="Password" required>
		  </div>
		
		  <button type="submit" class="btn btn-primary">Cadastrar</button>
	 </form>
	 </div>
	
</body>
</html>