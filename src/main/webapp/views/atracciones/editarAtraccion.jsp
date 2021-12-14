<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head-admin.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>

	<main class="container">

		<c:if test="${atraccion != null && !atraccion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al editar la atracción.</p>
			</div>
		</c:if>

		<form action="/atracciones/editarAtraccion.do" method="post">
			<input type="hidden" name="id" value="${atraccion.id}">
			<jsp:include page="form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>

