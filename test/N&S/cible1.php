<?php


/*

Avant tout, il faut vérifier si :

- Chaque variable existe (if(isset($_POST['cciv'])) par exemple)
- Vérifier le type de chaque variable (surtout pour les variables autre que des chaines de caractères)
- Protéger avec "htmlspecialchars()" pour éviter l'execution de code
*/

$b=$_POST['cnom'];
$c=$_POST['cprnom'];
$d=$_POST['cmail'];
$h=$_POST['ctel'];
$i=$_POST['cdate'];
$k=password_hash($_POST['cmdp'], PASSWORD_DEFAULT);



    // Pourquoi ? ça permet de dire à PDO de générer des exceptions quand il y a des problèmes, sinon il le fait pas et les try...catch ne servent à rien
    $bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

 
}
catch (Exeption $erreur)
{
    die('Erreur :'.$erreur->getMessage());


    // Ca parait plus compliqué mais on s'y fait (et c'est surtout plus sécuritaire)

  
    $query = $bdd->prepare("INSERT INTO `client`(`SexeCL`, `NOMCL`, `PRENOMCL`, `ADRMAILCL`,`TelCL`, `DATENAICL`,`MdpCL`) VALUES (?,?,?,?,?,?,?)");


    // "$query->execute" retourne "true" si ça s'est bien passé
    $isItOk = $query->execute([$a, $b, $c, $d,$h, $i,$k]);
    if($isItOk) {
        echo "Ajout du client effectué" ;
    }


// Ok pour le "include", ça fonctionnne : mais pourquoi ne pas faire une redirection vers la première page ?
// header('Location: Questionnaire1.php');
 
// Si tu veux afficher un message de confirmation tu peux le passer avec des paramètres GET
//header('Location: Questionnaire1.php?ajout=ok');
header('Location: connexion.php');

?>