package heranca.figuras;

public class Quadrado extends FiguraGeometrica {
	
	public Quadrado(double lado) {
		super(lado);
	}
	
	@Override
	public double calcularArea() {
		return lado * lado;
	}

}
