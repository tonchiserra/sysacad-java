package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Comision;
import logic.ABMCComision;

public class ConsultaComisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultaComisionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMCComision ctrlABMC = new ABMCComision();
		
		String codigo = request.getParameter("codigo");
		
		if(codigo == null) {
			response.sendRedirect("pages/abmc-comision.jsp");
			return;
		}
		
		Comision unaComision = new Comision();
		unaComision.setCodigoComision(codigo);
		unaComision = ctrlABMC.consulta(unaComision);
		
		if(unaComision != null) {
			session.setAttribute("abmc", unaComision);
		}
		
		response.sendRedirect("pages/abmc-comision.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
