package ec.edu.ups.appDis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.appDis.business.LoginHON;
import ec.edu.ups.appDis.business.PersonaON;
import ec.edu.ups.appDis.business.RolON;
import ec.edu.ups.appDis.business.UsuarioAdminON;
import ec.edu.ups.appDis.dao.RolDao;
import ec.edu.ups.appDis.model.LoginHistoricos;
import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.Rol;

@ManagedBean
@ViewScoped
public class LoginBean {

	@Inject
	private PersonaON on;

	@Inject
	private LoginHON onlogin;

	// private EmailClient emial;

	private Persona p;

	private LoginHistoricos login;

	private List<LoginHistoricos> listalogin;

	private static int idper;

	
	

	public Persona getP() {
		return p;
	}

	public void setP(Persona p) {
		this.p = p;
	}

	public List<LoginHistoricos> getListalogin() {
		return listalogin;
	}

	public void setListalogin(List<LoginHistoricos> listalogin) {
		this.listalogin = listalogin;
	}

	@PostConstruct
	public void init() {
		p = new Persona();
		login = new LoginHistoricos();
		listaLogins();
	}

	public String Login() throws Exception {

		// try {
		// EmailClient emial;
		if (on.buscarPersona(p.getCorreo(), p.getClave()) == true) {
			String Asunto = " Inicio de Sesion Exitoso";
			String CuerpoMail = "Hola mundo ";

			EmailClient.sendMail(p.getCorreo(), Asunto, CuerpoMail);

			login.setDescripcion(Asunto);
			login.setFecha("10/10/2020");
			login.setPersona(on.BuscarCorreo(p.getCorreo()));
			onlogin.crearHlogin(login);

			idper=on.BuscarCorreo(p.getCorreo()).getIdpersona();

			System.out.println("emelec campeonrrr" + idper);

			return "ListarAccesosSesion.xhtml";

		} else {

			String Asuntofail = " Inicio de Sesion Fallido";
			String CuerpoMailfail = "Se intento iniciar sesion  ";
			EmailClient.sendMail(p.getCorreo(), Asuntofail, CuerpoMailfail);

			login.setDescripcion(Asuntofail);
			login.setFecha("10/10/2020");
			login.setPersona(on.BuscarCorreo(p.getCorreo()));
			onlogin.crearHlogin(login);
			// } catch (Exception e) {
			return "index";
		}

	}

	public void listaLogins() {
		try {
			System.out.println("emelec campeon" + idper);
			//int id = on.BuscarCodigoPersona(on.BuscarCorreo(p.getCorreo()));
			listalogin = onlogin.getHistoricos(idper);
		} catch (Exception e) {
			System.out.println("Error al Listar" + e.getMessage());
		}

	}

}
