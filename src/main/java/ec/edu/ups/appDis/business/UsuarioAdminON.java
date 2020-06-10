package ec.edu.ups.appDis.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appDis.dao.UsuarioAdmiDao;
import ec.edu.ups.appDis.model.UsuarioAdministrativo;


@Stateless
public class UsuarioAdminON {

	@Inject
	private UsuarioAdmiDao uddao;
	
	public void crearUsuarioAdmi(UsuarioAdministrativo admi) {
		uddao.crearUsuarioAdmin(admi);
	}
	
	public List<UsuarioAdministrativo> listarUAdmi() throws Exception{
		return uddao.listaUAdmi("%");
	}

	public void eliminarUAdmi(int id) throws Exception {
        uddao.deleteUAdmi(id);;
    }
	
	
	public UsuarioAdministrativo buscarUsuarioAdmi(String usuario,String clave)throws Exception {
		return uddao.login(usuario, clave);
		
	}
	
	public UsuarioAdministrativo UsuarioAdmi(int id)throws Exception {
		return uddao.buscarUAdmin(id);
		
	}	
	
	
	public UsuarioAdministrativo BuscarUsuario(String usuario) throws Exception{
		return uddao.buscarUsuarioAdmi(usuario);
	}
}
