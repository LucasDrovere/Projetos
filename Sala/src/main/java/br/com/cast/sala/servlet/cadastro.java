package br.com.cast.sala.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.sala.entidade.Aluno;
import br.com.cast.sala.persistencia.AlunoDao;
import br.com.cast.sala.persistencia.ProfessorDao;

/**
 * Servlet implementation class cadastro
 */

public class cadastro extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nome = request.getParameter("txtNome");
		Integer professor = Integer.parseInt(request.getParameter("txtProfessor")); 
		
		Aluno a = new Aluno();
		a.setNome(nome);
		
		ProfessorDao pdao = new ProfessorDao();
		
		a.setProfessor(pdao.buscaPorId(professor));
		
		AlunoDao dao = new AlunoDao();
		dao.inserir(a);
		
		
	}

}
