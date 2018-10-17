package br.com.cast.castapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.castapi.business.PessoaBusiness;
import br.com.cast.castapi.dto.PessoaDTO;

@RestController
@RequestMapping(path="/pessoa")
public class TesteAPI {
	
	@Autowired
	private PessoaBusiness pessoaBusiness;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<PessoaDTO> buscarTodos() {
		return pessoaBusiness.buscarTodos();
	}
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.GET)
	public String buscarPorCpf(@PathVariable("cpf") String cpf) {
		System.out.println("cpf que veio por parametro: " + cpf);
		return "buscar por id";
	}
	
	@RequestMapping(path="/{cpf}/{nome}", method=RequestMethod.GET)
	public String buscarPorCpfENome(
			@PathVariable("cpf") String cpf, 
			@PathVariable("nome") String nome) {
		System.out.println("parametros: " + cpf + ", " + nome);
		return "buscar por id";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void inserir(@RequestBody PessoaDTO dto) {
		pessoaBusiness.inserir(dto);
	}

}
