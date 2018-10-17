package forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forum.entidade.Critica;
import forum.entidade.Usuario;
import forum.persistencia.CriticaDao;

/**
 * Servlet implementation class ExcluirCritica
 */
@WebServlet("/Excluir")
public class ExcluirCritica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario us = (Usuario) session.getAttribute("usuarios");
		String numPagina = request.getParameter("numPagina");
		
		CriticaDao dao = new CriticaDao();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Critica c = dao.buscarPorId(id);
		
		us.remove(c);
		
		dao.remover(c);
		
		response.sendRedirect("/forum/listar-criticas.jsp?numPagina=1");
	}

	

}