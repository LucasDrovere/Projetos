package exercicio1;

public class Motor {

	private String potencia;
	private String qntCilindros;
	
	public Motor() {
		this.potencia = "110 cv";
		this.qntCilindros = "4 cilindros";
	}

	@Override
	public String toString() {
		return potencia + ", "+ qntCilindros;
	}


	
}
