<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
		<style>
			body {
				padding-bottom: 60px;
			}

			.tag-editar {
				align-self: center;
				margin-left: 56%;
			}

			.tag-editar:hover {
				color: blue;
				cursor: pointer;
			}
		</style>
		<%@include file="/header.jsp" %>
	</head>

	<body>
		<div class="container" style="margin-bottom: 50px">
			<div class="row align-items-center">
				<div class="col-md-8">
					<h1 class="mt-5">Mi Perfil</h1>
				</div>
				<% logic.Usuario.Sesion usuario=(logic.Usuario.Sesion)
				request.getSession().getAttribute("usuarioLogeado"); %>
				<div class="col-md-4 text-center">
					<img
						class="img-fluid rounded-circle"
						src="data:image/png;base64, <%= usuario.getProfileImageBase64() %>"
						style="max-width: 100px; max-height: 100px"
						alt="Imagen de Perfil"
					/>
				</div>
			</div>
			<div class="user-info mt-4">
				<div style="display: inline-flex; width: 100%">
					<h2>Datos Básicos del Usuario</h2>
					<a class="tag-editar">Editar Perfil</a>
				</div>

				<table class="table table-bordered">
					<tr>
						<td>Nickname:</td>
						<td id="userNickname"><%= usuario.getNickname() %></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><%= usuario.getEmail() %></td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td><%= usuario.getNombre() %></td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><%= usuario.getApellido() %></td>
					</tr>
					<tr>
						<td>Fecha de Nacimiento:</td>
						<td><%= usuario.getFechaNacimiento()%></td>
					</tr>
					<tr>
						<td>Tipo de Usuario:</td>
						<td id="userType"><%= usuario.getUserType()%></td>
					</tr>
				</table>
			</div>
			<div class="user-options-cust mt-4" style="margin-bottom: 15px">
				<h2>Informacion Asociada</h2>
				<ul class="list-group">
					<li class="list-group-item" id="consultar-clases-custom">
						Ver Clases
						<div class="clases-info-custom mt-2" style="display: none">
							<h3>
								<% if (usuario.getUserType().equals("Profesor")) { out.println("Clases Dictadas"); }
								else { out.println("Clases Registradas"); } %>
							</h3>
							<div id="tablaClases"></div>
						</div>
					</li>

					<% if(usuario.getUserType().equals("Profesor")){ %>
					<li class="list-group-item" id="consultar-actividades-custom">
						Ver Actividades Deportivas
						<div class="actividades-info-custom mt-2" style="display: none">
							<h3>Actividades Deportivas Asociadas</h3>
							<div id="tablaActividades"></div>
						</div>
					</li>
					<%}%>
				</ul>
			</div>
		</div>
		<%@include file="/footer.jsp" %>
	</body>
</html>

<script>
	document.addEventListener('DOMContentLoaded', function () {
		var consultarClases = document.getElementById('consultar-clases-custom')
		var clasesInfo = document.querySelector('.clases-info-custom')
		var consultarActividades = document.getElementById('consultar-actividades-custom')
		var actividadesInfo = document.querySelector('.actividades-info-custom')

		consultarClases.addEventListener('click', function () {
			if (clasesInfo.style.display === 'none') {
				clasesInfo.style.display = 'block'
			} else {
				clasesInfo.style.display = 'none'
			}
		})

		consultarActividades.addEventListener('click', function () {
			if (actividadesInfo.style.display === 'none') {
				actividadesInfo.style.display = 'block'
			} else {
				actividadesInfo.style.display = 'none'
			}
		})
	})

	window.addEventListener('load', function getClasesAsociadas() {
		const userNickname = document.getElementById('userNickname').innerText
		debugger

		fetch('getClases?nickname=' + userNickname)
			.then((response) => {
				if (!response.ok) {
					throw new Error('La solicitud a getClases falló')
				}
				return response.text()
			})
			.then((data) => {
				document.getElementById('tablaClases').innerHTML = data
			})
			.catch((error) => {
				console.error('Error en la solicitud:', error)
			})
	})

	window.addEventListener('load', function getActividadesAsociadas() {
		const userType = document.getElementById('userType').innerText

		if (userType !== 'Profesor') return

		const userNickname = document.getElementById('userNickname').innerText

		debugger

		fetch('consultaActividades?nicknameUsuario=' + userNickname)
			.then((response) => {
				if (!response.ok) {
					throw new Error('La solicitud a ConsultaActividad falló')
				}
				return response.text()
			})
			.then((data) => {
				document.getElementById('tablaActividades').innerHTML = data
			})
			.catch((error) => {
				debugger
				console.error('Error en la solicitud:', error)
			})
	})
</script>
