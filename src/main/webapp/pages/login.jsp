<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Sysacad-java | Login</title>
	</head>
	<body>
		<main class="login__main-container">
			<form action="../LoginServlet" method="POST" name="form_login">
				<input type="text" name="legajo" required />
				<input type="password" name="password" required />
				<button type="submit">Ingresar</button>
			</form>
		</main>
	</body>
</html>