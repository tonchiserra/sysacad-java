package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Materia;
import logic.ABMCMateria;

public class ModificacionMateriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificacionMateriaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMCMateria ctrlABMC = new ABMCMateria();
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("desripcion");
		String anio = request.getParameter("anio");
		String idCarrera = request.getParameter("idCarrera");
		String plan = request.getParameter("plan");
		
		if(nombre == null) {
			response.sendRedirect("pages/abmc-materia.jsp");
			return;
		}
		
		Materia unaMateria = new Materia();
		unaMateria.setNombre(nombre);
		unaMateria.setDescripcion(descripcion);
		unaMateria.setAnio(Integer.parseInt(anio));
		unaMateria.setIdCarrera(Integer.parseInt(idCarrera));
		unaMateria.setPlan(Integer.parseInt(plan));
		
		unaMateria = ctrlABMC.modificacion(unaMateria);
		
		if(unaMateria != null) {
			session.setAttribute("abmc", unaMateria);
		}
		
		response.sendRedirect("pages/abmc-materia.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
