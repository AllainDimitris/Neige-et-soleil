<!DOCTYPE html>
<html>
	<head>

		<title>Questionnaire</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/stylesquest.css"/>




	</head>
	<body>
		<header>
		<h1> Neige et Soleil</h1>
		</header> <!-- haut de page--> <!-- div sert à créer des boites plutot que des ensembles et de les nommer-->



			<nav>
				<ul>
					<li class="menu-accueil"> <a href="Acceuil.php">Accueil</a></li>
					<li class="menu-immo"> <a href="LocationImmobiliere.php">Location Immobiliere</a></li>
					<li class="menu-randonne"> <a href="LocationMateriel.php">Location de matériel de randonnées</a></li>
					<li class="menu-connection"> <a href="Form.php">Créer un compte</a></li>
				</ul>
			</nav>

<?php
/*
	Si tu utilises le "Header:location" que je t'ai proposé dans Cible.php Ligne 74 : voici comment traiter la variable passée dans l'URL ($_GET)
	Si tu ne t'utilises pas tu peux enlever complètement cette partie de PHP


	if(array_key_exists('ajout', $_GET) && $_GET['ajout'] === 'ok') {
		echo "<h2>L'ajout du client a été fait avec succès</h2>";
	}
*/
?>

	<h1 align="center"> Veuillez entrer vos informations</h1>

	<body bgcolor="#9683EC">

	<form method="post" action="Cible1.php">

<div id="question">
Sexe : <br>
  <input type="radio" name="cciv" id="homme" value="homme">  <label for="homme">Homme</label>
  <br>
  <input type="radio" name="cciv" id="femme" value="femme">  <label for="femme">Femme</label>
  <br><br>
	<label for="nom">Nom</label>
	<input type="text" name="cnom" maxlength="30" placeholder="Nom" autofocus required pattern="[A-Za-z]{1,30}" title="Caractère spéciaux non admit">
 <br><br>
	<label for="prénom">Prénom</label>
	<input type="text" name="cprnom" maxlength="30" placeholder="Prénom" required pattern="[A-Za-z]{1,30}" title="Caractère spéciaux non admit">
 <br><br>
	<label for="email">E-Mail</label>
	<input type="email" name="cmail" maxlength="50" placeholder="E-Mail" required >
 <br><br>
	<label for="adresse">Adresse</label>
	<input type="text" name="cadr" maxlength="100" placeholder="Adresse" required >
 <br><br>
	<label for="CP">Code Postal</label>
	<input type="text" name="ccp" maxlength="5" placeholder="Code Postal" required >
 <br><br>
 	<label for="CP">Ville</label>
	<input type="text" name="cvil" maxlength="30" placeholder="Ville" required >
 <br><br>
 	<label for="Numéro de téléphone">Numéro de téléphone</label>
 	<input type="text" name="ctel"  maxlength="10" placeholder="Téléphone" required>
 <br><br>
 	<label for="Date de naissance">Date de naissance</label>
 	<input type="Date" name="cdate"  maxlength="20" placeholder="Date de naissance" required >
 <br><br>
 	<label for="Login">Login</label>
 	<input type="text" name="clog" maxlength="20" placeholder="Login" required pattern="[A-Za-z]{1,30}" title="Caractère spéciaux non admit">
 <br><br>
	<label for="Mot de passe">Mot de passe</label>
	<input type="password" name="cmdp"  maxlength="20" placeholder="Mot de passe" required >
 <br><br>
	<center>
		<input id="submit" type="submit" value="Envoyer le formulaire"/>
	</center>
 <br><br>
</form>
</div>

<footer>
		<?php include("footer.php"); ?>
</footer>

</body>
</html>
