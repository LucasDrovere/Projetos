package br.com.cast.json.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.cast.json.business.PessoaBusiness;
import br.com.cast.json.dto.PessoaDTO;

@WebServlet("/pessoa/*")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1-chamar o método buscarTodas do business
		PessoaBusiness business = new PessoaBusiness();

		String uri = req.getRequestURI();
		if (uri.endsWith("/pessoa")) { // buscar todos
			List<PessoaDTO> pessoasDTO = business.buscarTodas();
			escreveJSON(resp, pessoasDTO);
		} else { // buscar por cpf
			String cpf = getCPFDaURI(req);
			PessoaDTO pessoaDTO = business.buscarPorCpf(cpf);
			escreveJSON(resp, pessoaDTO);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * String linha = null; String conteudo = ""; while ((linha =
		 * req.getReader().readLine()) != null) { conteudo += linha; }
		 */

		String json = req.getReader().lines().collect(Collectors.joining());

		// 1-converter o json para DTO
		Gson gson = new Gson();
		PessoaDTO pessoaDTO = gson.fromJson(json, PessoaDTO.class);

		// 2-enviar o dto para o método salvar do business
		RespostaJSON resposta = new RespostaJSON();
		try {
			PessoaBusiness business = new PessoaBusiness();
			business.salvar(pessoaDTO);
			resposta.addInfo("Registro inserido com sucesso!");
		} catch (Exception e) {
			resposta.addErro(e.getMessage());
		}

		// 3-enviar mensagem de sucesso ou de erro
		escreveJSON(resp, resposta);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = getCPFDaURI(req);

		PessoaBusiness business = new PessoaBusiness();
		RespostaJSON resposta = new RespostaJSON();
		try {
			business.excluir(cpf);
			resposta.addInfo("Registros excluído com sucesso");
		} catch (Exception e) {
			resposta.addErro(e.getMessage());
		}

		escreveJSON(resp, resposta);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cpf = getCPFDaURI(req);

		String json = req.getReader().lines().collect(Collectors.joining());

		Gson gson = new Gson();
		PessoaDTO pessoaDTO = gson.fromJson(json, PessoaDTO.class);

		PessoaBusiness business = new PessoaBusiness();
		RespostaJSON resposta = new RespostaJSON();
		try {
			business.alterar(cpf, pessoaDTO);
			resposta.addInfo("Registro alterado com sucesso");
		} catch (Exception e) {
			resposta.addErro(e.getMessage());
		}

		escreveJSON(resp, resposta);
	}

	private String getCPFDaURI(HttpServletRequest req) {
		String uri = req.getRequestURI();
		int indexParam = uri.lastIndexOf("/");

		String cpf = uri.substring(indexParam + 1);
		return cpf;
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	}

	private void escreveJSON(HttpServletResponse resp, Object objeto) throws IOException {

		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

		Gson gson = new Gson();
		String json = gson.toJson(objeto);
		// 3-mudar o contentType para application/json
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		// 4-escrever o json na resposta
		resp.getWriter().append(json);
	}

}
