<!DOCTYPE html>
<html>
	<head>

		<title>Contact</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/stylescontact.css"/>




	</head>
	<body>
		<header>
		<h1> Neige et Soleil</h1>
		<?php include("header.php"); ?>
		</header> 

	<form method="post" action="Cible1.php">


<div id="question">
	<?php
// S'il y des données de postées
if ($_SERVER['REQUEST_METHOD']=='POST') {
 
  // (1) Code PHP pour traiter l'envoi de l'email
 
  // Récupération des variables et sécurisation des données
  $nom     = htmlentities($_POST['nom']); // htmlentities() convertit des caractères "spéciaux" en équivalent HTML
  $email   = htmlentities($_POST['email']);
  $message = htmlentities($_POST['message']);
 
  // Variables concernant l'email
 
  $destinataire = 'contact@example.com'; // Adresse email du webmaster (à personnaliser)
  $sujet = 'Titre du message'; // Titre de l'email
  $contenu = '<html><head><title>Titre du message</title></head><body>';
  $contenu .= '<p>Bonjour, vous avez reçu un message à partir de votre site web.</p>';
  $contenu .= '<p><strong>Nom</strong>: '.$nom.'</p>';
  $contenu .= '<p><strong>Email</strong>: '.$email.'</p>';
  $contenu .= '<p><strong>Message</strong>: '.$message.'</p>';
  $contenu .= '</body></html>'; // Contenu du message de l'email (en XHTML)
 
  // Pour envoyer un email HTML, l'en-tête Content-type doit être défini
  $headers = 'MIME-Version: 1.0'."\r\n";
  $headers .= 'Content-type: text/html; charset=iso-8859-1'."\r\n";
 
  // Envoyer l'email
  mail($destinataire, $sujet, $contenu, $headers); // Fonction principale qui envoi l'email
  echo '<h2>Message envoyé!</h2>'; // Afficher un message pour indiquer que le message a été envoyé
  // (2) Fin du code pour traiter l'envoi de l'email
}
?>
	<form method="post" action="<?php echo strip_tags($_SERVER['REQUEST_URI']); ?>">
      <p>Votre nom et prénom: <input type="text" name="nom" size="30" /></p>
      <p>Votre email: <span style="color:#ff0000;">*</span>: <input type="text" name="email" size="30" /></p>
      <p>Message <span style="color:#ff0000;">*</span>:</p>
      <textarea name="message" cols="60" rows="10"></textarea>
      <!-- Ici pourra être ajouté un captcha anti-spam (plus tard) -->
      <p><input type="submit" name="submit" value="Envoyer" /></p>
    </form>

</div>
</form>
</body>

		





<footer>
		<?php include("footer.php"); ?>
</footer>

</body>
</html>
