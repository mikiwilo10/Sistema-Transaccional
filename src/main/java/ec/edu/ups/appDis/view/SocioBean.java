/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appDis.view;

import ec.edu.ups.appDis.business.GestionBancariaON;
import ec.edu.ups.appDis.model.CuentaEN;
import ec.edu.ups.appDis.model.SocioEN;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Amay
 */

@ManagedBean
@ViewScoped
public class SocioBean {
   
    @Inject
    private GestionBancariaON on;
    
    private SocioEN newSocio;
    private List<SocioEN> listaSocio;
    private String cedula;

    
   
    
    
    
    public SocioEN getNewSocio() {
        return newSocio;
    }

    public void setNewSocio(SocioEN newSocio) {
        this.newSocio = newSocio;
    }

    public List<SocioEN> getListaSocio() {
        return listaSocio;
    }

    public void setListaSocio(List<SocioEN> listaSocio) {
        this.listaSocio = listaSocio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        System.out.println("Cedula Parametro:" +cedula);
        this.cedula = cedula;
        if(cedula!=null){
            try {
                newSocio = on.buscarSocio(cedula);
            } catch (Exception ex) {
                System.out.println("Error setCedula[BEAN]"+ex);
            }
            
            
        }
    }

   


    @Override
    public String toString() {
        return "SocioBean{" + "newSocio=" + newSocio + '}';
    }
    
    
    
    
    @PostConstruct
    public void init() {
       
        try {
            newSocio=new SocioEN();
          
            cargarSocios();
        } catch (Exception ex) {
            System.out.println("Error al Cargar Socios:"+ex.getMessage());
        }
 
    }
    
    
    public String guardarDatosScocio(){
    
        try {
            on.guardarSocio(newSocio);
            System.out.println("Socio Guardado...");
            
            
        } catch (Exception ex) {
            System.out.println("Error al ingresarSocio[SocioBean]"+ex);
        }
        return "listaSocios";
    }
    
    public String BuscarDatosScocio(String cedula){
    
        
        ArrayList<SocioEN>lista=new ArrayList<>();
        try {
            SocioEN buscar=on.buscarSocio(cedula);
            
            System.out.println("Cedula:"+buscar.getCedulaSocio());
            System.out.println("Nombre:"+buscar.getNombresSocio());
            System.out.println("Apellido:"+buscar.getApelidosSocio());
            System.out.println("Edad:"+buscar.getEdadSocio());
            System.out.println("Provincia:"+buscar.getProvinciaSocio());
            System.out.println("Ciudad:"+buscar.getCiudadSocio());
            System.out.println("Direccion:"+buscar.getDireccionSocio());
            System.out.println("Telefono Fijo:"+buscar.getTelefonoFijoSocio());
            System.out.println("Celular:"+buscar.getCedulaSocio());
           //Modificacion Xavier
            System.out.println("Correo:"+buscar.getCorreo());
            System.out.println("Clave:"+buscar.getClave());
            System.out.println("Estado Civil:"+buscar.getEstadoCiviilSocio());
            
            
        } catch (Exception ex) {
            System.out.println("Error al ingresarSocio[SocioBean]"+ex);
        }
        return null;
    }
    
     public String  eliminarScocio(String cedula) throws Exception{
    
        try {
            on.eliminarSocio(cedula);
            System.out.println("Socio Eliminado...");
            
            
        } catch (Exception ex) {
            throw new Exception("Error al ieliminar Socio[SocioBean]"+ex);
            
        }
        return null;
    }
    
    private void cargarSocios() throws Exception {
    
        //linea 135 importante
        listaSocio=on.listarSocios();
        
        try {
            List<SocioEN> l2=on.listarSocios();
            
            for(SocioEN lista:l2){
                
                System.out.println("Cedula:"+lista.getCedulaSocio());
            System.out.println("Nombre:"+lista.getNombresSocio());
            System.out.println("Apellido:"+lista.getApelidosSocio());
            System.out.println("Edad:"+lista.getEdadSocio());
            System.out.println("Provincia:"+lista.getProvinciaSocio());
            System.out.println("Ciudad:"+lista.getCiudadSocio());
            System.out.println("Direccion:"+lista.getDireccionSocio());
            System.out.println("Telefono Fijo:"+lista.getTelefonoFijoSocio());
            System.out.println("Celular:"+lista.getCedulaSocio());
          //Modificacion Xavier
            System.out.println("Correo:"+lista.getCorreo());
            System.out.println("Clave:"+lista.getClave());
            System.out.println("Estado Civil:"+lista.getEstadoCiviilSocio());
            
            }

        } catch (Exception ex) {
            System.out.println("Error al cargar socios"+ex.getMessage());
          
        }
    
    
    }
    
    public String editarSocio(String cedula){
    
        
        return "Socio?faces-redirect=true&cedulaSocio="+cedula;
    }
  
   
    
     public String redirigeCrearCuenta(String cedula){
         
         System.out.println("Redirigir:"+cedula);
        return "Cuenta?faces-redirect=true&cedulaSocio="+cedula;
    }
    
     public String redirigeCrearSocio(){
         
         System.out.println("Redirigir:"+cedula);
        return "Socio?faces-redirect=true";
    }
    
    
      public String  redirigeVerSocio(){
         
      
        return "listaSocios?faces-redirect=true";
    }
     
      
        public String verCuentas(){
         
      
        return "listarCuentas?faces-redirect=true";
    }
   
    
}
