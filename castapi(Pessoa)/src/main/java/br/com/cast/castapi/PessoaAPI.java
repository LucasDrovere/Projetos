package br.com.cast.castapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.castapi.dto.PessoaDTO;
import br.com.cast.castapi.model.Pessoa;
import br.com.cast.castapi.repository.PessoaRepository;

//@RestController
public class PessoaAPI {
	/*
	@Autowired
	private PessoaRepository repository;
	
	@RequestMapping(name="/test", method=RequestMethod.GET)
	public PessoaDTO test() {
		
		PessoaDTO dto = new PessoaDTO();
		dto.setCpf("321321321");
		dto.setEmail("teste@teste.com");
		
		List<Pessoa> lista = repository.buscarTodas();
		System.out.println(lista);
		
		return dto;
	}*/

}
