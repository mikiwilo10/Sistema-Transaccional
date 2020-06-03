package ec.edu.ups.appDis.view;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.appDis.business.LoginHON;
import ec.edu.ups.appDis.business.PersonaON;
import ec.edu.ups.appDis.business.RolON;
import ec.edu.ups.appDis.business.UsuarioAdminON;
import ec.edu.ups.appDis.dao.LoginHDao;
import ec.edu.ups.appDis.dao.PersonaDao;
import ec.edu.ups.appDis.dao.RolDao;
import ec.edu.ups.appDis.dao.UsuarioAdmiDao;
import ec.edu.ups.appDis.model.LoginHistoricos;
import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.Rol;
import ec.edu.ups.appDis.model.UsuarioAdministrativo;

@WebServlet("/persona")
public class RegistroPersona extends HttpServlet {

	@Inject
	private PersonaON on;

	@Inject
	private UsuarioAdminON onadmi;

	@Inject
	private RolON onrol;

	@Inject
	private LoginHON onlh;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println("<h1>Hola mundo</h1>");

		Persona p = new Persona();
		p.setNombre("wilmer");
		p.setCorreo("xavi-javi11@hotmail.com");
		p.setClave("cuenca");
		on.crearPersona(p);

		Persona p1 = new Persona();
		p1.setNombre("xavier");
		p1.setCorreo("mikiwilo10@gmail.com");
		p1.setClave("cuenca");
		on.crearPersona(p1);

		Persona p2 = new Persona();
		p2.setNombre("ligia");
		p2.setCorreo("xavimiki11@gmail.com");
		p2.setClave("cuenca");
		on.crearPersona(p2);

		/*
		 * 
		 * try {
		 * 
		 * 
		 * 
		 * 
		 * if (on.buscarPersona("xavi-javi11@hotmail.com", "cuenca") ==true)
		 * System.out.println("Usuario Encontrado");
		 * 
		 * List<LoginHistoricos>loginlista=new ArrayList<>();
		 * 
		 * LoginHistoricos lh =new LoginHistoricos(); LoginHistoricos lh2 =new
		 * LoginHistoricos();
		 * 
		 * lh.setDescripcion("Exitoso"); lh.setFecha("02/06/2020");
		 * lh.setPersona(on.BuscarCorreo("xavi-javi11@hotmail.com"));
		 * 
		 * lh2.setDescripcion("Fallido"); lh2.setFecha("08/06/2020");
		 * lh2.setPersona(on.BuscarCorreo("xavi-javi11@hotmail.com"));
		 * 
		 * onlh.crearHlogin(lh); onlh.crearHlogin(lh2);
		 * 
		 * 
		 * p.addLogin(lh); p.addLogin(lh2);
		 * 
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * System.out.println("usuario no existente"); }
		 * 
		 * 
		 * 
		 */

		UsuarioAdministrativo admi = new UsuarioAdministrativo();

		admi.setNombre("joselino");
		admi.setApellido("perez");
		admi.setUsuario("jperez");
		admi.setContrasena("cuenca");

		UsuarioAdministrativo admi2 = new UsuarioAdministrativo();

		admi2.setNombre("olivia");
		admi2.setApellido("popeye");
		admi2.setUsuario("joliva");
		admi2.setContrasena("cuenca");

		Rol rol1 = new Rol();
		rol1.setNombre("Gerente");

		Rol rol2 = new Rol();
		rol2.setNombre("Cajero");

		Rol rol3 = new Rol();
		rol3.setNombre("Jefe de Credito");

		Rol rol4 = new Rol();
		rol4.setIdrol(2);

		onrol.crearRol(rol1);
		onrol.crearRol(rol2);
		onrol.crearRol(rol3);

		admi.setRol(rol1);
		admi2.setRol(onrol.buscar(3));

		onadmi.crearUsuarioAdmi(admi);
		onadmi.crearUsuarioAdmi(admi2);

		List<Rol> listaRol = onrol.listaRol();
		for (Rol rol : listaRol) {
			System.out.println(rol.getNombre());
		}
//		
//	//	Rol r=onrol.buscar(2);
//		//System.out.println("miki"+r.getNombre());
//		
//		
//		
//		try {
//			List<UsuarioAdministrativo>uadmi=onadmi.listarUAdmi();
//			for (UsuarioAdministrativo au : uadmi) {
//				System.out.println(au.getNombre());
//				System.out.println(au.getRol().getNombre());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	//	
//		Rol rol=onrol.buscar(2);
//		System.out.println("miki"+rol.getNombre());
//		
//		//
////		try {
////			onrol.EliminarRol(rol);
////		} catch (Exception e) {
////			// TODO: handle exception
////		}
//		
//		List<Rol> listaRol2=onrol.listaRol();
//		for (Rol rolw : listaRol2) {
//			System.out.println(rolw.getNombre());
//		}
//		
//		
		try {
			Persona pb = on.BuscarCorreo("xavi-javi11@hotmail.com");
			System.out.println("PErsona Buscada" + pb.getNombre());
		} catch (Exception e) {
			// TODO: handle exception
		}

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		// Timestamp sqlTimeString = Timestamp.valueOf(calculateThresholdDate(sdf,
		// "yyyy-MM-dd HH:mm:ss"));

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);

//     List<LoginHistoricos>loginlista=onlh.getHistoricos(p.getIdpersona());
//     for (LoginHistoricos m : loginlista) {
//		System.out.println(m.getDescripcion());
//		System.out.println(m.getFecha());
//		System.out.println(m.getPersona().getNombre());
//		System.out.println(m.getPersona().getCorreo());
//     }
//		
//int id =on.BuscarCodigoPersona("xavi-javi11@hotmail.com");
//System.out.println("wewewe"+id);

	}

}
