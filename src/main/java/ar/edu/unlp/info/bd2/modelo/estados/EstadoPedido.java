package ar.edu.unlp.info.bd2.modelo.estados;

import ar.edu.unlp.info.bd2.modelo.Pedido;

public abstract class EstadoPedido {

	private Long id;

	private Pedido pedido;

	public EstadoPedido() {

	}

	public EstadoPedido(EstadoPedido estado) {
		this.setPedido(estado);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(EstadoPedido estado) {
		pedido.setEstado(estado);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	};

}