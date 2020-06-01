<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
	<body>
	
		<div class="wrapper">
		
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
			
			<!-- banner -->
			<div class="banner">
				<div class="container">
					<!-- heading -->
					<h2>Bienvenid@ ${sessionScope.user} a BuyArk</h2>
					<!-- sub heading -->
					<h3>¡Mira algún curso que te interese!</h3>
					<!-- access button -->
					<a href="registro.jsp" class="btn btn-default">Darse de alta</a>
				</div>
			</div>
			<!-- banner end -->
			
			<!-- works -->
			<div class="works" id="cursos">
				<div class="container">
					<!-- default heading -->
					<div class="default-heading">
						<!-- heading -->
						<h2>Nuestros cursos</h2>
						<!-- paragraph -->
						<p>Esperemos que encuentres lo que te apasione.</p>
					</div>
					<div class="row">
						<div class="col-md-4">
							<!-- work item -->
							<div class="work-item">
								<!-- work details image -->
								<img class="img-responsive" src="img/cursos/react.svg" alt="" />
								<!-- heading -->
								<h3>Curso de React</h3>
							</div>
						</div>
						<div class="col-md-4">
							<!-- work item -->
							<div class="work-item">
								<!-- work details image -->
								<img class="img-responsive" src="img/cursos/git.png" alt="" />
								<!-- heading -->
								<h3>Curso de GIT</h3>
							</div>
						</div>
						<div class="col-md-4">
							<!-- work item -->
							<div class="work-item">
								<!-- work details image -->
								<img class="img-responsive" src="img/cursos/python.jpg" alt="" />
								<!-- heading -->
								<h3>Curso de Python</h3>
							</div>
						</div>
						<div class="col-md-4">
							<!-- work item -->
							<div class="work-item">
								<!-- work details image -->
								<img class="img-responsive" src="img/cursos/kotlin.svg" alt="" />
								<!-- heading -->
								<h3>Curso de Kotlin</h3>
							</div>
						</div>
						<div class="col-md-4">
							<!-- work item -->
							<div class="work-item">
								<!-- work details image -->
								<img class="img-responsive" src="img/cursos/mongo.png" alt="" />
								<!-- heading -->
								<h3>Curso de MongoDB</h3>
							</div>
						</div>
						<div class="col-md-4">
							<!-- work item -->
							<div class="work-item">
								<!-- work details image -->
								<img class="img-responsive" src="img/cursos/java.svg" alt="" />
								<!-- heading -->
								<h3>Curso de Java</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- contact -->
			<div class="contact" id="opiniones">
				<div class="container">
					<!-- default heading -->
					<div class="default-heading">
						<!-- heading -->
						<h2>Tu opinion es importante</h2>
						<!-- paragraph -->
					</div>
					<!-- contact container -->
					<div class="contact-container">	
						<div class="row">
							<div class="col-md-8 col-sm-6">
								<!-- heading -->
								<h3>Expresate</h3>
								
								<form action="../Cursos" method="get" name="comment">
									<div class="form-group">
										<label for="contactName">Usuario</label>
										<input class="form-control" type="text" name="nickname" placeholder="Indica tu usuario" value=${sessionScope.user} >
									</div>
									<div class="form-group">
										<label for="contactMessage">Mensaje</label>
										<textarea class="form-control" name="comentario" rows="3" placeholder="Escribe tu opinión"></textarea>
									</div>
									<div class="form-group">
										<button type="submit" name="submit" id="submit" class="btn btn-default">Enviar mensaje</button>
									</div>
								</form>
							</div>
							<div class="col-md-4">
								<img class="img-responsive map" src="img/opinion.jpg" alt="" />
							</div>
						</div>
					</div>
				</div>
			</div>
			
		<jsp:include page="footer.jsp" /> 

		</div>
		
		
		<!-- Javascript files -->
		<!-- jQuery -->
		<script src="js/jquery.js"></script>
		<!-- Bootstrap JS -->
		<script src="js/bootstrap.min.js"></script>
		<!-- Respond JS for IE8 -->
		<script src="js/respond.min.js"></script>
		<!-- HTML5 Support for IE -->
		<script src="js/html5shiv.js"></script>
		<!-- Custom JS -->
		<script src="js/custom.js"></script>
	</body>	
</html>