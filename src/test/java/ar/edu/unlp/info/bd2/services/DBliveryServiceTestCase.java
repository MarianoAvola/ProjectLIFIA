package ar.edu.unlp.info.bd2.services;
import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unlp.info.bd2.config.SpringDataConfiguration;
import ar.edu.unlp.info.bd2.modelo.Cliente;
import ar.edu.unlp.info.bd2.modelo.Direccion;
import ar.edu.unlp.info.bd2.modelo.Pedido;
import ar.edu.unlp.info.bd2.modelo.Producto;
import ar.edu.unlp.info.bd2.modelo.Proveedor;
import ar.edu.unlp.info.bd2.repositories.DBliveryException;

import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {SpringDataConfiguration.class},
        loader = AnnotationConfigContextLoader.class)
public class DBliveryServiceTestCase {

    @Autowired
    @Qualifier("springDataJpaService")
    DBliveryService service;

    protected DBliveryService getService() {
        return service;
    }

    @BeforeEach
    public void setUp() {
        this.service = this.getService();
    }

    @Test
    public void testCreateUser() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1982);
        cal.set(Calendar.MONTH, Calendar.MAY);
        cal.set(Calendar.DAY_OF_MONTH, 17);
        Date dob = cal.getTime();
        Cliente u1 = this.service.createUser("hugo.gamarra@testmail.com", "123456", "hgamarra", "Hugo Gamarra", dob);
        assertNotNull(u1.getId());
    }

	/*
	 * @Test public void testGetUser() { Calendar cal = Calendar.getInstance();
	 * cal.set(Calendar.YEAR, 1982); cal.set(Calendar.MONTH, Calendar.MAY);
	 * cal.set(Calendar.DAY_OF_MONTH, 17); Date dob = cal.getTime(); Cliente u1 =
	 * this.service.createUser("hugo.gamarra@testmail.com", "123456", "hgamarra",
	 * "Hugo Gamarra", dob); assertNotNull(u1.getId()); assertEquals("hgamarra",
	 * u1.getNombre()); Optional<Cliente> u2 =
	 * this.service.getUserByUsername("hgamarra"); if (u2.isPresent()) { Cliente u3
	 * = u2.get(); assertEquals("hgamarra", u3.getNombre());
	 * assertEquals("hugo.gamarra@testmail.com", u3.getEmail()); } Optional<Cliente>
	 * u4 = this.service.getUserByEmail("hugo.gamarra@testmail.com"); if
	 * (u4.isPresent()) { Cliente u5 = u4.get(); assertEquals("hgamarra",
	 * u5.getNombre()); assertEquals("hugo.gamarra@testmail.com", u5.getEmail()); }
	 * Optional<Cliente> u6= this.service.getUserById(u1.getId()); if
	 * (u6.isPresent()) { Cliente u7 = u6.get(); assertEquals("hgamarra",
	 * u7.getNombre()); assertEquals("hugo.gamarra@testmail.com", u7.getEmail());
	 * assertEquals(u7.getId(), u1.getId()); } }
	 * 
	 * @Test public void testCreateProduct() { Proveedor s1 =
	 * this.service.createSupplier("Burger King", 30710256443l, new
	 * Direccion(Float.valueOf(-53.45F), Float.valueOf(-60.22F), "Av. Corrientes",
	 * 956)); assertNotNull(s1.getCuit());
	 * assertEquals("Burger King",s1.getNombre()); Producto p1 =
	 * this.service.createProduct("Combo Stacker ATR", Float.valueOf(2521.2F),
	 * Float.valueOf(2.5F),s1); assertNotNull(p1.getId());
	 * assertEquals("Combo Stacker ATR",p1.getNombre());
	 * assertEquals(1,p1.getPrecio()); }
	 * 
	 * @Test public void testUpdateProductPrice() throws DBliveryException{ Calendar
	 * cal = Calendar.getInstance(); Date startDate = cal.getTime(); Proveedor s1 =
	 * this.service.createSupplier("Burger King", 30710256443l, new
	 * Direccion(Float.valueOf(-53.45F), Float.valueOf(-60.22F), "Av. Corrientes",
	 * 956)); Producto p1 = this.service.createProduct("Combo Stacker ATR",
	 * Float.valueOf(2521.2F), Float.valueOf(2.5F),s1); assertNotNull(p1.getId());
	 * assertEquals(1,p1.getPrecio());
	 * 
	 * Producto p2 =
	 * this.service.updateProductPrice(p1.getId(),Float.valueOf(3000.0F),startDate);
	 * assertEquals(3000,p2.getPrecio()); assertEquals(2,p2.getPrecio()); }
	 * 
	 * @Test public void testCreateOrder() throws DBliveryException { Calendar cal =
	 * Calendar.getInstance(); Proveedor s1 =
	 * this.service.createSupplier("Burger King", 30710256443l, new
	 * Direccion(Float.valueOf(-53.45F), Float.valueOf(-60.22F), "Av. Corrientes",
	 * 956)); Producto p1 = this.service.createProduct("Combo Stacker ATR",
	 * Float.valueOf(2521.2F), Float.valueOf(2.5F),s1); Calendar cal2 =
	 * Calendar.getInstance(); cal2.set(Calendar.YEAR, 1982);
	 * cal2.set(Calendar.MONTH, Calendar.MAY); cal2.set(Calendar.DAY_OF_MONTH, 17);
	 * Date dob = cal.getTime(); Cliente u1 =
	 * this.service.createUser("hugo.gamarra@testmail.com", "123456", "hgamarra",
	 * "Hugo Gamarra", dob); Pedido o1 =
	 * this.service.createOrder2(Float.valueOf(-54.45F), Float.valueOf(-62.22F),u1);
	 * Pedido o2 = this.service.addProduct(o1.getId(), 1L, p1);
	 * assertNotNull(o1.getId()); assertNotNull(o2.getId());
	 * assertEquals(1,o2.getEstado()); assertEquals(u1,o2.getCliente());
	 * assertEquals(1,o2.getDetalles()); }
	 * 
	 * @Test public void testDeliverOrder() throws DBliveryException { Calendar cal
	 * = Calendar.getInstance(); Date orderDate = cal.getTime(); Proveedor s1 =
	 * this.service.createSupplier("Burger King", 30710256443l, new
	 * Direccion(Float.valueOf(-53.45F), Float.valueOf(-60.22F), "Av. Corrientes",
	 * 956)); Producto p1 = this.service.createProduct("Combo Stacker ATR",
	 * Float.valueOf(2521.2F), Float.valueOf(2.5F),s1); Calendar cal2 =
	 * Calendar.getInstance(); cal2.set(Calendar.YEAR, 1982);
	 * cal2.set(Calendar.MONTH, Calendar.MAY); cal2.set(Calendar.DAY_OF_MONTH, 17);
	 * Date dob = cal.getTime(); Cliente u1 =
	 * this.service.createUser("hugo.gamarra@testmail.com", "123456", "hgamarra",
	 * "Hugo Gamarra", dob); cal2.set(Calendar.YEAR, 1988); cal2.set(Calendar.MONTH,
	 * Calendar.JUNE); cal2.set(Calendar.DAY_OF_MONTH, 23); Date dob2 =
	 * cal.getTime(); Cliente u2 =
	 * this.service.createUser("delivery@info.unlp.edu.ar", "123456", "delivery",
	 * "Delivery", dob2); Pedido o1 =
	 * this.service.createOrder(orderDate,"Av. Corrientes 1405 2° B",
	 * Float.valueOf(-54.45F), Float.valueOf(-62.22F),u1);
	 * assertFalse(this.service.canDeliver(o1.getId()));
	 * assertThrows(DBliveryException.class, () ->
	 * this.service.deliverOrder(o1.getId(),u2),"The order can't be delivered");
	 * Pedido o2 = this.service.addProduct(o1.getId(), 1L, p1);
	 * assertTrue(this.service.canDeliver(o2.getId())); Pedido o3 =
	 * this.service.deliverOrder(o2.getId(),u2); assertNotNull(o3.getId());
	 * assertEquals(2,o3.getEstado()); assertEquals(u2,o3.getRepartidor()); }
	 * 
	 * @Test public void testCancelOrder() throws Exception { Calendar cal =
	 * Calendar.getInstance(); Date orderDate = cal.getTime(); Calendar cal2 =
	 * Calendar.getInstance(); cal2.set(Calendar.YEAR, 1982);
	 * cal2.set(Calendar.MONTH, Calendar.MAY); cal2.set(Calendar.DAY_OF_MONTH, 17);
	 * Date dob = cal.getTime(); Cliente u1 =
	 * this.service.createUser("hugo.gamarra@testmail.com", "123456", "hgamarra",
	 * "Hugo Gamarra", dob); Proveedor s1 =
	 * this.service.createSupplier("Burger King", 30710256443l, new
	 * Direccion(Float.valueOf(-53.45F), Float.valueOf(-60.22F), "Av. Corrientes",
	 * 956)); Pedido o1 =
	 * this.service.createOrder(orderDate,"Av. Corrientes 1405 2° B",
	 * Float.valueOf(-54.45F), Float.valueOf(-62.22F),u1);
	 * assertTrue(this.service.canCancel(o1.getId())); cal2.set(Calendar.YEAR,
	 * 1988); cal2.set(Calendar.MONTH, Calendar.JUNE);
	 * cal2.set(Calendar.DAY_OF_MONTH, 23); Date dob2 = cal.getTime(); Cliente u2 =
	 * this.service.createUser("delivery@info.unlp.edu.ar", "123456", "delivery",
	 * "Delivery", dob2); Producto p1 =
	 * this.service.createProduct("Combo Stacker ATR", Float.valueOf(2521.2F),
	 * Float.valueOf(2.5F),s1); Pedido o2 = this.service.addProduct(o1.getId(), 1L,
	 * p1); Pedido o3 = this.service.deliverOrder(o2.getId(), u2);
	 * assertFalse(this.service.canCancel(o3.getId()));
	 * assertThrows(DBliveryException.class, () ->
	 * this.service.cancelOrder(o3.getId()),"The order can't be cancelled"); Pedido
	 * o4 = this.service.createOrder(orderDate,"Av. Corrientes 1405 2° B",
	 * Float.valueOf(-54.45F), Float.valueOf(-62.22F),u1); Pedido o5 =
	 * this.service.cancelOrder(o4.getId()); //Revisar y verificar
	 * assertEquals(this.service.getActualStatus(o5.getId()).getPedido().getEstado2(
	 * ),"Cancelado"); assertEquals(2,o5.getEstado()); }
	 * 
	 * @Test public void testFinishOrder() throws DBliveryException { Calendar cal =
	 * Calendar.getInstance(); Date orderDate = cal.getTime(); Proveedor s1 =
	 * this.service.createSupplier("Burger King", 30710256443l, new
	 * Direccion(Float.valueOf(-53.45F), Float.valueOf(-60.22F), "Av. Corrientes",
	 * 956)); Producto p1 = this.service.createProduct("Combo Stacker ATR",
	 * Float.valueOf(2521.2F), Float.valueOf(2.5F),s1); Calendar cal2 =
	 * Calendar.getInstance(); cal2.set(Calendar.YEAR, 1982);
	 * cal2.set(Calendar.MONTH, Calendar.MAY); cal2.set(Calendar.DAY_OF_MONTH, 17);
	 * Date dob = cal.getTime(); Cliente u1 =
	 * this.service.createUser("hugo.gamarra@testmail.com", "123456", "hgamarra",
	 * "Hugo Gamarra", dob); cal2.set(Calendar.YEAR, 1988); cal2.set(Calendar.MONTH,
	 * Calendar.JUNE); cal2.set(Calendar.DAY_OF_MONTH, 23); Date dob2 =
	 * cal.getTime(); Cliente u2 =
	 * this.service.createUser("delivery@info.unlp.edu.ar", "123456", "delivery",
	 * "Delivery", dob2); Pedido o1 =
	 * this.service.createOrder(orderDate,"Av. Corrientes 1405 2° B",
	 * Float.valueOf(-54.45F), Float.valueOf(-62.22F),u1); Pedido o2 =
	 * this.service.addProduct(o1.getId(), 1L, p1);
	 * assertThrows(DBliveryException.class, () ->
	 * this.service.finishOrder(o2.getId()),"The order can't be finished"); Pedido
	 * o3 = this.service.deliverOrder(o2.getId(),u2);
	 * assertTrue(this.service.canFinish(o3.getId())); Pedido o4 =
	 * this.service.finishOrder(o3.getId()); assertNotNull(o4.getId());
	 * assertEquals(3,o3.getEstado()); //Revisar y verificar
	 * assertEquals(this.service.getActualStatus(o4.getId()).getPedido().getEstado2(
	 * ),"Entregado"); }
	 * 
	 * @Test public void testGetProduct() { Proveedor s1 =
	 * this.service.createSupplier("Burger King", 30710256443l, new
	 * Direccion(Float.valueOf(-53.45F), Float.valueOf(-60.22F), "Av. Corrientes",
	 * 956)); assertNotNull(s1.getCuit());
	 * assertEquals("Burger King",s1.getNombre()); Producto p1 =
	 * this.service.createProduct("Combo Stacker ATR", Float.valueOf(2521.2F),
	 * Float.valueOf(2.5F),s1); Producto p2 =
	 * this.service.createProduct("Combo Tostado de Campo", Float.valueOf(2210.2F),
	 * Float.valueOf(2.2F), s1); Producto p3 =
	 * this.service.createProduct("Combo Stacker ATR triple", Float.valueOf(1210F),
	 * Float.valueOf(1.8F), s1);
	 * assertEquals(this.service.getProductsByName("Combo Stacker ATR").size(),2);
	 * assertEquals(this.service.getProductsByName("Combo Tostado de Campo").size(),
	 * 1); assertEquals(this.service.getProductsByName("triple").size(),1);
	 * 
	 * }
	 */
}
