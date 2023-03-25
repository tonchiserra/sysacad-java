<%@ page import="entities.Materia" %>
<%@ page import="entities.Usuario" %>

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
		<title>ABMC Materia</title>
		<link rel="stylesheet" type="text/css" href="../styles/sysacad.css">
		<link rel="stylesheet" type="text/css" href="../styles/abmc.css">
		<script src="../js/index.js" defer></script>
		<script src="../js/userMenu.js" defer></script>
		<script src="../js/adminMenu.js" defer></script>
		<script src="../js/showABMCForm.js" defer></script>
		
		<!-- Google Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
	
		<!-- Java -->
		<%
			Usuario user = null;
			Materia newMateria = null;
		
			if(session.getAttribute("usuario") != null){
				user = (Usuario) session.getAttribute("usuario");
				if(!user.getIsAdmin()) {
					response.sendRedirect("./index.jsp");
				}
				
				if(session.getAttribute("abmc") != null) {
					newMateria = (Materia) session.getAttribute("abmc");
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
	
	<main class="main-container abmc-container">
		<h2>ABMC Materia</h2>
		<div class="select-abmc">
			<form class="select-abmc-form">
				<input type="radio" id="alta-radio" name="abmc-radio" data-form="AltaForm" />
				<label for="alta-radio">Alta</label>
				<input type="radio" id="baja-radio" name="abmc-radio" data-form="BajaForm" />
				<label for="baja-radio">Baja</label>
				<input type="radio" id="modificacion-radio" name="abmc-radio" data-form="ModificacionForm" />
				<label for="modificacion-radio">Modificacion</label>
				<input type="radio" id="consulta-radio" name="abmc-radio" data-form="ConsultaForm" />
				<label for="consulta-radio">Consulta</label>
			</form>
		</div>
		
		<div id="AltaForm" class="abmc-form-container">
			<form action="../AltaMateriaServlet" class="abmc-form">
				<h3>Alta de materia:</h3>
				<input type="text" name="nombre" placeholder="Ingrese nombre de la materia" required />
				<input type="text" name="descripcion" placeholder="Ingrese descripcion de la materia" />
				<input type="number" name="anio" placeholder="Ingrese a qué año pertenece la materia" required />
				<input type="number" name="idCarrera" placeholder="Ingrese id de carrera a la que pertenece" required />
				<input type="number" name="plan" placeholder="Ingrese plan de la materia" required />
				<button type="submit">Aceptar</button>
			</form>
		</div>
		
		<div id="BajaForm" class="abmc-form-container">
			<form action="../BajaMateriaServlet" class="abmc-form">
				<h3>Baja de materia</h3>
				<input type="number" name="id" placeholder="Ingrese id de la materia" required />
				<button type="submit">Aceptar</button>
			</form>
		</div>
		
		<div id="ModificacionForm" class="abmc-form-container">
			<form action="../ModificacionMateriaServlet" class="abmc-form">
				<h3>Modificacion de materia</h3>
				<input type="text" name="nombre" placeholder="Ingrese nombre de la materia" required />
				<input type="text" name="descripcion" placeholder="Ingrese descripcion de la materia" />
				<input type="number" name="anio" placeholder="Ingrese a qué año pertenece la materia" required />
				<input type="number" name="idCarrera" placeholder="Ingrese id de carrera a la que pertenece" required />
				<input type="number" name="plan" placeholder="Ingrese plan de la materia" required />
				<button type="submit">Aceptar</button>
			</form>
		</div>
		
		<div id="ConsultaForm" class="abmc-form-container">
			<form action="../ConsultaMateriaServlet" class="abmc-form">
				<h3>Consulta de materia</h3>
				<input type="number" name="id" placeholder="Ingrese id de la materia" required />
				<button type="submit">Aceptar</button>
			</form>
		</div>
		
		<%if(newMateria != null) { %>
			<div class="abmc-modal__container">
				<div class="abmc-modal">
					<button type="button" onclick="closeABMCModal()">x</button>
					<p>Id: <%=newMateria.getIdMateria() %></p>
					<p>Nombre: <%=newMateria.getNombre() %></p>
					<p>Descripción: <%=newMateria.getDescripcion() %></p>
					<p>Año: <%=newMateria.getAnio() %></p>
					<p>IdCarrera: <%=newMateria.getIdCarrera() %></p>
					<p>Plan: <%=newMateria.getPlan() %></p>
				</div>
			</div>
		<% }%>
	</main>
</body>
</html>