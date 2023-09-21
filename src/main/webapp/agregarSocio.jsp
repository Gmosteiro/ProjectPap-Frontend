<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"/>
<title>Gimnasio | Agregar Socio</title>
<%@include file="/header.jsp" %>
</head>
<body>
    
	<h1>Agregar Socio</h1>
	<form action="AgregarSocio" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Nombre</label> <input type="text" name="nomSocio"
				class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Ingrese el nombre del socio">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Cédula</label> <input type="text" name="cedSocio"
				class="form-control" id="exampleInputPassword1"
				placeholder="Documento de identidad del socio">
		</div>
		<button type="submit" class="btn btn-primary">Agregar Socio</button>
	</form>

	<%@include file="/footer.jsp" %>

</body>
</html>