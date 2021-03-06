<%@page import="br.com.sisgec.entidades.Imagem"%>
<%@page import="java.util.List"%>
<%@page import="br.com.sisgec.entidades.Critica"%>
<%@page import="br.com.sisgec.persistencia.CriticaDao"%>
<%@page import="br.com.sisgec.entidades.Usuario"%>
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
		Integer id = Integer.parseInt(request.getParameter("id"));
	
		Usuario us = (Usuario) session.getAttribute("usuarios");
		CriticaDao dao = new CriticaDao();
		Critica c = dao.buscarPorId(id);
		
		List<Imagem> imagens = c.getImagens();
		String caminho = "";
		
		for(Imagem img : imagens){
			if(img.getCritica().getId().equals(id)){
				caminho = img.getCaminho();
			}
		}
		
	%>
	
	<nav class="navbar fixed-top navbar-dark bg-dark">
 		 <a class="navbar-brand" style="color: white;">Ol�, <%=us.getNome() %></a>
	</nav>
	
	<div class="container  span7  col-md-11 col-md-offset-3" style="margin: 0 auto; margin-top:125px; marginfloat: none; border: 1px solid gray">
		<fieldset>
		<legend>Cadastrar | Editar | Visualizar Cr�tica</legend>
		<form class="col-md-6">
		  <div class="form-group" >
		    <label for="titulo">Titulo</label>
		    <input type="text" class="form-control" name="titulo" value="<%=c.getTitulo()%>" disabled>
		  </div>
		  
		  <div class="form-group">
		    <label>Descri��o</label>
		    <textarea type="text" class="form-control" name="descricao" disabled><%=c.getDescricao() %></textarea>

		  </div>

		  <div class="form-group" >
		  	 <img width='200px' src="/sisgec/Download-img?arquivo=<%=caminho%>">
		  </div>
		  
		  <a href='/sisgec/Listar-criticas.jsp?numPagina=1' type="submit" class="btn btn-primary" style="margin-bottom: 10px">Voltar</a>
		  
		</form>
		</fieldset>
	</div>

</body>
</html>