<!DOCTYPE html PUBLIC"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>

   <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <link rel="stylesheet" href="css/connexion.css"/>
    <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
    </head>


  <body class="is-preload">

    <div id="wrapper">
 	<?php include("header.php"); ?>

		<div class="tableau flexChild">
			<h2 class="flexChild"> Connexion </h2>
			<form method="post">
				<table>
					<tr>
						<td>
							<input type="text" name="Email" placeholder="Adresse email" required>
						</td>
						<td>
							<input type="password" name="Password" placeholder="Mot de passe" required>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<?php
								if (isset($_POST["connexion"]))
								{
									$bdd = new PDO('mysql:host=localhost;dbname=Basesite','root','');

									$req = $bdd->prepare('SELECT IDCL, ADRMAILCL, MdpCL from client where ADRMAILCL = :Email');
									$req->execute(array('Email' => $_POST['Email']));
									$resultat = $req->fetch();

									$PasswordCorrect = password_verify($_POST["Password"], $resultat["MdpCL"]);

									if (!$resultat)
									{
										echo 'Mauvais identifiant ou mot de passe !';
									}
									else
									{
										if ($PasswordCorrect)
										{
											$_SESSION['Email'] = $resultat['ADRMAILCL'];
											$_SESSION['ID'] = $resultat['IDCL'];
											header('Location: http://localhost/Neige-et-soleil/test/N&S/index.php');
										}
										else
										{
											echo 'Mauvais identifiant ou mot de passe';
										}
									}
								}
							?>
							<input type="submit" class="button" name="connexion" value="Se connecter"/>
							<a href="form.php"> Pas encore inscrit ? </a>
						</td>
					</tr>
				</table>
			</form>
		</div>

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
