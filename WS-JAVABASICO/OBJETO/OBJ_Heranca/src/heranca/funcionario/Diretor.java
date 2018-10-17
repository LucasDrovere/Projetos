package heranca.funcionario;

public class Diretor extends Funcionario{
	@Override
	public void exibir() {
		System.out.println("\nMonstrando informações do diretor: ");
		super.exibir();
	}
}
