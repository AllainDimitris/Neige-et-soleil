<?php
session_start();

if (isset($_SESSION['Email'])){

echo '<header id="header">
			<div class="content">
							<div class="inner">
								<h1>Accueil</h1>
								<p><a href="index.php">Bienvenue</a>
							</div>
						</div>
						<nav>
							<ul>
								<li><a href="index.php">Accueil</a></li>
								<li><a href="immobilier.php">Location immobilière</a></li>
								<li><a href="equipement.php">Location de materiel</a></li>
								<li><a href="profil.php">Vos reservations</a></li>
								<li><a href="deconnexion.php">Deconnexion</a></li>
							</ul>
						</nav>
					</header>' ;
}
	else {

echo '	<header id="header">
		<div class="content">
							<div class="inner">
								<h1>Accueil</h1>
								<p><a href="index.php">Bienvenue</a>
							</div>
						</div>
						<nav>
							<ul>
								<li><a href="index.php">Accueil</a></li>
								<li><a href="immobilier.php">Location immobilière</a></li>
								<li><a href="equipement.php">Location de materiel</a></li>
								<li><a href="form.php">Cree un compte</a></li>
								<li><a href="connexion.php">Connexion</a></li>
							</ul>
						</nav>
					</header>' ;
}
