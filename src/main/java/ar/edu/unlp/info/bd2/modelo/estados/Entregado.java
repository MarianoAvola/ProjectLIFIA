package ar.edu.unlp.info.bd2.modelo.estados;

/*
 * Si pedido.estado = 'PREPARADO' entonces pedido.estado = 'ENTREGADO'
 * solo modificable por Repartidor
 */

public class Entregado extends EstadoPedido {
	
	public Entregado() {
		//this.setEstado("ENTREGADO");
		super();
	}
}