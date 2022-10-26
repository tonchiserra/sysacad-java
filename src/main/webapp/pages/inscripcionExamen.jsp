<%@ page import="java.util.LinkedList" %>
<%@ page import="data.DataMateria" %>
<%@ page import="entities.*" %>

<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inscripción a exámen</title>
		<link rel="stylesheet" type="text/css" href="../styles/sysacad.css">
		<link rel="stylesheet" type="text/css" href="../styles/inscripcion.css">
		<script src="../js/index.js" defer></script>
		<script src="../js/userMenu.js" defer></script>
		
		<!-- Google Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;500;600;700&display=swap" rel="stylesheet">
	
		<!-- Java -->
		<%
			Usuario user = null;
		
			if(session.getAttribute("usuario") != null){
				user = (Usuario) session.getAttribute("usuario");
			}else{
				response.sendRedirect("./login.jsp");
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
			
			<user-menu></user-menu>
			<div class="main-menu__background"></div>
		</header>
		
		<main class="main-container">
			<h2 class="inscription-title">Inscripción a exámen</h2>
			
			<div class="inscription__table">
				<div class="inscription__table-header">
					<p class="table-header__title">Año</p>
					<p class="table-header__title">Materia</p>
					<p class="table-header__title">Plan</p>
					<p class="table-header__title">Inscripción</p>
				</div>
				<%	DataMateria dm = new DataMateria();
					LinkedList<Materia> materias = new LinkedList<>();
					materias = dm.getAll();
				%>
				<%for (Materia materia : materias){ %>
					<div class="inscription__table-row">
						<p class="table-row__age-text"><%=materia.getAnio()%></p>
						<p class="table-row__name-text"><%=materia.getNombre()%></p>
						<p class="table-row__plan-text"><%=materia.getPlan()%></p>
						<p class="table-row__inscription-text"><a href="">Inscribir</a></p>
					</div>
				<% }%>
			</div>
		</main>
	</body>
</html>