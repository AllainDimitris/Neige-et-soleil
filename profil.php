<!DOCTYPE html>
<html>
	<head>
		<title>Vos reservation</title>
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
										$bdd = new PDO('mysql:host=localhost;dbname=Basesite','root','');

										$bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

								}
								catch (Exception $e)
								{
										die('Erreur :'.$e->getMessage());
								}
								$reponse=$bdd->query('SELECT image, numeroh, adrh, villeh, datedebutr, datefinr, montantr 
									from habitation h, reservation r where h.idh = r.idh and idcl = '.$_SESSION['ID'].';');
								$donnees = $reponse->fetchAll();
								foreach ($donnees as $elements) {
									?>
							<table id="table" border>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="product-item">
									<tr>
										<td><img src=<?php echo $elements['image'];?> width=200>
										</a></td>
										<td id="az">
										<?php echo($elements['numeroh']);?>
										<?php echo($elements['adrh']);?>
										<?php echo($elements['villeh']), " ";?>
										<?php echo " Du ", ($elements['datedebutr'])," Au ";?>
										<?php echo($elements['datefinr']), " | ";?>
										<?php echo ($elements['montantr']), "€";?>
										</a>
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
