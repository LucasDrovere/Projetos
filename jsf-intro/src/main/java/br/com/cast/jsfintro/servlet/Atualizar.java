package br.com.cast.jsfintro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.jsfintro.entidade.Aluno;
import br.com.cast.jsfintro.persistencia.AlunoDao;
import br.com.cast.jsfintro.persistencia.ProfessorDao;

@WebServlet("/Atualizar")
public class Atualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        AlunoDao dao = new AlunoDao();
        
        String id = request.getParameter("ident");
        
        String nome = request.getParameter("nomeParam");
		Integer professor = Integer.parseInt(request.getParameter("professorParam"));
        
        Aluno aln = dao.buscarPorId(Integer.parseInt(id));
		aln.setNome(nome);
		ProfessorDao pdao = new ProfessorDao();
		aln.setProfessor(pdao.buscarPorId(professor));
		
		dao.alterar(aln);
		
		
	}

}
