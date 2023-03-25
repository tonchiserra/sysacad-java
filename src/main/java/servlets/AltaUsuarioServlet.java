package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Alumno;
import entities.Profesor;
import entities.Usuario;
import logic.ABMCUsuario;

public class AltaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AltaUsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMCUsuario ctrlABMC = new ABMCUsuario();
		
		String legajo = request.getParameter("legajo");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String contrasenia = request.getParameter("contrasenia");
		String dni = request.getParameter("dni");
		String email = request.getParameter("email");
		String idCarrera = request.getParameter("idCarrera");
		String sueldo = request.getParameter("sueldo");
		String isAdmin = request.getParameter("isAdmin");
		
		if(legajo == null) {
			response.sendRedirect("pages/abmc-usuario.jsp");
			return;
		}
		
		Usuario nuevoUsuario;
		
		if(Integer.parseInt(sueldo) > 0) {
			nuevoUsuario = new Profesor();
			((Profesor) nuevoUsuario).setSueldo(Double.parseDouble(sueldo));
		}else {
			nuevoUsuario = new Alumno();
			((Alumno) nuevoUsuario).setIdCarrera(Integer.parseInt(idCarrera));
		}
		
		nuevoUsuario.setLegajo(Integer.parseInt(legajo));
		nuevoUsuario.setNombre(nombre);
		nuevoUsuario.setApellido(apellido);
		nuevoUsuario.setContrasenia(contrasenia);
		nuevoUsuario.setDNI(dni);
		nuevoUsuario.setEmail(email);
		nuevoUsuario.setIsAdmin(Boolean.parseBoolean(isAdmin));
		
		nuevoUsuario = ctrlABMC.alta(nuevoUsuario);
		
		if(nuevoUsuario != null) {
			session.setAttribute("abmc", nuevoUsuario);
		}
		
		response.sendRedirect("pages/abmc-usuario.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
