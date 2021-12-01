package ar.edu.unlp.info.bd2.modelo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ar.edu.unlp.info.bd2.modelo.estados.*;

@Entity
@Table(name = "PEDIDOS")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ESTADO")
	private EstadoPedido estado;
	
	@Enumerated(EnumType.STRING)
	private EstadoPedido2 estado2;

	@Column(name = "PESO")
	private double pesoTotal;

	@Column(name = "PRECIO")
	private double precioTotal;

	@Column(name = "CLIENTE")
	private Cliente cliente;

	@Column(name = "REPARTIDOR")
	private Repartidor repartidor;

	@OneToMany(mappedBy = "PEDIDOS", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<DetallePedido> detalles;

	
	public Pedido(List<DetallePedido> detas) {
		detalles = new ArrayList<DetallePedido>();

		setEstado(new Pendiente());
		setEstado2(EstadoPedido2.PENDIENTE);

		detalles = detas;

		Iterator<DetallePedido> i = detalles.iterator();
		DetallePedido elem;// = new DetallePedido();
		double sumPre = 0;
		double sumPes = 0;
		while (i.hasNext()) {
			elem = i.next();
			sumPes = sumPes + elem.getProducto().getPeso();
			sumPre = sumPre + elem.getProducto().getPrecio();
		}

		pesoTotal = sumPes;
		precioTotal = sumPre;
	}

	public Pedido() {
		estado = new Pendiente();
		detalles = new ArrayList<DetallePedido>();
	}

	public void agregarProducto(DetallePedido detaProd) {
		detalles.add(detaProd);
		this.pesoTotal += detaProd.getProducto().getPeso() * detaProd.getCantProd();
		this.precioTotal += detaProd.getProducto().getPrecio() * detaProd.getCantProd();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
		// this.estado.setPedido(this);
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Repartidor getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	public EstadoPedido2 getEstado2() {
		return estado2;
	}

	public void setEstado2(EstadoPedido2 estado2) {
		this.estado2 = estado2;
	}

}