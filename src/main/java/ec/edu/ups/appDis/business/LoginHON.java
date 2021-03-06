package ec.edu.ups.appDis.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appDis.dao.LoginHDao;
import ec.edu.ups.appDis.model.LoginHistoricos;

@Stateless
public class LoginHON {

	@Inject
	private LoginHDao dao;
	
	/*
  	 * metodo que permite crear historico de sesion llamando al metodo crearAcceso de su clase dao
  	 */
	public void crearHlogin(LoginHistoricos lh) {
		dao.crearAcceso(lh);
	}
	
	/*
  	 * metodo que permite listar los historico de sesion llamando al metodo getAcceso de su clase dao
  	 */
	public List<LoginHistoricos> getHistoricos(String cedula){
		return dao.getAcceso(cedula);
	}
}
