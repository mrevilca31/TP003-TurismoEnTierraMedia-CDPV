<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<jsp:include page="../partials/head-admin.jsp"></jsp:include>
	<title>Atracciones</title>
</head>
<body>
	<jsp:include page="../partials/nav-admin.jsp"></jsp:include>
	
	<main class="container-lg">	
		<jsp:include page="../partials/form-nueva-atraccion.jsp"></jsp:include>
		
		<!-- Tabla de Atracciones -->
		<table
			class="table table-success table-striped table-hover table-bordered border-light mt-4 table-responsive">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Costo</th>
					<th scope="col">Duracion</th>
					<th scope="col">Cupo</th>
					<th scope="col">Tipo</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atraccion}" var="atraccion">
					<tr>
						<td><c:out value="${atraccion.nombre}"></c:out></td>
						<td><c:out value="${atraccion.costo}"></c:out></td>
						<td><c:out value="${atraccion.duracion}"></c:out></td>
						<td><c:out value="${atraccion.cupo}"></c:out></td>
						<td><c:out value="${atraccion.tipo}"></c:out></td>
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
	</main>
</body>
</html>