<%@ page import="java.util.LinkedList" %>
<%@ page import="data.DataExamen" %>
<%@ page import="data.DataMateria" %>
<%@ page import="data.DataCarrera" %>
<%@ page import="entities.Examen" %>
<%@ page import="entities.Carrera" %>
<%@ page import="entities.Alumno" %>
<%@ page import="entities.Usuario" %>
<%@ page import="entities.Materia" %>

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
		<link rel="stylesheet" type="text/css" href="../styles/sysacad.css">
		<link rel="stylesheet" type="text/css" href="../styles/index.css">
		<script src="../js/index.js" defer></script>
		<script src="../js/userMenu.js" defer></script>
		
		<!-- Google Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
	
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
			<%
				DataCarrera dCarrera=new DataCarrera();
				Carrera tCarrera=new Carrera();
				tCarrera.setIdCarrera(((Alumno) user).getIdCarrera());
				tCarrera=dCarrera.getOne(tCarrera);
			%>
			<div class="margen"></div>
			<div class="header-container">
				<div class="saludo">
					<p> ¡Hola! 👋 </p>
				</div>
				<div class="header-materia">
					<h1><%= user.getNombre() %> <%= user.getApellido() %></h1>
					<p><%= tCarrera.getDescripcion()%></p>
				</div>
			</div>
			<div class="academic-status">
				<div class="green-dot"></div>
				<p style="display:inline-block">Aprobada</p>
				<div class="yellow-dot"></div>
				<p style="display:inline-block">Regular</p>
				<div class="white-dot"></div>
				<p style="display:inline-block">Sin cursar</p>
			</div>

			<table class="content-table">
			    <thead>
			        <tr>
			            <th>Año</th>
		 				<th>Materia</th>
					  	<th>Nota</th>
			        </tr>
			    </thead>
			    <tbody>
			    	 <% DataMateria lm=new DataMateria();
					 	LinkedList<Materia> listaMaterias= new LinkedList<>();
					 	listaMaterias = lm.getAll();
					 %>
		 			 <%for (Materia mat : listaMaterias){ %>
		  				<%  DataExamen dExamen=new DataExamen();
		 			 		Examen tExamen=new Examen();
		 			 		tExamen.setLegajo(user.getLegajo());
		 			 		tExamen.setIdMateria(mat.getIdMateria());
		 			 		tExamen=dExamen.getOne(tExamen);
		 			 		if(tExamen==null){
		 			 			tExamen=new Examen();
		 			 			tExamen.setEstado("");
		 			 		}
					 	%>
			        	<%if(tExamen.getEstado().equals("Aprobado")){%>
			        	<tr class=usuario-aprobado>
			        	<%}else if((tExamen.getEstado().equals("Regular")) || (tExamen.getEstado().equals("a rendir"))){%>
			        	<tr class=usuario-regular>
			        	<%}else{%>
			        	<tr>
			        	 <% };%>
							<td style="text-align: center"><%=mat.getAnio()%></td>
		 					<td><%=mat.getNombre()%></td>
		 					
			 				<%if(tExamen.getEstado().equals("Aprobado")){%>
		        			<td style="text-align: center"><%=tExamen.getNota()%></td>
		       			 	<%}else{%>
		       			 	<td></td>
		       			 	
		        			<%};%> 
			        	</tr>
		 	         <% }%>
	    </tbody>
	</table>
		</main>
		
		<footer class="main-footer">
		
		</footer>
	</body>
</html>