package heranca.funcionario;

public class Gerente extends Funcionario {
	@Override
	public void exibir() {
		System.out.println("\nMonstrando informa��es do gerente: ");
		super.exibir();
	}
}
