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
import ec.edu.ups.appDis.model.SocioEN;

@Stateless
public class LoginHDao {

	@PersistenceContext
	private EntityManager em;

	 /*
  	 * metodo que permite crear los historicos de inicio de sesion en la base de datos
  	 */
	public void crearAcceso(LoginHistoricos lh) {
		em.persist(lh);

	}

	/*
  	 * metodo que permite listar los historicos de inicio de sesion en la base de datos por medio de su id
  	 */
	public List<LoginHistoricos> getAcceso(String id) {
		String jpql = "SELECT p FROM LoginHistoricos p "
				+ " WHERE id_socio LIKE :id";
		Query q = em.createQuery(jpql, LoginHistoricos.class);
		q.setParameter("id",id + "%");
		return q.getResultList();
	}
	
//	public List<SocioEN> getSocios(String filtro) throws Exception {
//		String jpql = "SELECT p FROM SocioEN p WHERE cedulaSocio LIKE :filtro";
//
//		Query q = em.createQuery(jpql, SocioEN.class);
//		q.setParameter("filtro", filtro + "%");
//		return q.getResultList();
//	}
	
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
