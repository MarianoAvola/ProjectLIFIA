package ar.edu.unlp.info.bd2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "NOMBRE_PRODUCTO")
	private String nombre;
	
	@Column(name = "PESO")
	private double peso;
	
	@Column(name = "PRECIO")
	private double precio;
	
	@Column(name = "PROVEEDOR")
	private Proveedor proveedor;
	
	private List<PrecioHistorico> preciosHistoricos;

	public Producto(String nomb, double pe, double prec) {
		nombre = nomb;
		peso = pe;
		precio = prec;
		preciosHistoricos = new ArrayList<PrecioHistorico>();
		PrecioHistorico primerPrecio = new PrecioHistorico(prec);
		preciosHistoricos.add(primerPrecio);
	}

	public Producto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (this.precio != precio) {
			PrecioHistorico nuevoPrecio = new PrecioHistorico(precio);
			preciosHistoricos.add(nuevoPrecio);
			this.precio = precio;
		}
	}

	public List<PrecioHistorico> getPreciosHistoricos() {
		return preciosHistoricos;
	}

	public void setPreciosHistoricos(List<PrecioHistorico> preciosHistoricos) {
		this.preciosHistoricos = preciosHistoricos;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}