package br.com.cast.filme.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FilmeDTO {
	
	private Integer id;
	
	@NotBlank(message = "Não pode estar em branco!")
	private String nome;
	
	@NotNull(message = "Não pode estar em Branco!")
	private DiretorDTO diretorDTO;
	@NotNull(message = "Não pode estar em Branco!")
	private GeneroDTO generoDTO;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public DiretorDTO getDiretorDTO() {
		return diretorDTO;
	}
	public void setDiretorDTO(DiretorDTO diretorDTO) {
		this.diretorDTO = diretorDTO;
	}
	public GeneroDTO getGeneroDTO() {
		return generoDTO;
	}
	public void setGeneroDTO(GeneroDTO generoDTO) {
		this.generoDTO = generoDTO;
	}
	

}
