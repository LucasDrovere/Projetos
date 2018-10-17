package exercicioRobo;
public class Robo {

	//char orientacao; // L, O, N e S
	double velocidade = 10;
	
	Posicao p = new Posicao();
	Orientacao o = new Orientacao();
	
	void inicializar(int x, int y, char orientacao) {
		p.x = x;
		p.y = y;
		o.orientacao = orientacao;
	}

	void mover() {
		if (o.orientacao == 'L') {
			p.x++;
		} else if (o.orientacao == 'N') {
			p.y++;
		} else if (o.orientacao == 'O') {
			p.x--;
		} else if (o.orientacao == 'S') {
			p.y--;
		}
	}

	void turnLeft() {
		if (o.orientacao == 'L') {
			o.orientacao = 'N';
		} else if (o.orientacao == 'N') {
			o.orientacao = 'O';
		} else if (o.orientacao == 'O') {
			o.orientacao = 'S';
		} else if (o.orientacao == 'S') {
			o.orientacao = 'L';
		}
	}

	void turnRight() {
		if (o.orientacao == 'L') {
			o.orientacao = 'S';
		} else if (o.orientacao == 'N') {
			o.orientacao = 'L';
		} else if (o.orientacao == 'O') {
			o.orientacao = 'N';
		} else if (o.orientacao == 'S') {
			o.orientacao = 'O';
		}
	}

	void turnAround() {
		if (o.orientacao == 'L') {
			o.orientacao = 'O';
		} else if (o.orientacao == 'N') {
			o.orientacao = 'S';
		} else if (o.orientacao == 'O') {
			o.orientacao = 'L';
		} else if (o.orientacao == 'S') {
			o.orientacao = 'N';
		}
	}

	boolean temBeeperPresente() {
		if (p.x == 10 && p.y == 12) {
			return true;
		} else if (p.x == 11 && p.y == 11) {
			return true;
		} 
			return false;
	}

	void verificar() {
		if (temBeeperPresente()) {
			System.out.println("Tem Beeper aqui");
		} else {
			System.out.println("Nao tem Beeper aqui");
		}
	}

	void imprimir() {
		System.out.println("\nPosicaoX é: " + p.x + " / " + "PosicaoY é: " + p.y);
		System.out.println("A orientacao é: " + o.orientacao);
		System.out.println("A velocidade é: " + velocidade);
	};
}


