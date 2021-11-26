package ar.edu.unlp.info.bd2.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROVEEDORES")
public class Proveedor {

	@Column(name = "CUIT")
	private Long cuit;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@OneToOne(orphanRemoval=true)
	@JoinColumn(name="DIR_FK")
	private Direccion direccion;
	
	private List<Producto> productos;

	public Proveedor(String nomb, Long nroCuit, Direccion dir) {
		nombre = nomb;
		cuit = nroCuit;
		direccion = dir;
		productos = new ArrayList<Producto>();
	}

	public Proveedor() {

	}

	public void addProducto(Producto prod) {
		prod.setProveedor(this);
		productos.add(prod);
	}

	public void removeProducto(Producto prod) {
		for (Producto producto : productos) {
			if (producto.equals(prod)) {
				productos.remove(producto);
			}
		}
	}

	public Pedido prepararPedido(Pedido pedido) {

		return null;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}