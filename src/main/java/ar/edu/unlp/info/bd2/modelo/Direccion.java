package ar.edu.unlp.info.bd2.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "DIRECCIONES")
public class Direccion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "COORDENADA_X")
	private double coordX;
	
	@Column(name = "COORDENADA_Y")
	private double coordY;
	
	@Column(name = "CALLE")
	private String calle;
	
	@Column(name = "ALTURA")
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