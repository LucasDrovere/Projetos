public class Estagiario extends Funcionario {

	public Estagiario(String nome) {
		super(nome, 30);
	}

	
	@Override
	public double calcularPagamento() {
		double valorPagamento = valorPorHora * cargaHorarioSemanal;
		return valorPagamento;
	}

}
