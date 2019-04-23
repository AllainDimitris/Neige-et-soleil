/* Habitation */
select distinct h.IDH,NUMEROH,ADRH,CPH,VILLEH,EXPOH, SURFACEHABH, SURFACEBALH, CAPACCH, DISTANCEPISTEH from habitation h, reservation r
where h.idh = r.idh
and curdate() not between datedebutr and datefinr
or h.idh not in (select idh from reservation);

/*Equipement*/
select distinct CODEE,NOME,TAILLE FROM equipement e, reservatione re
where e.codee = re.ide
and curdate() not between datedebute and datefinre
or e.codee not in (select ide from reservatione);






