package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrincipalExerciciosString {

	public static void main(String[] args) {
		
		String string = "Prova de Java";
		exercicioUmA(string);
		exercicioUmB(string, false);
		exercicioUmC(string);
		exercicioUmD("Eu tenho 32 anos e 2 meses");
		exercicioUmE("roma me tem amor");
		
		exercicioQuatro();
		System.out.println("\nbase octal:" + (0111));
		exercicioCinco("111A", 20);
		//10 + 20 + 400 + 8000
	}

	private static void exercicioCinco(String string, int base) {
		System.out.println("\nconvertendo para base " + base);
		int potencia = string.length() - 1;
		int valor = 0;
		
		Map<String, Integer> mapaDeValores = getMapaLetraParaNumero();
		
		for (char c : string.toCharArray()) {
			int digito = c - '0';
			if (Character.isAlphabetic(c)) {
				digito = mapaDeValores.get(String.valueOf(c));
			}
			valor += digito * Math.pow(base, potencia); 
			potencia--;
		}
		System.out.println(valor);
	}

	private static Map<String, Integer> getMapaLetraParaNumero() {
		
		Map<String, Integer> mapa = new HashMap<>();
		mapa.put("A", 10);
		mapa.put("B", 11);
		mapa.put("C", 12);
		mapa.put("D", 13);
		mapa.put("E", 14);
		mapa.put("F", 15);
		mapa.put("G", 16);
		mapa.put("H", 17);
		mapa.put("I", 18);
		mapa.put("J", 19);
		mapa.put("K", 20);
		mapa.put("L", 21);
		mapa.put("M", 22);
		mapa.put("N", 23);
		
		return mapa;
	}

	private static void exercicioQuatro() {
		int[] frase = new int[] { 84, 114, 234, 115, 32, 112, 114, 97, 116, 111, 115, 32, 100, 101, 32, 116, 114, 105,
				103, 111, 32, 112, 97, 114, 97, 32, 116, 114, 234, 115, 32, 116, 105, 103, 114, 101, 115, 32, 116, 114,
				105, 115, 116, 101, 115 };
		
		for (int dec : frase) {
			System.out.print((char) dec);
		}
	}

	private static void exercicioUmE(String string) {
		String stringInvertida = "";
		
		for (int i = string.length() - 1; i >= 0; i--) {
			char c = string.charAt(i);
			if (' ' != c) {
				stringInvertida += c;
			}
		}
		string = string.replace(" ", "");
		
		//verificar se é palindromo
		if (string.equalsIgnoreCase(stringInvertida)) {
			System.out.println("É palindromo \n" + 
					string + "\n" + stringInvertida);
		} else {
			System.out.println("Não é palíndromo");
		}
		
	}

	private static void exercicioUmD(String string) {
		int qtdDigitos = 0;
		
		for (char c : string.toCharArray()) {
			if (Character.isDigit(c)) {
				qtdDigitos++;
			}
		}
		System.out.println("Existem " + qtdDigitos + " digitos na string: " + string);
	}
	private static void exercicioUmC(String string) {
		List<Character> vogais = Arrays.asList(
			'a', 'e', 'i', 'o', 'u', 
			'A', 'E', 'I', 'O', 'U'
		);
		
		int qtdVogais = 0;
		
		for (char c : string.toCharArray()) {
			if (vogais.contains(c)) {
				qtdVogais++;
			}
		}
		System.out.println("Existem " + qtdVogais + " vogais na string: " + string);
	}

	private static void exercicioUmB(String string, boolean upper) {
		char[] caracteres = string.toCharArray();
		int distancia = 'a' - 'A';
		System.out.println(distancia);
		String valorCase = "";
		
		if (upper) {
			for (char c : caracteres) {
				if (c >= 'a' && c <= 'z') {
					valorCase += (char)(c - distancia);
				} else {
					valorCase += c;
				}
			}
		} else { //lower case
			for (char c : caracteres) {
				if (c >= 'A' && c <= 'Z') {
					valorCase += (char)(c + distancia);
				} else {
					valorCase += c;
				}
			}
		}
		System.out.println(valorCase);
	}

	private static void exercicioUmA(String string) {
		System.out.println("O tamanho da string é: " + string.length());
	}

}
