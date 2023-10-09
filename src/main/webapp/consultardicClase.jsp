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
    <form action="GetActividades" method="Post">
        <label for="institucion">Institucion:</label>
            <select class="form-select form-select-lg mb-3" id="institucion" name="institucion">
            </select>
        <button type="submit" class="btn btn-info btn-block btn-round">Buscar Actividades</button>
    </form>
  <form action="GetClases" method="Post">
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
        <button type="submit" class="btn btn-info btn-block btn-round">Buscar Clases</button>
      <table id="miTabla" border="1" class="table table-dark table-striped table-hover">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Fecha de inicio</th>
                    <th>Hora de inicio</th>
                    <th>URL</th>
                </tr>
            </thead>
            <tbody>
               <% List<Clase> clases = (List<Clase>) request.getAttribute("clases"); // Obtén la lista de clases desde el atributo de solicitud
                    if (clases != null) {
                        for (Clase clase : clases) {
                %>
                <tr>
                    <td><%= clase.getNombre() %></td>
                    <td><%= clase.getFecha() %></td>
                    <td><%= clase.getHora() %></td>
                    <td><%= clase.getUrl() %></td>
                </tr>
                    <% 
                           }
                       }
                    %>
            </tbody>
        </table>
                <div>
                    <div class="container" style="margin-bottom: 50px">
                        <div class="row align-items-center">
                            <div class="col-md-8">
                                <h1 class="mt-5">Clase</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="user-info mt-4">
                                    <h2>Datos Básicos de la Clase</h2>
                                    <table class="table table-bordered">
                                        <tr>
                                            <td>Nombre:</td>
                                            <td id="nombrec"></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha:</td>
                                            <td id="fechac"></td>
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
                                <table class="table table-dark table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>Socios</th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
        <script>
            var filas = document.querySelectorAll("#miTabla tbody tr");

            filas.forEach(function(fila) {
                fila.addEventListener("click", function() {
                    var nombre = fila.cells[0].textContent;
                    var fechaInicio = fila.cells[1].textContent;
                    var horaInicio = fila.cells[2].textContent;
                    var url = fila.cells[3].textContent;
                    document.getElementById("nombrec").textContent = nombre;
                    document.getElementById("fechac").textContent = fechaInicio;
                    document.getElementById("horac").textContent = horaInicio;
                    document.getElementById("urlc").textContent = url;
                });
            });
        </script>
    </form>  
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
<%@include file = "footer.jsp" %>
</body>
</html>