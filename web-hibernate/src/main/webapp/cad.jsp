<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Post</title>
</head>
<body>
<h1 align="center">Digite uma publicação para o brogue</h1>
	<form action="/web-hibernate/upload-img" 
		  method="post" 
	      enctype="multipart/form-data">
		<div align="center">
		<textarea rows="6" cols="100" name="texto">
		
		</textarea> 
		</div>
		
		<div align="center">
		<input type="submit" value="Enviar publicação">
			<input type="file" 
							name="meuArquivo"> 
							
		</div>
		<div>
			
		</div>
	</form>

</body>
</html>