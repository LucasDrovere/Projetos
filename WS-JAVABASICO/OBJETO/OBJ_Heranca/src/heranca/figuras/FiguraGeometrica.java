package heranca.figuras;


public abstract class FiguraGeometrica {

	protected double lado;
	
	public FiguraGeometrica(double lado) {
		this.lado = lado;
	}

	public abstract double calcularArea();
	
}

