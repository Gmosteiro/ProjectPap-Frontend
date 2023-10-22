<%-- 
    Document   : eliminarRegistro
    Created on : 11 oct. 2023, 18:49:59
    Author     : santi
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eliminar Registro</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Eliminar Registro</h1>
        
        <% if (request.getAttribute("elementosExistentes") != null && !(boolean) request.getAttribute("elementosExistentes")) { %>
    <div class="alert alert-danger mt-3" role="alert">
        Uno o más elementos proporcionados no existen en la base de datos.
    </div>
<% } else if (request.getAttribute("alta") != null && (boolean) request.getAttribute("alta")) { %>
    <div class="alert alert-primary mt-3" role="alert">
        Registro dado de alta con éxito. ya que no existia uno
    </div>
<% } else if (request.getAttribute("eliminado") != null && (boolean) request.getAttribute("eliminado")) { %>
    <div class="alert alert-primary mt-3" role="alert">
        Registro eliminado con éxito. Haz <a href="consultardicClase.jsp" class="alert-link">clic aquí</a> para ir a la consulta de clases.
    </div>
<% } %>


        <form action="EliminarRegistro" method="post">
            <div class="form-group">
                <label for="nombreInstitucion">Nombre Institución:</label>
                <input type="text" class="form-control" id="nombreInstitucion" name="nombreInstitucion" required>
            </div>
            <div class="form-group">
                <label for="nombreActividad">Nombre Actividad:</label>
                <input type="text" class="form-control" id="nombreActividad" name="nombreActividad" required>
            </div>
            <div class="form-group">
                <label for="nombreClase">Nombre Clase:</label>
                <input type="text" class="form-control" id="nombreClase" name="nombreClase" required>
            </div>
            <input type="hidden" name="nicknameSocio" value="<%=usuarioLogeado.getNickname()%>">
            <button type="submit" class="btn btn-primary">Eliminar Registro</button>
        </form>
    </div>
</body>
</html>
<%@include file="footer.jsp"%>
