package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import model.Proveedor;

@Transactional
public interface ProveedorRepository extends CrudRepository<Proveedor, Long>{

	

}
