package exercicioCarro;

public class Porta {
	int descricao;

	String estado = "Fechada";

	boolean Porta = true;

	void estado() {
		if (Porta) {
			abrir();
		} else
			fechar();
	}

	void abrir() {
		estado = "Porta aberta";
		System.out.println(estado);
	};

	void fechar() {
		estado = "Porta fechada";
		System.out.println(estado);
	};

}
