<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous"
/>
<%@ page import="java.util.Base64" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <% logic.Usuario.Sesion usuarioLogeado=(logic.Usuario.Sesion)
				request.getSession().getAttribute("usuarioLogeado"); if (usuarioLogeado !=null) { %>
	<div class="container-fluid">
		<a class="navbar-brand" style="margin-right: 25%; margin-left: 10%" href="menuPrincipal.jsp">GymPap</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
			aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		 <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link <%= (request.getRequestURI().endsWith("menuPrincipal.jsp")) ? "active" : "" %>" href="menuPrincipal.jsp">Inicio</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle <%= (request.getRequestURI().contains("gestionInscripcion.jsp")) ? "active" : "" %>" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Clases</a>
                            <ul class="dropdown-menu">
                                <% if (usuarioLogeado != null && usuarioLogeado.getUserType() == "Profesor") { %>
                                    <li><a class="dropdown-item" href="gestionInscripcion.jsp">Registrar dictado de clase</a></li>
                                    <li><a class="dropdown-item" href="consultardicClase.jsp">Consultar dictado de clase</a></li>
                                    <li><a class="dropdown-item" href="#">Ranking de socios en clases</a></li>
                                <% } else { %>  
                                    <li><a class="dropdown-item" href="gestionInscripcion.jsp">Registrar a clase</a></li>
                                    <li><a class="dropdown-item" href="#">Eliminar registro a clase</a></li>
                                <% } %>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle <%= (request.getRequestURI().contains("algo2")) ? "active" : "" %>" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Actividades Deportivas</a>
                            <ul class="dropdown-menu">
                                <% if (usuarioLogeado != null && usuarioLogeado.getUserType() == "Profesor") { %>
                                    <li><a class="dropdown-item" href="#">Ranking de clases en Actividades</a></li>
                                <% } %>
                                <li><a class="dropdown-item" href="#">Consultar actividad deportiva</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
		<div class="navbar-nav">
			<img
			src="data:image/png;base64, <%= imagenBase64 %>"
			alt="Imagen"
			style="width: 40px; height: 40px; border-radius: 50%"
		/>
				<a class="user-nav-link">
					<%= usuarioLogeado.getNombre() + " " + usuarioLogeado.getApellido() %>
				</a>
				<div id="user-options" class="user-options">
					<a class="user-options-a" href="consultaUsuario.jsp?userNickname=user">Tu Cuenta</a>
					<a class="user-options-a" href="CerrarSesion">Cerrar Sesion</a>
				</div>
				<% } else { %>
					<script>
						window.location.href = "/Gimnasio_Web/index.jsp"; // Redirigir al usuario a la página de inicio de sesión
					</script>
					<% } %>
					
			
			
		</div>
	</div>
</nav>

<style>
	.user-nav-link {
		display: block;
		padding: var(--bs-nav-link-padding-y) var(--bs-nav-link-padding-x);
		font-size: var(--bs-nav-link-font-size);
		font-weight: var(--bs-nav-link-font-weight);
		color: var(--bs-nav-link-color);
		text-decoration: none;
		background: 0 0;
		border: 0;
		transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out;
	}

	.user-options {
		display: none;
		position: absolute;
		background-color: white;
		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
		z-index: 1;
		margin-top: 40px;
		width: inherit;
	}

	.user-options-a {
		min-width: 200px;
	}

	.user-options:hover {
		display: block;
	}

	.user-nav-link:hover {
		cursor: pointer;
		color: blue;
		background-color: grey;
	}

	.user-nav-link:hover + .user-options {
		display: block;
	}

	.user-options a {
		display: block;
		padding: 10px;
		text-decoration: none;
		color: black;
	}

	.user-options a:hover {
		background-color: #f2f2f2;
	}

	.user-options.show {
		display: block;
	}
</style>
