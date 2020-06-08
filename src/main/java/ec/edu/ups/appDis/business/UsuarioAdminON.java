package ec.edu.ups.appDis.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appDis.dao.UsuarioAdmiDao;
import ec.edu.ups.appDis.model.UsuarioAdministrativo;
import ec.edu.ups.appDis.model.Rol;

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
}
