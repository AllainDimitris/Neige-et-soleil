select distinct h.IDH,NUMEROH,ADRH,CPH,VILLEH,EXPOH, SURFACEHABH, SURFACEBALH, CAPACCH, DISTANCEPISTEH from habitation h, reservation r
where h.idh = r.idh
and curdate() not between datedebutr and datefinr
or h.idh not in (select idh from reservation);