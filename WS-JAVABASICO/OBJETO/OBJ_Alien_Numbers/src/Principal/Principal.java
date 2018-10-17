package Principal;
import java.io.*;

public class Principal {

	static int caso = 1;

	public static void main(String[] args) throws IOException {

		// se necessário altere o conteúdo do arquivo A-small-practice.in para fazer os
		// testes conhecidos

		InputStream in = Principal.class.getResourceAsStream("A-small-practice.in");
		BufferedReader bf = new BufferedReader(new InputStreamReader(in));
		bf.readLine();

		String line = "";

		while ((line = bf.readLine()) != null) {

			String[] inputs = line.split(" ");

			String numeroDeEntrada = inputs[0];
			String source = inputs[1]; // linguagem de origem
			String target = inputs[2]; // linguagem alvo

			String saida = "TODO"; // TODO implementar o algoritmo
			imprimeCaso(saida);
		}
	}

	public static void imprimeCaso(String resultado) {
		System.out.printf("Case #%d: %s\n", caso, resultado);
		caso++;
	}
}