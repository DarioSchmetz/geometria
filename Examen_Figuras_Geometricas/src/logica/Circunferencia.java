package logica;

public class Circunferencia extends Figura{
	
	protected double radio ;
	
	public double CalcularArea() {
		return Math.PI * 2 * radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
}