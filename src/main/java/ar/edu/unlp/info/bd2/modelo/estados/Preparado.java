package ar.edu.unlp.info.bd2.modelo.estados;

import java.util.Timer;
import java.util.TimerTask;

import ar.edu.unlp.info.bd2.modelo.Pedido;

/*
 * Si pedido.estado = 'PENDIENTE' entonces pedido.estado = 'PREPARADO'
 * solo modificable por Sistema
 */

public class Preparado extends EstadoPedido {

	private Pedido pedido;

	public Preparado() {
		// this.setEstado("PREPARADO");
		super();
	}

	public void setPedido(Pedido ped) {
		this.pedido = ped;

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Preparado.this.pedido.setEstado(new Entregado());
			}
		}, 10000);

	}
}