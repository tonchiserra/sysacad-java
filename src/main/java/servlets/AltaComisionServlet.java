package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Comision;
import logic.ABMCComision;

public class AltaComisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AltaComisionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMCComision ctrlABMC = new ABMCComision();
		
		String codigo = request.getParameter("codigo");
		String cupoTotal = request.getParameter("cupo");
		
		if(codigo == null) {
			response.sendRedirect("pages/abmc-comision.jsp");
			return;
		}
		
		Comision nuevaComision = new Comision();
		nuevaComision.setCodigoComision(codigo);
		nuevaComision.setCupoTotal(Integer.parseInt(cupoTotal));
		nuevaComision = ctrlABMC.alta(nuevaComision);
		
		if(nuevaComision != null) {
			session.setAttribute("abmc", nuevaComision);
		}
		
		response.sendRedirect("pages/abmc-comision.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
