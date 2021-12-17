<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="../assets/images/Iconos/IconoAdmin.png">
<link rel="stylesheet" href="../assets/css/estilos-admin-modificar.css">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


<!-- Option 1: Bootstrap Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>

<body>
	<main>
		<c:if test="${tmp_user != null && !tmp_user.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al editar el usuario.</p>
			</div>
		</c:if>
		<h1 class="title">Editar Usuario</h1>
		<div class="contenido">
			<form class="formulario" action="/jsp01/usuario/editarUsuario.do"
				method="post">
				<input type="hidden" id="id" name="id" value="${tmp_user.id}" />
				<div class="mb-3">
					<label for="nombre" class="col-form-label">Nombre:</label> <input
						type="text" class="form-control" id="nombre" name="nombre"
						required value="${tmp_user.nombre}">
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
					<input type="password" class="form-control" id="password"
						name="password" required value="${tmp_user.password}"></input>
					<div class="invalid-feedback">
						<c:out value='${tmp_user.errors.get("password")}' />
					</div>
				</div>
				<button type="submit" class="btn btn-success mt-3 mx-3" href="">Confirmar</button>
				<a href="/jsp01/usuario/listaUsuarios.do"
					class="btn btn-danger mt-3 mx-3" role="button">
					Cancelar
				</a>
			</form>
		</div>
	</main>
</body>
</html>