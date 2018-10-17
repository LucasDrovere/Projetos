package desafio;

public class Main {
	
	public static void main(String[] args) {
		
		int base = 5;
		
		int qtdLinhas = base / 2 + 1;
		
		for (int linha = 0; linha < qtdLinhas; linha++) {
			
			int qtdEsp = base / 2 - linha;
			for (int esp = 0; esp < qtdEsp; esp++) {
				System.out.print(" ");
			}
			
			int qtdAst = linha * 2 + 1;
			for (int ast = 0; ast < qtdAst; ast++) {
				System.out.print("*");
			}
			
			System.out.println();
			
		}
		
	}

}
