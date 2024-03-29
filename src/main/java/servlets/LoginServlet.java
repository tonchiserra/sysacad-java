package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import entities.Usuario;
import logic.Login;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Usuario userLoged = new Usuario();
		Login ctrlLogin = new Login();
		
		int legajo = Integer.parseInt(request.getParameter("legajo"));
		String password = request.getParameter("password");
		
		userLoged.setLegajo(legajo);
		userLoged.setContrasenia(password);
		
		userLoged = ctrlLogin.validate(userLoged);
		
		if(userLoged != null && session.getAttribute("usuario") == null) {
			session.setAttribute("usuario", userLoged);
			response.sendRedirect("pages/index.jsp");
		}else {
			response.sendRedirect("pages/login.jsp");
		}
	}

}
