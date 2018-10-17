package principal.funcionario;

import heranca.funcionario.Diretor;
import heranca.funcionario.Funcionario;
import heranca.funcionario.Gerente;
import heranca.funcionario.Secretaria;

public class Principal {

	public static void main(String[] args) {
		Funcionario fun = new Funcionario();
		fun.setNome("Lucas");
		fun.setSobreNome("Rovere");
		fun.setIdade(23);
		fun.exibir();
		
		Secretaria sec = new Secretaria();
		sec.setNome("Maria");
		sec.setSobreNome("da Silva");
		sec.setIdade(29);
		sec.exibir();
		
		Gerente ger = new Gerente();
		ger.setNome("Bruce");
		ger.setSobreNome("Wayne");
		ger.setIdade(37);
		ger.exibir();
		
		Diretor dir = new Diretor();
		dir.setNome("Joao");
		dir.setSobreNome("da Silva");
		dir.setIdade(57);
		dir.exibir();
		
	}

}
