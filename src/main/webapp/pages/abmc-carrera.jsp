<%@ page import="entities.Carrera" %>
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
		<title>ABMC Carrera</title>
		<link rel="stylesheet" type="text/css" href="../styles/sysacad.css">
		<link rel="stylesheet" type="text/css" href="../styles/index.css">
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
		
			if(session.getAttribute("usuario") != null){
				user = (Usuario) session.getAttribute("usuario");
				if(!user.getNombre().equals("admin") && !user.getApellido().equals("admin")) {
					response.sendRedirect("./index.jsp");
				}
			}else{
				response.sendRedirect("./index.jsp");
			}
		%>

	</head>
<body>
	<div class="abmc-container">
		<h2>ABMC Carrera</h2>
		<div class="select-abmc">
			<form class="select-abmc-form">
				<label for="alta-radio">Alta</label>
				<input type="radio" id="alta-radio" name="abmc-radio" data-form="AltaForm" />
				<label for="baja-radio">Baja</label>
				<input type="radio" id="baja-radio" name="abmc-radio" data-form="BajaForm" />
				<label for="modificacion-radio">Modificacion</label>
				<input type="radio" id="modificacion-radio" name="abmc-radio" data-form="ModificacionForm" />
				<label for="consulta-radio">Consulta</label>
				<input type="radio" id="consulta-radio" name="abmc-radio" data-form="ConsultaForm" />
			</form>
		</div>
		
		<div id="AltaForm" class="abmc-form-container">
			<form action="#" class="alta-form">
				<label>Alta de carrera:</label>
				<input type="text" name="nombre" placeholder="Ingrese nombre de la carrera" required />
				<input type="text" name="descripcion" placeholder="Ingrese descripcion de la carrera" />
				<button type="submit">Aceptar</button>
			</form>
		</div>
		
		<div id="BajaForm" class="abmc-form-container">
			<form action="#" class="baja-form">
				<label>Baja de carrera</label>
				<input type="text" name="id" placeholder="Ingrese id de la carrera" required />
			</form>
		</div>
		
		<div id="ModificacionForm" class="abmc-form-container">
			<form action="#" class="modificacion-form">
				<label>Modificacion de carrera</label>
			</form>
		</div>
		
		<div id="ConsultaForm" class="abmc-form-container">
			<form action="#" class="consulta-form">
				<label>Consulta de carrera</label>
			</form>
		</div>
	</div>
</body>
</html>