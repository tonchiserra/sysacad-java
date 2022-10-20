<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Sysacad-java | Materias</title>
		<link rel="stylesheet" type="text/css" href="../styles/ListaMaterias.css">
		
		<!-- Google Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;500;600;700&display=swap" rel="stylesheet">
<title>Materias</title>
</head>
<body>
	<div class="lista_materias">
		<div class="row">
			<div class="thead1">
				<div class=table>
					<thead>
						<tr>
							<th>ID</th>
						  	<th>Nombre</th>
						  	<th>Descripcion</th>
						  	<th>Año</th>
						  	<th>Carrera</th>
						  	<th></th>
						  	<th></th>
						</tr>
					</thead>
					<tbody>
					<% for (Materia mat : listaMaterias){ %>
						<tr>
							<td><%mat.getIdMateria()%></td>
							<td><%mat.getNombre()%></td>
							<td><%mat.getDescripcion()%></td>
							<td><%mat.getAnio()%></td>
							<td><%mat.getIdCarrera()%></td>
							<td></td> <!-- editar -->
							<td></td> <!-- borrar-->
						</tr>
					<% }%>
					</tbody>
				
				</div>
			
			
			</div>
		
		
		</div>
	
	</div>	
	






<!-- 	<table> -->
<!-- 		<tbody> -->
<!-- 			<tr> -->
<!-- 			  	<th>ID</th> -->
<!-- 			  	<th>Nombre</th> -->
<!-- 			  	<th>Descripcion</th> -->
<!-- 			  	<th></th> -->
<!-- 			  	<th>Año</th> -->
<!-- 			  	<th></th> -->
<!-- 			  	<th>Carrera</th> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td class="td">1</td> -->
<!-- 				<td>Analisis Mat 1</td> -->
<!-- 				<td>Materia primer ano</td> -->
<!-- 				<td>1</td> -->
<!-- 				<td>Basicas</td> -->
<!-- 			</tr> -->
<!-- 		</tbody> -->
	
	
<!-- 	</table> -->
</body>
</html>