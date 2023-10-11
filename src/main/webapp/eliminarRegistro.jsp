<%-- 
    Document   : eliminarRegistro
    Created on : 11 oct. 2023, 18:49:59
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Registro</title>
    </head>
    <body>
        <h1>Eliminar Registro</h1>
        
        <form action="EliminarRegistro" method="post">
            <label for="nicknameSocio">Nickname Socio:</label>
            <input type="text" id="nicknameSocio" name="nicknameSocio" required><br><br>
            
            <label for="nombreClase">Nombre Clase:</label>
            <input type="text" id="nombreClase" name="nombreClase" required><br><br>
            
            <input type="submit" value="Eliminar Registro">
        </form>
    </body>
</html>

