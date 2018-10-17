package br.com.cast.conta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.conta.persistencia.DaoConta;

@WebServlet("/excluir")
public class ExclusaoDeContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String numero = request.getParameter("numero");
		DaoConta dao = new DaoConta();
		dao.excluir(numero);
		
		response.sendRedirect("/conta-jsp/listar-conta.jsp");
	}

}
