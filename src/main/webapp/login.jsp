<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="/jsp01/assets/images/Iconos/IconoLogin.png">
<title>login</title>
<link rel="stylesheet" type="text/css"
	href="/jsp01/assets/css/estilos-login.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Parque Tierra Media</h1>
		</div>
		<div class="main">
		
		<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			
			<c:if test="${success != null}">
				<div class="alert alert-success">
					<p>
						<c:out value="${success}" />
					</p>
				</div>
			</c:if>
			<form action="login" method="post">
				<div class="mb-3">
					<label for="nombre" class="form-label"></label> 
					<input class="form-control" placeholder="Usuario" name="nombre">
				</div>
				<div class="mb-3">
					<label for="password" class="form-label"></label> 
					<input type="password" class="form-control" placeholder="Password" name="password">
				</div>
				<button type="submit" class="btn btn-lg btn-primary">Ingresar</button>
			</form>
		</div>
	</div>
</body>
