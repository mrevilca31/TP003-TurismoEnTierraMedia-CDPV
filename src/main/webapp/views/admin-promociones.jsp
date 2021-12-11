<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<jsp:include page="../partials/head-admin.jsp"></jsp:include>
<title>Promociones</title>
</head>

<body>

	<jsp:include page="../partials/nav-admin.jsp"></jsp:include>

	<main class="container-lg">
		<!-- Tabla de Datos -->
		<table
			class="table table-success table-striped table-hover table-bordered border-light mt-4 table-responsive">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Costo</th>
					<th scope="col">Tiempo</th>
					<th scope="col">Cupo</th>
					<th scope="col">Tipo</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${promociones}" var="promocion">
					<tr>
						<td><c:out value="${promocion.nombre}"></c:out></td>
						<td><c:out value="${promocion.costo}"></c:out></td>
						<td><c:out value="${promocion.tiempo}"></c:out></td>
						<td><c:out value="${promocion.cupo}"></c:out></td>
						<td><c:out value="${promocion.tipo}"></c:out></td>
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

		<!-- Boton nuevo producto -->
		<button type="button" class="btn btn-success">
			<i class="bi bi-plus-square"></i> Nueva Promocion
		</button>
	</main>

</body>

</html>