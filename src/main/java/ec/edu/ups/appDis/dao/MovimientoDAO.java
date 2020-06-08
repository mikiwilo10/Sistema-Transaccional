/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appDis.dao;

import ec.edu.ups.appDis.model.MovimientoEN;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel Amay
 */

@Stateless
public class MovimientoDAO {
    
    
    @PersistenceContext
    private EntityManager em;
    
    public void insertMovimiento(MovimientoEN movimiento)throws Exception{
        em.persist(movimiento);
    }
    
    public MovimientoEN readMovimiento(int idMovimiento)throws Exception{
        return em.find(MovimientoEN.class, idMovimiento);
    }
    
    public void updateMovimiento(MovimientoEN movimiento)throws Exception{
     em.merge(movimiento);
    }
    
    public void deleteMovimiento(int idMovimiento)throws Exception{
     MovimientoEN m=readMovimiento(idMovimiento);
     em.remove(m);
    }
    
     public List<MovimientoEN> getMovimientos(String filtro)throws Exception {
        String jpql = "SELECT p FROM CuentaEN p WHERE fechaMovimiento LIKE :filtro";

        Query q = em.createQuery(jpql, MovimientoEN.class);
        q.setParameter("filtro", filtro + "%");
        return q.getResultList();
    }
    
    
     public List<MovimientoEN> listarMovimiento(String idCuenta){
         String jpql = "Select p FROM MovimientoEN p WHERE p.cuenta like '" + idCuenta+"'";
         Query q = em.createQuery(jpql, MovimientoEN.class);

          return q.getResultList();
     }
    
    
    
    
    
    
}
