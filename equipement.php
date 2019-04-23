<!DOCTYPE html>
<html>
	<head>
		<title>Location Immobiliere</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="css/main.css"/>
		<link rel="stylesheet" href="css/equipement.css"/>
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
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
				$reponse=$bdd->query('select distinct CODEE,NOME,TAILLE FROM equipement e, reservatione re
where e.codee = re.ide
and curdate() not between datedebute and datefinre
or e.codee not in (select ide from reservatione);');
				$donnees = $reponse->fetchAll();
				foreach ($donnees as $elements) {
					?>
					<table id="table" border>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="product-item">
					<tr>
						<td><a href="reservationequip.php?CODEE=<?php echo $elements['CODEE']; ?>"> <?php echo "<img src=images/equipement/".$elements['CODEE'].".jpg width=300>";?></a></td>
						<td><a id="mais" href="reservationequip.php?CODEE=<?php echo $elements['CODEE']; ?>">
							<?php echo ($elements['NOME']);?>
							<?php echo " , Taille : ", ($elements['TAILLE']);?>
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
			<form action="" class="formulaire">

                </form>


			<?php include("header.php"); ?>
			<p>
                        Recherche
            </p>





                </div>

	</body>
</html>
