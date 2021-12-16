<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="container-fluid">
	<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-success">
		<div class="container-fluid">
			<a class="navbar-brand" href="/jsp01/usuario/listaUsuarios.do">Parque
				Tierra Media</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/jsp01/atracciones/listaAtracciones.do">Atracciones</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/jsp01/promociones/listaPromociones.do">Promociones</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/jsp01/usuario/listaUsuarios.do">Usuarios</a></li>
					<li class="nav-item dropdown position-absolute end-0 me-4"><a
						class="nav-link active dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> ${usuario.nombre}
					</a>
						<ul class="dropdown-menu dropdown-menu-end "
							aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="#"><i
									class="bi bi-coin"></i> ${usuario.presupuesto} monedas</a></li>
							<li><a class="dropdown-item" href="#"><i
									class="bi bi-hourglass-split"></i> ${usuario.tiempoDisponible} horas</a></li>
							<li><a class="dropdown-item" href="/jsp01/logout"><i
									class="bi bi-box-arrow-left"></i> Salir</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
</header>