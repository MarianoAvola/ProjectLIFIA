package ar.edu.unlp.info.bd2.modelo;

import java.time.LocalDateTime;


public class DetallePedido {

	private Producto producto;
	private LocalDateTime horaPreparacion;
	private int cantProd;

	public DetallePedido(Producto prod, LocalDateTime horaPrep, int cantProd) {
		this.horaPreparacion = horaPrep;
		this.cantProd = cantProd;
		this.producto = prod;
	}

	public DetallePedido() {

	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public LocalDateTime getHoraPreparacion() {
		return horaPreparacion;
	}

	public void setHoraPreparacion(LocalDateTime horaPreparacion) {
		this.horaPreparacion = horaPreparacion;
	}

	public int getCantProd() {
		return cantProd;
	}

	public void setCantProd(int canProd) {
		this.cantProd = canProd;
	}

	@Override
	public String toString() {
		return "DetallePedido [horaPreparacion=" + horaPreparacion + ", cantProd=" + cantProd + "]";
	}
}