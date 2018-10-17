package br.com.cast.jsfintro.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.cast.jsfintro.business.AlunoBusiness;
import br.com.cast.jsfintro.dto.AlunoDTO;
import br.com.cast.jsfintro.entidade.Aluno;
import br.com.cast.jsfintro.persistencia.AlunoDao;

@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		AlunoBusiness alnB = new AlunoBusiness();
		AlunoDao alnDao = new AlunoDao();
		
		List<Aluno> alunos = alnDao.buscarTodos();
		
		List<AlunoDTO> alunosDto = alnB.buscarTodos();
		
		Gson gson = new Gson();

		String json = gson.toJson(alunos);

		response.setContentType("application/json");
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
