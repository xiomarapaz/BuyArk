<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Acceder</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>

</head>
<body>
<div class="container mx-auto">
	<div class="row">
		<div class="row boton">
	        <!--link para el acceso al formulario del registro-->
	      		<a href="portada.jsp">
	            <button id="btn" type="button" class="btn btn-light boton">Página principal</button>
	      		</a>
	    </div>
	</div>
	
	<h1>Acceso a usuarios</h1>
	
	<div class="row mt-4">
		<form action="login" method="post">
			<label>Usuario: </label>
	      		<input type="text" name="user" placeholder="nickname"><br/>
	    
	  	    <label>Contraseña</label>
	    	  	<input type="password" name="pass" placeholder="contraseña"><br />
		
		  	<button type="submit" class="btn btn-light boton">Entrar</button><br/>
		  	<a class="dropdown-item" href="registro.jsp">Darse de alta</a>
		 </form>
	</div>

</div>
		 
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>