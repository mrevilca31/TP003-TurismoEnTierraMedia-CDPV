<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<jsp:include page="../partials/head-user.jsp"></jsp:include>
<link rel="stylesheet" href="../assets/css/estilos-user-inicio.css">
<title>Inicio</title>
</head>

<body>
	<jsp:include page="../partials/nav-user.jsp"></jsp:include>
	<main>
		<h1 class="title">Bienvenido</h1>
		<!-- Carrusel -->
		<div class="container-lg my-3">
			<div id="carouselExampleCaptions" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<a href="/jsp01/usuario/inicio.do"> <img
							src="../assets/images/fondos/FondoGeneral.jpg"
							class=" d-block mx-auto my-auto" role="button" alt="..."
							width="850 px" height="500 px">
						</a>
						<div class="carousel-caption d-none d-md-block">
							<h1>¡Hola ${usuario.nombre}!</h1>
							<h3>Estas ofertas están diseñadas para ti</h3>
						</div>
					</div>
					<c:forEach items="${ofertas}" var="ofertas">
						<div class="carousel-item">
							<a href="/jsp01/atracciones/listaAtraccionesUsuario.do"> <img
								src="../assets/images/Atracciones/<c:out value="${ofertas.nombre}"></c:out>.jpg"
								class=" d-block mx-auto my-auto" role="button" alt="..."
								width="850 px" height="500 px">
							</a>
							<div class="carousel-caption d-none d-md-block">
								<h2>"${ofertas.nombre.toUpperCase()}"</h2>
								<h4>COSTO: ${ofertas.costo} monedas</h4>
								<h4>TIPO: ${ofertas.tipoAtraccion}</h4>
								<h6>Click sobre la imagen para mas informacion.</h6>
							</div>
						</div>
					</c:forEach>
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