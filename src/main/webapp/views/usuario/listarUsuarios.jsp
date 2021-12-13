<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head-admin.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>

	<main class="container">

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

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Usuarios</h1>
		</div>

		<c:if test="${usuario.isAdmin()}">
			<div class="mb-3">
				<a href="/turismo/usuario/crearUsuario.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nuevo Usuario
				</a>
			</div>
		</c:if>
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Presupuesto</th>
					<th>Tiempo Disponible</th>
					<th>Atracción Preferida</th>
					<th>Contraseña</th>
					<th>Rol</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuario}" var="tmp_user">
					<tr>
						<td><strong><c:out value="${usuario.nombre}"></c:out></strong></td>
						<td><c:out value="${tmp_user.presupuesto}"></c:out></td>
						<td><c:out value="${tmp_user.tiempoDisponible}"></c:out></td>
						<td><c:out value="${tmp_user.tiempoDisponible}"></c:out></td>
						<td><c:out value="${tmp_user.atraccionPreferida}"></c:out></td>
						<td><c:out value="${tmp_user.password}"></c:out></td>
						<td><c:choose>
								<c:when test="${tmp_user.admin}">
									Admin
								</c:when>
								<c:otherwise>
									Normal
								</c:otherwise>
							</c:choose></td>
						<td><c:if
								test="${usuario.admin && (!tmp_user.admin || tmp_user.id == usuario.id)}">
								<a href="/turismo/usuario/editarUsuario.do?id=${tmp_user.id}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="/turismo/usuario/eliminarUsuario.do?id=${tmp_user.id}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>