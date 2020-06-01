<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
<body>
		<div class="works" id="cursos">
				<div class="container">
					<!-- default heading -->
					<div class="default-heading">
						<!-- heading -->
						<h2>Inscritebe en nuestros cursos</h2>
						<!-- paragraph -->
						<p>Esperemos que encuentres lo que te apasione.</p>
					</div>
					<form action="../Cursos" method="post" name="cursos">
					<h3>Selecciona tus cursos</h3>
						<div class="row">
							<div class="col-md-4">
							<!-- work item -->
								<div class="work-item">
									<!-- work details image -->
									<img class="img-responsive" src="img/cursos/react.svg" alt="" />
									<!-- heading -->
									<h3>Curso de React</h3>
									<!-- checkbox -->
									<label class="checkbox-inline"> 
										<input type="checkbox" name="image[]" value="react" /> React
									</label> 
								</div>
							</div>
							<div class="col-md-4">
								<!-- work item -->
								<div class="work-item">
									<!-- work details image -->
									<img class="img-responsive" src="img/cursos/git.png" alt="" />
									<!-- heading -->
									<h3>Curso de GIT</h3>
									<!-- checkbox -->
									<label class="checkbox-inline"> 
										<input type="checkbox" name="image[]" value="git" /> Git
									</label> 
								</div>
							</div>
							<div class="col-md-4">
								<!-- work item -->
								<div class="work-item">
									<!-- work details image -->
									<img class="img-responsive" src="img/cursos/python.jpg" alt="" />
									<!-- heading -->
									<h3>Curso de Python</h3>
									<!-- checkbox -->
									<label class="checkbox-inline"> 
										<input type="checkbox" name="image[]" value="python" /> Python
									</label> 
								</div>
							</div>
							<div class="col-md-4">
								<!-- work item -->
								<div class="work-item">
									<!-- work details image -->
									<img class="img-responsive" src="img/cursos/kotlin.svg" alt="" />
									<!-- heading -->
									<h3>Curso de Kotlin</h3>
									<!-- checkbox -->
									<label class="checkbox-inline"> 
										<input type="checkbox" name="image[]" value="kotlin" /> Kotlin
									</label> 
								</div>
							</div>
							<div class="col-md-4">
								<!-- work item -->
								<div class="work-item">
									<!-- work details image -->
									<img class="img-responsive" src="img/cursos/mongo.png" alt="" />
									<!-- heading -->
									<h3>Curso de MongoDB</h3>
									<!-- checkbox -->
									<label class="checkbox-inline"> 
									<input type="checkbox" name="image[]" value="mongo" /> MongoDB
									</label> 
								</div>
							</div>
							<div class="col-md-4">
								<!-- work item -->
								<div class="work-item">
									<!-- work details image -->
									<img class="img-responsive" src="img/cursos/java.svg" alt="" />
									<!-- heading -->
									<h3>Curso de Java</h3>
									<!-- checkbox -->
									<label class="checkbox-inline"> 
										<input type="checkbox" name="image[]" value="java" /> Java
									</label> 
								</div>
							</div>
					</div> <!-- final div class row -->
					
						<h3>Selecciona un método de pago</h3>
			               <div id="pago" class="col-md-12 col-lg-12 nopad text-center">
								<label class="radio-inline p-4">VisaCard <input type="radio" name="payment" value="credit" ></label>
								<label class="radio-inline p-4">Paypal <input type="radio" name="payment" value="paypal" ></label> 
			               </div>
                       
	                       <div class="col-md-4 col-lg-12">
	                              <label>Usuario</label>
	                             <input type="text"  name="nickname" class="form-control" id="nickname"  value=${sessionScope.user}>
	                       </div>
	                       
	                       <br>
      					
	      					<div class="col-md-4 text-center offset-3">
	                              <button type="submit" class=" btn btn-block mybtn btn-light tx-tfm ">Comprar</button>
	                       </div>
				
				</form>
				</div>
			</div>
					
		<jsp:include page="footer.jsp" />	
</body>
</html>