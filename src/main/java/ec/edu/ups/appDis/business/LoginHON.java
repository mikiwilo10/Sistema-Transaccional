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
	
	public void crearHlogin(LoginHistoricos lh) {
		dao.crearAcceso(lh);
	}
	
	public List<LoginHistoricos> getHistoricos(int id){
		return dao.getAcceso(id);
	}
}
