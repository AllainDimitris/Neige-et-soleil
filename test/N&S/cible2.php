<?php

try
{
    $bdd = new PDO('mysql:host=localhost;dbname=Basesite','root','');

    $bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

}
catch (Exeption $erreur)
{
    die('Erreur :'.$erreur->getMessage());
}


try {
    $bdd->beginTransaction();

    $CreationRes;
    $CreationRes = $bdd->prepare("INSERT INTO Reservation(idcl, ids, datedebutr, datefinr, etatr, saisonr, montantr) VALUES (:id, 1, :dated, :datef, :etatr, :saison, :montant);");
                            
                            $CreationRes->bindvalue(':id', htmlspecialchars($_SESSION['ID']), PDO::PARAM_INT);
                            $CreationRes->bindvalue(':dated', htmlspecialchars($_POST['rdated']), PDO::PARAM_STR);
                            $CreationRes->bindvalue(':datef', htmlspecialchars($_POST['rdatef']), PDO::PARAM_STR);
                            $CreationRes->execute();

} catch(\Exception $erreur) {
    throw new \Exception('Erreur survenue !' . $erreur->getMessage());
}

header('Location: immobilier.php');
?>
