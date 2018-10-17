package exercicio4;

import java.util.HashMap;
import java.util.Map;

public class SalaDeAula {

	private Professor professor;
	private Map<Integer, Aluno> mapaDeAlunos;
	private int chamada = 0;
	
	public SalaDeAula(Professor professor) {
		this.professor = professor;
		mapaDeAlunos = new HashMap<>();
		}
	
	
	public void adicionarAluno(Aluno a) throws LimiteDeAlunosPorSalaException{
		if(mapaDeAlunos.size() >= 30) {
			throw new LimiteDeAlunosPorSalaException();
		}
		chamada++;
			mapaDeAlunos.put(chamada, a);
		System.out.println("Aluno adicionado a sala");
	}


	public int getChamada() {
		return chamada;
	}
}