<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<title>Gimnasio | Agregar Clase</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
		class="navbar-brand" href="#">MenuGym</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Homepage
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="agregarSocio.jsp">Agregar
					Socio</a></li>
			<li class="nav-item"><a class="nav-link" href="agregarClase.jsp">Agregar
					Clase</a></li>
			<li class="nav-item"><a class="nav-link"
				href="gestionInscripcion.jsp">Inscripciones</a></li>
			<li class="nav-item"><a class="nav-link"
				href="consultas.jsp">Consultas</a></li>
		</ul>
	</div>
	</nav>

	<%
		String id = request.getParameter("idClase");
		String nombre = request.getParameter("nomClase");
		String turno = request.getParameter("turnoClase");
		String tipo = request.getParameter("tipoClase");
	%>
	<h1>Agregar Clase</h1>
	<p class="lead">
  Continuemos con el alta de la clase <%=nombre%> de ID <%=id%>
</p>
	<form action="AgregarClase" method="post">
		<input type="hidden" name="idClase" value="<%=id%>">
		<input type="hidden" name="nomClase" value="<%=nombre%>">
		<input type="hidden" name="turnoClase" value="<%=turno%>">
		<input type="hidden" name="tipoClase" value="<%=tipo%>">
	<%if (tipo.equals("spinning")){%>
		<div class="form-group">
			<label for="exampleInputEmail1">ID</label> <input type="text"
				name="cantBicicletasClase" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp"
				placeholder="Ingrese un ID para la clase">
		</div>
	<%}else if (tipo.equals("entrenamiento")){ %>	
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">¿En la rambla?
					</label>
			</div>
			<select class="custom-select" id="inputGroupSelect01"
				name="enRamblaLaClase">
				<option selected>Indique si la clase será en la rambla</option>
				<option value="si">Si</option>
				<option value="no">No</option>
			</select>
		</div>
	<%}%>
		<button type="submit" class="btn btn-primary">Agregar Clase</button>
	</form>




	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>