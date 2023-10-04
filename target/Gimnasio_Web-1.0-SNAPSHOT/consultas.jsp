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
<title>Gimnasio | Consultas</title>
<%@include file="/header.jsp" %>
</head>
<body>
	<h1>Consultar información de las clases</h1>
	<form action="Consultas" method="post">
		<input type="hidden" name="boton" id="boton" value="">
		<div class="form-group">
			<label for="exampleInputPassword1">ID Clase</label> <input type="text"
				name="idClase" class="form-control" id="exampleInputPassword1"
				placeholder="Documento de identidad del socio">
		</div>
		<button type="button" class="btn btn-primary"
			onclick="procesar('socios')">Ver Socios</button>
		<button type="button" class="btn btn-primary"
			onclick="procesar('clase')">Datos de la clase</button>
	</form>
	<script type="text/javascript">
		function procesar(tipo) {
			document.getElementById("boton").value = tipo;
			document.forms[0].submit();
		}
	</script>
	<%@include file = "footer.jsp" %>
</body>
</html>