<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="container-fluid">
	<!--barra de navegacion -->
	<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-success">
		<div class="container-fluid">
			<a class="navbar-brand" href="user-inicio.html">Parque Tierra
				Media</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						href="user-inicio.html">Inicio</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="user-atracciones.html">Atracciones</a></li>
					<li class="nav-item"><a class="nav-link"
						href="user-promociones.html">Promociones</a></li>
					<li class="nav-item"><a class="nav-link"
						href="user-itinerario.html">Itinerario</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Nombre
							Usuario </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="#">Salir</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
</header>