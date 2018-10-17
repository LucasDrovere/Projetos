import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class PrincipalExercicioDinamico {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		BancoDePessoas banco = new BancoDePessoas();
		Pessoa p = new Pessoa();

		System.out.println("Digite seu nome: ");
		String nomeDigitado = ler.next();
		p.setNome(nomeDigitado);

		if (banco.mapa.containsKey(p.pegarLetra())) {
			banco.mapa.get(p.pegarLetra()).add(new Pessoa().setNome(nomeDigitado));
		} else {
			new ArrayList<>().add(p.setNome(nomeDigitado));
			banco.mapa.keySet().add(p.pegarLetra());
		}

		System.out.println("Percorrendo as chaves");
		for (String chave : banco.mapa.keySet()) {
			System.out.println("chave : " + chave + " > " + banco.mapa.get(chave));
		}
		System.out.println("Percorrendo os valores");
		for (ArrayList<Pessoa> name : banco.mapa.values()) {
			System.out.println("Nome: " + name);
		}
		
		
		
		Iterator<Pessoa> itPessoas = p.iterator();
				
				
				
				
	}
}