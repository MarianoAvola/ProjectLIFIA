package ar.edu.unlp.info.bd2.modelo.estados;

import ar.edu.unlp.info.bd2.modelo.Pedido;

/*
 * Estado por defecto al crear el pedido. 
 */

public class Pendiente extends EstadoPedido {

	public Pendiente() {

	}

	public Pendiente(Pedido ped) {
		super(ped, "Pendiente");

	}
	
}