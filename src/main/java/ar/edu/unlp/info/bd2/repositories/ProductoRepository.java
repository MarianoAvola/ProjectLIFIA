package ar.edu.unlp.info.bd2.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.info.bd2.modelo.Pedido;
import ar.edu.unlp.info.bd2.modelo.Producto;


@Transactional
public interface ProductoRepository extends CrudRepository<Producto, Long>{
	
	// Obtiene todos los usuarios que han gastando más de 'amount' en alguna orden en la plataforma
	@Query(value="select * from clientes cli, pedidos ped where cli.id = ped.id_cliente", nativeQuery=true)
	public List<Pedido> getAllOrdersMadeByUser (String username);

	
	// Obtiene los 10 productos más costosos. 
	@Query(value="select top 10 nombre, peso, precio from productos order by precio desc", nativeQuery=true)
	public List<String> getTop10MoreExpensiveProducts();
	
	
	// Obtiene los productos que nos cambiaron su precio
	@Query(value="select P.NOMBRE from producto AS P\n"
			+ "INNER JOIN precio_historico AS PH \n"
			+ "ON P.ID = PH.ID\n"
			+ "where P.PRECIO = PH.PRECIO", nativeQuery=true)
	public List<String> getProductsOnePrice();
	
	
	//Obtiene el listado de productos con su precio a una fecha dada
	@Query(value="select P.NOMBRE from producto AS P\n"
			+ "INNER JOIN precio_historico AS PH \n"
			+ "ON P.ID = PH.ID\n"
			+ "where PH.FIN_PH = day", nativeQuery=true)
	public List<String> getProductsWithPriceAt(Date day);


	
}
