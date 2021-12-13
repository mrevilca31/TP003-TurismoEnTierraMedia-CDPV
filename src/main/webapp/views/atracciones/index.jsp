<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head-admin.jsp"></jsp:include>
<title>Atracciones</title>
</head>
<body>


	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>

	<main class="container-lg">

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

		<c:if test="${usuario.isAdmin()}">
			<div class="mb-3">
				<a href="/atracciones/crearAtraccion.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Atracción <jsp:include
						page="/partials/formAtraccion.jsp"></jsp:include>
				</a>
			</div>
		</c:if>

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
				<c:forEach items="${atracciones}" var="atraccion">
					<tr>
						<td><c:out value="${atraccion.nombre}"></c:out></td>
						<td><c:out value="${atraccion.costo}"></c:out></td>
						<td><c:out value="${atraccion.duracion}"></c:out></td>
						<td><c:out value="${atraccion.cupo}"></c:out></td>
						<td><c:out value="${atraccion.tipo}"></c:out></td>
						<td><c:if test="${usuario.isAdmin}">
								<a href="/atracciones/editarAtraccion.do?id=${atraccion.id}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="/atracciones/eliminarAtracciones.do?id=${atraccion.id}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if>  
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>
