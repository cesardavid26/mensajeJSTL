<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mensajeria</title>
</head>
<body>
<h2>Mensajeria</h2>
<form action="MensajeControl" method="post">
	<div class="form-group">
		<div class="col-sm-10">
     <button type="submit" class="btn btn-primary btn-lg" name="accion" value="registrar">Registrar</button>
    </div>
</div>
    <div class="form-group " >
    	<div class="col-sm-10">
    <button type="submit" class="btn btn-primary btn-lg" name="accion" value="listar">Listar</button>
    </div>
</div>
</form>
</body>
</html>