package br.com.cast.jsfintro.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.cast.jsfintro.business.PessoaBusiness;
import br.com.cast.jsfintro.dto.PessoaDTO;

@WebServlet("/Pessoa/*")
public class Pessoa extends HttpServlet {

	//LISTAR
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		PessoaBusiness pessoaB = new PessoaBusiness();

		List<PessoaDTO> pessoasDto = pessoaB.buscarTodos();

		Gson gson = new Gson();

		String json = gson.toJson(pessoasDto);

		response.setContentType("application/json");
		response.getWriter().append(json);
	}

	//SALVAR
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// recupera a string json da requisição
		String json = request.getReader().lines().collect(Collectors.joining());

		
		Gson gson = new Gson();
		PessoaDTO pessoaDTO = gson.fromJson(json, PessoaDTO.class);

		PessoaBusiness pessoaB = new PessoaBusiness();
		pessoaB.salvar(pessoaDTO);

		System.out.println(pessoaDTO);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// recupera a string json da requisição
		String json = req.getReader().lines().collect(Collectors.joining());

		
		Gson gson = new Gson();
		PessoaDTO pessoaDTO = gson.fromJson(json, PessoaDTO.class);
		
		PessoaBusiness pessoaB = new PessoaBusiness();
		
		System.out.println(pessoaDTO);
		
		pessoaB.remover(pessoaDTO.getCpf());
		
	}
}
