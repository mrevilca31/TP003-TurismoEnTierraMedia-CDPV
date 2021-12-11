<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<jsp:include page="../partials/head-user.jsp"></jsp:include>
	<link rel="stylesheet" href="../assets/css/estilos-user-inicio.css">
	<title>Inicio</title>
</head>

<body>
    <jsp:include page="../partials/nav-user.jsp"></jsp:include>
	<main>
		<h1 class="title">Bienvenidos</h1>
		<!-- Carrusel -->
		<div class="container-lg mt-3">
			<div id="carouselExampleCaptions" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<a href="#"> <img src="../assets/images/Castillo.jpg"
							class=" d-block mx-auto my-auto" alt="..." width="850 px"
							height="500 px">
						</a>
						<div class="carousel-caption d-none d-md-block">
							<h2>NOMBRE PRODUCTO</h2>
							<p>Click sobre la imagén para más información.</p>
						</div>
					</div>
					<div class="carousel-item">
						<a href="#"> <img src="../assets/images/Castillo.jpg"
							class=" d-block mx-auto my-auto" alt="..." width="850 px"
							height="500 px">
						</a>
						<div class="carousel-caption d-none d-md-block">
							<h2>NOMBRE PRODUCTO</h2>
							<p>Click sobre la imagén para más información.</p>
						</div>
					</div>
					<div class="carousel-item">
						<a href="#"> <img src="../assets/images/Castillo.jpg"
							class=" d-block mx-auto my-auto" alt="..." width="850 px"
							height="500 px">
						</a>
						<div class="carousel-caption d-none d-md-block">
							<h2>NOMBRE PRODUCTO</h2>
							<p>Click sobre la imagén para más información.</p>
						</div>
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
	</main>
	<jsp:include page="../partials/footer.jsp"></jsp:include>
</body>