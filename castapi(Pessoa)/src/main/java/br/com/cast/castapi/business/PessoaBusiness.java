package br.com.cast.castapi.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.castapi.dto.PessoaDTO;
import br.com.cast.castapi.model.Pessoa;
import br.com.cast.castapi.repository.PessoaRepository;

@Service
public class PessoaBusiness {
	
	@Autowired
	private PessoaRepository repositorio;
	
	public List<PessoaDTO> buscarTodos() {
		List<Pessoa> pessoas = repositorio.buscarTodas();
		List<PessoaDTO> dtos = new ArrayList<>();
		
		for (Pessoa pessoa : pessoas) {
			dtos.add(PessoaDTO.fromPessoa(pessoa));
		}
		return dtos;
	}

	@Transactional
	public void inserir(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		Pessoa.fromDTO(pessoa, dto);
		
		repositorio.inserir(pessoa);
	}

}
