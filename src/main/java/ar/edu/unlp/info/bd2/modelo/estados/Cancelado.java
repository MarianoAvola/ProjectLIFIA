package ar.edu.unlp.info.bd2.modelo.estados;

import ar.edu.unlp.info.bd2.modelo.Pedido;

/*
 * Si pedido.estado = 'PENDIENTE' entonces pedido.estado = 'CANCELADO'
 * solo modificable por Cliente
 */

public class Cancelado extends EstadoPedido {

	private Pedido pedido;

	public Pedido getPedido() {
		return pedido;
	}

	public Cancelado() {
		// this.setEstado("CANCELADO");
		super();
	}

	public void setPedido(Pedido ped) {
		this.pedido = ped;

	}
}