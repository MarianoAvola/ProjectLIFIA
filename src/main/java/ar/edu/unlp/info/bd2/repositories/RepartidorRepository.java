package repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import model.Repartidor;

@Transactional
public interface RepartidorRepository extends CrudRepository<Repartidor, Long>{

	
}
