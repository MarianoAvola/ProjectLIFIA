package ar.edu.unlp.info.bd2.modelo.estados;

import ar.edu.unlp.info.bd2.modelo.Pedido;

public class Entregado extends EstadoPedido {
	
	public Entregado() {
	
	}
	
	public Entregado(Pedido ped) {
		super(ped, "Entregado");
	}
}