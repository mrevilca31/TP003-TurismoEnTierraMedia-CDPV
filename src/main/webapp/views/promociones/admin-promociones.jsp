<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<jsp:include page="../../partials/head-admin.jsp"></jsp:include>
<title>Promociones</title>
</head>

<body>

	<jsp:include page="../../partials/nav-admin.jsp"></jsp:include>

	<main class="container-lg">
		<!-- Boton nuevo producto -->
		<button type="button" class="btn btn-success mt-3">
			<i class="bi bi-plus-square"></i> Nueva Promocion
		</button>
		<!-- Tabla de Datos -->
		<table
			class="table table-success table-striped table-hover table-bordered border-light mt-4 table-responsive">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Tipo de Promocion</th>
					<th scope="col">Tipo de Atracciones</th>
					<th scope="col">Atracciones Incluidas</th>
					<!-- <th scope="col">Tipo descuento</th> -->
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${promociones}" var="promocion">
					<tr>
					<!-- ACA IRIA UN IF DEPENDIENDO DEL TIPO DE PROMO -->
						<td><c:out value="${promocion.nombre}"></c:out></td>
						<td><c:out value="${promocion.tipoPromo}"></c:out></td>
						<td><c:out value="${promocion.tipoPreferido}"></c:out></td>						
						<td><c:out value="${promocion.atraccionesEnPromocion}"></c:out></td>
						<!-- <td><c:out value="${promocion.tipo}"></c:out></td> -->
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