package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import data.DataExamen;
import data.DataUsuario;
import entities.Examen;
import entities.Usuario;
import logic.Login;

public class InscripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InscripcionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fecha = request.getParameter("Mesa");
		int legajo = Integer.parseInt(request.getParameter("Legajo"));
		int idMateria = Integer.parseInt(request.getParameter("Materia"));
		
		DataUsuario du = new DataUsuario();
		Usuario userLoged = new Usuario();
		userLoged.setLegajo(legajo);
		userLoged = du.getOne(userLoged);
		
		DataExamen de = new DataExamen();
		Examen alumnoMateria = new Examen();
		alumnoMateria.setLegajo(legajo);
		alumnoMateria.setIdMateria(idMateria);
		alumnoMateria = de.getOne(alumnoMateria);
		
		if(alumnoMateria.getEstado().toLowerCase() == "cursando") {
			System.out.println("cursando brotherrrrr");
		}
	}

}
