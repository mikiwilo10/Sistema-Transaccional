package ec.edu.ups.appDis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.UsuarioAdministrativo;

@Stateless
public class UsuarioAdmiDao {

	@PersistenceContext
	private EntityManager em;

	public void crearUsuarioAdmin(UsuarioAdministrativo admi) {
		em.persist(admi);
	}

	public List<UsuarioAdministrativo> listaUAdmi(String nombre){
	
	    	String jpql = "SELECT p FROM UsuarioAdministrativo p WHERE nombre LIKE :nombre";
	    	//System.out.println(jpql);

	    	Query q = em.createQuery(jpql, UsuarioAdministrativo.class);
	    	 
	    	q.setParameter("nombre", nombre +"%");
	    	return q.getResultList();
	    	
	    	
	    }

}
