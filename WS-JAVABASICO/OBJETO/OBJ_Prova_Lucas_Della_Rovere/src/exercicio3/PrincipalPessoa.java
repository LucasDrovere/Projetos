package exercicio3;

public class PrincipalPessoa {

	public static void main(String[] args) {
		PessoaFisica pF = new PessoaFisica("Maria", "111.111.111-11");
		pF.imprimir();

		System.out.println();

		PessoaJuridica pJ = new PessoaJuridica("Simples", "XX.XXX.XXX/YYYY-ZZ");
		pJ.imprimir();

	}
}
