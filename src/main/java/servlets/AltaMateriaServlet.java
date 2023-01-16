package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Materia;
import logic.ABMCMateria;

public class AltaMateriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AltaMateriaServlet() {
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
		
		Materia nuevaMateria = new Materia();
		nuevaMateria.setNombre(nombre);
		nuevaMateria.setDescripcion(descripcion);
		nuevaMateria.setAnio(Integer.parseInt(anio));
		nuevaMateria.setIdCarrera(Integer.parseInt(idCarrera));
		nuevaMateria.setPlan(Integer.parseInt(plan));
		
		nuevaMateria = ctrlABMC.alta(nuevaMateria);
		
		if(nuevaMateria != null) {
			session.setAttribute("abmc", nuevaMateria);
		}
		
		response.sendRedirect("pages/abmc-materia.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
