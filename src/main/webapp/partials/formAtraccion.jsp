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
							required value="${atraccion.tipoAtraccion}"></input>
						<div class="invalid-feedback">
							<c:out value='${atraccion.errors.get("tipo")}'></c:out>
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