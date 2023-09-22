<%-- 
    Document   : altaActividad
    Created on : 21 set. 2023, 21:03:35
    Author     : santi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alta Actividad</title>
</head>
<body>
    <form action="AltaActividad" method="post" enctype="multipart/form-data">
        Nombre: <input type="text" name="nombre"><br>
        Descripción: <input type="text" name="descripcion"><br>
        Duración (minutos): <input type="text" name="duracion"><br>
        Costo: <input type="text" name="costo"><br>
        Fecha de Registro: <input type="date" name="fechaRegistro"><br>
        Imagen: <input type="file" name="imagen"><br>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>
