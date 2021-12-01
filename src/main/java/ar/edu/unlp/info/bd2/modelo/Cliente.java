package ar.edu.unlp.info.bd2.modelo;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.edu.unlp.info.bd2.modelo.estados.*;

@Entity
@Table(name = "CLIENTES")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAME")
	private String nombre;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNac;
	
	@Column(name = "USERNAME")
	private String usuario;
	
	@Column(name = "PASSWORD")
	private String contrasena;
	
	@OneToOne(orphanRemoval=true)
	@JoinColumn(name="DIR_FK")
	private Direccion direccion;
	
	private List<Pedido> pedidos;

	public Cliente(String nomb, String correo, Date fecNac, String user, String pass) {
		nombre = nomb;
		email = correo;
		fechaNac = fecNac;
		usuario = user;
		contrasena = pass;
		pedidos = new ArrayList<Pedido>();
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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
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

}