<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro</title>
</head>
<body>
<h2>Registro</h2>
<form action="MensajeControl" method="post">
	<div class="form-group">
		<div class="col-sm-10">
     <button type="submit" class="btn btn-primary btn-lg" name="accion" value="atras">Volver</button>
    </div>
</div>
</form>
<form id="formLogin" method="post" action="MensajeControl">
<div class="form-group row">
	<label for="inputEmail3" style="text-align: left;" class="col-sm-3 col-form-label">Nombre</label>
            <div class="col-sm-4">
            <input type="text" class="form-control" id="usuarioLogin" name="nombre" placeholder="Usuario" required="Llena este campo">
            </div>
</div>
<div class="form-group row">
	<label for="inputEmail3" style="text-align: left;" class="col-sm-3 col-form-label">Email</label>
            <div class="col-sm-4">
            <input type="email" class="form-control" id="usuarioLogin" name="email" placeholder="Email" required="Llena este campo">
            </div>
</div>
<div class="form-group row">
	<label for="inputEmail3" style="text-align: left;" class="col-sm-3 col-form-label">Website</label>
            <div class="col-sm-4">
            <input type="text" class="form-control" id="usuarioLogin" name="website" placeholder="Website" required="Llena este campo">
            </div>
</div>
<div class="form-group row">
	<label for="inputEmail3" style="text-align: left;" class="col-sm-3 col-form-label">Usuario</label>
	        <div class="col-sm-4">
	        <jsp:useBean id="uD" class="mensajeJPA.dao.UsuarioDAO" scope="request"></jsp:useBean>
	        <select name="usuario">
						<option>Usuario</option>
						<c:forEach var="u" items="${uD.listar()}">
						
						<option value="<c:out value="${u.getUser()}"/>"><c:out value="${u.getUser()}"/></option>
						</c:forEach>
					</select>
				</div>
</div>
<div class="form-group row">
	<label for="inputEmail3" style="text-align: left;" class="col-sm-3 col-form-label">Mensaje</label>
            <div class="col-sm-4">
            <textarea rows="10" cols="30"  class="form-control" id="usuarioLogin" name="mensaje" placeholder="Mensaje" required="Llena este campo"></textarea>
            </div>
</div>

<div class="col-sm-10">
      <button type="submit" id= "login" class="btn btn-primary btn-lg" name="accion" value="ingresar" >Registrar</button><br><br>
    </div>
    </form>
</body>
</html>