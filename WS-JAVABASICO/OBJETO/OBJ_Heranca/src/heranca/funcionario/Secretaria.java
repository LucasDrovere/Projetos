package heranca.funcionario;

public class Secretaria extends Funcionario {
	@Override
	public void exibir() {
		System.out.println("\nMonstrando informa��es da secretaria: ");
		super.exibir();
	}
}
