<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="logic.Clase.Clase" %>
<%@ page import="logic.ActividadDeportiva.ActividadDeportiva" %> 
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <link
                rel="stylesheet"
                href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                crossorigin="anonymous"
        />

        <title>Tabla desde el Backend</title>
        <%@include file="/header.jsp" %>
</head>
<body>
        <div class="row">
            <div class="col">
                <label for="institucion">Institucion:</label>
                <select class="form-select form-select-lg mb-3" id="institucion" name="institucion"></select>
            </div>
            <div class="col">
                <label for="actividad">Actividad:</label>
                <select class="form-select form-select-lg mb-3" id="actividad" name="actividad">
                   <% List<ActividadDeportiva> nombresActividades = (List<ActividadDeportiva>) request.getAttribute("nombresActividades");
                      if (nombresActividades != null) {
                          for (ActividadDeportiva actividad : nombresActividades) {
                   %>
                   <option value="<%= actividad.getNombre() %>"><%= actividad.getNombre() %></option>
                   <%
                          }
                      }
                   %>
                </select>
            </div>
        </div>
        <button id="buscarClasesButton" type="submit" class="btn btn-info btn-block btn-round">Buscar Clases</button>
      <table id="miTabla" border="1" class="table table-dark table-striped table-hover"></table>
                <div>
                    <div class="container" style="margin-bottom: 50px">
                        <div class="row align-items-center">
                            <div class="col-md-8">
                                <h1 class="mt-5">Clase</h1>
                            </div>
                            <div class="col-md-4 text-center">
                                	<div class="col-md-4 text-center">
						<img 
                                                    id="imagen"
                                                    class="img-fluid rounded-circle"
							
							style="max-width: 150px; max-height: 150px"
                                                        alt="Imagen de Clase"
                                                        />
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="user-info mt-4" style="margin-top: 0;">
                                    <h2>Datos Básicos de la Clase</h2>
                                    <table id="ClaseInfo" class="table table-bordered">
                                        <tr>
                                            <td>Nombre:</td>
                                            <td id="nombrec"></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha:</td>
                                            <td id="fechac"></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha Registro:</td>
                                            <td id="fecharc"></td>
                                        </tr>
                                        <tr>
                                            <td>Hora:</td>
                                            <td id="horac"></td>
                                        </tr>
                                        <tr>
                                            <td>Url:</td>
                                            <td id="urlc"></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="user-info mt-4" style="margin-top: 0;">
                                    <h2 class="mt-5">Socios Registrados</h2>
                                        <table id="Registrados" class="table table-dark table-striped table-hover">
                                            <tbody>
                                                <tr>
                                                    <td id="nickname"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
 <script>
    document.addEventListener('DOMContentLoaded', function() {
        var selectInstitucion = document.getElementById('institucion');

        // Realiza una solicitud fetch al servlet GetInstituciones
        fetch('GetInstituciones')
            .then(response => {
                if (!response.ok) {
                    throw new Error('No se pudo obtener los datos de instituciones');
                }
                return response.text();
            })
            .then(data => {
                var instituciones = data.split('\n');
                instituciones.forEach(function(nombre) {
                    var option = document.createElement('option');
                    option.value = nombre;
                    option.text = nombre;
                    selectInstitucion.appendChild(option);
                });
            })
            .catch(error => {
                console.error('Error al obtener datos de instituciones: ' + error);
            });
    });
</script>
<script>
    // Obtén una referencia al select de instituciones
    var selectInstitucion = document.getElementById('institucion');
    var actividadSelect = document.getElementById('actividad');  // Agrega esta línea

    // Agrega un controlador de eventos para el evento "change"
    selectInstitucion.addEventListener('change', function() {
        // Obtén el valor seleccionado en el select de instituciones
        var institucionSeleccionada = selectInstitucion.value;

        // Realiza una solicitud fetch al servlet para obtener las actividades relacionadas con la institución
        fetch('GetActividades?institucion=' + institucionSeleccionada)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al obtener actividades por institución');
                }
                return response.text(); // Suponiendo que el servidor devuelve datos en formato de texto plano
            })
            .then(data => {
                // Limpia el select de actividades
                actividadSelect.innerHTML = '';

                // Divide el resultado en líneas (supongo que cada línea es un nombre de actividad)
                var actividades = data.split('\n');

                // Agrega las nuevas opciones al select de actividades
                actividades.forEach(function(nombre) {
                    var option = document.createElement('option');
                    option.value = nombre;
                    option.text = nombre;
                    actividadSelect.appendChild(option);
                });
            })
            .catch(error => {
                console.error('Error al obtener actividades por institución: ' + error);
            });
    });
</script>
<script>
    var actividadSelect = document.getElementById('actividad');
    var buscarClasesButton = document.getElementById('buscarClasesButton');

    // Agrega un controlador de eventos al botón
    buscarClasesButton.addEventListener('click', function() {
        // Obtén el valor seleccionado en el select
        var actividadSeleccionada = actividadSelect.value;
        
        // Realiza una solicitud fetch al servlet GetClases
        fetch('GetClases?actividad=' + actividadSeleccionada)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al llamar al servlet GetClases');
                }
                return response.text();
            })
            .then(data => {
                // Procesa la respuesta del servlet si es necesario
                document.getElementById('miTabla').innerHTML = data;
                // Hacer algo con la respuesta, por ejemplo, actualizar la página
            })
            .catch(error => {
                // Maneja errores si es necesario
                console.error(error);
            });
    });
</script>
<script>
    document.addEventListener('DOMContentLoaded', function() {
    var miTabla = document.querySelector('#miTabla');
    var claseInfoTable = document.querySelector('#ClaseInfo');
    var tablaRegistrados = document.querySelector('#Registrados');
    var imagenClase = document.getElementById('imagen');
    miTabla.addEventListener('click', function(event) {
        if (event.target.tagName === 'TD') {
            var row = event.target.parentElement;
            var nombre = row.cells[0].textContent;
            var fecha = row.cells[1].textContent;
            var fechaRegistro = row.cells[2].textContent;
            var hora = row.cells[3].textContent;
            var url = row.querySelector('a').getAttribute('href');

            // Asignar los valores a las celdas de la tabla "ClaseInfo"
            document.getElementById('nombrec').textContent = nombre;
            document.getElementById('fechac').textContent = fecha;
            document.getElementById('fecharc').textContent = fechaRegistro;
            document.getElementById('horac').textContent = hora;
            document.getElementById('urlc').textContent = url;
            
            fetch('GetImagenClase?nombreClase=' + nombre)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Error al obtener la imagen de la clase');
                    }
                    return response.text();
                })
                .then(data => {
                    // Actualiza la fuente de la imagen de la clase con los datos recibidos
                    imagenClase.src = 'data:image/png;base64,' + data;
                })
                .catch(error => {
                    console.error('Error al obtener la imagen de la clase: ' + error);
                });
            
        } else {
            console.log("No se hizo clic en una fila de la tabla.");
        }
    });
});
</script>
<script>
            document.addEventListener('DOMContentLoaded', function() {
        var miTabla = document.querySelector('#miTabla');
        var tablaRegistrados = document.querySelector('#Registrados');

        miTabla.addEventListener('click', function(event) {
            if (event.target.tagName === 'TD') {
                var row = event.target.parentElement;
                var nombre = row.cells[0].textContent;

                // Realiza una solicitud fetch al servlet GetSocios con el nombre de la clase como parámetro
                fetch(`GetSocios?nombreClase=` + nombre)
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Error al obtener datos del servlet GetSocios');
                        }
                        return response.text();
                    })
                    .then(data => {
                        // Limpiar la tabla "Registrados"
                        tablaRegistrados.innerHTML = '';

                        // Dividir los datos en líneas o elementos individuales, dependiendo de su estructura
                        const elementos = data.split('\n');

                        elementos.forEach(elemento => {
                            const fila = document.createElement('tr');
                            const celda = document.createElement('td');
                            celda.textContent = elemento.trim();
                            fila.appendChild(celda);
                            tablaRegistrados.appendChild(fila);
                        });
                    })
                    .catch(error => {
                        console.error('Error al obtener datos del servlet GetSocios: ' + error);
                    });
            } else {
                console.log("No se hizo clic en una fila de la tabla.");
            }
        });
    });
</script>
<%@include file = "footer.jsp" %>
</body>
</html>