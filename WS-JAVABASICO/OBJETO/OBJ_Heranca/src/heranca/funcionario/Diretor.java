package heranca.funcionario;

public class Diretor extends Funcionario{
	@Override
	public void exibir() {
		System.out.println("\nMonstrando informa��es do diretor: ");
		super.exibir();
	}
}
