import java.util.ArrayList;

public class Empresa {
	String nome;
	private ArrayList<Funcionario> funcionarios;
	
	public Empresa(String n){
		this.nome = n;
		funcionarios = new ArrayList<>();
	}
	
	public void addFuncionario(Funcionario f) {
		funcionarios.add(f);
	}
	
	public void listarFuncionarios() {
		for (Funcionario f : funcionarios) {
			System.out.println("Nome do funcionario: " + f + "\tSalario: " + SetorFinanceiro.pagarFuncionario(f));
		}
	}
}
