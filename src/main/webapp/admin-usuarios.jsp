<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<jsp:include page="partials/head-admin.jsp"></jsp:include>
	<title>Usuarios</title>
</head>

<body>
	<jsp:include page="partials/nav-admin.jsp"></jsp:include>
	<main class="container-lg">
		<!-- Tabla de Datos -->
		<table
			class="table table-success table-striped table-hover table-bordered border-light mt-4 table-responsive">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Presupuesto</th>
					<th scope="col">Tiempo Disponible</th>
					<th scope="col">Tipo Favorito</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td><c:out value="${atraccion.nombre}"></c:out></td>
						<td><c:out value="${atraccion.presupuesto}"></c:out></td>
						<td><c:out value="${atraccion.tiempoDisponible}"></c:out></td>
						<td><c:out value="${atraccion.tipoFavorito}"></c:out></td>
						<td>
							<button type="button" class="btn btn-primary mx-2">
								<i class="bi bi-pencil-square"></i> Modificar
							</button>
							<button type="button" class="btn btn-danger">
								<i class="bi bi-trash"></i> Eliminar
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Boton Nuevo Usuario -->
		<button type="button" class="btn btn-success">
			<i class="bi bi-plus-square"></i> Nuevo Usuario
		</button>
	</main>

</body>
</html>