<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<jsp:include page="../../partials/head-admin.jsp"></jsp:include>

<title>Atracciones</title>
</head>
<body>
	<jsp:include page="../../partials/nav-admin.jsp"></jsp:include>

	<main class="container-lg">

		<!-- Boton nueva atraccion -->
		<button type="button" class="btn btn-success mt-3"
			data-bs-toggle="modal" data-bs-target="#exampleModal">
			<i class="bi bi-plus-square"></i> Nueva Atraccion
		</button>
		<jsp:include page="form.jsp"></jsp:include>

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<!-- Tabla de Atracciones -->
		<table
			class="table table-success table-striped table-hover table-bordered border-light mt-4 table-responsive">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Costo</th>
					<th scope="col">Duración</th>
					<th scope="col">Cupo</th>
					<th scope="col">Tipo</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atracciones}" var="atraccion">
					<tr>
						<td><c:out value="${atraccion.nombre}"></c:out></td>
						<td><c:out value="${atraccion.costo}"></c:out></td>
						<td><c:out value="${atraccion.duracion}"></c:out></td>
						<td><c:out value="${atraccion.cupo}"></c:out></td>
						<td><c:out value="${atraccion.tipoAtraccion}"></c:out></td>
						<td>
							<button type="button" class="btn btn-primary mx-2"
								data-bs-toggle="modal" data-bs-target="#exampleModal">
								<i class="bi bi-pencil-square"></i> Modificar
							</button> <jsp:include page="form.jsp"></jsp:include>
							<button type="button" class="btn btn-danger">
								<i class="bi bi-trash"></i> Eliminar
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

</body>
</html>