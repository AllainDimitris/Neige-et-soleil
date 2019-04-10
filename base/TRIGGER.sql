update client set nbreservation=(select count(idr) from reservation where client.idcl=reservation.idcl group by client.idcl);



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
then signal sqlstate '45000' set message_text = "Impossible";
else  
insert into histores values (old.idr, old.idcl, old.ids,old.datedebutr, old.datefinr, old.etatr, old.saisonr, old.montantr);
end //
delimiter ;


insert into contrat values (1,5,5,"8 ski",500,"2018-05-06","2018-07-15");
insert into contrat values (2,8,6,"planche",500,"2018-05-06","2018-08-04");
insert into contrat values (3,2,7,"chaussure",500,"2018-05-06","2018-08-02");

alter table contrat add datefinc date;

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

insert into contrat values(5555,5555,6666,'location',1500,'2018-08-28','2018-08-30','2018-09-30')
insert into contrat values(5559,5855,6776,'location',3000,'2018-08-28','2018-08-30','2018-09-30')

create table archivep as select * from contratp where 2=0; 
drop trigger if exists archivep1; 
delimiter // 
create trigger archivep1 
	before delete on contratp
	for each row 
	begin 
	insert into archivep select * from contratp where referencecp=old.referencecp;
		end // 

		delimiter ;

drop trigger if exists archivep2;
delimiter // 
create trigger archivep2
after update on contratp 
for each row 
begin 
insert into archivep select * from contratp where referencecp=old.referencecp;
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




Create view STAT (nbresa,saisr) 
as select sum(nbreservation),r.ids from client c, saison s, reservation r 
where c.idcl = r.idcl
and r.ids = s.ids;



create view stat2 (nomp,prenomp,referencecp,annee)
as select nomp,prenomp,count(referencecp), year(datesignc) from contratp
where contraP.IDP = proprietaire.IDP 
group by contratp.IDP,year(datesignc);  



create table archivep3 as select * from contratp where 2=0; 
drop trigger if exists archivep3; 
delimiter // 
create trigger archivep3
	before delete on contratp
	for each row 
	begin 
	if RENOUVELLEMENTC = 'true'
	contratp = 'renouvellement'
	else 
	insert into archive3 select * from contratp where referencep = old.referencep;
		end // 
		delimiter ;



drop trigger if exists verifsaison;
delimiter //
create trigger verifsaison
before insert on reservation 
for each row
begin 
declare nums int(2);
select ids into nums from saison
 where month(new.datedebutr) between datedebuts and datefins;
 set new.ids = nums;
end //
delimiter ;