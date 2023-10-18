<%-- 
    Document   : rankingActividades
    Created on : 17 oct. 2023, 19:37:17
    Author     : santi
--%>

<%@ page import="java.util.List" %>
<%@ page import="logic.ActividadDeportiva.ActividadDeportiva" %>
<%@ page import="logic.Clase.controllers.ControllerRanking" %>
<%@include file="/header.jsp" %>


<div class="container mt-4">
    <h2>Ranking de Actividades Deportivas</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Costo</th>
                <th scope="col">Descripción</th>
            </tr>
        </thead>
        <tbody>
            <%
                ControllerRanking controllerRanking = new ControllerRanking();
                List<ActividadDeportiva> rankingActividades = controllerRanking.obtenerRankingDeActividades();
                controllerRanking.closeEntityManagerFactory();
                
                for (ActividadDeportiva actividad : rankingActividades) {
            %>
                <tr>
                    <td><%= actividad.getNombre() %></td>
                    <td><%= actividad.getCosto() %></td>
                    <td><%= actividad.getDescripcion() %></td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
<%@include file="/footer.jsp" %>
