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
		<h1 class="title">Editar Atraccion</h1>
		<div class="contenido">
			<form class="formulario"
				action="/jsp01/atracciones/editarAtraccion.do" method="post">
				<input type="hidden" name="id" value="${atraccion.id}">
				<div class="mb-2">
					<label for="nombre" class="col-form-label danger">Nombre:</label> <input
						type="text" class="form-control" id="nombre" name="nombre"
						required value="${atraccion.nombre}">
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
						required value="${atraccion.tipoAtraccion}" readonly></input>
					<div class="invalid-feedback">
						<c:out value='${atraccion.errors.get("tipo")}'></c:out>
					</div>
				</div>
				<button type="submit" class="btn btn-success mt-3 mx-3">Confirmar</button>
				<a href=/jsp01/atracciones/listaAtracciones.do
					class="btn btn-danger mt-3 mx-3" role="button">
					Cancelar
				</a>
			</form>
		</div>

	</main>
</body>
</html>

