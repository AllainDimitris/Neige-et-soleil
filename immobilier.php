<!DOCTYPE html>
<html>
	<head>
		<title>Location Immobiliere</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="css/immobilier.css"/>
		<link rel="stylesheet" href="css/main.css"/>
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body>
		<body class="is-preload">

			<div id="wrapper">
				<?php include("header.php"); ?>
				

                <form action="" class="formulaire"> <br>
								<?php
								try
								{
										$bdd = new PDO('mysql:host=localhost;dbname=basesite','root','');

										$bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

								}
								catch (Exception $e)
								{
										die('Erreur :'.$e->getMessage());
								}
								$reponse=$bdd->query('SELECT IDH,NUMEROH,ADRH,CPH,VILLEH,EXPOH, SURFACEHABH, SURFACEBALH, CAPACCH, DISTANCEPISTEH FROM habitation');
								$donnees = $reponse->fetchAll();
								foreach ($donnees as $elements) {
									?>
							<table id="table" border>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="product-item">
									<tr>
										<td><a href="reservationimmo.php?IDH=<?php echo $elements['IDH']; ?>"> <?php echo "<img src=images/habitation/".$elements['IDH'].".jpg width=300>";?></a></td>
										<td id="az"><a id='mais' href="reservationimmo.php?IDH=<?php echo $elements['IDH']; ?>">
										<?php echo($elements['NUMEROH']);?>
										<?php echo($elements['ADRH']);?>
										<?php echo($elements['VILLEH']);?>
										<?php echo($elements['CPH']);?>
										<?php echo "Exposition : ", ($elements['EXPOH']);?>
										<?php echo "Surface habitable : ", ($elements['SURFACEHABH']);?>
										<?php echo "Surface balcon : ", ($elements['SURFACEBALH']);?>
										<?php echo "Capacité : ", ($elements['CAPACCH']);?>
										<?php echo "Distance des pistes : ", ($elements['DISTANCEPISTEH']);?></a>
										</td>
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

</body>
</html>
