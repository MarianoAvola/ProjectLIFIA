package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.List;

import ar.edu.unlp.info.bd2.modelo.*;
//import ar.edu.unlp.info.bd2.repositories.DBliveryException;

public interface DBliveryStatisticsService {


    /**
     * obtiene el producto más pesado
     * @return el producto más pesado
     */
    Producto  getMaxWeigth();

    /**
     * Obtiene todas las ordenes realizadas por el usuario con username <code>username</code>
     * @param username
     * @return Una lista de ordenes que satisfagan la condición
     */
    List<Pedido> getAllOrdersMadeByUser(String username);

    /**
     * Obtiene el listado de las ordenes pendientes
     */
    List<Pedido> getPendingOrders();

    /**
     * Obtiene el listado de las ordenes enviadas y no entregadas
     */
    List<Pedido> getSentOrders();

    /**
     * Obtiene todas las ordenes entregadas entre dos fechas
     * @param startDate
     * @param endDate
     * @return una lista con las ordenes que satisfagan la condición
     */
    List<Pedido> getDeliveredOrdersInPeriod(Date startDate, Date endDate);

    /**
     * Obtiene todas las órdenes entregadas para el cliente con username <code>username</code>
     * @param username
     * @return una lista de ordenes que satisfagan la condición
     */
    List<Pedido> getDeliveredOrdersForUser(String username);

    /**
     * Obtiene los productos que no cambiaron su precio
     * @return una lista de productos que satisfagan la condición
     */
    List<Producto> getProductsOnePrice();

    /**
     * obtiene los productos vendidos en un <code>day</code>
     * @param day
     * @return una lista los productos vendidos
     */
    List<Producto> getSoldProductsOn(Date day);
}