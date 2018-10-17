<%@page import="br.com.cast.entidade.Imagem"%>
<%@page import="br.com.cast.entidade.Post"%>
<%@page import="br.com.cast.persistencia.PostDao"%>
<%@page import="java.util.List"%>
<html>
<body style="background-color:grey;">
<h1 align="center">Brogue</h1>

	<%
	PostDao dao = new PostDao();
	List<Post> posts = dao.buscarTodos();
	%>
	
	<div align="center">
		
		<% for (Post post : posts) { %>
		<h3 align="center"> <%= post.getTexto() %> </h3>
		<% 	for (Imagem img : post.getImagens()) { %>
			<div align="center">
				<img width="200px" src="/web-hibernate/download-img?arquivo=<%= img.getArquivo() %>" />
			</div>
		<% } } %>
	</div>
</body>
</html>
