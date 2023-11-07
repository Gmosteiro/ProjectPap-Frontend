<%-- 
    Document   : rankingActividades
    Created on : 17 oct. 2023, 19:37:17
    Author     : santi
--%>

<%@ page import="java.util.List" %>
<%@iclude file="publicadores.ControladorPublish" %>
<%@iclude file="publicadores.PublishServiceLocator" %>

<%@include file="/header.jsp" %>


<div class="container mt-4">
    <h2>Ranking de Actividades Deportivas</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Costo</th>
                <th scope="col">Descripción</th>
                <th scope="col">Imagen</th>
            </tr>
        </thead>
        <tbody>
        
           
        </tbody>
    </table>
</div>
<%@include file="/footer.jsp" %>
