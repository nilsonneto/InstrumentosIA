<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Instrumentos - Consulta por Ontologia</title>
		<link href="../css/my.css" rel="stylesheet"/>
		<link href="../css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script type="text/javascript">
			function createLine(str){
				var strArr = str.split(' ');
				var td = "<tr>";
				
				for (var i=0; i< strArr.length; i++) {
				    td = td + "<td>" + strArr[i] + "</td>"; 
				}
				
				td = td + "</tr>";
				
				return td;
			}
		
		</script>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/InstrumentosIA/index.jsp">Consulta de Instrumentos Musicais</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/InstrumentosIA/index.jsp#filtros">Home</a></li>
						<li><a href="/InstrumentosIA/index.jsp#sobre">Grupo</a></li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</nav>

		<div class="container">
			<div class="page-header" id="resultados">
				<h1>Resultados</h1>
			</div>
			<div>
				<table class="table table-striped">
					<thead>
						<tr>
							<td><strong>Nome</strong></td>
							<td><strong>Tipo</strong></td>
							<td><strong>Material</strong></td>
							<td><strong>Numero de Cordas</strong></td>
							<td><strong>Tem Pes?</strong></td>
							<td><strong>Preco Medio</strong></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${resultList}" var="res">
							<script type="text/javascript">
								document.write(createLine("${res}"));
							</script>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>