package ar.edu.unlp.info.bd2.modelo;

import java.time.LocalDate;
import java.util.*;
import ar.edu.unlp.info.bd2.modelo.estados.*;

public class Cliente {

	private Long id;
	private String nombre;
	private String email;
	private LocalDate fechaNac;
	private String usuario;
	private String contrasena;

	private Set<Pedido> pedidos;

	public Cliente(String nomb, String correo, LocalDate fecNac, String user, String pass) {
		nombre = nomb;
		email = correo;
		fechaNac = fecNac;
		usuario = user;
		contrasena = pass;
		pedidos = new HashSet<>();
		if (user == null) {
			usuario = nombre;
		}
	}

	public Cliente() {

	}

	public void crearPedido(Pedido pedido) {
		pedido.setCliente(this);
		this.pedidos.add(pedido);
	}

	public void cancelarPedido(Pedido ped) {
		ped.setEstado(new Cancelado());
	}

	public void removePedido(Pedido ped) {
		for (Pedido pedido : pedidos) {
			if (pedido.equals(ped)) {
				pedidos.remove(pedido);
			}
		}
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

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}