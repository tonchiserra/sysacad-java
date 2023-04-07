<%@ page import="entities.Carrera" %>
<%@ page import="entities.Usuario" %>
<%@ page import="entities.Alumno" %>
<%@ page import="entities.Profesor" %>
<%@ page import="entities.Examen" %>
<%@ page import="java.util.LinkedList" %>

<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Exámenes</title>
		<link rel="stylesheet" type="text/css" href="../styles/sysacad.css">
		<link rel="stylesheet" type="text/css" href="../styles/abmc.css">
		<script src="../js/index.js" defer></script>
		<script src="../js/userMenu.js" defer></script>
		<script src="../js/adminMenu.js" defer></script>
		
		<!-- Google Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
	
		<!-- Java -->
		<%
			Usuario user = null;
			LinkedList<Examen> listaExamenes = null;
		
			if(session.getAttribute("usuario") != null){
				user = (Usuario) session.getAttribute("usuario");
				if(!user.getIsAdmin()) {
					response.sendRedirect("./index.jsp");
				}
				
				if(session.getAttribute("examenes") != null) {
					listaExamenes = (LinkedList<Examen>) session.getAttribute("examenes");
					session.setAttribute("abmc", null);
				}
			}else{
				response.sendRedirect("./index.jsp");
			}
		%>

	</head>
<body>
	<header class="main-header">
		<div class="main-header-container">
			<div class="header__title-container">
				<img src="../assets/utn-logo.svg" alt="UTN-logo" />
				<div class="header__title-text">
					<h2>UTN FRRo</h2>
					<p>Sistema de autogestión alumnos</p>
				</div>
			</div>
			<button type="button" class="button__menu-mobile" onclick="handleMenu()" >
				<img class="icon-hamburger" src="../assets/icon-hamburger.svg" />
				<img class="icon-close" src="../assets/icon-close.svg" />
			</button>
		</div>
		
		<% if(user.getIsAdmin()) { %>
			<admin-menu></admin-menu>
		<%}else { %>
			<user-menu></user-menu>
		<%} %>
		<div class="main-menu__background"></div>
	</header>
	
	<main class="main-container">
		<h2>Exámenes</h2>
		
		<div id="ConsultaForm">
			<form action="../ConsultaExamenServlet" class="abmc-form">
				<h3>Consulta de usuario</h3>
				<input type="text" name="legajo" placeholder="Ingrese legajo del usuario" required />
				<button type="submit">Aceptar</button>
			</form>
		</div>
		
		<%if(listaExamenes != null) { %>
			<form action="../ExamenServlet">
				<ul class="examenes">
					<%for (Examen exm : listaExamenes){ %>
						<li>
							<p><%=exm.getLegajo() %></p>
							<p><%=exm.getIdMateria() %></p>
							<p><%=exm.getFecha() %></p>
							<input type="number" max=10 name="nota-<%=exm.getFecha() %>" value="<%=exm.getNota() %>" required>
						</li>
					<%} %>
				</ul>
				<button type="submit">Aceptar</button>
				
				<!-- 
					Crear lógica para traerme los examenes
					Crear Servlet y logica para actualizar la db
				 -->
			</form>
		<%} %>
	</main>
</body>
</html>