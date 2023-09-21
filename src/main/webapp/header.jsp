<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous"
/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
        <% logic.Usuario.Sesion usuarioLogeado = (logic.Usuario.Sesion)
			request.getSession().getAttribute("usuarioLogeado"); %>
	<div class="container-fluid">
    <a class="navbar-brand" style="margin-right: 25%; margin-left: 10%" href="menuPrincipal.jsp">GymPap</a>
    <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation"
    >
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
                        <li><a class="dropdown-item" href="#">Consultar dictado de clase</a></li>
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
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <% if (usuarioLogeado != null) { %>
                <div class="dropdown">
                    <a class="navbar-brand dropdown-toggle" href="#" role="button" id="userDropdown" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="<%= usuarioLogeado.getProfileImage() %>" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
                        <%= usuarioLogeado.getNombre() + " " + usuarioLogeado.getApellido() %>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="userDropdown">
                        <!-- Agrega aquí los elementos del menú desplegable -->
                        <a class="dropdown-item" href="#">Tu Cuenta</a>
                        <!-- Puedes agregar más elementos según sea necesario -->
                    </div>
                </div>
            <% } %>
        </div>
    </nav>
</div>
</nav>
                
                
