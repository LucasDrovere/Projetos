<%@page import="br.com.cast.entidade.Post"%>
<%@page import="br.com.cast.persistencia.PostDao"%>
<%@page import="java.util.List"%>
<html>
<body>
	<h2>Hello World!</h2>

	<%
		PostDao dao = new PostDao();
		Post post = dao.buscarPorId(1);
	%>

	<div>
	
	
		<%=post.getTextoComImagens()%>
	</div>
	
	<form action="img" method="get">
		<div>
			<!--<img src="/post-img/img?arquivo=casa.jpg" name="arquivo"/>-->
			<input type='text' name='arquivo'> 
			<input type="submit" value="Buscar img">
		</div>
	</form>


</body>
</html>
