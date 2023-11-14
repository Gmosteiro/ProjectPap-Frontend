<%-- 
    Document   : rankingActividades
    Created on : 17 oct. 2023, 19:37:17
    Author     : santi
--%>

<%@page import="publicadores.DtActividadDeportiva"%>
<%@ page import="java.util.List" %>
<%@ page import="publicadores.ControladorPublish"%>
<%@ page import="publicadores.ControladorPublishServiceLocator"%>

<%@include file="/header.jsp" %>

<div class="container mt-4">
    <h2>Ranking de Actividades Deportivas</h2>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Descripción</th>
                <th scope="col">Duración</th>
                <th scope="col">Costo</th>
                <th scope="col">Fecha de Registro</th>
                <th scope="col">Imagen</th>
            </tr>
        </thead>
        <tbody>
            <% 
                ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
                ControladorPublish port = cps.getControladorPublishPort();

                // Obtener el ranking de actividades deportivas
                DtActividadDeportiva[] rankingActividades = port.obtenerRankingDeActividades();

                if (rankingActividades != null) {
                    for (DtActividadDeportiva actividad : rankingActividades) {
            %>
                        <tr>
                            <td><%= actividad.getNombre() %></td>
                            <td><%= actividad.getDescripcion() %></td>
                            <td><%= actividad.getDuracion() %></td>
                            <td><%= actividad.getCosto() %></td>
                            <td><%= actividad.getFechaRegistro() %></td>
                            <td><img src="data:image/png;base64,<%= actividad.getImagen() %>" style="width: 40px; height: 40px; border-radius: 50%;" /></td>
                        </tr>
            <% 
                    }
                } else {
            %>
                    <tr>
                        <td colspan="6">No se encontraron actividades</td>
                    </tr>
            <% 
                }
            %>
        </tbody>
    </table>
</div>

<%@include file="/footer.jsp" %>
