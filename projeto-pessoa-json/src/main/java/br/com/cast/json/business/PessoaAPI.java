package br.com.cast.json.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cast.castapi.business.PessoaBusiness;
import br.com.cast.castapi.dto.PessoaDTO;
//@RestController
@RequestMapping(path = "/pessoa")
public class PessoaAPI {
	
	@Autowired
	private PessoaBusiness pb;
	
	@RequestMapping(name="/buscarTodos", method=RequestMethod.GET)
	public List<PessoaDTO> buscarTodos() {
		List<PessoaDTO> pessoasDTO = pb.buscarTodos();
		System.out.println(pessoasDTO);
		return pessoasDTO;
	}
	
	@RequestMapping(name="/inserir", method = RequestMethod.POST)
	public void inserir(@RequestBody PessoaDTO dto) {
		pb.inserir(dto);
		System.out.println("Pessoa: " + dto + "inserida com sucesso!");
	}
	
	@RequestMapping(name="/remover", path = "/{cpf}" , method = RequestMethod.DELETE)
	public String remover(@PathVariable("cpf") String cpf) {
		pb.excluir(cpf);
		System.out.println("removendo pessoa por cpf " + cpf);
		return "cpf" + cpf + " deletado";
	}
	
	@RequestMapping(path = "/{cpf}", method = RequestMethod.GET)
	public String buscarPorCpf(@PathVariable("cpf") String cpf) {
		System.out.println("Cpf que veio por parametro: " + cpf);
		return "buscando por cpf: " + cpf + "";
	}
	
	@RequestMapping(path = "/{cpf}" , method = RequestMethod.PUT)
	public String alterar(@PathVariable("cpf") String cpf, @RequestBody PessoaDTO dto) {
		System.out.println("alterando pessoa por cpf " + cpf);
		dto.setCpf(cpf);
		System.out.println(dto);
		
		
		return "cpf" + cpf + dto + " alterado";

	}
	
	
}
