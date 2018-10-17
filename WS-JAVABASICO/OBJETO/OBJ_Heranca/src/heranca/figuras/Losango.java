package heranca.figuras;

public class Losango extends FiguraGeometrica {
	//diagonal maior � o lado
	//e diagonal menor � o pr�prio atributo
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
