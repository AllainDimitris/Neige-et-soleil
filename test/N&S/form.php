<!DOCTYPE html PUBLIC"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>

   <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <link rel="stylesheet" href="css/form.css"/>
    <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>

     
    </head>


  <body class="is-preload">

    <div id="wrapper"> 
 	<?php include("header.php"); ?>
         

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

  <form method="post" action="cible1.php">

<div id="question">
	Sexe <br>
  <input type="radio" name="cciv" id="homme" value="homme">  <label for="homme">Homme</label> 
  <input type="radio" name="cciv" id="femme" value="femme">  <label for="femme">Femme</label>
  <br><br>
	<label for="nom">Nom</label>
	<input type="text" name="cnom" maxlength="30" placeholder="Nom" autofocus required pattern="[A-Za-z]{1,30}" title="Caractère spéciaux non admit"><br>
	<label for="prénom">Prénom</label>
	<input type="text" name="cprnom" maxlength="30" placeholder="Prénom" required pattern="[A-Za-z]{1,30}" title="Caractère spéciaux non admit"><br>
	<label for="email">E-Mail</label>
	<input type="email" name="cmail" maxlength="50" placeholder="E-Mail" required ><br>
	<label for="adresse">Adresse</label>
	<input type="text" name="cadr" maxlength="100" placeholder="Adresse" required ><br>
	<label for="CP">Code Postal</label>
	<input type="text" name="ccp" maxlength="5" placeholder="Code Postal" required ><br>
 	<label for="CP">Ville</label>
	<input type="text" name="cvil" maxlength="30" placeholder="Ville" required ><br>
 	<label for="Numéro de téléphone">Téléphone</label>
 	<input type="text" name="ctel"  maxlength="10" placeholder="Téléphone" required><br>
 	<label for="Date de naissance">Date de naissance</label>
 	<input type="date" name="cdate"  maxlength="40" placeholder="Date de naissance" required ><br>
 	<label for="Login">Login</label>
 	<input type="text" name="clog" maxlength="20" placeholder="Login" required pattern="[A-Za-z]{1,30}" title="Caractère spéciaux non admit"><br>
	<label for="Mot de passe">Mot de passe</label>
	<input type="password" name="cmdp"  maxlength="20" placeholder="Mot de passe" required ><br>
	<center>
	<label></label>
	<input id="submit" type="submit" value="Envoyer le formulaire  ">	
	</center>
 </div>
</form>


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