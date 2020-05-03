<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
<%@ page import="mensajeJPA.entities.Mensaje"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar</title>
</head>
<body>
<h2>Listado de Mensajes</h2>
<form action="MensajeControl" method="post">
	<div class="form-group">
		<div class="col-sm-10">
     <button type="submit" class="btn btn-primary btn-lg" name="accion" value="atras">Volver</button>
    </div>
</div>
</form>
<jsp:useBean id="mD" class="mensajeJPA.dao.MensajeDAO" scope="request"></jsp:useBean>
<table class="table">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Email</th>
			<th>Usuario</th>
			<th>Mensaje</th>
			<th>Acciones</th>


		</tr>
		<c:forEach var="m" items="${mD.listar()}">

			<tr>
				<td><c:out value="${m.getId()}" /></td>
				<td><c:out value="${m.nombre}" /></td>
				<td><c:out value="${m.email}" /></td>
				<td><c:out value="${m.usuario.getUsuario()}" /></td>
				<td><c:out value="${m.getMensaje()}" /></td>
				<td>
					<form action="MensajeControl" method="post">
						<input type="hidden" name="id" value="${m.getId()}">
						<div class="form-group row">
							<div class="col-sm-12">
								<button type="submit" name="accion" value="editar"
									class="btn btn-primary btn-lg">Editar</button>
								<button type="submit" name="accion" value="eliminar"
									class="btn btn-primary btn-lg">Eliminar</button>

							</div>
						</div>


					</form>

				</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>