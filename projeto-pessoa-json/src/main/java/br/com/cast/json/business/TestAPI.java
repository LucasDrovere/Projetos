package br.com.cast.json.business;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.castapi.dto.PessoaDTO;

@RestController
@RequestMapping(path = "/pessoa")
public class TestAPI {

	@RequestMapping(path = "", method = RequestMethod.GET)
	public PessoaDTO buscarTodos() {
		PessoaDTO dto = new PessoaDTO();
		dto.setNome("Lucas");
		dto.setEmail("lucas@email.com");
		dto.setCpf("44444444");
		return dto;
	}

	@RequestMapping(path = "/{cpf}", method = RequestMethod.GET)
	public String buscarPorCpf(@PathVariable("cpf") String cpf) {
		System.out.println("Cpf que veio por parametro: " + cpf);
		return "buscando por cpf: " + cpf + "";
	}

	@RequestMapping(path = "/{cpf}/{nome}", method = RequestMethod.GET)
	public String buscarPorCpfENome(@PathVariable("cpf") String cpf, @PathVariable("nome") String nome) {
		System.out.println("parametros: " + cpf + ", " + nome);
		return "buscando por cpf: " + cpf + " e nome: " + nome + " ";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String inserir(@RequestBody PessoaDTO dto) {
		System.out.println("INSERINDO " + dto);
		return "inserir dto" + dto;

	}
	
	@RequestMapping(path = "/{cpf}" , method = RequestMethod.DELETE)
	public String remover(@PathVariable("cpf") String cpf) {
		System.out.println("removendo pessoa por cpf " + cpf);
		return "cpf" + cpf + " deletado";

	}

	@RequestMapping(path = "/{cpf}" , method = RequestMethod.PUT)
	public String alterar(@PathVariable("cpf") String cpf, @RequestBody PessoaDTO dto) {
		System.out.println("alterando pessoa por cpf " + cpf);
		dto.setCpf(cpf);
		System.out.println(dto);
		
		
		return "cpf" + cpf + dto + " alterado";

	}
	
	/*@RequestMapping(path = "/{cpf}/{nome}/{email}", method = RequestMethod.POST)
	public String inserirParam(@PathVariable("cpf") String cpf, @PathVariable("nome") String nome, @PathVariable("email") String email) {
		PessoaDTO pDTO = new PessoaDTO();
		pDTO.setCpf(cpf);
		pDTO.setNome(nome);
		pDTO.setEmail(email);

		System.out.println(pDTO);
		return "inserir dto" + pDTO;
	}*/
}
