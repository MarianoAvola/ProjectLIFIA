package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.modelo.*;
import ar.edu.unlp.info.bd2.modelo.estados.EstadoPedido;
import ar.edu.unlp.info.bd2.repositories.DBliveryException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DBliveryService {

	/**
	 * Crea y devuelve un nuevo Producto.
	 * 
	 * @param name     nombre del producto a ser creado
	 * @param price    precio actual del producto
	 * @param weight   peso actual del producto
	 * @param supplier el productor del producto
	 * @return el producto creado
	 */
	Producto createProduct(String name, Float price, Float weight, Proveedor supplier);

	Producto createProduct(String name, Float price, Float weight, Proveedor supplier, Date date);

	/**
	 * Crea y retorna un nuevo Productor
	 * 
	 * @param name    nombre del productor
	 * @param cuil    cuil del productor
	 * @param address dirección del productor
	 * @param coordX  coordenada X de la dirección del productor
	 * @param coordY  coordeada Y de la dirección del produtor
	 * @return el productor creado
	 */
	Proveedor createSupplier(String name, String cuil, String address, Float coordX, Float coordY);

	/**
	 * Crea y retorna un Cliente
	 * 
	 * @param email       email del usuario
	 * @param password    clave del usuario
	 * @param username    nombre de usuario del usuario
	 * @param name        nombre y apellido del usuario
	 * @param dateOfBirth fecha de nacimiento del usuario
	 * @return el usuario creado
	 */
	Cliente createUser(String email, String password, String username, String name, Date dateOfBirth);

	/**
	 * Crea y retorna un Repartidor
	 * 
	 * @param email       email del repartidor
	 * @param password    clave del repartidor
	 * @param username    nombre de usuario del repartidor
	 * @param name        nombre y apellido del repartidor
	 * @param dateOfBirth fecha de nacimiento del repartidor
	 * @return el repartidor creado
	 */
	Repartidor createDelivery(String email, String password, String username, String name, Date dateOfBirth);

	/**
	 * Actualiza el precio del producto manteniendo el historial de cambios de
	 * precio del mismo.
	 * 
	 * @param id        id del producto
	 * @param price     nuevo precio del producto
	 * @param startDate fecha de inicio del nuevo precio
	 * @return el producto modificado
	 * @throws DBliveryException en caso de que no exista el producto para el id
	 *                           dado
	 */
	Producto updateProductPrice(Long id, Float price, Date startDate) throws DBliveryException;

	/**
	 * Obtiene el usuario por id
	 * 
	 * @param id
	 * @return el usuario con el id provisto
	 */
	Optional<Cliente> getUserById(Long id);

	/**
	 * Obtiene el usuario por el email
	 * 
	 * @param email
	 * @return el usuario con el email provisto
	 */
	Optional<Cliente> getUserByEmail(String email);

	/**
	 * Obtiene el usuario por el username
	 * 
	 * @param username
	 * @return el usuario con el username provisto
	 */
	Optional<Cliente> getUserByUsername(String username);

	/**
	 * Obtiene el pedido por id
	 * 
	 * @param id
	 * @return el pedido con el id provisto
	 */
	Optional<Pedido> getOrderById(Long id);

	/**
	 * Crea y retorna un nuevo pedido
	 * 
	 * @param orderDate timestamp de la fecha en que fue realizado el pedido
	 * @param address     dirección en la cual se debe entregar el pedido
	 * @param coordX      coordenada X de la dirección
	 * @param coordY      coordenada Y de la dirección
	 * @param client      cliente que realizó el pedido
	 * @return el nuevo pedido
	 */
	Pedido createOrder(Date orderDate, String address, Float coordX, Float coordY, Cliente client);

	/**
	 * Crea y retorna un nuevo pedido
	 * 
	 * @param tWeight peso total del pedido
	 * @param tPrice  precio total del pedido
	 * @param user    Cliente que realiza el pedido
	 * @return el nuevo pedido
	 */
	Pedido createOrder2(double tWeight, double tPrice, Cliente user);

	/**
	 * agrega un producto al pedido
	 * 
	 * @param order    pedido al cual se le agrega el producto
	 * @param quantity cantidad de producto a agregar
	 * @param product  producto a agregar
	 * @return el pedido con el nuevo producto
	 * @throws DBliveryException en caso de no existir el pedido
	 */
	Pedido addProduct(Long order, Long quantity, Producto product) throws DBliveryException;

	/**
	 * Registra el envío del pedido, registrando al repartidor y cambiando su estado
	 * a Send.
	 * 
	 * @param order        pedido a ser enviado
	 * @param deliveryUser Usuario que entrega el pedido
	 * @return el pedido modificado
	 * @throws DBliveryException en caso de no existir el pedido, que el pedido no
	 *                           se encuentre en estado Pending o sí no contiene
	 *                           productos.
	 */
	Pedido deliverOrder(Long order, Cliente deliveryUser) throws DBliveryException;

	/**
	 * Se asigna el repartidor al pedido.
	 * 
	 * @param order        ID del pedido
	 * @param deliveryUser repartidor asignado
	 * @return el pedido con el repartidor ya asignado
	 * @throws DBliveryException
	 */
	Pedido deliverOrder2(Long order, Repartidor deliveryUser) throws DBliveryException;

	/**
	 * Cancela un pedido
	 * 
	 * @param order id del pedido a cancelar
	 * @return el pedido modificado
	 * @throws DBliveryException en caso de no existir el pedido o si el pedido no
	 *                           esta en estado pending
	 */
	Pedido cancelOrder(Long order) throws DBliveryException;

	Pedido cancelOrder(Long order, Date date) throws DBliveryException;

	/**
	 * Registra la entrega de un pedido.
	 * 
	 * @param order pedido a finalizar
	 * @return el pedido modificado
	 * @throws DBliveryException en caso que no exista el pedido o si el mismo no
	 *                           esta en estado Send
	 */
	Pedido finishOrder(Long order) throws DBliveryException;

	Pedido finishOrder(Long order, Date date) throws DBliveryException;

	/**
	 * verifica si un pedido se puede cancelar, para lo cual debe estar en estado
	 * pending
	 * 
	 * @param order pedido a ser cancelado
	 * @return true en caso que pueda ser cancelado false en caso contrario.
	 * @throws DBliveryException si no existe el pedido.
	 */
	boolean canCancel(Long order) throws DBliveryException;

	/**
	 * verifica si se puede finalizar un pedido
	 * 
	 * @param id del pedido a finalizar
	 * @return true en caso que pueda ser finalizado, false en caso contrario
	 * @throws DBliveryException en caso de no existir el pedido
	 */
	boolean canFinish(Long id) throws DBliveryException;

	/**
	 * verifica si un pedido puede ser enviado para lo cual debe tener productos y
	 * estar en estado pending
	 * 
	 * @param order pedido a ser enviado
	 * @return true en caso que pueda ser enviado, false en caso contrario
	 * @throws DBliveryException si el pedido no esta en estado pending.
	 */
	boolean canDeliver(Long order) throws DBliveryException;

	/**
	 * Obtiene el estado actual de un pedido.
	 * 
	 * @param order pedido del cual se debe retornar el estado actual
	 * @return el estado del pedido actual
	 */
	EstadoPedido getActualStatus(Long order);

	/**
	 * Obtiene el listado de productos que su nombre contega el string dado
	 * 
	 * @param name string a buscar
	 * @return Lista de productos
	 */
	List<Producto> getProductsByName(String name);

	


}
