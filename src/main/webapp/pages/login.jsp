<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Sysacad-java | Login</title>
		<link rel="stylesheet" type="text/css" href="../styles/login.css">
		
		<!-- Google Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;500;600;700&display=swap" rel="stylesheet">
	
		<!-- Java -->
		<%
			if(session.getAttribute("usuario") != null){
				response.sendRedirect("./index.jsp");
			}
		%>	
	</head>
	<body>
		<main class="login__main-container">
			<div class="login__title-container">
				<img src="../assets/utn-logo.svg" alt="UTN-logo" />
				<div class="login-title">
					<h1>Universidad Tecnológica Nacional</h1>
					<h2>Facultad Regional Rosario</h2>
				</div>
			</div>
			
			<p class="login__description">Sistema autogetión de alumnos</p>
			
			<form class="form-login" action="../LoginServlet" method="POST" name="form_login">
				<input type="text" name="legajo" placeholder="Ingresar legajo" required />
				<input type="password" name="password" placeholder="Ingresar contraseña" required />
				<button type="submit">Ingresar</button>
			</form>
			
			<div class="no-account__container">
				<p>¿No tienes una cuenta?</p>
				<p>Puedes pedirla en alumnado</p>
			</div>
		</main>
	</body>
</html>