package crud_filme_array.Servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_filme_array.Controller.FilmeController;
import crud_filme_array.Entidade.Filme;

@WebServlet("/cad")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FilmeController filmeController = new FilmeController();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nomeParameter");
		String genero = request.getParameter("generoParameter");
		String duracao = request.getParameter("duracaoParameter");
		String diretor = request.getParameter("diretorParameter");
		String ano = request.getParameter("anoParameter");

		Random rand = new Random();
		int n = rand.nextInt(50) + 1;

		Filme f = new Filme();
		f.setId(n);
		f.setNome(nome);
		f.setGenero(genero);
		f.setDuracao(duracao);
		f.setDiretor(diretor);
		f.setAno(ano);

		filmeController.inserir(f);

		response.sendRedirect("/crud_filme_array/resultado.jsp");
	}

}
