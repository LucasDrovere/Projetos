<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<h1>CADASTRO DE ALUNOS</h1>
	
	<form id="formulario" action="/Sala/cadastro" method="post">
		Nome: <input type="text" name="txtNome"/></br>
		ID Professor: <input type="text" name="txtProfessor"/>
	
	<input id="btn-salvar" type="submit" value="Salvar">
	</form>