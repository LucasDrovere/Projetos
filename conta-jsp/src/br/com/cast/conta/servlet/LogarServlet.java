package br.com.cast.conta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cast.conta.modelo.Usuario;
import br.com.cast.conta.persistencia.DaoUsuario;

@WebServlet("/logar")
public class LogarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuarioParam = request.getParameter("usuario");
		String senhaParam = request.getParameter("senha");
		
		HttpSession session = request.getSession();
		
		DaoUsuario dao = new DaoUsuario();
		Usuario usuario = dao.logar(usuarioParam, senhaParam);
		
		if (usuario != null) {
			//adiciona o usuário na sessão
			session.setAttribute("usuarioLogado", usuario);
			request
				.getRequestDispatcher("inicio.jsp")
				.forward(request, response);
		} else {
			//retorna o html de login
			request
				.getRequestDispatcher("login.jsp")
				.forward(request, response);
		}
		
	}
	

}
