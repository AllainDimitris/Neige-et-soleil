<!DOCTYPE html>
<html>
	<head>

		<title>Location Immobiliere</title>
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
		</header>
<?php include("header.php"); ?>

			<p>
                        Recherche
            </p>

				<div id="searchbar">

                <form action="" class="formulaire">
                <input class="champ" type="text" value="Recherche"/>
                <input class="bouton" type="button" value="Chercher" />

                </form>
                </div>
		<div id= "contenuprincipale">


		</div>

<footer>
	<<?php include("footer.php"); ?>
</footer>
</body>
</html>
