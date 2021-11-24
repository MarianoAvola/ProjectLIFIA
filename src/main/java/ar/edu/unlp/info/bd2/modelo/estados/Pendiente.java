package ar.edu.unlp.info.bd2.modelo.estados;

import ar.edu.unlp.info.bd2.modelo.Pedido;

/*
 * Estado por defecto al crear el pedido. 
 */

public class Pendiente extends EstadoPedido {

	private Pedido pedido;
	
	public Pendiente (){
		//this.pedido.setEstado(null);
		super();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	
	
//	public void setPedido(Pedido ped) {
//		this.pedido = ped;
//		
//		Timer timer = new Timer();
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				Pendiente.this.pedido.setEstado(new Preparado());
//			}
//		}, 5000);
//	}
	
}