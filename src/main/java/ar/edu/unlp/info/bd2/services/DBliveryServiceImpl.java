package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlp.info.bd2.modelo.Cliente;
import ar.edu.unlp.info.bd2.modelo.Direccion;
import ar.edu.unlp.info.bd2.modelo.Pedido;
import ar.edu.unlp.info.bd2.modelo.Producto;
import ar.edu.unlp.info.bd2.modelo.Proveedor;
import ar.edu.unlp.info.bd2.modelo.Repartidor;
import ar.edu.unlp.info.bd2.modelo.estados.EstadoPedido;
import ar.edu.unlp.info.bd2.repositories.*;

@Entity
public class DBliveryServiceImpl implements DBliveryService {
		
	@Autowired
	private DBliveryRepository repository;
	
	public DBliveryServiceImpl() {
		
	}
	public DBliveryServiceImpl(DBliveryRepository repository) {
		this.repository = repository;	}
	

	@Transactional
	public Producto createProduct(String name, Float price, Float weight, Proveedor supplier) {
		Producto product = new Producto();
		this.repository.save(product);		
		return product;
	}

	@Transactional
	public Producto createProduct(String name, Float price, Float weight, Proveedor supplier, Date date) {
		Producto product = new Producto();
		this.repository.save(product);		
		return product;
	}
	
	@Transactional
	public Proveedor createSupplier(String name, Long cuil, Direccion address) {
		Proveedor supplier = new Proveedor(name,cuil,address);
		this.repository.save(supplier);		
		return supplier;
	}

	@Transactional
	public Cliente createUser(String email, String password, String username, String name, Date dateOfBirth) {
		Cliente user =  new Cliente(name, email, dateOfBirth, username, password);
		this.repository.save(user);
		return user;
	}

	@Transactional
	public Repartidor createDelivery(String email, String password, String username, String name, Date dateOfBirth) {
		Repartidor deliver =  new Repartidor(name, email, dateOfBirth, username, password);
		this.repository.save(deliver);
		return deliver;
	}

	@Transactional
	public Producto updateProductPrice(Long id, Float price, Date startDate) throws DBliveryException {
		return null;
	}

	@Transactional
	public Optional<Cliente> getUserById(Long id) {
		return null;
	}

	@Transactional
	public Optional<Cliente> getUserByEmail(String email) {
		return null;
	}

	@Override
	public Optional<Cliente> getUserByUsername(String username) {
		return null;
	}

	@Override
	public Optional<Pedido> getOrderById(Long id) {
		return null;
	}

	@Override
	public Pedido createOrder(Date orderDate, String address, Float coordX, Float coordY, Cliente client) {
		return null;
	}

	//Replantear modelo de pedido y sus productos o lineas de detales/productos.
	@Override
	public Pedido createOrder2(double tWeight, double tPrice, Cliente user) {
		Pedido order =  new Pedido(); //Crea el pedido(carrito vacio)
		
		this.repository.save(order);
		return order;
	}

	@Override
	public Pedido addProduct(Long order, Long quantity, Producto product) throws DBliveryException {
		return null;
	}

	@Override
	public Pedido deliverOrder(Long order, Cliente deliveryUser) throws DBliveryException {
		return null;
	}

	public Pedido deliverOrder2(Long order, Repartidor deliveryUser) throws DBliveryException {
		return null;
	}

	public Pedido cancelOrder(Long order) throws DBliveryException {
		return null;
	}

	public Pedido cancelOrder(Long order, Date date) throws DBliveryException {
		return null;
	}

	public Pedido finishOrder(Long order) throws DBliveryException {
		return null;
	}

	public Pedido finishOrder(Long order, Date date) throws DBliveryException {
		return null;
	}

	public boolean canCancel(Long order) throws DBliveryException {
		return false;
	}

	public boolean canFinish(Long id) throws DBliveryException {
		return false;
	}

	public boolean canDeliver(Long order) throws DBliveryException {
		return false;
	}

	public EstadoPedido getActualStatus(Long order) {
		return null;
	}

	public List<Producto> getProductsByName(String name) {
		return null;
	}

}
