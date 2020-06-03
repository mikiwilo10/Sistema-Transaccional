package ec.edu.ups.appDis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appDis.business.RolON;
import ec.edu.ups.appDis.business.UsuarioAdminON;
import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.Rol;
import ec.edu.ups.appDis.model.UsuarioAdministrativo;

@ManagedBean
@ViewScoped
public class RegistroUsuarioBean {

	@Inject
	private RolON ron;

	@Inject
	private UsuarioAdminON onadmi;

	private UsuarioAdministrativo uadmi;

	private Rol rol;

	private List<Rol> rols;

	private int id;

	private List<UsuarioAdministrativo> listaUAdmi;

	public List<UsuarioAdministrativo> getListaUAdmi() {
		return listaUAdmi;
	}

	public void setListaUAdmi(List<UsuarioAdministrativo> listaUAdmi) {
		this.listaUAdmi = listaUAdmi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UsuarioAdministrativo getUadmi() {
		return uadmi;
	}

	public void setUadmi(UsuarioAdministrativo uadmi) {
		this.uadmi = uadmi;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getRols() {
		return rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@PostConstruct
	public void init() {
		rols = ron.listaRol();

		uadmi = new UsuarioAdministrativo();

//		//on.buscarPersona(p.getCorreo(), p.getClave());
		recuperarUAdmi();
	}

	public String guardarDatos() {
		try {
			rol = new Rol();

			uadmi.setRol(ron.buscar(id));
			onadmi.crearUsuarioAdmi(uadmi);
			saveMessage();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "listar";
	}

	public void recuperarUAdmi() {
		try {
			listaUAdmi = onadmi.listarUAdmi();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al Listar" + e.getMessage());
		}

	}

	public void eliminar() {

	}

	public void saveMessage() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Usuario Creado Exitoso "));
	}

}
