package exercicioRobo;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		Robo r = new Robo();
		
		r.p.x = ler.nextInt();
		
		r.inicializar(10, 10, 'L');
		r.imprimir();
		r.mover();
		r.turnLeft();
		r.mover();
		r.imprimir();
		r.verificar();
		r.mover();
		r.turnLeft();
		r.mover();
		r.imprimir();
		r.verificar();
	}
}
