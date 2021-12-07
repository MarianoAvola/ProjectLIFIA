package ar.edu.unlp.info.bd2.modelo.estados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ar.edu.unlp.info.bd2.modelo.Pedido;

@Entity
@Table(name="EstadoPedidos")
public class EstadoPedido {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="estadoPed")
	private Pedido pedido;
	
	@Column(name="estadoAct")
	private String estadoA;
	
	public EstadoPedido() {
		
	}
	
	public EstadoPedido(Pedido ped, String estActual) {
		this.setEstadoA(estActual);
		this.setPedido(ped);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getEstadoA() {
		return estadoA;
	}

	public void setEstadoA(String estadoA) {
		this.estadoA = estadoA;
	}
	
	
	
}