<%@page import="br.com.cast.sala.persistencia.AlunoDao"%>
<%@page import="br.com.cast.sala.entidade.Aluno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<h1>LISTAGEM DE ALUNOS</h1>

<% AlunoDao dao = new AlunoDao();
	List<Aluno> alunos = dao.buscarTodos();%>


<table>
<thead>
<tr>
	<th>NOME DO ALUNO</th>
	<th>NOME DO PROFESSOR</th>

</tr>
</thead>
<tbody>
<% for (Aluno a : alunos){%>
	<tr>
			<td><%=a.getNome() %></td>
			<td><%=a.getProfessor().getNome() %></td>
	</tr>
	<% }%>
</tbody>
</table>
</body>
</html>