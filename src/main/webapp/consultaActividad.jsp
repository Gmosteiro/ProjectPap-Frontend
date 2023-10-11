<%-- 
    Document   : consultaActividad
    Created on : 10 oct. 2023, 22:56:46
    Author     : santi
--%>


<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
    <title>Consulta de Actividad</title>
    <%@include file="/header.jsp" %>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var form = document.getElementById('consulta-form');
            form.addEventListener('submit', function (e) {
                e.preventDefault();
                var nombreActividad = document.querySelector('input[name="nombreActividad"]').value;

                var xhr = new XMLHttpRequest();
                xhr.open('GET', 'consultaActividades?nombreActividad=' + nombreActividad, true);

                xhr.onload = function () {
                    if (xhr.status >= 200 && xhr.status < 400) {
                        var responseHTML = xhr.responseText;
                        var tablaContainer = document.getElementById('tabla-container');
                        tablaContainer.innerHTML = responseHTML;

                        // Fetch classes associated with the activity
                        fetch('getClases?nombreActividad=' + nombreActividad)
                            .then(response => response.text())
                            .then(data => {
                                document.getElementById('clases-container').innerHTML = data;
                            })
                            .catch(error => console.error('Error en la solicitud:', error));
                    } else {
                        console.error('Error en la petición');
                    }
                };

                xhr.send();
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <div class="user-options-cust mt-4">
            <h2>Consulta de Actividad Deportiva</h2>
            <form id="consulta-form" action="consultaActividades" method="get">
                <input type="text" name="nombreActividad" placeholder="Nombre de la Actividad" required>
                <input type="submit" value="Consultar Actividad">
            </form>
            <div id="tabla-container"></div>
        </div>

        <!-- Tabla de Clases Asociadas -->
        <div id="clases-container" class="mt-4"></div>
    </div>
    <%@include file = "footer.jsp" %>
</body>
</html>
