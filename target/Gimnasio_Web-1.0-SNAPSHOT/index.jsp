<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Iniciar Sesión</title>
    <link rel="userIcon" href="imagenes/UserIcon.png" />
</head>

<body>
    <header class="intro"></header>
    <main>
        <article>
            <div class="container" style="margin-top: 10%;">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="text-center">
                            <img src="GetImage?imageName=UserIcon.jpg" width="150" height="150" />
                            <h4 style="margin-bottom: 20px;">Iniciar Sesión</h4>
                        </div>
                        <form action="Login" method="POST">
                            <div class="form-group">
                                <input type="text" class="form-control" id="email1" name="email" placeholder="Nickname..." />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="password1" name="password" placeholder="Contraseña..." />
                            </div>
                            <button type="submit" class="btn btn-info btn-block btn-round">Iniciar</button>
                        </form>
                    </div>
                </div>
            </div>
        </article>
    </main>
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <%@include file="/footer.jsp" %>
</body>

</html>
