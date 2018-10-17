package heranca.funcionario;

public class Gerente extends Funcionario {
	@Override
	public void exibir() {
		System.out.println("\nMonstrando informações do gerente: ");
		super.exibir();
	}
}
