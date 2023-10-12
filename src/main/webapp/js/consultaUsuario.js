document.addEventListener('DOMContentLoaded', function () {
	const consultarClases = document.getElementById('consultar-clases-custom')
	const clasesInfo = document.querySelector('.clases-info-custom')
	const consultarActividades = document.getElementById('consultar-actividades-custom')
	const actividadesInfo = document.querySelector('.actividades-info-custom')
	debugger
	const buttonEditar = document.getElementById('editarBtn')

	consultarClases.addEventListener('click', function () {
		if (clasesInfo.style.display === 'none') {
			clasesInfo.style.display = 'block'
		} else {
			clasesInfo.style.display = 'none'
		}
	})

	if (consultarActividades) {
		consultarActividades.addEventListener('click', function () {
			if (actividadesInfo.style.display === 'none') {
				actividadesInfo.style.display = 'block'
			} else {
				actividadesInfo.style.display = 'none'
			}
		})
	}

	buttonEditar.addEventListener('click', function () {
		document.getElementById('nombre').style.display = 'none'
		document.getElementById('apellido').style.display = 'none'
		document.getElementById('fechaNacimiento').style.display = 'none'
		document.getElementById('nombreInput').style.display = 'inline'
		document.getElementById('apellidoInput').style.display = 'inline'
		document.getElementById('fechaNacimientoInput').style.display = 'inline'
		document.getElementById('aceptarBtn').style.display = 'inline'
		document.getElementById('editarBtn').style.display = 'none'
		document.getElementById('cancelarBtn').style.display = 'inline'
	})

	document.getElementById('cancelarBtn').addEventListener('click', function () {
		document.getElementById('nombre').style.display = 'inline'
		document.getElementById('apellido').style.display = 'inline'
		document.getElementById('fechaNacimiento').style.display = 'inline'
		document.getElementById('nombreInput').style.display = 'none'
		document.getElementById('apellidoInput').style.display = 'none'
		document.getElementById('fechaNacimientoInput').style.display = 'none'
		document.getElementById('aceptarBtn').style.display = 'none'
		document.getElementById('editarBtn').style.display = 'inline'
		document.getElementById('cancelarBtn').style.display = 'none'

		document.getElementById('nombreInput').value = document.getElementById('nombre').innerText
		document.getElementById('apellidoInput').value = document.getElementById('apellido').innerText
		document.getElementById('fechaNacimientoInput').value = document.getElementById('fechaNacimiento').innerText
	})

	document.getElementById('aceptarBtn').addEventListener('click', function () {
		const nuevoNombre = document.getElementById('nombreInput').value
		const nuevoApellido = document.getElementById('apellidoInput').value
		const nuevaFechaNacimiento = document.getElementById('fechaNacimientoInput').value
		const nuevoUserType = document.getElementById('userTypeSelect').value

		// Realizar una solicitud Fetch para enviar los datos actualizados al servidor
		fetch('/actualizarPerfil', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				nickname: nuevoNickname,
				email: nuevoEmail,
				nombre: nuevoNombre,
				apellido: nuevoApellido,
				fechaNacimiento: nuevaFechaNacimiento,
				userType: nuevoUserType
			})
		})
			.then((response) => response.json())
			.then((data) => {
				// Manejar la respuesta del servidor, por ejemplo, mostrar un mensaje de éxito
				alert('Perfil actualizado exitosamente')
			})
			.catch((error) => {
				// Manejar errores en la solicitud Fetch
				console.error('Error al actualizar el perfil:', error)
			})

		document.getElementById('nombre').style.display = 'inline'
		document.getElementById('apellido').style.display = 'inline'
		document.getElementById('fechaNacimiento').style.display = 'inline'

		document.getElementById('nombreInput').style.display = 'none'
		document.getElementById('apellidoInput').style.display = 'none'
		document.getElementById('fechaNacimientoInput').style.display = 'none'

		document.getElementById('aceptarBtn').style.display = 'none'
	})
})

window.addEventListener('load', function getClasesAsociadas() {
	const userNickname = document.getElementById('userNickname').innerText

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
			console.error('Error en la solicitud:', error)
		})
})
