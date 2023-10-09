<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<link
			rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
			crossorigin="anonymous"
		/>
		<title>Mi Perfil</title>
		<%@include file="/header.jsp" %>
	</head>
	<body>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-8">
					<h1 class="mt-5">Mi Perfil</h1>
				</div>
				<div class="col-md-4 text-center">
					<img
						class="img-fluid rounded-circle"
						src="./descargar.png"
						style="max-width: 100px; max-height: 100px"
						alt="Imagen de Perfil"
					/>
				</div>
			</div>
			<div class="user-info mt-4">
				<h2>Datos Basicos del Usuario</h2>
				<table class="table table-bordered">
					<tr>
						<td>Nickname:</td>
						<td>Juan123</td>
					</tr>
					<tr>
						<td>Email:</td>
						<td>juan@example.com</td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td>Juan</td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td>Perez</td>
					</tr>
					<tr>
						<td>Fecha de Nacimiento:</td>
						<td>01/01/1990</td>
					</tr>
				</table>
			</div>
			<div class="user-options-cust mt-4">
				<h2>Opciones de Consulta</h2>
				<ul class="list-group">
					<li class="list-group-item" id="consultar-clases-custom">
						Consultar Clases
						<div class="clases-info-custom mt-2" style="display: none">
							<h3>Informacion de Clases</h3>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Actividad Deportiva</th>
										<th>Descripcion</th>
										<th>Duracion</th>
										<th>Costo</th>
										<th>Fecha de Registro</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Actividad 1</td>
										<td>Descripcion de Actividad 1</td>
										<td>60 minutos</td>
										<td>$50.00</td>
										<td>2023-09-20</td>
									</tr>
									<!-- Agrega mas filas según sea necesario -->
								</tbody>
							</table>
						</div>
					</li>
					<li class="list-group-item" id="consultar-actividades-custom">
						Consultar Actividades Deportivas
						<div class="actividades-info-custom mt-2" style="display: none">
							<h3>Informacion de Actividades Deportivas</h3>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Fecha</th>
										<th>Fecha de Registro</th>
										<th>Hora</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Clase 1</td>
										<td>2023-10-10</td>
										<td>2023-09-15</td>
										<td>10:00 AM</td>
									</tr>
									<!-- Agrega mas filas según sea necesario -->
								</tbody>
							</table>
						</div>
					</li>
				</ul>
			</div>
		</div>

		<script>
			// JavaScript para mostrar u ocultar la informacion de Clases y Actividades Deportivas
			document.addEventListener('DOMContentLoaded', function () {
				var consultarClases = document.getElementById('consultar-clases-custom')
				var clasesInfo = document.querySelector('.clases-info-custom')
				var consultarActividades = document.getElementById('consultar-actividades-custom')
				var actividadesInfo = document.querySelector('.actividades-info-custom')

				consultarClases.addEventListener('click', function () {
					if (clasesInfo.style.display === 'none') {
						clasesInfo.style.display = 'block'
						document.getElementById('consultar-clases-custom').value = ''
					} else {
						clasesInfo.style.display = 'none'
						document.getElementById('consultar-clases-custom').value = 'Consultar Clases'
					}
					// clasesInfo.style.display = clasesInfo.style.display === 'none' ? 'block' : 'none'
				})

				consultarActividades.addEventListener('click', function () {
					if (actividadesInfo.style.display === 'none') {
						debugger
						actividadesInfo.style.display = 'block'
						document.getElementById('consultar-actividades-custom').value = ''
					} else {
						actividadesInfo.style.display = 'none'
						document.getElementById('consultar-actividades-custom').value = 'Consultar Actividades'
					}
					// actividadesInfo.style.display = actividadesInfo.style.display === 'none' ? 'block' : 'none'
				})
			})
		</script>
	</body>
	<%@include file = "footer.jsp" %>
</html>
