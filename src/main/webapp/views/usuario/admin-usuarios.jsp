<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<jsp:include page="../../partials/head-admin.jsp"></jsp:include>

<title>Usuarios</title>
</head>

<body>
	<jsp:include page="../../partials/nav-admin.jsp"></jsp:include>
	<main class="container-lg">
		<!-- Boton nuevo Usuario -->
		<a href="/jsp01/usuario/crearUsuario.do"
			class="btn btn-success mt-3" role="button" data-bs-toggle="modal"
			data-bs-target="#exampleModal"> <i class="bi bi-plus-square"></i>
			Nuevo Usuario
		</a>
		<jsp:include page="formulario.jsp"></jsp:include>

		<!-- Tabla de Datos -->
		<table
			class="table table-success table-striped table-hover table-bordered border-light mt-4 table-responsive">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Presupuesto</th>
					<th scope="col">Tiempo Disponible</th>
					<th scope="col">Atraccion Preferida</th>
					<th scope="col">Rol</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td><c:out value="${usuario.nombre}"></c:out></td>
						<td><c:out value="${usuario.presupuesto}"></c:out></td>
						<td><c:out value="${usuario.tiempoDisponible}"></c:out></td>
						<td><c:out value="${usuario.atraccionPreferida}"></c:out></td>
						<td><c:choose>
								<c:when test="${usuario.admin}">
									Admin
								</c:when>
								<c:otherwise>
									Normal
								</c:otherwise>
							</c:choose></td>
						<td>
							<a href="/jsp01/usuario/editarUsuario.do?id=${usuario.id}"
								class="btn btn-primary mx-2" role="button"> <i class="bi bi-pencil-square"></i>
									Modificar
						    </a>
							
							<a href="/jsp01/usuario/eliminarUsuario.do?id=${usuario.id}"
									class="btn btn-danger" role="button"><i
									class="bi bi-trash"></i> Eliminar
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

</body>
</html>