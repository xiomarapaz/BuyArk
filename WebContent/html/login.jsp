<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<jsp:include page="head.jsp" /> 
<jsp:include page="header.jsp" /> 

<body>
<div class="container">		
		<div class="row">
			<div class="col-md-8 col-sm-6">
			<!-- heading -->
			<h3>Acceso a usuarios</h3>
				<form action="../login" method="post">
				<div class="form-group">
					<label for="user">Usuario:</label>
					<input class="form-control" type="text" name="user" placeholder="username" />
				</div>

				<div class="form-group">
					<label for="password">Contraseña:</label>
					<input class="form-control" type="password" name="pass" placeholder="password" />
				</div>
				<div class="form-group">
					<button type="submit" name="submit" id="submit" class="btn btn-default">Entrar</button>
					<a class="dropdown-item" href="registro.jsp">Darse de alta</a>
				</div>
				</form>
			</div>
		</div>
		<div>
			<jsp:include page="footer.jsp" /> 
		</div>
</div>
</body>
	
</html>