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
import ec.edu.ups.appDis.model.LoginHistoricos;
//import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.SocioEN;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 4537479482646908992L;

	//	@Inject
//private PersonaON on;
	@Inject
	private GestionBancariaON on;

	@Inject
	private LoginHON onlogin;

	// private EmailClient emial;

//private Persona p;
	private SocioEN p;
	private LoginHistoricos login;

	private List<LoginHistoricos> listalogin;

	private static String idper;
//private Persona pp = null;
	private SocioEN pp = null;
//
//	public Persona getP() {
//		return p;
//	}
//
//	public void setP(Persona p) {
//		this.p = p;
//	}

	public List<LoginHistoricos> getListalogin() {
		return listalogin;
	}

	public SocioEN getP() {
		return p;
	}

	public void setP(SocioEN p) {
		this.p = p;
	}

	public void setListalogin(List<LoginHistoricos> listalogin) {
		this.listalogin = listalogin;
	}

	@PostConstruct
	public void init() {
		p = new SocioEN();
		login = new LoginHistoricos();
		//try {
			listaLogins();
	//	} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}

	}

	public String Login() throws Exception{
		FacesMessage message;
		SimpleDateFormat date = new SimpleDateFormat();
		String fecha = date.format(new Date());
		try {

			pp = on.buscarPersona(p.getCorreo(), p.getClave());
			if (pp != null) {
				// FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inicio
				// de Sesion Exitoso"));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", pp);
				String Asunto = " Inicio de Sesion Exitoso";
				String CuerpoMail = "Hola " + pp.getNombresSocio() + " Su inicio de sesion fu exitoso" + " " + fecha;

				login.setDescripcion(Asunto);
				login.setFecha(fecha);
				login.setSocio(on.BuscarCorreo(p.getCorreo()));
				onlogin.crearHlogin(login);
				idper = on.BuscarCorreo(p.getCorreo()).getCedulaSocio();

				EmailClient.sendMail(p.getCorreo(), Asunto, CuerpoMail);
				return "listarCuentas?faces-redirect=true";

			} else {
				String Asuntofail = " Inicio de Sesion Fallido";
				String CuerpoMailfail = "Querido Usuario su intento de Sesion a sido Fallido en la fecha:" + fecha
						+ " Observamos que tienes problemas para iniciar sesion en tu cuenta";
				
				

			if (on.BuscarCorreo(p.getCorreo()) != null) {

					login.setDescripcion(Asuntofail);
					login.setFecha(fecha);
					login.setSocio(on.BuscarCorreo(p.getCorreo()));
					onlogin.crearHlogin(login);
					EmailClient.sendMail(p.getCorreo(), Asuntofail, CuerpoMailfail);

			 } 

			}

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario o Clave Incorrectas"));
		} catch (Exception e) {
			
			
			
			}
		return null;

	}

	public void listaLogins() {
		try {
			System.out.println("Lista del Usuario: " + idper);

			listalogin = onlogin.getHistoricos(idper);

		} catch (Exception e) {
			System.out.println("Error al Listar" + e.getMessage());
		}

	}

//	public void saveMessage() {
//		FacesContext context = FacesContext.getCurrentInstance();
//
//		context.addMessage(null, new FacesMessage("Inicio de Sesion\",\"Usuario Correcto"));
//	}

	public void cerrarSession() throws Exception {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

	}

	public void verificarSession() throws Exception {
		SocioEN p1 = (SocioEN) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		try {
			if (p1 == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("permisos.xhtml");
			} else {
				// listaLogins();
				System.out.println("miki mouse emelc" + pp.getNombresSocio());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
}
