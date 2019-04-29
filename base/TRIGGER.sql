update client set nbreservation=(select count(idr) from reservation where client.idcl=reservation.idcl group by client.idcl);


/* Nombre de reservation par client*/
drop trigger if exists nbreservation;
delimiter //
create trigger nbreservation
after 
	insert on reservation for each row
begin
	update client set nbreservation=nbreservation+1 where idcl=new.idcl;
end //
delimiter ;



drop trigger if exists dropreservation;
delimiter //
create trigger dropreservation
after 
	delete on reservation for each row
begin
	update client set nbreservation=nbreservation-1 where idcl=old.idcl;
end //
delimiter ;



create table histoRes as select * from reservation where 2=0;


drop trigger if exists historiqueres;
delimiter //
create trigger historiqueres
After delete on reservation
for each row
begin
if old.datefinr is null
then 
signal sqlstate '45000' 
set message_text = "Impossible";
else
insert into histores select * from reservation where idr = old.idr;
end if;
end //
delimiter ;


create table archive as select * from contrat where 2=0; 
drop trigger if exists archive; 
delimiter // 
create trigger archive 
	after delete on contrat
	for each row 
	begin 
	insert into archive values(old.idh, old.idr, old.objetc, old.prixc, old.datesignc,old.datefinc);
		end // 

		delimiter ;

drop trigger if exists archive2;
delimiter //
create trigger archive2
after update on contrat 
for each row 
begin 
insert into archive select * from contrat where referencec=old.referencec;
end //
delimiter ; 		



create table archivep as select * from contratp where 2=0; 
drop trigger if exists archivep1; 
delimiter // 
create trigger archivep1 
	before delete on contratp
	for each row 
	begin 
	insert into archivep select * from contratp 
		where referencecp=old.referencecp;
		end // 
		delimiter ;

drop trigger if exists archivep2;
delimiter // 
create trigger archivep2
after update on contratp 
for each row 
begin 
insert into archivep select * from contratp 
	where referencecp=old.referencecp;
end //
delimiter ;

drop trigger if exists validresa;
delimiter // 
create trigger validresa
before insert on contrat 
for each row 
begin 
declare x int;
select count(*) into x from reservation
where idr = new.idr and etatr = 'valide';
if x=0 
then 
signal sqlstate '45000'
		set message_text = 'non reserve';
end if; 
end//
delimiter ;		


Create view STAT (Saison, Nombredereservation) 
as select count(nbreservation),r.ids 
from client c, saison s, reservation r 
where c.idcl = r.idcl
and r.ids = s.ids
group by r.ids;

create view Statparclient (Nom, Prenom, Nombredereservation)
as select nomcl, prenomcl, count(*) 
from client c, reservation r
where c.idcl = r.idcl
group by nomcl;

create view stathabmois (Mois, Annee, Nombredereservation)
as select month(datedebutr), year(datedebutr), count(*) from reservation
group by month(datedebutr), year(datedebutr);

create view statequimois (Mois, Annee, Nombredereservation)
as select month(datedebute), year(datedebute), count(*) from reservatione
group by month(datedebute), year(datedebute);

create view Procontrat (IDP, Habitation, Nom, Prenom, Datedebut, Datefin)
as select p.idp, idh, nomp, prenomp, datedebcp, datefincp
from proprietaire p, contratp c
where p.idp = c.idp
group by idh;

create view Inventaireequip as select ifnull(idte, 'Resultat') as materiel, count(case when idte='1' then codee else null end) as Gants,
count(case when idte = '2' then codee else null end) as Ski, 
count(case when idte = '3' then codee else null end) as Casque,
count(case when idte = '4' then codee else null end) as Chaussure,
count(case when idte = '5' then codee else null end) as Luge,
count(case when idte = '6' then codee else null end) as SnowBoard,
count(*) as total from equipement group by idte with rollup;


create view Inventairehab as select ifnull(idt, 'Resultat') as Habitation, count(case when idt='1' then idh else null end) as Appartement,
count(case when idt = '2' then idh else null end) as Chalet, 
count(case when idt = '3' then idh else null end) as Maison,
count(*) as total from habitation group by idt with rollup;

/*

create view stat2 (nomp,prenomp,referencecp,annee)
as select nomp,prenomp,count(referencecp), year(datesignc) 
from contratp
where contraP.IDP = proprietaire.IDP 
group by contratp.IDP,year(datesignc);  


create table archivep3 as select * from contratp where 2=0; 
drop trigger if exists archivep3; 
delimiter // 
create trigger archivep3
	before delete on contratp
	for each row 
	begin 
	if RENOUVELLEMENTC = 1
	then
	set contratp = 'renouvellement';
	else 
	insert into archive3 select * from contratp 
	where referencep = old.referencep;
	end if;
end // 
delimiter ;
*/


drop trigger if exists verifsaison;
delimiter //
create trigger verifsaison
before insert on reservation 
for each row
begin 
declare nums int(2);
select ids into nums from saison
 where month(new.datedebutr) between datedebuts 
 and datefins;
 set new.ids = nums;
end //
delimiter ;




drop trigger if exists Calculmontant;
delimiter //
create trigger Calculmontant
after 
	insert on reservation for each row
begin
declare jours int(5);
	select DATEDIFF('datedebutr', 'datefinr') into jours from reservation;
	set new.montantr = jours*prixh;
end //
delimiter ;



drop trigger if exists verifreserv;
delimiter //
create trigger verifreserv
before 
	insert on reservation for each row
begin
declare jours int(5);
	select DATEDIFF('datedebutr', 'datefinr') into jours from reservation

end //
delimiter ;


drop trigger if exists stockhab;
delimiter //
create trigger stockhab
before 
	insert on reservation for each row
begin
	declare datefin date;
	select max(datefinr) into datefin from reservation where idh = new.idh;
	if new.datedebutr < datefin 
	then 
	signal sqlstate'45000' set message_text='Habitation non disponible';
	end if;
end //
delimiter ;