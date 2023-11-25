package logica;

public class Rectangulo extends Figura{
	
	protected double largo;
	protected double ancho ;
	
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	
	public double CalcularArea(){
		return largo*ancho;
	}
	
}
