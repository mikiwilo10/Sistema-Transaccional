/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appDis.dao;

import ec.edu.ups.appDis.model.CuentaEN;
import ec.edu.ups.appDis.model.SocioEN;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
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
public class CuentaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
    public void insertCuenta(CuentaEN cuenta) throws Exception{
       
        em.persist(cuenta);
    
    }
    
    public CuentaEN readCuenta(String id) throws Exception{
     return em.find(CuentaEN.class, id);
    }
    
    public void updateCuenta(CuentaEN cuenta)throws Exception{
     em.merge(cuenta);
    }
    
    
    public void deleteCuenta(String idCuenta)throws Exception{
     CuentaEN c=readCuenta(idCuenta);
     em.remove(c);
    }
    
    public List<CuentaEN> getCuenta(String filtro) throws Exception{
        String jpql = "SELECT p FROM CuentaEN p WHERE tipoCuenta LIKE :filtro";

        Query q = em.createQuery(jpql, CuentaEN.class);
        q.setParameter("filtro", filtro + "%");
        return q.getResultList();
    }
    
    
    public void actualizarSaldoCuenta(String idCuenta,double cantidad) throws Exception{
             
        String jpql = "UPDATE CuentaEN p SET p.saldo = p.saldo+"+cantidad+
                " WHERE idcuenta='"+idCuenta+"'";

        Query query = em.createQuery(jpql);
        query.executeUpdate();
      
        
    }
    
    
     public void actualizarRetiroCuenta(String idCuenta,double cantidad) throws Exception{
             
        String jpql = "UPDATE CuentaEN p SET p.saldo = p.saldo-"+cantidad+
                " WHERE idcuenta='"+idCuenta+"'";

        
        
        
        Query query = em.createQuery(jpql);
        query.executeUpdate();
      
        
        
    }


    
}
