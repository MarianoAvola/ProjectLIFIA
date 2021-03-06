package ar.edu.unlp.info.bd2.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ar.edu.unlp.info.bd2.modelo.estados.*;

@Entity
@Table(name = "REPARTIDORES")
public class Repartidor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "USERNAME")
	private String usuario;
	
	@Column(name = "PASSWORD")
	private String contrasena;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FECHA_NACIMIENTO")
	private LocalDate fechaNac;

	private Set<Pedido> pedidos;

	public Repartidor(String nomb, String correo, LocalDate fecNac, String user, String pass) {
		this.pedidos = new HashSet<>();
		nombre = nomb;
		email = correo;
		fechaNac = fecNac;
		contrasena = pass;
		if (user == null)
			usuario = nombre;
		else
			usuario = user;
	}

	public Repartidor() {

	}

	public void tomarPedido(Pedido pedido) {

		if (pedido.getEstado() instanceof Pendiente) {
			pedido.setRepartidor(this);
			pedidos.add(pedido);
		}
	}

	// Cambia el estado de Pedido
	public void entregarPedido(Pedido pedido) {
		EstadoPedido ep = new Entregado();
		pedido.setEstado(ep);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}