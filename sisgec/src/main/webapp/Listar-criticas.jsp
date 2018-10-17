<%@page import="br.com.sisgec.persistencia.CriticaDao"%>
<%@page import="br.com.sisgec.persistencia.UsuarioDao"%>
<%@page import="br.com.sisgec.entidades.Critica"%>
<%@page import="java.util.List"%>
<%@page import="br.com.sisgec.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Críticas</title>
</head>
<body>
	
	<%	
		CriticaDao dao = new CriticaDao();	
		Usuario us = (Usuario) session.getAttribute("usuarios");
		List<Critica> criticas = null;
		
		String numPagina = request.getParameter("numPagina");
	
		Integer count = Integer.valueOf(dao.tamanhoTable(us).toString());
		
		if(numPagina.equals("0")){
			numPagina = "1";
		}
		
		Integer offset = (Integer.parseInt(numPagina) * 5) - 5;
		
		if(count == 0){
			count = 1;
		}
		
		if(offset < count){
			criticas =  dao.buscarCriticasUsuario(us, offset);
		}else{
		
			System.out.println("entrei aqui");
			numPagina = String.valueOf(Integer.parseInt(numPagina) - 1);
			offset = (Integer.parseInt(numPagina) * 5) - 5;
			criticas =  dao.buscarCriticasUsuario(us, offset);
		}
		
	%>
	
	<nav class="navbar fixed-top navbar-dark bg-dark">
 		 <a class="navbar-brand" style="color: white;">Olá, <%=us.getNome()%></a>
 		 
 		 <form class="form-inline" action="/sisgec/Sair" method="post">
    		 <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Sair</button>
  		</form>
	</nav>
	
	<div class="container  span7  col-md-11 col-md-offset-3" style="margin: 0 auto; margin-top:100px; marginfloat: none; border: 1px solid gray">
		<fieldset>
		<legend>Filtrar Críticas</legend>
		<form class="col-md-6" action='/sisgec/filtrar-critica.jsp'>
		  <div class="form-group" >
		    <label for="titulo">Titulo</label>
		    <input type="text" class="form-control" name="titulo">
		  </div>
		  
		   <div class="form-group">
		    <label for="exampleInputEmail1">Descrição</label>
		    <input type="text" class="form-control" name="descricao">
		  </div>
		  
		   <input type="submit" class="btn btn-primary" value="Consultar" style="margin-bottom: 10px; color: white;">
		   <a href='/sisgec/Listar-criticas.jsp?numPagina=1' class="btn btn-primary" style="margin-bottom: 10px">Limpar</a>
		  
		</form>
		</fieldset>
	</div>
	
	<div style="margin-left: 55px; margin-top: 10px;">
		<form>
			<div style="color: white;">
			  	<a href='/sisgec/cadastrar-critica.jsp' type="submit" class="btn btn-primary">Cadastrar nova Crítica</a>
			  </div>
		</form>
	</div>
	
	<div style="margin-top: 10px; margin-left: 55px">
	<table class="table table-striped table-active col-md-11 ">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Descrição</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%for(Critica c : criticas){ %>
			<tr>
				<td><%=c.getTitulo() %></td>
				<td><%=c.getDescricao() %></td>
				
				<td>
					<a href='/sisgec/visualizar-critica.jsp?id=<%=c.getId() %>' class="btn btn-success" style="color: white;">Visualizar</a>
					<a href='/sisgec/alterar-critica.jsp?id=<%=c.getId() %>' class="btn btn-secondary" style="color: white;">Editar</a>
					<a href='/sisgec/Excluir?id=<%=c.getId() %>' class="btn btn-danger" style="color: white;">Excluir</a>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
	</div>
	
	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	    <li class="page-item">
	      <a class="page-link" href="/sisgec/Listar-criticas.jsp?numPagina=<%=Integer.parseInt(numPagina) - 1%>" tabindex="-1">Voltar</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="/sisgec/Listar-criticas.jsp?numPagina=<%=Integer.parseInt(numPagina) + 1%>">Próximo</a>
	    </li>
	  </ul>
	</nav>

</body>
</html>