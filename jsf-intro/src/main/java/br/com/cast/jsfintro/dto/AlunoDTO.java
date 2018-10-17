package br.com.cast.jsfintro.dto;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

interface Grupo1 {
}

interface Grupo2 {
}

@GroupSequence({ AlunoDTO.class, Grupo2.class, Grupo1.class })
public class AlunoDTO {

	private Integer id;

	@NotEmpty(message = "Teste vazio!!!")
	@Size(min = 2, max = 10, groups = Grupo1.class)
	@NotBlank(message = "Cara, não pode estar em branco!", groups = Grupo2.class)
	private String nome;
	@NotBlank(message = "Cara, não pode estar em branco!", groups = Grupo2.class)
	private String sobrenome;
	
	private Integer idProfessor;
	
	private ProfessorDTO professorDTO;

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public ProfessorDTO getProfessorDTO() {
		if (professorDTO == null) {
			professorDTO = new ProfessorDTO();
		}
		return professorDTO;
	}

	public void setProfessorDTO(ProfessorDTO professorDTO) {
		this.professorDTO = professorDTO;
	}

	@Override
	public String toString() {
		return "AlunoDTO [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", idProfessor=" + idProfessor
				+ ", professorDTO=" + professorDTO + "]";
	}

	
}
