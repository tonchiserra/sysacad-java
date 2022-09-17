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
		<title>Sysacad-java</title>
		<link rel="stylesheet" type="text/css" href="../styles/index.css">
		<script src="./js/index.js" defer></script>
		
		<!-- Google Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;500;600;700&display=swap" rel="stylesheet">
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
				<button type="button" class="button__menu-mobile">
					<img class="icon-hamburger" src="../assets/icon-hamburger.svg" />
					<img class="icon-close" src="../assets/icon-close.svg" />
				</button>
			</div>
			
			<aside class="main-menu">
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
			</aside>
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