package exercicioCarro;

public class Cambio {
	int marchaAtual;
	
	
	void mudarDeMarcha(int velocidadeAtual){
		if (velocidadeAtual >=0 && velocidadeAtual <= 20) {
			marchaAtual = 1;
		}else if(velocidadeAtual >= 21 && velocidadeAtual <= 40) {
			marchaAtual = 2;
		}else if(velocidadeAtual >= 41 && velocidadeAtual <= 60) {
			marchaAtual = 3;
	}else if(velocidadeAtual >= 61 && velocidadeAtual <= 80) {
		marchaAtual = 4;
	} else if(velocidadeAtual > 80) {
		marchaAtual = 5;}

 }
}
