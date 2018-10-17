
public class ProgramadorJunior extends Funcionario{
	public static final double PORCENTAGEM_INSS = 10;
	
	public ProgramadorJunior(String nome) {
		super(nome, 40);
	}

	@Override
	public double calcularPagamento() {
		double valorPagamento = valorPorHora * cargaHorarioSemanal * (1 - (PORCENTAGEM_INSS /100));
		return valorPagamento;
	}

}
