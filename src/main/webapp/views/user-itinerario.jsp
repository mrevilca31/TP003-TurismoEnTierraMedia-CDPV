<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<jsp:include page="../partials/head-user.jsp"></jsp:include>
<link rel="stylesheet" href="../assets/css/estilos-user-atracciones.css">
<title>Itinerario</title>
</head>

<body>
	<jsp:include page="../partials/nav-user.jsp"></jsp:include>
	<main class="container-lg">
		<h1 class="title">Productos Adquiridos</h1>
		<c:if test= "${itinerario != Null}">
		<c:forEach items="${itinerario}" var="producto">
			<div class="card mt-4 border-secondary">
				<h5 class="card-header text-white bg-success">Promo/Atraccion</h5>
				<div class="card-body text-dark bg-light">
					<h5 class="card-title">${producto.toString()} </h5>
				</div>
			</div>
		</c:forEach>
		</c:if>
	</main>
</body>