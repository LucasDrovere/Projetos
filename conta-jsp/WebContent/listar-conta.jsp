<%@page import="br.com.cast.conta.modelo.Usuario"%>
<%@page import="br.com.cast.conta.modelo.Conta"%>
<%@page import="java.util.List"%>
<%@page import="br.com.cast.conta.persistencia.DaoConta"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/signin.css" rel="stylesheet">
<title>Listar contas</title>
</head>
<body>
	<%
		DaoConta dao = new DaoConta();
		List<Conta> contas = dao.buscarTodas();
		int i = 0;
	%>


	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Número da Conta</th>
				<th scope="col">Saldo Disponivel</th>
				<th scope="col">Alterar Conta</th>
				<th scope="col">Excluir Conta</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Conta c : contas) {
					i++;
			%>
			<tr>
				<th scope="row"><%=i%></th>
				<td><%=c.getNumero()%></td>
				<td><%=c.getSaldo()%></td>
				<td><a
					href="/conta-jsp/cadastrar-conta.jsp?numero=<%=c.getNumero()%>">Alterar
						Saldo</a></td>
				<td><a href="/conta-jsp/excluir?numero=<%=c.getNumero()%>">Excluir</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>