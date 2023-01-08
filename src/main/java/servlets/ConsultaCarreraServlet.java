package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Carrera;
import logic.ABMCCarrera;

public class ConsultaCarreraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultaCarreraServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMCCarrera ctrlABMC = new ABMCCarrera();
		
		String id = request.getParameter("id");
		
		if(id == null) {
			response.sendRedirect("pages/abmc-carrera.jsp");
			return;
		}
		
		Carrera unaCarrera = new Carrera();
		unaCarrera.setIdCarrera(Integer.parseInt(id));
		unaCarrera = ctrlABMC.consulta(unaCarrera);
		
		if(unaCarrera != null) {
			session.setAttribute("abmc", unaCarrera);
		}
		
		response.sendRedirect("pages/abmc-carrera.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
