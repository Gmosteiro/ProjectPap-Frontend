<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="publicadores.Clase" %>
<%@ page import="publicadores.ActividadDeportiva" %> 
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
        <div class="row">
            <div class="col-9"> <!-- Esta columna ocupará el 75% del ancho total -->
                <table id="miTabla" border="1" class="table table-striped"></table>
            </div>
            <div class="col-3"> <!-- Esta columna ocupará el 25% del ancho total -->
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Socios Registrados</th>
                        </tr>
                    </thead>
                    <tbody id="Registrados">
                        <tr>
                            <td id="nickname"></td>
                        </tr>
                    </tbody>
                </table>
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
    selectInstitucion.addEventListener('click', function() {
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
        //limpio todo que esta sucio.
//        document.getElementById('nombrec').textContent = '';
//        document.getElementById('fechac').textContent = '';
//        document.getElementById('fecharc').textContent = '';
//        document.getElementById('horac').textContent = '';
//        document.getElementById('urlc').textContent = '';
//
        // Limpia la tabla "Registrados"
        var tablaRegistrados = document.querySelector('#Registrados');
        tablaRegistrados.innerHTML = '';

        // Limpia la imagen
        //var imagenClase = document.getElementById('imagen');
        //imagenClase.src = '';
        // Obtén el valor seleccionado en el select
        var actividadSeleccionada = actividadSelect.value;
        
        // Realiza una solicitud fetch al servlet GetClases
        fetch('GetClases?nombreActividad=' + actividadSeleccionada)
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