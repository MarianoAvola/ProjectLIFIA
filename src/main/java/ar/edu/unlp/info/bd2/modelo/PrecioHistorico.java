package ar.edu.unlp.info.bd2.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PRECIO_HISTORICO")
public class PrecioHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "PRECIO_ACTUAL")
	private double precio;
	
	@Column(name = "PRECIO_INICIO")
	private LocalDate inicioPH;
	
	@Column(name = "PRECIO_FIN")
	private LocalDate finPH;

	public PrecioHistorico(double precio) {
		this.precio = precio;
		inicioPH = LocalDate.now();
	}

	public PrecioHistorico() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getInicioPH() {
		return inicioPH;
	}

	public void setInicioPH(LocalDate inicioPH) {
		this.inicioPH = inicioPH;
	}

	public LocalDate getFinPH() {
		return finPH;
	}

	public void setFinPH(LocalDate finPH) {
		this.finPH = finPH;
	}
}