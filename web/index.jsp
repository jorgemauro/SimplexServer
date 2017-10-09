<html>
<head>
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title></title>
</head>
<body>

	<div id = "form">
		<form action="simplex.php" method="post">
			<h1 align = "center"><label for="simplex" align= "center">Simplex</label></h1>

			<input type = "radio" name = "tipo" id = "maximizar" class = "radio" value = "Maximizar"> Maximizar					
			<input type = "radio" name = "tipo" id = "minimizar" class = "radio" value = "Minimizar" checked> Minimizar	<br> <br>
			
            <div class="input-field col s6">
              <label for="fo">Quantidade de variáveis função objetiva</label>
              <input id="fo" name = "fo" type="text" class="validate" size = "2" required = "true">
            </div>
            
            <br><div class="input-field col s6">
              <label for="restricoes">Quantidade de restrições</label>
              <input id="restricoes" name="restricoes" type="text" class="validate" size = "2" required = "true"> 
              <br><br><label for="tamRestricoes">Tamanho das restrições</label>
              <input id="tamRestricoes" name="tamRestricoes" type="text" class="validate" size = "2" required = "true">                
            </div>   				 
            
            <br> <input type = "submit" name = "button" value = "Gerar variáveis" id = "button">		            
        
	</div>
          
<p>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    
</body>
</html>
