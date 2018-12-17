<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
   <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <link rel="stylesheet" href="css/main.css"/>
    <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
    </head>

	<body>

  <body class="is-preload">

    <div id="wrapper">
        <?php include("header.php"); ?>
         <h1>Créer un compte</h1>





<?php
// S'il y des données de postées
if ($_SERVER['REQUEST_METHOD']=='POST') {
  // Code PHP pour traiter l'envoi de l'email
  
  $nombreErreur = 0; // Variable qui compte le nombre d'erreur
  
  // Définit toutes les erreurs possibles
  if (!isset($_POST['email'])) { // Si la variable "email" du formulaire n'existe pas (il y a un problème)
    $nombreErreur++; // On incrémente la variable qui compte les erreurs
    $erreur1 = '<p>Il y a un problème avec la variable "email".</p>';
  } else { // Sinon, cela signifie que la variable existe (c'est normal)
    if (empty($_POST['email'])) { // Si la variable est vide
      $nombreErreur++; // On incrémente la variable qui compte les erreurs
      $erreur2 = '<p>Vous avez oublié de donner votre email.</p>';
    } else {
      if (!filter_var($_POST['email'], FILTER_VALIDATE_EMAIL)) {
        $nombreErreur++; // On incrémente la variable qui compte les erreurs
        $erreur3 = '<p>Cet email ne ressemble pas un email.</p>';
      }
    }
  }
  
  if (!isset($_POST['message'])) {
    $nombreErreur++;
    $erreur4 = '<p>Il y a un problème avec la variable "message".</p>';
  } else {
    if (empty($_POST['message'])) {
      $nombreErreur++;
      $erreur5 = '<p>Vous avez oublié de donner un message.</p>';
    }
  }
  
  if (!isset($_POST['captcha'])) {
    $nombreErreur++;
    $erreur6 = '<p>Il y a un problème avec la variable "captcha".</p>';
  } else {
    if ($_POST['captcha']!=4) {
      $nombreErreur++;
      $erreur7 = '<p>Désolé, le captcha anti-spam est erroné.</p>';
    }
  }
  
  if ($nombreErreur==0) { // S'il n'y a pas d'erreur
    // Récupération des variables et sécurisation des données
    $nom = htmlentities($_POST['nom']); // htmlentities() convertit des caractères "spéciaux" en équivalent HTML
    $email = htmlentities($_POST['email']);
    $message = htmlentities($_POST['message']);
    
    // Variables concernant l'email
    $destinataire = 'allaindimitris@gmail.com'; // Adresse email du webmaster
    $sujet = 'Titre du message'; // Titre de l'email
    $contenu = '<html><head><title>Titre du message</title></head><body>';
    $contenu .= '<p>Bonjour, vous avez reçu un message à partir de votre site web.</p>';
    $contenu .= '<p><strong>Nom</strong>: '.$nom.'</p>';
    $contenu .= '<p><strong>Email</strong>: '.$email.'</p>';
    $contenu .= '<p><strong>Message</strong>: '.$message.'</p>';
    $contenu .= '</body></html>'; // Contenu du message de l'email
    
    // Pour envoyer un email HTML, l'en-tête Content-type doit être défini
    $headers = 'MIME-Version: 1.0'."\r\n";
    $headers .= 'Content-type: text/html; charset=iso-8859-1'."\r\n";
    
    @mail($destinataire, $sujet, $contenu, $headers); // Fonction principale qui envoi l'email
    
    echo '<h2>Message envoyé!</h2>'; // Afficher un message pour indiquer que le message a été envoyé
  } else { // S'il y a un moins une erreur
    echo '<div style="border:1px solid #ff0000; padding:5px;">';
    echo '<p style="color:#ff0000;">Désolé, il y a eu '.$nombreErreur.' erreur(s). Voici le détail des erreurs:</p>';
    if (isset($erreur1)) echo '<p>'.$erreur1.'</p>';
    if (isset($erreur2)) echo '<p>'.$erreur2.'</p>';
    if (isset($erreur3)) echo '<p>'.$erreur3.'</p>';
    if (isset($erreur4)) echo '<p>'.$erreur4.'</p>';
    if (isset($erreur5)) echo '<p>'.$erreur5.'</p>';
  if (isset($erreur6)) echo '<p>'.$erreur6.'</p>';
  if (isset($erreur7)) echo '<p>'.$erreur7.'</p>';
    echo '</div>';
  }
}
?>


	<form method="post" action="<?php echo strip_tags($_SERVER['REQUEST_URI']); ?>">
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

<footer>
  <?php include("footer.php"); ?>
</footer>
</div>
</div>
        <div id="bg"></div>

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>


  </body>
</html>