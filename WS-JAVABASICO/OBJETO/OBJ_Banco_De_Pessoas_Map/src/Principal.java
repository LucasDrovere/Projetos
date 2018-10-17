import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		Map<String, String> mapa = new HashMap<>();
		
		mapa.put("111111111", "Maria");
		mapa.put("222222222", "Joao");
		
		String cpfAPesquisar = "222222222";
		
		String nome = mapa.get(cpfAPesquisar);
		
		System.out.println("O nome da pessoa é: " + nome);
		
		
		Set<String> chaves = mapa.keySet();
		
		System.out.println("Percorrendo as chaves");
		for (String chave : chaves) {
			System.out.println("chave : " + chave + " > " + mapa.get(chave));
		}
		
		System.out.println("Percorrendo os valores");
		for (String name: mapa.values()) {
			System.out.println("Nome: " + name);
		}
		
	}

}
