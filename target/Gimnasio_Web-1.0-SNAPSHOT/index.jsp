<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css" />
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
                            <img src="https://static.vecteezy.com/system/resources/previews/018/765/757/original/user-profile-icon-in-flat-style-member-avatar-illustration-on-isolated-background-human-permission-sign-business-concept-vector.jpg" width="150" height="150" />
                            <h4 style="margin-bottom: 20px;">Iniciar Sesión</h4>
                        </div>
                        <form action="Login" method="POST">
                            <div class="form-group">
                                <input type="email" class="form-control" id="email1" name="email" placeholder="Email..." />
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
</body>

</html>
