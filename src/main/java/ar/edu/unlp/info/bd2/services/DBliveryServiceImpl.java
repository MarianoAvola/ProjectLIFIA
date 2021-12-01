package ar.edu.unlp.info.bd2.services;

import java.time.LocalDate;
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
	private ProductoRepository repositoryProd;
	@Autowired
	private PedidoRepository repositoryOrder;
	@Autowired
	private DetallePedidoRepository repositoryDP;
	@Autowired
	private ClienteRepository repositoryUser;
	@Autowired
	private RepartidorRepository repositoryRep;
	@Autowired
	private ProveedorRepository repositorySup;
	

	@Transactional
	@Override
	public Producto createProduct(String name, Float price, Float weight, Proveedor supplier) {
		Producto product = new Producto();
		this.repositoryProd.save(product);		
		return product;
	}

	@Transactional
	@Override
	public Producto createProduct(String name, Float price, Float weight, Proveedor supplier, Date date) {
		Producto product = new Producto();
		this.repositoryProd.save(product);		
		return product;
	}
	
	@Transactional
	public Proveedor createSupplier(String name, Long cuil, Direccion address) {
		Proveedor supplier = new Proveedor(name,cuil,address);
		this.repositorySup.save(supplier);		
		return supplier;
	}

	@Transactional
	@Override
	public Cliente createUser(String email, String password, String username, String name, Date dateOfBirth) {
		Cliente user =  new Cliente(name, email, dateOfBirth, username, password);
		this.repositoryUser.save(user);
		return user;
	}

	@Transactional
	@Override
	public Repartidor createDelivery(String email, String password, String username, String name, Date dateOfBirth) {
		Repartidor deliver =  new Repartidor(name, email, dateOfBirth, username, password);
		this.repositoryRep.save(deliver);
		return deliver;
	}

	@Transactional
	@Override
	public Producto updateProductPrice(Long id, Float price, Date startDate) throws DBliveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Optional<Cliente> getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Optional<Cliente> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pedido> getOrderById(Long id) {
		// TODO Auto-generated method stub
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
		
		this.repositoryOrder.save(order);
		return order;
	}

	@Override
	public Pedido addProduct(Long order, Long quantity, Producto product) throws DBliveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido deliverOrder(Long order, Cliente deliveryUser) throws DBliveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido deliverOrder2(Long order, Repartidor deliveryUser) throws DBliveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido cancelOrder(Long order) throws DBliveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido cancelOrder(Long order, Date date) throws DBliveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido finishOrder(Long order) throws DBliveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido finishOrder(Long order, Date date) throws DBliveryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canCancel(Long order) throws DBliveryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canFinish(Long id) throws DBliveryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canDeliver(Long order) throws DBliveryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EstadoPedido getActualStatus(Long order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getProductsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
