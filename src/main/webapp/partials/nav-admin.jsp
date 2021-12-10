<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="container-fluid">
        <nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-success">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Parque Tierra Media</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Atracciones</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="admin-promociones.jsp">Promociones</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="admin-usuarios.html">Usuarios</a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Administrador
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                      <li><a class="dropdown-item" href="#">Salir</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
    </header>