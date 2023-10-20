document.addEventListener('DOMContentLoaded', function () {

    const actividadSelect = document.getElementById('actividad');
    const buscarClasesButton = document.getElementById('buscarClasesButton');

    // Agrega un controlador de eventos al botón
    buscarClasesButton.addEventListener('click', function () { // Obtén el valor seleccionado en el select

        debugger
        const actividadSeleccionada = actividadSelect.value;
if(actividadSeleccionada !== null && actividadSeleccionada !== "Select"){

        // Realiza una solicitud fetch al servlet GetClases
        fetch('GetClases?nombreActividad=' + actividadSeleccionada).then((response) => {
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
    }
    });


})
