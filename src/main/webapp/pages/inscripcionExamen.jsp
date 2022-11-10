<%@ page import="java.util.LinkedList" %>
<%@ page import="data.DataMateria" %>
<%@ page import="data.DataMesa" %>
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
		<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
		
		<!-- Java -->
		<%
			Usuario user = null;
			String inscripcionKey = null;
		
			if(session.getAttribute("usuario") != null){
				user = (Usuario) session.getAttribute("usuario");
			
				if(session.getAttribute("inscripcion") != null){
					inscripcionKey = (String) session.getAttribute("inscripcion");
					session.setAttribute("inscripcion", null);
				}
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
					
					DataMesa dme = new DataMesa();
					LinkedList<Mesa> mesas = new LinkedList<>();
					mesas = dme.getAll();
				%>
				
				<%for (Materia materia : materias){ %>
					<div class="inscription__table-row">
						<div class="table-row__content-top">
							<p class="table-row__age-text"><%=materia.getAnio()%></p>
							<p class="table-row__name-text"><%=materia.getNombre()%></p>
							<p class="table-row__plan-text"><%=materia.getPlan()%></p>
							<label for="Materia-<%=materia.getIdMateria()%>" class="table-row__inscription-text">Ver mesas</label>
						</div>
						<input class="materia-checkbox" type="checkbox" name="Materia-<%=materia.getIdMateria()%>" id="Materia-<%=materia.getIdMateria()%>" />	
						<div class="table__modal-info">
							<form action="../InscripcionServlet" class="mesas-form">
								<% int i = 0;
								for (Mesa mesa : mesas){ 
									i++;
									if(mesa.getIdMateria() == materia.getIdMateria()){ %>
										<div class="mesa-item">
											<input type="radio" name="Mesa" id="Materia-<%=materia.getIdMateria()%>-Mesa-<%=mesa.getIdMateria()%>-<%=i%>" value="<%=mesa.getFechaHora()%>" />	
											<label for="Materia-<%=materia.getIdMateria()%>-Mesa-<%=mesa.getIdMateria()%>-<%=i%>">
												<p>Fecha <%=mesa.getFechaHora()%></p>
												<p>-</p>
												<p>Llamado número <%=mesa.getLlamado()%></p>
											</label>
										</div>
										<%if(inscripcionKey != null && inscripcionKey.equals("Materia-"+Integer.toString(materia.getIdMateria())+"-Fecha-"+mesa.getFechaHora())) { %>
											<div class="inscripcion-modal__container">
												<div class="inscripcion-modal">
													<button type="button" onclick="closeInscripcionModal()">x</button>
													<h3>¡Felicitaciones, <%=user.getNombre() %>! Te has inscripto a un nuevo exámen:</h3>
													<p>Fecha: <%=mesa.getFechaHora() %></p>
													<p>Materia: <%=materia.getNombre() %></p>
													<p>Año materia: <%=materia.getAnio() %> año</p>
													<p>Pronto tu profesor se comunicará con usted para brindarle más detalles.</p>
												</div>
											</div>
										<% }%>
									<% }%>	
								<% }%>
								<%if(inscripcionKey != null && inscripcionKey.equals("Error-noRegular-Materia-"+Integer.toString(materia.getIdMateria()))) { %>
									<div class="inscripcion-modal__container">
										<div class="inscripcion-modal">
											<button type="button" onclick="closeInscripcionModal()">x</button>
											<h3>Oops... No has podido inscribirte en este exámen:</h3>
											<p>No has podido inscribirte en el exámen de la materia <%=materia.getNombre() %> debido a que aún no te encuentras regular en la misma.</p>
											<p>Si consideras que esto es un error, por favor comunícate con alumnado.</p>
										</div>
									</div>
								<% }%>
								<%if(user != null) {%>
									<input type="hidden" name="Legajo" value="<%=user.getLegajo()%>">
								<% }%>
								<input type="hidden" name="Materia" value="<%=materia.getIdMateria()%>">
								<button type="submit">Inscribirse</button>
							</form>
						</div>
					</div>
				<% }%>
			</div>
		</main>
	</body>
</html>