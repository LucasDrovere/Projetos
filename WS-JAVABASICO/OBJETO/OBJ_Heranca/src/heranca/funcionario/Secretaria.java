package heranca.funcionario;

public class Secretaria extends Funcionario {
	@Override
	public void exibir() {
		System.out.println("\nMonstrando informações da secretaria: ");
		super.exibir();
	}
}
