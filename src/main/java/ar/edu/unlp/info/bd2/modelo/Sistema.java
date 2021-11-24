package ar.edu.unlp.info.bd2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

	private List<Pedido> pedidos;
	private List<Cliente> clientes;
	private List<Repartidor> repartidores;

	public Sistema() {
		clientes = new ArrayList<>();
		pedidos = new ArrayList<>();
		repartidores = new ArrayList<>();
	}

	public void darAltaCli(Cliente cliente) {
		clientes.add(cliente);
	}

	public void darAltaRep(Repartidor repartidor) {
		this.repartidores.add(repartidor);
	}

	void darBajaCli(Cliente cliente) {
		for (Cliente cli : clientes) {
			if (cli.equals(cliente)) {
				clientes.remove(cliente);
			}
		}
		System.out.println("Cliente dado de baja");
	}

	void darBajaRep(Repartidor repartidor) {
		for (Repartidor rep : repartidores) {
			if (rep.equals(repartidor)) {
				repartidores.remove(repartidor);
			}
		}
		System.out.println("Repartidor dado de baja");
	}

	public void nuevoPedido(Pedido pedido) {
		pedidos.add(pedido);
		System.out.println("Se agrego nuevo pedido");
	}

	public int totalPedidosPendientes() {
		return pedidos.size();
	}

	public int totalClientes() {
		return clientes.size();
	}

	public int totalRepartidores() {
		return repartidores.size();
	}

}