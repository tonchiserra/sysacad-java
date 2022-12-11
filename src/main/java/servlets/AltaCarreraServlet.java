package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Carrera;
import logic.ABMC;

public class AltaCarreraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AltaCarreraServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMC ctrlABMC = new ABMC();
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		if(nombre == null) {
			response.sendRedirect("pages/abmc-carrera.jsp");
			return;
		}
		
		Carrera nuevaCarrera = new Carrera();
		nuevaCarrera.setNombre(nombre);
		nuevaCarrera.setDescripcion(descripcion);
		nuevaCarrera = ctrlABMC.alta(nuevaCarrera);
		
		if(nuevaCarrera != null) {
			session.setAttribute("abmc", nuevaCarrera);
			//mostrar esto en el jsp, al igual que en el servlet de inscripcion
		}
		
		response.sendRedirect("pages/abmc-carrera.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
