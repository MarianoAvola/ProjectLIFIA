package ar.edu.unlp.info.bd2.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.info.bd2.modelo.DetallePedido;


@Transactional
public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Long>{

	// Obtiene los productos vendidos en un 'day'. REVISAR sintaxis
	@Query(value="select dp.producto.nombre"
			+ "from detalles-pedidos dp"
			+ "where dp.horaPreparacion = day", nativeQuery=true)
	public List<String> getSoldProductsOn(Date day);

	
	//Obtiene la lista de productos que no se han vendido
	/* Primero eliminar las tuplas duplicadas de los detalles pedidos
	 * */
	@Query(value="select pro.nombre "
			+ "from productos pro, pedidos ped "
			+ "where ", nativeQuery=true)
	public List<String> getProductsNoSold();




}
