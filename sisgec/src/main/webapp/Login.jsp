<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body class="p-3 mb-2 bg-light text-dark">
	
	<nav class="navbar fixed-top navbar-dark bg-dark">
 		 <a class="navbar-brand" style="color: white;">Sisgec</a>
  		<form class="form-inline" action="/sisgec/cadastrarUsuario.jsp">
    		 <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cadastre-se</button>
  		</form>
	</nav>
	
	<div class="container  span7  col-md-4 col-md-offset-3" style="margin: 0 auto; margin-top:125px; marginfloat: none; border: 3px solid light">
	 <form action="/sisgec/Logar" method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Username</label>
		    <input type="text" class="form-control" name="usuario" placeholder="Enter username" required>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Password</label>
		    <input type="password" class="form-control" name="senha" placeholder="Password" required>
		  </div>
		  <button type="submit" class="btn btn-primary">Entrar</button>
	 </form>
	 </div>

</body>
</html>