/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.appDis.view;
import ec.edu.ups.appDis.business.GestionBancariaON;
import ec.edu.ups.appDis.model.CuentaEN;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
/**
 *
 * @author Daniel Amay
 */



@ManagedBean
@ViewScoped
public class CuentaBean {
    
    @Inject
    private GestionBancariaON on;
    
   private CuentaEN newCuenta;
   private List<CuentaEN> listaCuenta;
   
  
   

   private Date  fecha=new Date();

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
   

    public CuentaEN getNewCuenta() {
        return newCuenta;
    }

    public void setNewCuenta(CuentaEN newCuenta) {
        this.newCuenta = newCuenta;
    }

    public List<CuentaEN> getListaCuenta() {
        return listaCuenta;
    }

    public void setListaCuenta(List<CuentaEN> listaCuenta) {
        this.listaCuenta = listaCuenta;
    }



   private String idCuenta;
   
      public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        System.out.println("ID Cuenta: "+idCuenta);
        this.idCuenta = idCuenta;
        if(idCuenta!=null){
            try {
                newCuenta=on.buscarCuenta(idCuenta);
               
            } catch (Exception ex) {
               System.out.println("Error setIDCuenta[BEAN]"+ex);
            }
        }
        
        
    }
    
   
    @PostConstruct
    public void init(){
        try {
            newCuenta=new CuentaEN();
            cargarCuentas();
        } catch (Exception ex) {
            System.out.println("Error init [CuentaBean]");
        }
    
    }
   
    
     /*    Cuenta             */
    
    
  
    
   
    
    public String guardarDatosCuenta(){
    
        try {
 
            on.guardarCuenta(newCuenta);
            
            System.out.println("Cuenta Guardada");

        } catch (Exception ex) {
            System.out.println("Guardar Cuenta..."+ex.getMessage());
        }
         return "listarCuentas";
    }
    

    
    
    
    public void cargarCuentas() throws Exception {
        listaCuenta = on.listarCuentas();
    }

    public String eliminarCuenta(String idCuenta){
    
        try {
            on.eliminarCuenta(idCuenta);
        } catch (Exception ex) {
            System.out.println("Error al Eliminar Cuenta [Bean]"+ex);
        }
        return null;
    }
    

    
    public String conpruebaCuentaExistente(String idCuenta){
    
        try {
            
            CuentaEN busqueda=on.buscarCuenta(idCuenta);
            
            System.out.println("Encontrado"+busqueda.getIdCuenta());
            System.out.println("Encontrado Pertenece"+busqueda.getSocio().getNombresSocio());
           
        } catch (Exception ex) {
            System.out.println("Error al Buscar:"+ex.getMessage());
                    
        }
         return null;
    }
    
    
    
        public String redirigeCrearMovimiento(String idCuenta){
         
         System.out.println("Redirigir:"+idCuenta);
        return "Movimiento?faces-redirect=true&idCuenta="+idCuenta;
    }
    
       public String redirigeCrearRetiro(String idCuenta){
         
         System.out.println("Redirigir:"+idCuenta);
        return "Retiro?faces-redirect=true&idCuenta="+idCuenta;
    }
    
        
        

       /**
        * Numero de Cuenta
        */
       
       public static long numbGen() {
       while (true) {
           long numb = (long)(Math.random() * 100000000 * 1000000); // had to use this as int's are to small for a 13 digit number.
           if (String.valueOf(numb).length() == 12)
               return numb;
       }
   }
       
     String aleatorio=String.valueOf(numbGen());
       
       public String numero(){
       return aleatorio;
       }

       public String getAleatorio() {
           return aleatorio;
       }

       public void setAleatorio(String aleatorio) {
           this.aleatorio = aleatorio;
       }
       
    
}
