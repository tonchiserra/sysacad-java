package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Comision;
import logic.ABMC;

public class BajaComisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BajaComisionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMC ctrlABMC = new ABMC();
		
		String codigo = request.getParameter("codigo");
		
		if(codigo == null) {
			response.sendRedirect("pages/abmc-comision.jsp");
			return;
		}
		
		Comision unaComision = new Comision();
		unaComision.setCodigoComision(codigo);
		unaComision = ctrlABMC.baja(unaComision);
		
		if(unaComision != null) {
			session.setAttribute("abmc", unaComision);
		}
		
		response.sendRedirect("pages/abmc-comision.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
