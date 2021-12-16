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

		<c:if test="${tmp_user != null && !tmp_user.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al editar el usuario.</p>
			</div>
		</c:if>

		<form action="/jsp01/usuario/editarUsuario.do" method="post">
			<input type="hidden" id="id" name="id" value="${tmp_user.id}" />
			<div class="mb-3">
				<label for="nombre" class="col-form-label">Nombre:</label> <input
					type="text" class="form-control" id="nombre" name="nombre" required
					value="${tmp_user.nombre}">
			</div>
			<div class="mb-3">
				<label for="presupuesto"
					class='col-form-label ${tmp_user.errors.get("presupuesto") != null ? "is-invalid" : "" }'>Monedas:</label>
				<input class="form-control" type="number" id="presupuesto"
					name="presupuesto" required value="${tmp_user.presupuesto}"></input>
				<div class="invalid-feedback">
					<c:out value='${tmp_user.errors.get("presupuesto")}'></c:out>
				</div>
			</div>
			<div class="mb-3">
				<label for="tiempoDisponible"
					class='col-form-label ${tmp_user.errors.get("tiempoDisponible") != null ? "is-invalid" : "" }'>Tiempo
					disponible:</label> <input class="form-control" type="number"
					id="tiempoDisponible" name="tiempoDisponible" required
					value="${tmp_user.tiempoDisponible}"></input>
				<div class="invalid-feedback">
					<c:out value='${tmp_user.errors.get("tiempoDisponible")}'></c:out>
				</div>
			</div>
			<div class="mb-3">
				<label for="atraccionPreferida"
					class='col-form-label ${tmp_user.errors.get("atraccionPreferida") != null ? "is-invalid" : "" }'>Atracción
					Preferida:</label> <input type="text" class="form-control"
					id="atraccionPreferida" name="atraccionPreferida" required
					value="${tmp_user.atraccionPreferida}"></input>
				<div class="invalid-feedback">
					<c:out value='${tmp_user.errors.get("atraccionPreferida")}'></c:out>
				</div>
			</div>
			<div class="mb-3">
				<label for="password"
					class='col-form-label ${tmp_user.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label>
				<input type="text" class="form-control" id="password"
					name="password" required value="${tmp_user.password}"></input>
				<div class="invalid-feedback">
					<c:out value='${tmp_user.errors.get("password")}' />
				</div>
			</div>
			<button type="submit" class="btn btn-success mt-3" href="">Confirmar</button>
			<button type="button" class="btn btn-danger mt-3"
				data-bs-dismiss="modal">Cancelar</button>
		</form>

		
	</main>
</body>
</html>