package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entities.Usuario;
import logic.ABMCUsuario;

public class BajaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BajaUsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ABMCUsuario ctrlABMC = new ABMCUsuario();
		
		String legajo = request.getParameter("legajo");
		
		if(legajo == null) {
			response.sendRedirect("pages/abmc-usuario.jsp");
			return;
		}
		
		Usuario unUsuario = new Usuario();
		unUsuario.setLegajo(Integer.parseInt(legajo));
		unUsuario = ctrlABMC.baja(unUsuario);
		
		if(unUsuario != null) {
			session.setAttribute("abmc", unUsuario);
		}
		
		response.sendRedirect("pages/abmc-usuario.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
