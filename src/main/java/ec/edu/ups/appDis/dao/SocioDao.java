/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appDis.dao;

import ec.edu.ups.appDis.model.SocioEN;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Daniel Amay
 */

@Stateless
public class SocioDao {

	@PersistenceContext
	private EntityManager em;

	public void insertSocio(SocioEN socio) throws Exception {
		em.persist(socio);
	}

	public SocioEN readSocio(String cedulaSocio) throws Exception {
		return em.find(SocioEN.class, cedulaSocio);
	}

	public void updateSocio(SocioEN socio) throws Exception {
		em.merge(socio);
	}

	public void deleteSocio(String cedula) throws Exception {
		SocioEN s = readSocio(cedula);
		em.remove(s);
	}

	public List<SocioEN> getSocios(String filtro) throws Exception {
		String jpql = "SELECT p FROM SocioEN p WHERE cedulaSocio LIKE :filtro";

		Query q = em.createQuery(jpql, SocioEN.class);
		q.setParameter("filtro", filtro + "%");
		return q.getResultList();
	}

	/*
	 * 
	 */
	public SocioEN buscarCorreo(String correo) {
		String jpql = "SELECT p FROM SocioEN p " + "WHERE p.correo LIKE :correo";
		TypedQuery<SocioEN> query = em.createQuery(jpql, SocioEN.class);
		query.setParameter("correo", correo);

		SocioEN c = query.getSingleResult();
		return c;
	}

	public SocioEN login(String correo, String clave) {
		SocioEN p = null;
		String jpql = "SELECT p FROM SocioEN p " + "WHERE p.correo LIKE :correo AND p.clave LIKE :clave";

		TypedQuery<SocioEN> query = em.createQuery(jpql, SocioEN.class);
		query.setParameter("correo", correo);
		query.setParameter("clave", clave);
		System.out.println("Encontrado");
   
		try {
			p = query.getSingleResult();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return p;
     	

	}
}
