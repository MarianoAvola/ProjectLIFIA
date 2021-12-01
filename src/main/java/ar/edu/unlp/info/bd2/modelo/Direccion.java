package ar.edu.unlp.info.bd2.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECCIONES")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "COORDENADA_X")
	private float coordX;
	
	@Column(name = "COORDENADA_Y")
	private float coordY;
	
	@Column(name = "CALLE")
	private String calle;
	
	@Column(name = "ALTURA")
	private int altura;

	public Direccion(float x, float y, String nombCalle, int nroCasa) {
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

	public void setCoordX(float coordX) {
		this.coordX = coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(float coordY) {
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