package ar.edu.unlp.info.bd2.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROVEEDORES")
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CUIT")
	private Long cuit;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DIRECCION")
	private Direccion direccion;
	
	private Set<Producto> productos;

	public Proveedor(String nomb, Long nroCuit, Direccion dir) {
		nombre = nomb;
		cuit = nroCuit;
		direccion = dir;
		productos = new HashSet<>();
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

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
}