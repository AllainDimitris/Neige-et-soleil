<?php


/*

Avant tout, il faut vérifier si :

- Chaque variable existe (if(isset($_POST['cciv'])) par exemple)
- Vérifier le type de chaque variable (surtout pour les variables autre que des chaines de caractères)
- Protéger avec "htmlspecialchars()" pour éviter l'execution de code
*/

$a=$_POST['cciv'];
$b=$_POST['cnom'];
$c=$_POST['cprnom'];
$d=$_POST['cmail'];
$h=$_POST['ctel'];
$i=$_POST['cdate'];
$k=password_hash($_POST['cmdp'], PASSWORD_DEFAULT);


// On protège la connexion avec un try...catch pour gérer les exceptions
try
{
    // Connexion à MySQL via PDO
    $bdd = new PDO('mysql:host=localhost;dbname=Basesite','root','');
    // J'ai rajouté la ligne juste en dessous
    // Pourquoi ? ça permet de dire à PDO de générer des exceptions quand il y a des problèmes, sinon il le fait pas et les try...catch ne servent à rien
    $bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

}
catch (Exeption $erreur)
{
    die('Erreur :'.$erreur->getMessage());
}


// On protège la requête SQL avec un try...catch pour faire sortir les erreurs et les gérer (c'est comme ça que j'ai debuggué)
try {

    // De base tu avais utiliser "$bdd->query" : enfait ça s'est plutôt pour des "SELECT"
    // pour faire de l'insertion/modification/suppression il vaut mieux utiliser "$query->exec"

    // Le problème est que tu as des variables issues d'un formulaire (tu t'exposes à des injections SQL (je te laisse regarder sur le net))
    // Pour résoudre le problème des varaibles il existe des requêtes "préparées" : on fait la requête en 2 temps :
    // - Préparation : "$bdd->prepare" : on fournit la requête SQL avec des "?" pour chaque variable qu'on va renseigner ensuite
    // - Execution   : "$bdd->execute" : on fournit un tableau avec toutes les variables qu'on veut envoyer

    // Ca parait plus compliqué mais on s'y fait (et c'est surtout plus sécuritaire)

    $query = $bdd->prepare("INSERT INTO `client`(`SexeCL`, `NOMCL`, `PRENOMCL`, `ADRMAILCL`,`TelCL`, `DATENAICL`,`MdpCL`) VALUES (?,?,?,?,?,?,?)");


    // "$query->execute" retourne "true" si ça s'est bien passé
    $isItOk = $query->execute([$a, $b, $c, $d,$h, $i,$k]);
    if($isItOk) {
        echo "Ajout du client effectué" ;
    }

    $query->closeCursor();

} catch(\Exception $erreur) {
    // C'est comme ça qu'on gère les exceptions, c'est plus propre qu'un "die"
    throw new \Exception('Erreur survenue !' . $erreur->getMessage());
}

// Ok pour le "include", ça fonctionnne : mais pourquoi ne pas faire une redirection vers la première page ?
// header('Location: Questionnaire1.php');
// Si tu veux afficher un message de confirmation tu peux le passer avec des paramètres GET
//header('Location: Questionnaire1.php?ajout=ok');
include("form.php");

?>
