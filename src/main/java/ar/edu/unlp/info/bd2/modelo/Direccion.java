package ar.edu.unlp.info.bd2.modelo;

public class Direccion {

	private Long id;
	private double coordX;
	private double coordY;
	private String calle;
	private int altura;

	public Direccion(double x, double y, String nombCalle, int nroCasa) {
		coordX = x;
		coordY = y;
		calle = nombCalle;
		altura = nroCasa;
	}

	public Direccion() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCoordX() {
		return coordX;
	}

	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

}