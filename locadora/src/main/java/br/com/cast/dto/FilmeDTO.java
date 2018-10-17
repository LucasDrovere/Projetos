package br.com.cast.dto;

public class FilmeDTO {

	private Integer id;
	private String nome;
	private String ano;

	private Integer idGenero;
	private GeneroDTO generodto;
	
	private Integer idDiretor;
	private DiretorDTO diretordto;
	
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
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Integer getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}
	public GeneroDTO getGenerodto() {
		return generodto;
	}
	public void setGenerodto(GeneroDTO generodto) {
		this.generodto = generodto;
	}
	public Integer getIdDiretor() {
		return idDiretor;
	}
	public void setIdDiretor(Integer idDiretor) {
		this.idDiretor = idDiretor;
	}
	public DiretorDTO getDiretordto() {
		return diretordto;
	}
	public void setDiretordto(DiretorDTO diretordto) {
		this.diretordto = diretordto;
	}
}
