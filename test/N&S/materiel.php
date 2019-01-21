<!DOCTYPE html>
<html>
	<head>
		<title>Location Immobiliere</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="css/main.css"/>
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
		<body class="is-preload">

			<div id="wrapper">
				<?php include("header.php"); ?>
				<div id="searchbar">

                <form action="" class="formulaire"> <br>
                <input class="champ" type="text" placeholder="Recherche"/> <br>
                <input class="bouton" type="button" value="Chercher" />
				</div>
				<?php
				try
				{
						$bdd = new PDO('mysql:host=localhost;dbname=Basesite','root','');

						$bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

				}
				catch (Exception $e)
				{
						die('Erreur :'.$e->getMessage());
				}
				$reponse=$bdd->query('SELECT CODEE,NOME,ETATE,COULEUR,TAILLE,LETTRETAILLE FROM equipement');
				$donnees = $reponse->fetchAll();
				foreach ($donnees as $elements) {
					?>
					<table>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="product-item">
					<tr>
						<td><?php echo "<img src=images/equipement/".$elements['CODEE'].".jpg width=150>";?></td>
						<td><a href=""><?php echo($elements['NOME']);?>
						<?php echo($elements['ETATE']);?>
						<?php echo($elements['COULEUR']);?>
						<?php echo($elements['TAILLE']);?>
						<?php echo($elements['LETTRETAILLE']);?></td></a>
						 <button type="submit">
 						 "<img src=images/equipement/".$elements['CODEE'].".jpg alt="Reserver le Materiel" title="Reserver le matériel" />
					</button> 
					</tr>
					</div>
				</div>
			</table>
			<?php }  ?>
			</div>
				<?php include("footer.php"); ?>
			</div>

			<div id="bg"></div>

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<form action="" class="formulaire">

                </form>


			<?php include("header.php"); ?>
			<p>
                        Recherche
            </p>





                </div>

	</body>
</html>
