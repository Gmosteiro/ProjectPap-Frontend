<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>Bootstrap 4 Login Modal Example</title>
		<!-- Bootstrap CSS -->
		<link
			rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css"
		/>
		<link rel="stylesheet" href="css/style.css" />
        <link rel="userIcon" href="imagenes/UserIcon.png"
	</head>
	<body>
		<header class="intro"></header>
		<main>
			<article>
				<div
					class="modal fade"
					id="loginModal"
					tabindex="-1"
					role="dialog"
					aria-labelledby="exampleModalLabel"
					aria-hidden="true"
				>
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header border-bottom-0">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<img
								src="GetImage" alt="Imagen de usuario" 
								width="150"
								height="150"
							/>

							<div class="modal-body">
								<div class="form-title text-center" style="margin-bottom: 30px">
									<h4>Iniciar Sesion</h4>
								</div>
								<div class="d-flex flex-column text-center">
									<form>
										<div class="form-group">
											<input
												type="email"
												class="form-control"
												id="email1"
												placeholder="Email..."
											/>
										</div>
										<div class="form-group">
											<input
												type="password"
												class="form-control"
												id="password1"
												placeholder="Contraseña..."
											/>
										</div>
										<button type="button" class="btn btn-info btn-block btn-round">Login</button>
									</form>
								</div>
							</div>
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
		<script>
			$(document).ready(function () {
				// Mostrar el modal al cargar la página
				$('#loginModal').modal('show')
			})
		</script>
	</body>
</html>
