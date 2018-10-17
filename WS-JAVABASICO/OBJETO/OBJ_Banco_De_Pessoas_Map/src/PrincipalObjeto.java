import java.util.HashMap;
import java.util.Map;

public class PrincipalObjeto {

	public static void main(String[] args) {
		Map <String, Pessoa> mapa = new HashMap<>();
		
		Pessoa maria = new Pessoa("Maria", "111111111111");
		Pessoa joao = new Pessoa("Joao", "2222222222");
		mapa.put(maria.getCpf(), maria);
		mapa.put(joao.getCpf(), joao);
		
		Pessoa pessoaPesquisada  = mapa.get("2222222222");
		
		System.out.println(pessoaPesquisada);
		System.out.println();
		System.out.println("Percorrendo as chaves");
		//cpf
		for(String chave : mapa.keySet()) {
			System.out.println("chave: " + chave + " > " + mapa.get(chave));
		}
		System.out.println();
		System.out.println("Percorrendo os valores");
		//nomes
		for(Pessoa p : mapa.values()) {
			System.out.println(p);
		}
		
	}

}
