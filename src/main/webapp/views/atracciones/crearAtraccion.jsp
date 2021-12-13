<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/partials/head-admin.jsp"></jsp:include>
	<title>Crear atraccion</title>
</head>
<body>
	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>
	
	<main class="container">

		<c:if test="${atraccion != null && !atraccion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear la atracción.</p>
			</div>
		</c:if>

		<form action="/atracciones/crearAtraccion.do" method="post">
			<jsp:include page="/views/atracciones/form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>

  