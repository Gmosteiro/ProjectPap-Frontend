<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="logic.Clase.Clase" %>
<%@ page import="logic.ActividadDeportiva.ActividadDeportiva" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous" />
<title>Gimnasio | Alta de Clase</title>
<%@include file="/header.jsp" %>
</head>
    <body>
    <h1>Alta de Clase</h1>
        <form action="GestionClase" method="post">
            <div class="row">
                <div class="col-md-3">
                    <label for="institucion">Institucion:</label>
                    <select class="form-select form-select-lg mb-3" id="institucion" name="institucion"></select>
                </div>
                <div class="col-md-3">
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
            <input type="hidden" name="boton" id="boton" value="">
            <div class="row">
                <div class="col-md-3">
                <label for="profeso">Profesor:</label>
                     <select class="form-select form-select-lg mb-3" id="profeso" name="profeso">
                         <option></option>
                     </select>
                </div>
                <div class="form-group">
                    <label for="nombreClase">Nombre de la Clase</label>
                    <input type="text" name="nombreClase" class="form-control col-3" id="nombreClase" placeholder="Ingrese el nombre de la clase">
                </div>
                <div class="col-md-3">
                    <label for="imagen">Seleccionar Imagen:</label>
                    <input type="file" class="form-control-file" id="imagen" name="imagen">
                </div>
            </div>
            <div class="form-group">
                <label for="fechaHoraInicio">Fecha y Hora de Inicio</label>
                <input type="datetime-local" name="fechaHoraInicio" class="form-control col-3" id="fechaHoraInicio">
            </div>
            <div class="form-group">
                <label for="urlAsociada">URL Asociada</label>
                <input type="text" name="urlAsociada" class="form-control col-3" id="urlAsociada" placeholder="URL relacionada a la clase">
            </div>
            <button type="button" class="btn btn-success" onclick="procesar('alta')">Dar de Alta Clase</button>
            <button type="button" class="btn btn-primary" onclick="procesar('modificar')">Modificar Clase</button>
            <button type="button" class="btn btn-danger" onclick="procesar('cancelar')">Cancelar</button>
        </form>
    <script type="text/javascript">
        function procesar(tipo) {
            document.getElementById("boton").value = tipo;
            document.forms[0].submit();
        }
    </script>
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
    <%@include file = "footer.jsp" %>
</body>
</html>