package ar.edu.unlp.info.bd2.modelo;

import java.time.LocalDate;

public class PrecioHistorico {

	private Long id;
	private double precio;
	private LocalDate inicioPH;
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