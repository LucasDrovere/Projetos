package br.com.cast.jsfintro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.jsfintro.entidade.Aluno;
import br.com.cast.jsfintro.persistencia.AlunoDao;

@WebServlet("/Excluir")
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Aluno aln = new Aluno();
        AlunoDao dao = new AlunoDao();
        
        String id = request.getParameter("ident");
        
        aln = dao.buscarPorId(Integer.parseInt(id));
        
        dao.excluir(aln);
		
		
	}

}
