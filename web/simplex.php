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
					$fo = $_POST['fo'];
					$i = 1;
					echo "<input type = 'text' name = '".$i."' id = '".$i."' size = '4' required = 'true'>";
					echo "x".$i;
					while($i < $fo){
						echo " + ";
						echo "<input type = 'text' name = '".$i."' id = '".$i."' size = '4' required = 'true'>";
						echo "x".++$i."";	
					}
				?>
				
			<br><br><br>Restrições: <br>			
				<?php
					$restricoes = $_POST['restricoes'];
					$tamRestricoes = $_POST['tamRestricoes'];

					$i = 1;
					$cont = 0;

					while($i <= $restricoes){
						echo "<br><br><input type = 'text' name = '".$i."' id = '".$i."' size = '4' required = 'true'>";
						echo "x".++$cont;
						$j = 1;
						while($j < $tamRestricoes){
							echo " + ";
							echo "<input type = 'text' name = '".$i."' id = '".$i."' size = '4' required = 'true'>";
							echo "x".++$cont."";
						$j++;	
						}
						$i++;
					}
				?>           
			</div>
			
			<br> <input type = "submit" name = "button" value = "Executar Simplex" id = "button">		
			
	</div>
          
<p>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    
            <script type ="text/javascript">
    
			function mostrar(){
				document.getElementById('divRestricoes').hidden = false;
				
				var nome = document.getElementById('nome').value;

			}
			
			
    </script>
</body>
</html>
