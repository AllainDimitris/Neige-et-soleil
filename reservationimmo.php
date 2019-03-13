<!DOCTYPE html>
<html>
	<head>
		<title>Reservation</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
   		<link rel="stylesheet" href="css/reservationimmo.css"/>
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body>
		<body class="is-preload">

			<div id="wrapper">	
				<?php include("header.php"); ?>

    <br><br>
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
	$reponse=$bdd->query('SELECT IDH,NUMEROH,ADRH,CPH,VILLEH,EXPOH, SURFACEHABH, SURFACEBALH, CAPACCH, DISTANCEPISTEH FROM habitation where IDH ='.$_GET['IDH'].';');
	$donnees = $reponse->fetchAll();
	foreach ($donnees as $elements) {
									?>
							<table id="table" border>
										<?php echo "<img src=images/habitation/".$elements['IDH'].".jpg width=400>";?>
								<tr>
									<td id="gauche">
										<?php echo($elements['NUMEROH']);?>
										<?php echo($elements['ADRH']);?><br>
										<?php echo($elements['VILLEH']);?><br>
										<?php echo($elements['CPH']);?><br>
										<?php echo "Exposition : ", ($elements['EXPOH']);?><br>
										<?php echo "Surface habitable : ", ($elements['SURFACEHABH']);?><br>
										<?php echo "Surface balcon : ", ($elements['SURFACEBALH']);?><br>
										<?php echo "Capacité : ", ($elements['CAPACCH']);?><br>
										<?php echo "Distance des pistes : ", ($elements['DISTANCEPISTEH']);?></td>
									<td>
								<div id="question">
									<form method="post" action="cible2.php">
									<label for="Date de naissance">Date de début</label>
									<input type="date" name="rdated"  maxlength="40" placeholder="Date de début" required><br>
									<label for="Date de naissance">Date de fin</label>
							 		<input type="date" name="rdatef"  maxlength="40" placeholder="Date de fin" required><br>
									<input id="submit" type="submit" value="Envoyer la réservation  "></form></td>
								</div>
								</tr>
							</table>
							<?php }  ?>
    
<br><br>
<footer>
	<?php include("footer.php"); ?>
</footer>
</div>
<div id="bg"></div>

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

</body>
</html>