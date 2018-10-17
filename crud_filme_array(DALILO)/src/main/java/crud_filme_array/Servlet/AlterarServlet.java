package crud_filme_array.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_filme_array.Controller.FilmeController;
import crud_filme_array.Entidade.Filme;

@WebServlet("/alterar")
public class AlterarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	FilmeController filmeController = new FilmeController();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("idParameter"));
		
		String nome = request.getParameter("nomeParameter");
		String genero = request.getParameter("generoParameter");
		String duracao = request.getParameter("duracaoParameter");
		String diretor = request.getParameter("diretorParameter");
		String ano = request.getParameter("anoParameter");
		
		Filme f = filmeController.buscarPorId(id);
		f.setNome(nome);
		f.setGenero(genero);
		f.setDuracao(duracao);
		f.setDiretor(diretor);
		f.setAno(ano);
		
		filmeController.alterar(f);
		
		response.sendRedirect("/crud_filme_array/resultado.jsp");
		
	}

}
