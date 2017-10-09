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
			<form action="simplex.jsp" method="post">
				<h1 align = "center"><label for="simplex" align= "center">Simplex</label></h1>

				<br>Função objetivo (FO): 
					<?php
						$fo = $_POST['fo']; //numero de variaveis da funcao objetiva
						$i = 1;
						echo "<input type = 'text' name = '".$i."' id = '".$i."' size = '4' required = 'true'>";
						echo "x".$i;
						
						while($i < $fo){ //cria campos de variaveis para a funcao objetiva
							echo " + ";
							echo "<input type = 'text' name = '".$i."' id = '".$i."' size = '4' required = 'true'>";
							echo "x".++$i."";	
						}
					?>
				
				<br><br><br>Restrições:			
					<?php
						$restricoes = $_POST['restricoes']; //numero de restricoes
						$tamRestricoes = $_POST['tamRestricoes']; //tamanho padrao das restricoes

						$i = 1;
						$cont = 0;

						while($i <= $restricoes){ //cria campos para as restricoes
							echo "<br><br><input type = 'text' name = '".$i."' id = '".$i."' size = '4' required = 'true'>";
							echo "x".++$cont;
							$j = 1;
							
							while($j < $tamRestricoes){ // cria campos de variaveis para as restricoes
								echo " + ";
								echo "<input type = 'text' name = '".$i."' id = '".$i."' size = '4' required = 'true'>";
								echo "x".++$cont."";
								$j++;	
							}
							
							$i++;
						}
					?>           
			
				<br><br> <input type = "submit" name = "button" value = "Executar Simplex" id = "button">		
			</form>	
		</div>
          
    		<!--Import jQuery before materialize.js-->
    		<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    		<script type="text/javascript" src="js/materialize.min.js"></script>						
	</body>
</html>
