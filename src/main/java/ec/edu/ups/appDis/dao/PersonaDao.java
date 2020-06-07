package ec.edu.ups.appDis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Stateless
public class PersonaDao {

	@PersistenceContext
	private EntityManager em;
/*
	public void crearPErsona(Persona p) {
		em.persist(p);
	}

	// buscar por la clave primaria
	public Persona buscar() {
		return em.find(Persona.class, "id");
	}

//	public boolean login(String correo, String clave) {
//		String jpql = "SELECT p FROM Persona p " + "WHERE p.correo LIKE :correo AND p.clave LIKE :clave";
//
//		TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
//		query.setParameter("correo", correo);
//		query.setParameter("clave", clave);
//		try {
//			Persona c = query.getSingleResult();
//			System.out.println("Encontrado");
////        Query q =em.createQuery(jpql);
////		q.setParameter("correo", correo);
////		q.setParameter("clave", clave); 
////      
////        	try {
////        		Persona p = (Persona) q.getSingleResult();
//			return true;
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			return false;
//		}
//
////        	
//
//	}
	
	public Persona login(String correo, String clave) {
		Persona p =null;
		String jpql = "SELECT p FROM Persona p " + "WHERE p.correo LIKE :correo AND p.clave LIKE :clave";

		TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
		query.setParameter("correo", correo);
		query.setParameter("clave", clave);
		//try {
			//Persona c = query.getSingleResult();
			System.out.println("Encontrado");
			//em.close();
			//return c;
//        Query q =em.createQuery(jpql);
//		q.setParameter("correo", correo);
//		q.setParameter("clave", clave); 
//      
        	try {
        		p = query.getSingleResult();
			//return p;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
return p;
//        	

	}

	public List<Persona> getPersonas(String cedula) {
		String jpql = "SELECT p FROM Persona p WHERE cedula LIKE :cedula";
		// System.out.println(jpql);

		Query q = em.createQuery(jpql, Persona.class);

		q.setParameter("cedula", cedula + "%");
		return q.getResultList();

	}

	public Persona buscarCorreo(String correo) {
		String jpql = "SELECT p FROM Persona p " + "WHERE p.correo LIKE :correo";
		TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
		query.setParameter("correo", correo);

		Persona c = query.getSingleResult();
		return c;
	}
	
	
*/	
//	public int buscarCodigoPersona(String correo) {
//		String jpql="SELECT p FROM Persona p "
//				+ "WHERE p.correo LIKE :correo";
//		 TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
//		    query.setParameter("correo", correo);
//		  
//		    Persona c= query.getSingleResult();
//		return c.getIdpersona();
//	}

}
