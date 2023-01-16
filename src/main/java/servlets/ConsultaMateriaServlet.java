package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Materia;
import logic.ABMCMateria;

public class ConsultaMateriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultaMateriaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMCMateria ctrlABMC = new ABMCMateria();
		
		String idMateria = request.getParameter("id");
		
		if(idMateria == null) {
			response.sendRedirect("pages/abmc-materia.jsp");
			return;
		}
		
		Materia unaMateria = new Materia();
		unaMateria.setIdMateria(Integer.parseInt(idMateria));
		unaMateria = ctrlABMC.consulta(unaMateria);
		
		if(unaMateria != null) {
			session.setAttribute("abmc", unaMateria);
		}
		
		response.sendRedirect("pages/abmc-materia.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
