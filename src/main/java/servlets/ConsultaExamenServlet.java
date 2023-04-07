package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;

public class ConsultaExamenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultaExamenServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		logic.Examen ctrlExamen = new logic.Examen();
		
		String legajo = request.getParameter("legajo");
		
		entities.Examen nuevoExamen = new entities.Examen();
		nuevoExamen.setLegajo(Integer.parseInt(legajo));
		
		LinkedList<entities.Examen> losExamenes = new LinkedList<>();
		losExamenes = ctrlExamen.consulta(nuevoExamen);
		
		session.setAttribute("examenes", losExamenes);
		response.sendRedirect("pages/examenes.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
