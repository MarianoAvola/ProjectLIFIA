package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.modelo.Producto;

@Repository
public class DBliveryRepository {
	
	@Autowired
	private SessionFactory sessionF;
	
	public void save(Object obj) {
		Session session = null;
		try {
			session = this.sessionF.getCurrentSession();
			session.save(obj);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void update(Object obj) {
		Session session = null;
		try {
			session = this.sessionF.getCurrentSession();
			session.update(obj);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private Session aSession() {
		return sessionF.getCurrentSession();
	}
	
	public Optional<Producto> getProductById(Long id) {
		Producto p = (Producto) this.aSession().createQuery("select p " + "from Producto p " + "where p.id=:id")
				.setParameter("id", id).getSingleResult();
		Optional<Producto> ret = Optional.ofNullable(p);
		return ret;
	}
	
	

}
