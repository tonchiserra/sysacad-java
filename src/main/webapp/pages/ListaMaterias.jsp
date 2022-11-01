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
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Sysacad-java | Materias</title>
		<link rel="stylesheet" type="text/css" href="../styles/sysacad.css">
		<link rel="stylesheet" type="text/css" href="../styles/ListaMaterias.css">
		
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
<%-- 	<h1><%= user.getNombre() %> <%= user.getApellido() %></h1> --%>
	<div class="saludo">
		<p> ¡Hola! 👋 </p>
	</div>
	<div class=header-materia>
		<h1>Jose Socolsky</h1>
		<p>Ingenieria en Sistemas de Informacion</p>
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
	        	<tr>
					<td><%=mat.getAnio()%></td>
 					<td><%=mat.getNombre()%></td>
	 				<td></td> <!-- usar estado de examen para colores css -->
	        	</tr>
 	         <% }%>
	    </tbody>
	</table>



















<!-- 	<div class="lista_materias"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="thead1"> -->
<!-- 				<div class=table> -->
<!-- 					<thead> -->
<!-- 						<tr> -->
<!-- 							<th>Año</th> -->
<!-- 						  	<th>Materia</th> -->
<!-- 						  	<th>Nota</th> -->

<!-- 						</tr> -->
<!-- 					</thead> -->
<!-- 					<tbody> -->
<%-- 					<%DataMateria lm=new DataMateria(); --%>
<%-- 					 LinkedList<Materia> listaMaterias = lm.getAll(); %> --%>
<%-- 					<% for (Materia mat : listaMaterias){ %> --%>
<!-- 						<tr> -->
<%-- 							<td><%=mat.getAnio()%></td> --%>
<%-- 							<td><%=mat.getNombre()%></td> --%>
<!-- 							<td>5</td> -->

<!-- 						</tr> -->
<%-- 					<% }%> --%>
<!-- 					</tbody> -->
				
<!-- 				</div> -->
			
			
<!-- 			</div> -->
		
		
<!-- 		</div> -->
	
<!-- 	</div>	 -->
	
</body>
</html>