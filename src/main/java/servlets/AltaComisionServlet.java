package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Comision;
import logic.ABMC;

public class AltaComisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AltaComisionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMC ctrlABMC = new ABMC();
		
		String codigo = request.getParameter("codigo");
		String cupoTotal = request.getParameter("cupo");
		
		if(codigo == null) {
			response.sendRedirect("pages/abmc-comision.jsp");
			return;
		}
		
		Comision nuevaComision = new Comision();
		nuevaComision.setNombre(nombre);
		nuevaComision.setDescripcion(descripcion);
		nuevaComision = ctrlABMC.alta(nuevaComision);
		
		if(nuevaComision != null) {
			session.setAttribute("abmc", nuevaComision);
		}
		
		response.sendRedirect("pages/abmc-comision.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
