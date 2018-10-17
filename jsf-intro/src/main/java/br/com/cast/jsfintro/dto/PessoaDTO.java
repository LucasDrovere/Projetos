package br.com.cast.jsfintro.dto;

public class PessoaDTO {
	
	private String cpf;
	
	private String nome;
	private String email;
	private String idEndereco;
	private EnderecoDTO enderecoDto;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}
	public EnderecoDTO getEnderecoDto() {
		return enderecoDto;
	}
	public void setEnderecoDto(EnderecoDTO enderecoDto) {
		this.enderecoDto = enderecoDto;
	}
	@Override
	public String toString() {
		return "PessoaDTO [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", idEndereco=" + idEndereco
				+ ", enderecoDto=" + enderecoDto + "]";
	}
}
