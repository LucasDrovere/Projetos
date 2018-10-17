package forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.entidade.Usuario;
import forum.persistencia.UsuarioDao;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/Cadastrar")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDao dao = new UsuarioDao();
		
		String nome = request.getParameter("nome");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario us = new Usuario();
		us.setNome(nome);
		us.setUsuario(usuario);
		us.setSenha(senha);
		
		dao.inserir(us);
		
		response.sendRedirect("/forum/login.jsp");
		
	}

}
