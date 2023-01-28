package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.Mesa;
import logic.ABMCMesa;

public class BajaMesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BajaMesaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMCMesa ctrlABMC = new ABMCMesa();
		
		String llamado = request.getParameter("llamado");
		String idMateria = request.getParameter("idMateria");
		String fechaHora = request.getParameter("fechaHora");
		
		if(llamado == null || idMateria == null || fechaHora == null) {
			response.sendRedirect("pages/abmc-mesa.jsp");
			return;
		}
		
		Mesa nuevaMesa = new Mesa();
		nuevaMesa.setLlamado(Integer.parseInt(llamado));
		nuevaMesa.setIdMateria(Integer.parseInt(idMateria));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(fechaHora, formatter);
		nuevaMesa.setFechaHora(dateTime);
		
		nuevaMesa = ctrlABMC.baja(nuevaMesa);
		
		if(nuevaMesa != null) {
			session.setAttribute("abmc", nuevaMesa);
		}
		
		response.sendRedirect("pages/abmc-mesa.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
