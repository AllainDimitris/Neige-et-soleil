<!DOCTYPE html>
<html>
	<head>
		<title>Reservation</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
   		<link rel="stylesheet" href="css/reservationequi.css"/>
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body>
		<body class="is-preload">

			<div id="wrapper">	
				<?php include("header.php"); ?>
<?php
if (!isset($_SESSION['ID']))
{
    header('Location: connexion.php');
}

?>

    <br><br>
<?php
								$_SESSION['CODEE'] = $_GET['CODEE'];
								try
								{
										$bdd = new PDO('mysql:host=localhost;dbname=Basesite','root','');

										$bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

								}
								catch (Exception $e)
								{
										die('Erreur :'.$e->getMessage());
								}
	$reponse=$bdd->query('SELECT CODEE, IDT, NOME, TAILLE FROM equipement where CODEE ='.$_GET['CODEE'].';');
	$donnees = $reponse->fetchAll();
	foreach ($donnees as $elements) {
									?>
							<table id="table" border>
										<?php echo "<img src=images/equipement/".$elements['CODEE'].".jpg width=350>";?><br>
								<tr>
									<td id="gauche">
										<?php echo($elements['NOME']);?>
										<?php echo($elements['TAILLE']);?><br>
									</td>
									<td>
								<div id="question">
									<form method="post" action="cible3.php">
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