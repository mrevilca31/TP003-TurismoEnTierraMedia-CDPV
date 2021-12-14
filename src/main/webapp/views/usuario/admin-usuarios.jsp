<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<jsp:include page="../../partials/head-admin.jsp"></jsp:include>
<link rel="shortcut icon" href="../../assets/images/Iconos/IconoAdmin.png">

<title>Usuarios</title>
</head>

<body>
	<jsp:include page="../../partials/nav-admin.jsp"></jsp:include>
	<main class="container-lg">
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
							<button type="button" class="btn btn-primary mx-2"
								href="/jsp01/usuario/editarUsuario.do">
								<i class="bi bi-pencil-square"></i> Modificar

							</button>
							<button type="button" class="btn btn-danger"
								href="/jsp01/usuario/eliminarUsuario.do">
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