package br.com.cast.filme.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="diretor", schema="filme")
public class Diretor {

	
	@Id
	@SequenceGenerator(name="gerador_diretor_seq",
				sequenceName="diretor_id_seq",
				schema="filme",
				allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator="gerador_diretor_seq")
		private Integer id;
	
	
		private String nome;
		private Integer idade;
		
		
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
		public Integer getIdade() {
			return idade;
		}
		public void setIdade(Integer idade) {
			this.idade = idade;
		}
	
}
