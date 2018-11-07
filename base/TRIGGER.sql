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


insert into reservation values (1, 1,1, '2018-09-25', '2018-10-15', 'oui', 'été', 15);
insert into reservation values (3, 1,1, '2018-09-25', '2018-10-15', 'oui', 'été', 36);
insert into reservation values (2, 2,1, '2018-09-25', '2018-10-15', 'oui', 'été', 20);


create table histoRes as select * from reservation where 2=0;


drop trigger if exists historiqueres;
delimiter //
create trigger historiqueres
After delete on reservation
for each row
begin
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


		