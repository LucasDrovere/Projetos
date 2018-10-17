
public class JogoVelha {
	private String[][] jv = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };

	public String exibir() {
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				System.out.printf("  " + jv[l][c]);
			}
			System.out.println("\n");
		}
		return null;
	}

	public boolean check(String pos) {
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				if (jv[l][c].equals(pos))
					return true;
			}
		}
		return false;
	}

	// jogo.jogada("1", "X");
	public void jogada(String pos, String simbJogador) {
		if (pos.equals("1")) {
			jv[0][0] = simbJogador;
		} else if (pos.equals("2")) {
			jv[0][1] = simbJogador;
		} else if (pos.equals("3")) {
			jv[0][2] = simbJogador;
		} else if (pos.equals("4")) {
			jv[1][0] = simbJogador;
		} else if (pos.equals("5")) {
			jv[1][1] = simbJogador;
		} else if (pos.equals("6")) {
			jv[1][2] = simbJogador;
		} else if (pos.equals("7")) {
			jv[2][0] = simbJogador;
		} else if (pos.equals("8")) {
			jv[2][1] = simbJogador;
		} else if (pos.equals("9")) {
			jv[2][2] = simbJogador;
		}
	}

	// vetor com 8 posicoes para guardar as combinaçoes de possiveis vitorias
	public String winner(int jogadas) {
		String[] v = new String[8];
		String winner = "null";
		if (jogadas == 9) {
			winner = "Deu Velha ";
		}
		v[0] = jv[0][0] + jv[0][1] + jv[0][2];
		v[1] = jv[1][0] + jv[1][1] + jv[1][2];
		v[2] = jv[2][0] + jv[2][1] + jv[2][2];
		v[3] = jv[0][0] + jv[1][0] + jv[2][0];
		v[4] = jv[0][1] + jv[1][1] + jv[2][1];
		v[5] = jv[0][2] + jv[1][2] + jv[2][2];
		v[6] = jv[0][0] + jv[1][1] + jv[2][2];
		v[7] = jv[0][2] + jv[1][1] + jv[2][0];

		for (int i = 0; i < v.length; i++) {
			if (v[i].equals("XXX")) {
				winner = "Jogador X ";
			} else if (v[i].equals("OOO")) {
				winner = "Jogador O ";
			}
		}
		return winner;
	}
}
