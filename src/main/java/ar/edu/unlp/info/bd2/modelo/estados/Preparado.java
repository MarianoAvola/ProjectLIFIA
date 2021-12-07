package ar.edu.unlp.info.bd2.modelo.estados;

import ar.edu.unlp.info.bd2.modelo.Pedido;

public class Preparado extends EstadoPedido {

	public Preparado() {

	}

	public Preparado(Pedido ped) {
		super(ped, "Preparado");

	}
}