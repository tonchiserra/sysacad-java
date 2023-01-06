package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Carrera;
import logic.ABMC;

public class ModificacionCarreraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificacionCarreraServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMC ctrlABMC = new ABMC();
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		if(id == null) {
			response.sendRedirect("pages/abmc-carrera.jsp");
			return;
		}
		
		Carrera unaCarrera = new Carrera();
		unaCarrera.setIdCarrera(Integer.parseInt(id));
		unaCarrera.setNombre(nombre);
		unaCarrera.setDescripcion(descripcion);
		unaCarrera = ctrlABMC.modificacion(unaCarrera);
		
		if(unaCarrera != null) {
			session.setAttribute("abmc", unaCarrera);
		}
		
		response.sendRedirect("pages/abmc-carrera.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
