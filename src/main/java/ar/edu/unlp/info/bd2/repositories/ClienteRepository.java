package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.info.bd2.modelo.Cliente;
import ar.edu.unlp.info.bd2.modelo.Pedido;

@Transactional
public interface ClienteRepository extends CrudRepository<Cliente, Long>{


	//EJEMPLO
	@Query(value="select * from cliente where correo=:correo and clave=:clave limit 1", nativeQuery=true)
	public Optional<Cliente> buscarPorCorreoClave(@Param("correo") String correo, @Param("clave") String clave);
	
	//EJEMPLO
	public Optional<Cliente> findByCorreo(String correo);
	
	/*
	 *  Obtiene todas las órdenes realizadas por el usuario con username 'username'
	 */
	@Query("select * from clientes cli, pedidos ped where cli.id = ped.id_cliente")
	public List<Pedido> getAllOrdersMadeByUser (String username);

	
	
}
