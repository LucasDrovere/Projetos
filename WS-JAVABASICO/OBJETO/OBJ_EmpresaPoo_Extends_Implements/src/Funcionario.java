
public abstract class Funcionario implements Faturavel {
	
	protected String nome = "";
	protected int cargaHorarioSemanal;
	
	
	public Funcionario (String nome, int cargaHorarioSemanal) {
		this.nome = nome;
		this.cargaHorarioSemanal = cargaHorarioSemanal;
	}


	
	@Override
	public String toString() {
		return nome;
	}
}

