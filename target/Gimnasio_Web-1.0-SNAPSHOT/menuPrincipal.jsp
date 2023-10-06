<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

		<link
			rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
			crossorigin="anonymous"
		/>

		<title>Homepage</title>
		<%@include file="/header.jsp" %>
	</head>

	<body>
		<div class="">
			<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100" src="./imagenes/img1.jpg" alt="First slide" />
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="./imagenes/img2.jpg" alt="Second slide" />
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="./imagenes/img3.jpg" alt="Third slide" />
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="./imagenes/img4.jpg" alt="Third slide" />
					</div>
				</div>
			</div>
		</div>
	</body>
	<%@include file = "footer.jsp" %>
</html>
