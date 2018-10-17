package heranca.figuras;

public class Losango extends FiguraGeometrica {
	//diagonal maior é o lado
	//e diagonal menor é o próprio atributo
	private double diagonalMenor;
	
	public Losango(double diagonalMaior, double diagonalMenor) {
		super(diagonalMaior);
		this.diagonalMenor = diagonalMenor;
	}
	
	@Override
	public double calcularArea() {
		return (lado * diagonalMenor) / 2;
	}

}
