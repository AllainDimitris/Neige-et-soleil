<!DOCTYPE html>
<html>
	<head>

		<title>Location Materiel</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/main.css"/>
		<?php
			if (file_exists("css/".basename(__FILE__, '.php').".css"))
			{
				echo '<link href="css/'.basename(__FILE__, '.php').'.css" rel="stylesheet">';
			}
		?>
		

	</head>
	<body>
		<header>
		<h1> Neige et Soleil</h1>
		</header> <!-- haut de page--> <!-- div sert à créer des boites plutot que des ensembles et de les nommer-->
<?php include("header.php"); ?>

		<div id= "contenuprincipale">
			<p>


			Matos
			</p>

		</div>
<footer>
<?php include("footer.php"); ?>
</footer>
	</body>
</html>
