<!DOCTYPE html>
<html>
	<head>

		<title>Zone de location</title>
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
		<div id= "contenuprincipale">
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2826.2851648306023!2d6.632144615538548!3d44.89719437909839!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNDTCsDUzJzQ5LjkiTiA2wrAzOCcwMy42IkU!5e0!3m2!1sfr!2sfr!4v1537350096403"
 width="500" height="500" frameborder="0" style="border:0" allowfllscreen></iframe>
		</div>

<footer>
	<<?php include("footer.php"); ?>
</footer>
</body>
</html>
