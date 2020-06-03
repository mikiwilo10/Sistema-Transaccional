package ec.edu.ups.appDis.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.edu.ups.appDis.model.LoginHistoricos;
import ec.edu.ups.appDis.model.Persona;

@Stateless
public class LoginHDao {

	@PersistenceContext
	private EntityManager em;

	public void crearAcceso(LoginHistoricos lh) {
		em.persist(lh);

	}

	public List<LoginHistoricos> getAcceso(int id) {
		String jpql = "SELECT p FROM LoginHistoricos p "
				+ " WHERE id_persona = :id";
		Query q = em.createQuery(jpql, LoginHistoricos.class);
		q.setParameter("id", id);
		return q.getResultList();
	}
	
	
//	public CategoriaEN read3(int id) {
//		String jpql = "SELECT cat " + "	 FROM CategoriaEN cat " + "		  JOIN FETCH cat.producto p "
//				+ " WHERE cat.codigo = :a";
//		Query q = em.createQuery(jpql, CategoriaEN.class);
//		q.setParameter("a", id);
//		CategoriaEN cat = (CategoriaEN) q.getSingleResult();
//
//		return cat;
//	}
	
	
//	public List<LoginHistoricos> getAcceso(String correo) {
//		String jpql = "SELECT p FROM LoginHistoricos p WHERE correo LIKE :correo";
//		// System.out.println(jpql);
//
//		Query q = em.createQuery(jpql, Persona.class);
//
//		q.setParameter("correo", correo + "%");
//		return q.getResultList();
//
//	}
//	public void insertar(String descripcion, String fecha,int id) {
//		
//		// Query query = em.createNamedQuery("CALL historicos(:descripcion,:fecha,:id)");
//		 Query query = em.createNamedQuery("{CALL appdis.historicos(:descripcion,:fecha,:id)}",LoginHistoricos.class);
//		 query.setParameter("descripcion", descripcion);
//		 query.setParameter("fecha", fecha); 
//		 query.setParameter("id", id);
//		query.executeUpdate();
//		
//	
//	}

}
