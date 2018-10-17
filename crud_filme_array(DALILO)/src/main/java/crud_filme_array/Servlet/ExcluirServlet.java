package crud_filme_array.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_filme_array.Controller.FilmeController;

@WebServlet("/excluir")
public class ExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	FilmeController filmeController = new FilmeController();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("idParameter"));
		
		filmeController.deletar(id);
		
		response.sendRedirect("/crud_filme_array/resultado.jsp");
	}

	

}
