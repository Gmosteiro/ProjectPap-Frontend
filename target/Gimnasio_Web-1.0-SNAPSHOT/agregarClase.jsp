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
<title>Gimnasio | Agregar Socio</title>
<%@include file="/header.jsp" %>
</head>
<body>
<h1>Agregar Clase</h1>
	<form action="continuarAgregarClase.jsp" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">ID</label> <input type="text"
				name="idClase" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp"
				placeholder="Ingrese un ID para la clase">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Nombre</label> <input type="text"
				name="nomClase" class="form-control" id="exampleInputPassword1"
				placeholder="Ingrese un nombre para la clase">
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Turno</label>
			</div>
			<select class="custom-select" id="inputGroupSelect01" name="turnoClase">
				<option selected>Debe elegir un turno</option>
				<option value="manana">Mañana</option>
				<option value="tarde">Tarde</option>
				<option value="noche">Noche</option>
			</select>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Tipo de Clase</label>
			</div>
			<select class="custom-select" id="inputGroupSelect01" name="tipoClase">
				<option selected>Indique el tipo de clase</option>
				<option value="entrenamiento">Entrenamiento</option>
				<option value="spinning">Spinning</option>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">Continuar</button>
	</form>
	<%
	String id=request.getParameter("idClase");
	String nombre=request.getParameter("nomClase");	
	String turno=request.getParameter("turnoClase");
	String tipo=request.getParameter("tipoClase");
	%>
    <%@include file="/footer.jsp" %>
</body>
</html>