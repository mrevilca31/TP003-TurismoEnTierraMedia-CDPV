<!-- Boton nuevo producto -->
<button type="button" class="btn btn-success mt-3"
	data-bs-toggle="modal" data-bs-target="#exampleModal">
	<i class="bi bi-plus-square"></i> Nueva Atraccion
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Nueva Atraccion</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form>
					<div class="mb-3">
						<label for="name" class="col-form-label">Nombre:</label> <input
							type="text" class="form-control" id="name" name="name" required
							value="${attraction.name}">
					</div>
					<div class="mb-3">
						<label for="cost"
							class='col-form-label ${attraction.errors.get("cost") != null ? "is-invalid" : "" }'>Costo:</label>
						<input class="form-control" type="number" id="cost" name="cost"
							required value="${attraction.cost}"></input>
						<div class="invalid-feedback">
							<c:out value='${attraction.errors.get("cost")}'></c:out>
						</div>
					</div>
					<div class="mb-3">
						<label for="duration"
							class='col-form-label ${attraction.errors.get("duration") != null ? "is-invalid" : "" }'>Duration:</label>
						<input class="form-control" type="number" id="duration"
							name="duration" required value="${attraction.duration}"></input>
						<div class="invalid-feedback">
							<c:out value='${attraction.errors.get("duration")}'></c:out>
						</div>
					</div>
					<div class="mb-3">
						<label for="capacity"
							class='col-form-label ${attraction.errors.get("capacity") != null ? "is-invalid" : "" }'>Capacity:</label>
						<input class="form-control" type="number" id="capacity"
							name="capacity" required value="${attraction.capacity}"></input>
						<div class="invalid-feedback">
							<c:out value='${attraction.errors.get("capacity")}'></c:out>
						</div>
					</div>
					<button type="submit" class="btn btn-success mt-3">Crear</button>
					<button type="button" class="btn btn-danger mt-3"
						data-bs-dismiss="modal">Cancelar</button>
				</form>
			</div>
		</div>
	</div>
</div>