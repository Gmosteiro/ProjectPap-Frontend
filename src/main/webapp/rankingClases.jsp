<%-- 
    Document   : RankingClases
    Created on : 17 oct. 2023, 20:23:49
    Author     : santi
--%>
<%@ page import="java.util.List" %>
<%@ page import="publicadores.ControladorPublish"%>
<%@ page import="publicadores.ControladorPublishServiceLocator"%>
<%@ page import="publicadores.DtClase"%>

<%@include file="/header.jsp" %>

<div class="container mt-4">
    <h2>Ranking de Dictado de Clases</h2>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Fecha</th>
                <th scope="col">URL</th>
                <th scope="col">Imagen</th>
            </tr>
        </thead>
        <tbody>
            <% 
                ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
                ControladorPublish port = cps.getControladorPublishPort();

                // Obtener el ranking de clases
                DtClase[] rankingClases = port.obtenerRankingDeClases();

                if (rankingClases != null) {
                    for (DtClase clase : rankingClases) {
            %>
                        <tr>
                            <td><%= clase.getNombre() %></td>
                            <td><%= clase.getFecha() %></td>
                            <td><%= clase.getUrl() %></td>
                            <td><img src="data:image/png;base64,<%= clase.getImagen() %>" style="width: 40px; height: 40px; border-radius: 50%;" /></td>
                        </tr>
            <% 
                    }
                } else {
            %>
                    <tr>
                        <td colspan="4">No se encontraron clases</td>
                    </tr>
            <% 
                }
            %>
        </tbody>
    </table>
</div>

<%@include file="/footer.jsp" %>
