<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<!--Import Google Icon Font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/ajustes.css"  media="screen,projection"/>

	<!--Let browser know website is optimized for mobile-->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<title>Simplex</title>
</head>
	<body>
            <nav class="cyan darken-3">
                <div class="nav-wrapper ">
                    <a href="#" class="brand-logo cyan darken-3 center">SIMPLEX</a>
                </div>
            </nav>

            <div class="container">
			<form method="post" action="rest/myresource" class="formulario">
                <div class="card">
				<p>
				<input type = "radio" name = "tipo" id = "maximizar" class = "radio" value = "Maximizar"/>
                    <label for="maximizar">Maximizar</label>
				</p>
				<p>
				<input type = "radio" name = "tipo" id = "minimizar" class = "radio" value = "Minimizar" checked />
					<label for="minimizar">Minimizar</label>
				</p>
				<div class="input-field col s6">
					<label for="funcoes">Digite a função objetiva</label>
					<input id="funcoes" placeholder="Ex: 80x1+60x2=0" name = "funcoes" type="text" class="validate" size = "2" required = "true"/>
				</div>
                <div class="input-field col s6" id="R">
                    <label for="restricoes_0">Tamanho das restrições <i class="small material-icons  tooltipped" id="alert"data-position="bottom" data-delay="50" data-tooltip="Para adicionar restrições clique no botão de adicionar">error_outline</i></label>
                    <input id="restricoes_0" name="restricoes_0" type="text" class="validate" size = "2" required = "true"/>
				</div>
                    <div class="row">
                <a class="btn-floating btn-large waves-effect waves-light cyan darken-3" id="adiciona"><i class="material-icons">add</i></a>
                    </div>
            </div>
                <input type = "submit" name = "button" value = "Executar semplex" class="waves-effect waves-light btn" id = "button">
			</form>
            </div>
    </div>

		<!--Import jQuery before materialize.js-->
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="js/materialize.min.js"></script>
		<script  type="text/javascript" src="js/ajuste.js"></script>

	</body>
</html>
