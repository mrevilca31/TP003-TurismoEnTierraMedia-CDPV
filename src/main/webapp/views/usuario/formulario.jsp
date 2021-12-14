
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Usuario</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form>
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
							<c:out value='${tmp_user.errors.get("password")}'/>
						</div>
					</div>
					<button type="submit" class="btn btn-success mt-3" href="">Crear</button>
					<button type="button" class="btn btn-danger mt-3"
						data-bs-dismiss="modal">Cancelar</button>
				</form>
			</div>
		</div>
	</div>
</div>