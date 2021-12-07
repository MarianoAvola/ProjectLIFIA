package ar.edu.unlp.info.bd2.modelo.estados;

import ar.edu.unlp.info.bd2.modelo.Pedido;

public class Cancelado extends EstadoPedido {

	public Cancelado() {
	}

	public Cancelado (Pedido ped) {
		super(ped, "Cancelado");

	}
}