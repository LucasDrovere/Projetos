import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;

public class PrincipalExercicio {

	public static void main(String[] args) {
		Map<String, ArrayList<Pessoa>> mapa = new HashMap<>();
		ArrayList<Pessoa> m = new ArrayList<>();
		ArrayList<Pessoa> l = new ArrayList<>();
		ArrayList<Pessoa> b = new ArrayList<>();
		
		m.add(new Pessoa("Maria", "222222222"));
		m.add(new Pessoa("Mario", "222232322"));
		m.add(new Pessoa("Marcelo", "3214324321"));
		l.add(new Pessoa("Luana", "321432541"));
		l.add(new Pessoa("Lucas", "432432432"));
		b.add(new Pessoa("Lucas", "432432432"));
		
		mapa.put("M", m);
		mapa.put("L", l);

		System.out.println("Percorrendo as chaves");
		for (String chave : mapa.keySet()) {
			System.out.println("Chave: " + chave + " >  " + mapa.get(chave));
		}
		System.out.println();

		System.out.println("Percorrendo os valores");
		for (ArrayList<Pessoa> p : mapa.values()) {
			System.out.println(p);
		}

	}

}
