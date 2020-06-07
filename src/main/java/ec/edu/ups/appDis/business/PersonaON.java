package ec.edu.ups.appDis.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appDis.dao.PersonaDao;
import ec.edu.ups.appDis.model.Persona;

@Stateless
public class PersonaON {

	@Inject
	private PersonaDao pdao;
	
	public void crearPersona(Persona p) {
		pdao.crearPErsona(p);
	}
	
//	public boolean buscarPersona(String correo,String clave)throws Exception {
//		return pdao.login(correo, clave);
//	}
	
	public Persona buscarPersona(String correo,String clave)throws Exception {
		return pdao.login(correo, clave);
		
	}
	
	
	public Persona BuscarCorreo(String correo) {
		return pdao.buscarCorreo(correo);
	}
	
	public int BuscarCodigoPersona(String correo) {
		return pdao.buscarCodigoPersona(correo);
	}
	
}
