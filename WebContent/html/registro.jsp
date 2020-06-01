<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />

<body>
<!-- header -->
			<header>
				<!-- navigation -->
				<nav class="navbar navbar-default" role="navigation">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"><img class="img-responsive" src="img/logo.png" alt="Logo" /></a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="index.jsp">Home</a></li>
								<li><a href="cursos.jsp">Cursos</a></li>
								<li><a href="#opiniones">Opiniones</a></li>
								<li><a href="login.jsp">Entrar</a></li>
							</ul>
						</div><!-- /.navbar-collapse -->
					</div><!-- /.container-fluid -->
				</nav>
			</header>
	
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