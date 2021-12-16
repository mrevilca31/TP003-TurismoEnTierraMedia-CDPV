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

		<form action="/jsp01/atracciones/editarAtraccion.do" method="post">
			<input type="hidden" name="id" value="${atraccion.id}">
			<div class="mb-3">
				<label for="nombre" class="col-form-label">Nombre:</label> <input
					type="text" class="form-control" id="nombre" name="nombre" required
					value="${atraccion.nombre}">
			</div>
			<div class="mb-3">
				<label for="costo"
					class='col-form-label ${atraccion.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
				<input class="form-control" type="number" id="costo" name="costo"
					required value="${atraccion.costo}"></input>
				<div class="invalid-feedback">
					<c:out value='${atraccion.errors.get("costo")}'></c:out>
				</div>
			</div>
			<div class="mb-3">
				<label for="duracion"
					class='col-form-label ${atraccion.errors.get("duracion") != null ? "is-invalid" : "" }'>Duracion:</label>
				<input class="form-control" type="number" id="duracion"
					name="duracion" required value="${atraccion.duracion}"></input>
				<div class="invalid-feedback">
					<c:out value='${atraccion.errors.get("duracion")}'></c:out>
				</div>
			</div>
			<div class="mb-3">
				<label for="cupo"
					class='col-form-label ${atraccion.errors.get("cupo") != null ? "is-invalid" : "" }'>Cupo:</label>
				<input class="form-control" type="number" id="cupo" name="cupo"
					required value="${atraccion.cupo}"></input>
				<div class="invalid-feedback">
					<c:out value='${atraccion.errors.get("cupo")}'></c:out>
				</div>
			</div>
			<div class="mb-3">
				<label for="tipo"
					class='col-form-label ${atraccion.errors.get("tipo")!= null ? "is-invalid" : "" }'>Tipo:</label>
				<input class="form-control" type="text" id="tipo" name="tipo"
					required value="${atraccion.tipo}"></input>
				<div class="invalid-feedback">
					<c:out value='${atraccion.errors.get("tipo")}'></c:out>
				</div>
			</div>
			<button type="submit" class="btn btn-success mt-3">Confirmar</button>
			<button type="button" class="btn btn-danger mt-3"
				data-bs-dismiss="modal">Cancelar</button>
		</form>
	</main>
</body>
</html>

