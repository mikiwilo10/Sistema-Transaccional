/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appDis.business;

import ec.edu.ups.appDis.dao.CuentaDAO;
import ec.edu.ups.appDis.dao.MovimientoDAO;
import ec.edu.ups.appDis.dao.SocioDao;
import ec.edu.ups.appDis.model.CuentaEN;
import ec.edu.ups.appDis.model.MovimientoEN;
import ec.edu.ups.appDis.model.SocioEN;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Amay 7/6/2020 -Template
 */

@Stateless
public class GestionBancariaON {
    
    @Inject
    private SocioDao socioDao;
    
    
    @Inject
    private CuentaDAO cuentaDAO;
    
    
    @Inject
    private MovimientoDAO movimientoDAO;
    
    /*  Socio */
    
    public void guardarSocio(SocioEN socio) throws Exception {

        SocioEN aux = socioDao.readSocio(socio.getCedulaSocio());

        if (aux != null) {
            socioDao.updateSocio(socio);
        } else {

            if (validarCedula(socio.getCedulaSocio()) == true) {
                socioDao.insertSocio(socio);
            }

        }

    }

    public SocioEN buscarSocio(String cedulaSocio) throws Exception {
        return socioDao.readSocio(cedulaSocio);

    }

    public void actualizarSocio(SocioEN socio) throws Exception {
        socioDao.updateSocio(socio);
    }

    public void eliminarSocio(String cedula) throws Exception {
        socioDao.deleteSocio(cedula);
    }

    public List<SocioEN> listarSocios() throws Exception {
        return socioDao.getSocios("%");
    }

    public boolean validarCedula(String cedula) throws Exception {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {

                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;

                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {

            cedulaCorrecta = false;
            throw new Exception("Una excepcion ocurrio en el proceso de validadcion" + err);
        }

        if (!cedulaCorrecta) {
            throw new Exception("Cedula Incorrecta- !! Verifique la cedula para ingresar los contactos");

        }

        return cedulaCorrecta;

    }
    
    /* Cuenta */
    
    public void guardarCuenta(CuentaEN cuenta)throws Exception {
        
        CuentaEN aux=cuentaDAO.readCuenta(cuenta.getIdCuenta());
        
        if(aux!=null){
            cuentaDAO.updateCuenta(cuenta);
        }else{
 
                   cuentaDAO.insertCuenta(cuenta);
        }
        }
    
    public CuentaEN buscarCuenta(String id)throws Exception{
    return cuentaDAO.readCuenta(id);
    }
    
    public void actualizarCuenta(CuentaEN cuenta)throws Exception{
     cuentaDAO.updateCuenta(cuenta);
    }
    
    public void eliminarCuenta(String idCuenta)throws Exception{
     cuentaDAO.deleteCuenta(idCuenta);
    }
    
    public List<CuentaEN>listarCuentas()throws Exception{
    return cuentaDAO.getCuenta("%");
    }
    
    
    /*Movimiento*/
    
  
    
    public void guardarMovimiento(MovimientoEN movimiento)throws Exception{
        movimientoDAO.insertMovimiento(movimiento);
    }
    
      public MovimientoEN buscarMovimiento(int id)throws Exception{
    return movimientoDAO.readMovimiento(id);
    }
    
    public void actualizarMovimiento(MovimientoEN movimientoEN)throws Exception{
     movimientoDAO.updateMovimiento(movimientoEN);
    }
    
    
   /*Depositar Saldo*/
    public void depositar(String idCuenta,double cantidad){
    
        try {
            cuentaDAO.actualizarSaldoCuenta(idCuenta, cantidad);
        } catch (Exception ex) {
            System.out.println("Error SALDO[ON]"+ex.getLocalizedMessage());
                   
        }
        
    }
    
    
    /*Retirar Saldo*/
    public void retirar(String idCuenta,double cantidad){

        try {
            
            CuentaEN aux=cuentaDAO.readCuenta(idCuenta);
            
            if(cantidad>aux.getSaldo()){
                System.out.println("Solo Puede Retirar:"+aux.getSaldo());
            }else{
            
            cuentaDAO.actualizarRetiroCuenta(idCuenta, cantidad);
            }
        } catch (Exception ex) {
            System.out.println("Error SALDO[ON]"+ex.getLocalizedMessage());
                   
        }
        
    }
    /*
     * miki
     */
	public SocioEN buscarPersona(String correo,String clave)throws Exception {
		return socioDao.login(correo, clave);
		
	}
	
	
	public SocioEN BuscarCorreo(String correo) throws Exception{
		return socioDao.buscarCorreo(correo);
	}
   
	
	 public List<MovimientoEN> listarMovimiento(String idCuenta){
	        return movimientoDAO.listarMovimiento(idCuenta);
	    }
	 
	 public List<MovimientoEN> listarMovimientoFecha(String idCuenta, Date desde, Date hasta, String tipo){
	        return movimientoDAO.listarMovimientoFecha(idCuenta,desde,hasta,tipo);
	    }
    
}
