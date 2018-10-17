package br.com.cast.jsfintro.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfintro.dto.EnderecoDTO;
import br.com.cast.jsfintro.dto.PessoaDTO;
import br.com.cast.jsfintro.entidade.Endereco;
import br.com.cast.jsfintro.entidade.Pessoa;
import br.com.cast.jsfintro.persistencia.EnderecoDao;
import br.com.cast.jsfintro.persistencia.PessoaDao;

public class PessoaBusiness {
	
	private PessoaDao pessoaDao;
	private EnderecoDao enderecoDao;
	
	public PessoaBusiness() {
		this.pessoaDao = new PessoaDao();
		this.enderecoDao = new EnderecoDao();
	}
	
	
	public void salvar(PessoaDTO pessoaDto) {
		
		EnderecoDTO endDTO = pessoaDto.getEndereco();
		Endereco end = new Endereco();
		
		end.setCep(endDTO.getCep());
		end.setLogradouro(endDTO.getLogradouro());
		end.setNumero(endDTO.getNumero());
		end.setComplemento(endDTO.getComplemento());
		end.setBairro(endDTO.getBairro());
		end.setCidade(endDTO.getCidade());
		end.setUf(endDTO.getUf());
		
		Pessoa p = new Pessoa();
		p.setNome(pessoaDto.getNome());
		p.setCpf(pessoaDto.getCpf());
		p.setEmail(pessoaDto.getEmail());
		p.setEndereco(end);
		
		pessoaDao.inserir(p);
	}
	
	public void remover(String cpf) {
		Pessoa p = pessoaDao.buscarPorCpf(cpf);
		pessoaDao.remover(p);
	}
	
	public PessoaDTO buscarPorCpf(String cpf) {
		PessoaDTO pDTO = new PessoaDTO();
		Pessoa p = pessoaDao.buscarPorCpf(cpf);
		pDTO.setNome(p.getNome());
		pDTO.setCpf(p.getCpf());
		pDTO.setEmail(p.getEmail());
		
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		Endereco end = p.getEndereco();
		enderecoDTO.setCep(end.getCep());
		enderecoDTO.setNumero(end.getNumero());
		enderecoDTO.setBairro(end.getBairro());
		enderecoDTO.setCidade(end.getCidade());
		enderecoDTO.setComplemento(end.getComplemento());
		enderecoDTO.setLogradouro(end.getLogradouro());
		enderecoDTO.setUf(end.getUf());
		
		pDTO.setEndereco(enderecoDTO);
		
		return pDTO;
	}
	
	public void alterar(PessoaDTO pessoaDto) {
		Pessoa p = new Pessoa();
		
		Endereco end = enderecoDao.buscarPorCep(pessoaDto.getEndereco().getCep());
		
		p.setNome(pessoaDto.getNome());
		p.setCpf(pessoaDto.getCpf());
		p.setEmail(pessoaDto.getEmail());
		p.setEndereco(end);
		pessoaDao.alterar(p);
	}


	public List<PessoaDTO> buscarTodos() {
		
		List<Pessoa> pessoas = pessoaDao.buscarTodos();
		List<PessoaDTO> pessoasDto = new ArrayList<>();
		
		for (Pessoa p : pessoas) {
			PessoaDTO pDTO = new PessoaDTO();
			
			pDTO.setNome(p.getNome());
			pDTO.setCpf(p.getCpf());
			pDTO.setEmail(p.getEmail());
			
			EnderecoDTO enderecoDTO = new EnderecoDTO();
			Endereco end = p.getEndereco();
			enderecoDTO.setCep(end.getCep());
			enderecoDTO.setNumero(end.getNumero());
			enderecoDTO.setBairro(end.getBairro());
			enderecoDTO.setCidade(end.getCidade());
			enderecoDTO.setComplemento(end.getComplemento());
			enderecoDTO.setLogradouro(end.getLogradouro());
			enderecoDTO.setUf(end.getUf());
			pDTO.setEndereco(enderecoDTO);
			
			pessoasDto.add(pDTO);
		}
		
		return pessoasDto;
	}
}
