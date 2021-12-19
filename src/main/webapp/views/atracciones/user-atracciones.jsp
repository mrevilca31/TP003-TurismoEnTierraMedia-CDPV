<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<jsp:include page="../../partials/head-user.jsp"></jsp:include>
<link rel="stylesheet" href="../assets/css/estilos-user-atracciones.css">

<title>Atracciones</title>
</head>
<body>
	<jsp:include page="../../partials/nav-user.jsp"></jsp:include>
	<main>
		<h1 class="title">Atracciones Disponibles</h1>

		<!-- Cards con las Atracciones -->
		<div
			class="contenido container-fluid d-flex flex-wrap justify-content-center">
			<c:forEach items="${atracciones}" var="atraccion">
				<div class="card">
					<img
						src="../assets/images/Atracciones/<c:out value="${atraccion.getNombre()}"></c:out>.jpg"
						alt="">

					<h4>
						<c:out value="${atraccion.getNombre().toUpperCase()}"></c:out>
					</h4>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">DURACION:
							${atraccion.getDuracion()} horas</li>
						<li class="list-group-item">PRECIO: ${atraccion.getCosto()}
							monedas</li>
						<li class="list-group-item">TIPO:
							${atraccion.getTipoAtraccion()}</li>
					</ul>

					<!-- Button trigger modal -->
					<c:choose>

						<c:when
							test="${usuario.puedePagar(atraccion) && usuario.tieneTiempo(atraccion) && atraccion.hayCupo()}">
							<button type="button" class="btn btn-success mx-5 mt-3"
								data-bs-toggle="modal"
								data-bs-target="#exampleModal-${atraccion.id}">
								<i class="bi bi-cart-plus"></i> Comprar
							</button>
						</c:when>
						<c:otherwise>
							<a href="#" class="btn btn-secondary rounded disabled"
								role="button">No se puede comprar</a>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- Modal -->
				<div class="modal fade" id="exampleModal-${atraccion.id}"
					tabindex="-1" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">CONFIRMACION
									DE COMPRA$</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">¿Realmente desea realizar esta
								compra?</div>
							<div class="modal-footer">
								<a href="/jsp01/atracciones/buy.do?id=${atraccion.id}"
									class="btn btn-success rounded" role="button">Confirmar</a>
								<button type="button" class="btn btn-danger"
									data-bs-dismiss="modal">Cancelar</button>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</main>
	<jsp:include page="../../partials/footer.jsp"></jsp:include>
</body>