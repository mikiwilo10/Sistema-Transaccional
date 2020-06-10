/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appDis.view;

import ec.edu.ups.appDis.business.GestionBancariaON;
import ec.edu.ups.appDis.model.CuentaEN;
import ec.edu.ups.appDis.model.MovimientoEN;
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
public class MovimientoBean {
    
     @Inject
    private GestionBancariaON on;
     
     private MovimientoEN newMovimiento;
     private List<MovimientoEN> listaMovimiento;
 
      private Date  fecha=new Date();

 
    public MovimientoEN getNewMovimiento() {
        return newMovimiento;
    }

    public void setNewMovimiento(MovimientoEN newMovimiento) {
        this.newMovimiento = newMovimiento;
    }

    public List<MovimientoEN> getListaMovimiento() {
        return listaMovimiento;
    }

    public void setListaMovimiento(List<MovimientoEN> listaMovimiento) {
        this.listaMovimiento = listaMovimiento;
    }

  

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
     
    
    
    
     
       @PostConstruct
    public void init() {
        newMovimiento=new MovimientoEN();
        
    }
      
      public String guardarMovimiento(){
         try {
             on.guardarMovimiento(newMovimiento);
             
             
             
             
             
         } catch (Exception ex) {
             System.out.println("error guardarMovimeinto [Bean]"+ex);
         }
         return null;
      }
      
    
      public void depositar(String idCuenta,double cantidad){
      
      on.depositar(idCuenta, cantidad);
          System.out.println("depositando...");
      }
      
      
  public void retiar(String idCuenta,double cantidad){
      
      on.retirar(idCuenta, cantidad);
          System.out.println("retirando...");
      }
    
      
         
     public String redirigeListarCuentas(){
         
        
        return "listarCuentas";
    }
      
     
     public List<MovimientoEN> listarMovimiento(String idCuenta){
         return on.listarMovimiento(idCuenta);
     }
     
     private String idCuenta;

     public String getIdCuenta(){
         return idCuenta;
     }
  
     public void setIdCuenta(String idCuenta){
         this.idCuenta = idCuenta;
     }
    
     
     
     private Date fechadesde;
     private Date fechahasta;
     private String tipo_movi;


	public Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public String getTipo_movi() {
		return tipo_movi;
	}

	public void setTipo_movi(String tipo_movi) {
		this.tipo_movi = tipo_movi;
	}
     
     
	 public List<MovimientoEN> listarMovimientoFecha (String idCuenta, Date desde, Date hasta, String tipo){
         return on.listarMovimientoFecha(idCuenta,desde,hasta,tipo);
     }
    
    
}
