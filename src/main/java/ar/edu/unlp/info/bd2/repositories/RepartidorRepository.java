package ar.edu.unlp.info.bd2.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.info.bd2.modelo.Repartidor;


@Transactional
public interface RepartidorRepository extends CrudRepository<Repartidor, Long>{

	
}
