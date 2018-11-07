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
if old.datefinr is null
then signal sqlstate '45000' set message_text = "Impossible";
else  
insert into histores values (old.idr, old.idcl, old.ids,old.datedebutr, old.datefinr, old.etatr, old.saisonr, old.montantr);
end //
delimiter ;
