package exercicioCarro;

public class Carro {
	int ano;
	Porta p1;
	Porta p2;
	Porta p3;
	Porta p4;
	Porta qnt;
	String marca;
	String modelo;
	int velocidadeAtual;
	
	
	Motor motor = new Motor();
	Cambio cambio = new Cambio();
	
	void lerDesc(String descMotor, int ano, String marcaVeiculo, String descModelo) {
		motor.descricao = descMotor;
		this.ano = ano;
		this.marca = marcaVeiculo;
		this.modelo = descModelo;
	}
	
	void acelerar(int velAdicional) {
		velocidadeAtual = velocidadeAtual + velAdicional;
		cambio.mudarDeMarcha(velocidadeAtual);
	};
	
	void adicionarPortas(int qntPortas) {
		if (qntPortas == 1) {
			this.p1 = new Porta();
		}else if(qntPortas == 2) {
			this.p1 = new Porta();
			this.p2 = new Porta();
		}else if (qntPortas == 3) {
			this.p1 = new Porta();
			this.p2 = new Porta();
			this.p3 = new Porta();
		}else if (qntPortas == 4) {
			this.p1 = new Porta();
			this.p2 = new Porta();
			this.p3 = new Porta();
			this.p4 = new Porta();
		}else {
			System.out.println("Quantidade maxima atingida!");
		}
	}
	
	void exibirCaraceristicas(){
		int qtdPortas = 0;
		if (p1 != null) {
			qtdPortas++;
		}
		if (p2 != null) {
			qtdPortas++;
		}
		if (p3 != null) {
			qtdPortas++;
		}
		if (p4 != null) {
			qtdPortas++;
		}	
		System.out.println("\nCaracteristicas do veiculo: ");
		System.out.println("Quantidade de Portas: " + qtdPortas);
		System.out.println("Descricao do motor: " + motor.descricao);
		System.out.println("Ano do veiculo: " + ano);
		System.out.println("A marca do veiculo é: " + marca);
		System.out.println("Modelo do veiculo: " + modelo);
	};
	
	void exibirEstado(){
		System.out.println("\nEstado do veiculo: ");
		System.out.println("Velocidade atual do carro: " + velocidadeAtual + "km/h");
		System.out.println("Marcha atual do carro: " + cambio.marchaAtual);
		if (p1 != null) {
			System.out.println("Estado da porta1: " + p1.estado);
		}
		if (p2 != null) {
			System.out.println("Estado da porta2: " + p2.estado);
		}
		if (p3 != null) {
			System.out.println("Estado da porta3: " + p3.estado);
		}
		if (p4 != null) {
			System.out.println("Estado da porta4: " + p4.estado);
		}
	}
}
	

