package br.com.cast.jsfforum.dto;

import java.util.ArrayList;
import java.util.List;

public class CriticaDTO {
	
	private Integer id;
	private String titulo;
	private String descricao;
	private UsuarioDTO usuarioDTO;
	private List<ImagemDTO> imagensDTO = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	public List<ImagemDTO> getImagensDTO() {
		return imagensDTO;
	}
	public void setImagensDTO(List<ImagemDTO> imagensDTO) {
		this.imagensDTO = imagensDTO;
	}

	
}


