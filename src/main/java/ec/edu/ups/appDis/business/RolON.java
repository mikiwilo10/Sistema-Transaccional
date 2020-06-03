package ec.edu.ups.appDis.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appDis.dao.RolDao;
import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.Rol;

@Stateless
public class RolON {

	@Inject
	private RolDao dao;

	public void crearRol(Rol rol) {
		dao.crearRol(rol);
	}

	public List<Rol> listaRol() {
		return dao.listaRol();

	}
	public Rol buscar(int id) {
		return dao.buscar(id);
	}
	
	public void EliminarRol(Rol rol) {
		dao.delete(rol);
	}
}
