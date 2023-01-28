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

public class ModificacionUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificacionUsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMCUsuario ctrlABMC = new ABMCUsuario();
		
		String legajo = request.getParameter("legajo");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String idCarrera = request.getParameter("idCarrera");
		String sueldo = request.getParameter("sueldo");
		
		if(nombre == null) {
			response.sendRedirect("pages/abmc-usuario.jsp");
			return;
		}
		
		Usuario unUsuario;
		
		if(idCarrera.length() > 0) {
			unUsuario = new Alumno();
			((Alumno) unUsuario).setIdCarrera(Integer.parseInt(idCarrera));
		}else {
			unUsuario = new Profesor();
			((Profesor) unUsuario).setSueldo(Double.parseDouble(sueldo));
		}
		
		unUsuario.setLegajo(Integer.parseInt(legajo));
		unUsuario.setNombre(nombre);
		unUsuario.setApellido(apellido);
		unUsuario.setEmail(email);
		
		unUsuario = ctrlABMC.modificacion(unUsuario);
		
		if(unUsuario != null) {
			session.setAttribute("abmc", unUsuario);
		}
		
		response.sendRedirect("pages/abmc-usuario.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
