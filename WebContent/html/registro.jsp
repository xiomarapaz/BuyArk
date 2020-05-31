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
			<h3>Nuevo usuario</h3>
				<form action="../registro" method="post">
				<div class="form-group">
					<label for="user">*Usuario:</label>
					<input class="form-control" type="text" id="user" name="user" placeholder="username" />
				</div>
				<div class="form-group">
					<label for="email">*Email:</label>
					<input class="form-control" type="email" id="email" name="email" placeholder="example@google.com" />
				</div>
				<div class="form-group">
					<label for="password">*Contraseña:</label>
					<input class="form-control" type="password" id="pass" name="pass" placeholder="password" />
		      		<p>Utiliza mínimo 8 caracteres alfanumericos, incluir mayusculas y minusculas <p>
				</div>
				<div class="form-group">
					<button type="submit" name="submit" id="submit" class="btn btn-default">Registrar</button>
					<a class="dropdown-item" href="login.jsp">Tienes ya una cuenta?</a>
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