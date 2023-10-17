<%-- 
    Document   : RankingClases
    Created on : 17 oct. 2023, 20:23:49
    Author     : santi
--%>
<%@ page import="java.util.List" %>
<%@ page import="logic.Clase.controllers.ControllerRanking" %>
<%@ page import="logic.Clase.Clase" %>
<%@include file="/header.jsp" %>

<div class="container mt-4">
    <h2>Ranking de Dictado de Clases</h2>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Fecha</th>
                <th scope="col">URL</th>
            </tr>
        </thead>
        <tbody>
            <%
                ControllerRanking controllerRanking = new ControllerRanking();
                List<Clase> rankingClases = controllerRanking.obtenerRankingDeClases();
                controllerRanking.closeEntityManagerFactory();
                
                for (Clase clase : rankingClases) {
            %>
                <tr>
                    <td><%= clase.getNombre() %></td>
                    <td><%= clase.getFecha() %></td>
                    <td><a href="<%= clase.getUrl() %>">Enlace</a></td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>

<%@include file="/footer.jsp" %>
