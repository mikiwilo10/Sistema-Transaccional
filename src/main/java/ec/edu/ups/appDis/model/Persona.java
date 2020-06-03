package ec.edu.ups.appDis.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private int idpersona;

	private String nombre;
	private String correo;
	private String clave;

	@OneToMany(mappedBy = "persona",fetch = FetchType.EAGER)
	private List<LoginHistoricos> loginh;

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	
	
	public List<LoginHistoricos> getLoginh() {
		return loginh;
	}

	public void setLoginh(List<LoginHistoricos> loginh) {
		this.loginh = loginh;
	}

	public void addLogin(LoginHistoricos t) {
		if (loginh == null)
			loginh = new ArrayList<LoginHistoricos>();

		loginh.add(t);

	}

}
