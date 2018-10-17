package br.com.cast.jsfprova.dto;

import java.util.Date;

public class LivroDTO {
	private Integer id;
	private String titulo;
	private Date data_publicacao;
	
	private AutorDTO autorDto;
	private Integer idAutor;
	
	private CategoriaDTO categoriaDto;
	private Integer idCategoria;
	
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
	public Date getData_publicacao() {
		return data_publicacao;
	}
	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}
	public AutorDTO getAutorDto() {
		return autorDto;
	}
	public void setAutorDto(AutorDTO autorDto) {
		this.autorDto = autorDto;
	}
	public Integer getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}
	public CategoriaDTO getCategoriaDto() {
		return categoriaDto;
	}
	public void setCategoriaDto(CategoriaDTO categoriaDto) {
		this.categoriaDto = categoriaDto;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
}
