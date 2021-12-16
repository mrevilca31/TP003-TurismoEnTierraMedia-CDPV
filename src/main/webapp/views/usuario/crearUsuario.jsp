<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head-admin.jsp"></jsp:include>
</head>
<body>
	

	<main class="container">

		<c:if test="${tmp_user != null && !tmp_user.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear el usuario.</p>
			</div>
		</c:if>

		<jsp:include page="formulario.jsp"></jsp:include>
	</main>
</body>
</html>
