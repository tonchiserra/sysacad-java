<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sysacad-java</title>
		<link rel="stylesheet" type="text/css" href="./style.css">
	</head>
	
	<body>
		<header class="main-header">
			<div class="header__title-container">
				<!-- img logotipo utn -->
				<div class="header__title-text">
					<h2>UTN FRRo</h2>
					<p>Sistema de autogestión alumnos</p>
				</div>
			</div>
			<button type="button" class="button_menu-mobile">
				<!-- svg menu open -->
				<!-- svg menu close -->
			</button>
			<div class="header__main-menu">
				<nav>
					<ul>
						<li><a href="">Página principal</a></li>
						<li><a href="">Calendario académico 2022</a></li>
						<li><a href="">Trámite alumnos</a></li>
						<li><a href="">Materias del plan</a></li>
						<li><a href="">Estado académico</a></li>
						<li><a href="">Exámenes</a></li>
						<li><a href="">Cursado</a></li>
						<li><a href="">Correlatividades</a></li>
						<li><a href="">Inscripción a exámen</a></li>
						<li><a href="">Inscripción a cursado</a></li>
						<li><a href="">Avisos</a></li>
						<li><a href="">Cambio de contraseña</a></li>
						<li><a href="">Salir</a></li>
					</ul>
				</nav>
			</div>
		</header>
		
		<main class="main-container">
			<p class="text-title">¡Hola!</p>
			<h3 class="text-title__username"><!-- Tomar nombre de la db --></h3>
			<p class="text-title"><!-- Tomar carrera de la db --></p>
			
			<div class="academic-status__container">
				<div class="academic-status__legends">
					<div class="legend">
						<div class="legend__point white"></div>
						<p class="legend__text">Sin cursar</p>
					</div>
					<div class="legend">
						<div class="legend__point yellow"></div>
						<p class="legend__text">Regular</p>
					</div>
					<div class="legend">
						<div class="legend__point green"></div>
						<p class="legend__text">Aprobada</p>
					</div>
				</div>
				<div class="academic-status__table">
					<div class="academic-status__table-header">
						<p class="table-header__title">Año</p>
						<p class="table-header__title">Materia</p>
						<p class="table-header__title">Nota</p>
					</div>
					<!-- por cada materia -->
						<div class="academic-status__table-row"> <!-- cambiar el color de la fila segun el estado -->
							<p class="table-row__age-text"><!-- Tomar año de materia de la db --></p>
							<p class="table-row__name-text"><!-- Tomar nombre de materia de la db --></p>
							<p class="table-row__note-text"><!-- Tomar nota de materia de la db --></p>
						</div>
					<!-- fin for -->
				</div>
			</div>	
		</main>
		
		<footer class="main-footer">
		
		</footer>
	</body>
</html>