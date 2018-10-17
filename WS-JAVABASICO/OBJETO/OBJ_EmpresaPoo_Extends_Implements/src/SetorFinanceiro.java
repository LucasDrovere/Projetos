public class SetorFinanceiro {

	private SetorFinanceiro() {
		
	}
	
	public static double pagarFuncionario(Faturavel f) {
		return f.calcularPagamento();
	}
}