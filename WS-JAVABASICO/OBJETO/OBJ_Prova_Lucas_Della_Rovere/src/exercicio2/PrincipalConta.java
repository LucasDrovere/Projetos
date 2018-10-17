package exercicio2;

public class PrincipalConta {

	public static void main(String[] args) {
		
		Cliente cli = new Cliente("José da silva", "111.111.111-11", "44.444.444-4 ");
		Conta c = new Conta("00000002-1", 20.00, cli);
		System.out.println(c.toString());

	}

}
