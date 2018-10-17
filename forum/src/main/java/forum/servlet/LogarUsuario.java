package forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forum.entidade.Usuario;
import forum.persistencia.UsuarioDao;

/**
 * Servlet implementation class LogarUsuario
 */
@WebServlet("/login")
public class LogarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UsuarioDao dao = new UsuarioDao();
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario us = dao.verificaLogin(usuario, senha);
		
		if(us != null) {
			session.setAttribute("usuarios", us);
			response.sendRedirect("listar-criticas.jsp?numPagina=1");
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
