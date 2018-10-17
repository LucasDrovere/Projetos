package br.com.cast.jsfforum.dto;

public class ImagemDTO {

	private Integer id;
	private String caminho;
	private CriticaDTO criticadto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public CriticaDTO getCriticadto() {
		return criticadto;
	}
	public void setCriticadto(CriticaDTO criticadto) {
		this.criticadto = criticadto;
	}
	
}
