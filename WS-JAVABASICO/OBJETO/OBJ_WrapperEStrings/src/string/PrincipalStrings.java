package string;

public class PrincipalStrings {

	public static void main(String[] args) {
		String s = "Olá mundo!";
		
		
		String palavra = "m";
		if (s.contains(palavra)) {
			System.out.println("Contem" + palavra);
		}else {
			System.out.println("Não contem" + palavra);
		}
		
		System.out.println("Posicao da letra: " + s.indexOf("n"));
		
		System.out.println("Letra na posicao: " + s.charAt(8));

		
		
		System.out.println(s.substring(3));
		
		
		System.out.println(s.substring(3, 7));
	
		s.endsWith("!");
		
		s.startsWith("o");
		
		s = s.replace("!", "?");
		
		System.out.println(s);
		
		
		
	}

}
