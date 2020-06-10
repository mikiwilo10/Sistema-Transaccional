package ec.edu.ups.appDis.view;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appDis.business.GestionBancariaON;
import ec.edu.ups.appDis.business.LoginHON;
import ec.edu.ups.appDis.business.UsuarioAdminON;
import ec.edu.ups.appDis.model.LoginHistoricos;
//import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.SocioEN;
import ec.edu.ups.appDis.model.UsuarioAdministrativo;

@ManagedBean
@SessionScoped
public class LoginAdmiBean implements Serializable {



	@Inject
	private UsuarioAdminON onadmi;

	private UsuarioAdministrativo p;

	private static String idper;

	private UsuarioAdministrativo usuario = null;

	

	public UsuarioAdministrativo getP() {
		return p;
	}

	public void setP(UsuarioAdministrativo p) {
		this.p = p;
	}

	@PostConstruct
	public void init() {
		p = new UsuarioAdministrativo();

	}

	public String Login() throws Exception {
		
		try {

			usuario =onadmi.buscarUsuarioAdmi(p.getUsuario(), p.getContrasena());
					
			if (usuario != null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inicio de Sesion Exitoso"));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("admi", usuario);

//				idper = onadmi.BuscarUsuario(p.getUsuario());

				return "Socio?faces-redirect=true";

			} else {

			}

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario o Clave Incorrectas"));
		} catch (Exception e) {

		}
		return null;

	}

	public void cerrarSession() throws Exception {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

	}

	public void verificarSessionAdmi() throws Exception {
		UsuarioAdministrativo p1 = (UsuarioAdministrativo) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("admi");
		try {
			if (p1 == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("permisos2.xhtml");
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
