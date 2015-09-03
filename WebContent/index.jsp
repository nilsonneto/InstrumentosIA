<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Instrumentos - Consulta por Ontologia</title>
		<link href="css/my.css" rel="stylesheet"/>
		<link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Consulta de Instrumentos Musicais</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#filtros">Home</a></li>
						<li><a href="#sobre">Grupo</a></li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</nav>

		<div class="container">
			<div class="page-header" id="filtros">
				<h1>Filtros</h1>
			</div>
			<div class="alert alert-info" role="alert">
				Pressione <strong>&lt;Enter&gt;</strong> num campo para pesquisar somente com aquele parametro.<br/>
				Selecione o botão <strong>Pesquisar</strong> para utilizar todos os parametros.
			</div>
			<div class="container-fluid">
				<h4>Dados do Instrumento</h4>
				<form action="busca/instrumentos" method="POST" id="formTipo" class="form-horizontal">
					<div class="form-group">
						<label for="txtTipo" class="col-sm-2 control-label">Tipo</label>
    					<div class="col-sm-10">
							<input class="form-control" name="txtTipo" id="txtTipo" type="text" placeholder="Digite um tipo de instrumento" />
						</div>
					</div>
					<div class="form-group">
						<label for="txtMaterial" class="col-sm-2 control-label">Material</label>
    					<div class="col-sm-10">
							<input class="form-control" name="txtMaterial" id="txtMaterial" type="text" placeholder="Digite o tipo de material do instrumento" />
						</div>
					</div>
					<div class="form-group">
						<label for="txtCordas" class="col-sm-2 control-label">Número de Cordas</label>
    					<div class="col-sm-10">
							<input class="form-control" name="txtCordas" id="txtCordas" type="text" placeholder="Digite o numero de cordas do instrumento" />
						</div>
					</div>
					<div class="form-group">
						<label for="txtCordas" class="col-sm-2 control-label">Preço</label>
    					<div class="col-sm-5">
							<input class="form-control" name="txtMinPreco" id="txtMinPreco" type="text" placeholder="Digite o preço mínimo do instrumento" />
						</div>
    					<div class="col-sm-5">
							<input class="form-control" name="txtMaxPreco" id="txtMaxPreco" type="text" placeholder="Digite o preço máximo do instrumento" />
						</div>
					</div>
					<button type="submit" class="btn btn-primary" >Pesquisar</button>
				</form>
			</div>
			<div class="page-header" id="sobre">
				<h1>Desenvolvido Por</h1>
			</div>
			<div class="container">
				<ul class="list-unstyled">
					<li><h4 class="marginTopZero">Carlos Renan de Oliveira</h4></li>
					<li><h4>Nilson Perboni Neto</h4></li>
					<li><h4>Thais Andreetti</h4></li>
				</ul>
			</div>
		</div>
	</body>
</html>