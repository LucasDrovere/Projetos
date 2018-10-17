package br.com.sisgec.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sisgec.entidades.Usuario;
import br.com.sisgec.persistencia.UsuarioDao;

/**
 * Servlet implementation class LogarUsuario
 */
@WebServlet("/Logar")
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
			response.sendRedirect("/sisgec/Listar-criticas.jsp?numPagina=1");
		}else {
			response.sendRedirect("/sisgec/Login.jsp");
		}
		
	}

}
