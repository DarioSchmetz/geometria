package logica;

public class Triangulo extends Figura {

	protected double altura;
	protected double ancho;

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double CalcularArea() {
		return ancho * altura / 2;
	}

}
