package br.com.cast.json.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.json.dao.PessoaDao;
import br.com.cast.json.dto.PessoaDTO;
import br.com.cast.json.model.Pessoa;

public class PessoaBusiness {
	
	private PessoaDao dao;
	
	public PessoaBusiness() {
		dao = new PessoaDao();
	}

	public List<PessoaDTO> buscarTodas() {
		List<Pessoa> pessoas = dao.buscarTodos();
		List<PessoaDTO> dtos = new ArrayList<>();
		
		for (Pessoa pessoa : pessoas) {
			dtos.add(PessoaDTO.fromPessoa(pessoa));
		}
		
		dao.fechar();
		
		return dtos;
	}

	public void salvar(PessoaDTO pessoaDTO) throws Exception {
		//converter de dto para entidade
		Pessoa pessoa = new Pessoa();
		Pessoa.fromDTO(pessoa, pessoaDTO);
		
		dao.inserir(pessoa);
		dao.fechar();
	}
	
	public void alterar(String cpf, PessoaDTO pessoaDTO) throws Exception {
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		Pessoa.fromDTO(pessoa, pessoaDTO);
		dao.alterar(pessoa);
		dao.fechar();
	}

	public void excluir(String cpf) throws Exception {
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		dao.excluir(pessoa);
		dao.fechar();
	}

	public PessoaDTO buscarPorCpf(String cpf) {
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		PessoaDTO dto = PessoaDTO.fromPessoa(pessoa);
		dao.fechar();
		return dto;
	}

}
