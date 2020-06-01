<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Gracias por visitarnos	</title>
</head>
<body>
	<form action="../Salir" method="post" name="cursos">
		<h3>¿Estás seguro? ${sessionScope.user}</h3>
		<button>Si</button>
	</form>
</body>
</html>