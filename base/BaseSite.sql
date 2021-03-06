DROP DATABASE IF EXISTS BaseSite;

CREATE DATABASE IF NOT EXISTS BaseSite;
USE BaseSite;
# -----------------------------------------------------------------------------
#       TABLE : HABITATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS HABITATION

 (
   IDH INTEGER(4) NOT NULL  auto_increment,
   IDT INTEGER(4) NOT NULL  ,
   IDP INTEGER(4) NOT NULL, 
   ADRH VARCHAR(35) NULL  ,
   NUMEROH INTEGER(2) NULL  ,
   CPH INTEGER(5) NULL  ,
   VILLEH VARCHAR(25) NULL ,
   EXPOH VARCHAR(15) NULL  ,
   SURFACEHABH INTEGER(3) NULL  ,
   SURFACEBALH INTEGER(3) NULL  ,
   CAPACCH INTEGER(2) NULL  ,
   DISTANCEPISTEH varchar(6) NULL,
   MONTANT varchar(25) null,
   IMAGE varchar(155) null
   ,  PRIMARY KEY (IDH) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE HABITATION
# -----------------------------------------------------------------------------

CREATE  INDEX I_FK_HABITATION_PROPRIETAIRE
     ON HABITATION (IDP ASC);

CREATE  INDEX I_FK_HABITATION_TYPEHABITATION
     ON HABITATION (IDT ASC);

# -----------------------------------------------------------------------------
#       TABLE : TYPEHABITATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TYPEHABITATION
 (
   IDT INTEGER(4) NOT NULL  ,
   LIBELLE VARCHAR(2) NULL  ,
   TYPE varchar(20),
PRIMARY KEY (IDT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SAISON
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SAISON
 (
   IDS INTEGER(4) NOT NULL  ,
   DATEDEBUTS int(2) NULL  ,
   DATEFINS int(2) NULL  ,
   REDUCTIONS varchar(3) NULL  
   , PRIMARY KEY (IDS) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PROPRIETAIRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROPRIETAIRE
 (
   IDP INTEGER(4) NOT NULL auto_increment,
   NOMP VARCHAR(20) NULL  ,
   PRENOMP VARCHAR(20) NULL 
   , PRIMARY KEY (IDP) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CONTRATP
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONTRATP
 (
   REFERENCECP INTEGER(4) auto_increment NOT NULL  ,
   IDH INTEGER(4) NOT NULL  ,
   IDP INTEGER(4) NOT NULL  ,
   OBJETCP VARCHAR(20) NULL  ,
   DATEDEBCP date NULL  ,
   DATEFINCP date NULL  , 
   PRIMARY KEY (REFERENCECP) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONTRATP
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONTRATP_HABITATION
     ON CONTRATP (IDH ASC);

CREATE  INDEX I_FK_CONTRATP_PROPRIETAIRE
     ON CONTRATP (IDP ASC);

# -----------------------------------------------------------------------------
#       TABLE : CLIENT
# -----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS CLIENT
 (
   IDCL int auto_increment NOT NULL  ,
   SexeCL varchar(10) not null , 
   NOMCL VARCHAR(30) not NULL  ,
   PRENOMCL VARCHAR(30) not NULL  ,
   ADRMAILCL varchar(50) not null ,
   TelCL char(10) not null ,
   DATENAICL date not NULL   ,
   MdpCL varchar(100) not null,
   nbreservation int(3) default 0,
    PRIMARY KEY (IDCL) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CONTRAT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONTRAT
 (
   REFERENCEC INTEGER(4) auto_increment NOT NULL  ,
   IDH INTEGER(4) NOT NULL  ,
   IDR INTEGER(4) NOT NULL  ,
   OBJETC VARCHAR(25) NULL  ,
   PRIXC INTEGER(5) NULL  ,
   DATEDEBUTC date NULL ,
   DATEFINC date null
   , PRIMARY KEY (REFERENCEC) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONTRAT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONTRAT_HABITATION
     ON CONTRAT (IDH ASC);

CREATE UNIQUE INDEX I_FK_CONTRAT_RESERVATION
     ON CONTRAT (IDR ASC);

# -----------------------------------------------------------------------------
#       TABLE : RESERVATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RESERVATION
 (
   IDR INTEGER(4) auto_increment NOT NULL  ,
   IDCL INTEGER(4) NOT NULL  ,
   IDS INTEGER(4) NOT NULL  ,
   IDH INTEGER(4) NOT NULL  ,
   DATEDEBUTR date NULL  ,
   DATEFINR date NULL  ,
   ETATR VARCHAR(15) NULL  ,
   MONTANTR INTEGER(5) NULL  
   , PRIMARY KEY (IDR)
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE RESERVATION
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_RESERVATION_CLIENT
     ON RESERVATION (IDCL ASC);

CREATE  INDEX I_FK_RESERVATION_SAISON
     ON RESERVATION (IDS ASC);

CREATE  INDEX I_FK_RESERVATION_HABITATION
     ON RESERVATION (IDH ASC);


CREATE TABLE IF NOT EXISTS RESERVATIONE
 (
   IDRE INTEGER(4) auto_increment NOT NULL  ,
   IDCL INTEGER(4) NOT NULL  ,
   IDE INTEGER(4) NOT NULL  ,
   DATEDEBUTE date NULL  ,
   DATEFINRE date NULL  ,
   ETATRE VARCHAR(15) NULL  ,
   MONTANTRE INTEGER(5) NULL  
   , PRIMARY KEY (IDRE)
 ) 
 comment = "";

CREATE  INDEX I_FK_RESERVATIONE_CLIENT
     ON RESERVATIONE (IDCL ASC);

CREATE  INDEX I_FK_RESERVATIONE_EQUIPIMENT
     ON RESERVATIONE (IDE ASC);

# -----------------------------------------------------------------------------
#       TABLE : EQUIPEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EQUIPEMENT
 (
   CODEE INTEGER(4) auto_increment NOT NULL  ,
   IDTE INTEGER(4) NOT NULL  ,
   NOME VARCHAR(30) NULL  ,
   TAILLE varchar(2) NULL,
   MONTANT varchar(25) null,
   IMAGE varchar(155) null,
   PRIMARY KEY (CODEE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : TYPEHABITATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TYPEEQUIPEMENT
 (
   IDTE INTEGER(4) NOT NULL  ,
   LIBELLE VARCHAR(2) NULL  ,
   TYPE varchar(20),
PRIMARY KEY (IDTE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : USER
# -----------------------------------------------------------------------------

create table user(
  iduser int(5) not null auto_increment,
  email varchar(50) not null,
  mdp varchar(255) not null,
  nom varchar(50),
  prenom varchar(50),
  droits enum("admin","user","autre"),
  primary key(iduser)
  );

insert into user values
(null,"a@gmail.com","123","ben","oka","admin");

insert into user values(null,"b@gmail.com","123","ayoub","dimitris","user");

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE EQUIPEMENT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_EQUIPEMENT_TYPEEQUIPEMENT
     ON EQUIPEMENT (IDTE ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE HABITATION 
  ADD FOREIGN KEY FK_HABITATION_TYPEHABITATION (IDT)
      REFERENCES TYPEHABITATION (IDT) ;

ALTER TABLE HABITATION 
  ADD FOREIGN KEY FK_HABITATION_PROPRIETAIRE (IDP)
      REFERENCES PROPRIETAIRE (IDP) ;

ALTER TABLE CONTRATP 
  ADD FOREIGN KEY FK_CONTRATP_HABITATION (IDH)
      REFERENCES HABITATION (IDH) ;


ALTER TABLE CONTRATP 
  ADD FOREIGN KEY FK_CONTRATP_PROPRIETAIRE (IDP)
      REFERENCES PROPRIETAIRE (IDP) ;


ALTER TABLE CONTRAT 
  ADD FOREIGN KEY FK_CONTRAT_HABITATION (IDH)
      REFERENCES HABITATION (IDH) ;


ALTER TABLE CONTRAT 
  ADD FOREIGN KEY FK_CONTRAT_RESERVATION (IDR)
      REFERENCES RESERVATION (IDR) ;


ALTER TABLE RESERVATION 
  ADD FOREIGN KEY FK_RESERVATION_SAISONERVATION_CLIENT (IDCL)
      REFERENCES CLIENT (IDCL) ;

ALTER TABLE RESERVATION 
  ADD FOREIGN KEY FK_RESERVATION_SAISON (IDS)
      REFERENCES SAISON (IDS) ;

ALTER TABLE RESERVATION 
  ADD FOREIGN KEY FK_RESERVATION_HABITATION (IDH)
      REFERENCES HABITATION (IDH) ;

ALTER TABLE EQUIPEMENT 
  ADD FOREIGN KEY FK_EQUIPEMENT_TYPEEQUIPEMENT (IDTE)
      REFERENCES TYPEEQUIPEMENT (IDTE) ;

ALTER TABLE RESERVATIONE
  ADD FOREIGN KEY FK_RESERVATIONE_SAISONERVATION_CLIENT (IDCL)
      REFERENCES CLIENT (IDCL) ;

ALTER TABLE RESERVATIONE
  ADD FOREIGN KEY FK_RESERVATIONE_EQUIPEMENT (IDE)
      REFERENCES EQUIPEMENT (IDE) ;


insert into equipement values (0001,2,"Ski bleu et jaune",42, "80", "images/equipement/1.jpg");
insert into equipement values (0002,2,"Ski noire et rouge",40, "82", "images/equipement/2.jpg");
insert into equipement values (0003,2,"Ski Orange", 38, "80", "images/equipement/3.jpg");
insert into equipement values (0004,2,"Ski noire et Vert", 36, "85", "images/equipement/4.jpg");
insert into equipement values (0005,4,"Chaussure ski bleu", 42, "20", "images/equipement/5.jpg");
insert into equipement values (0006,4,"Chaussure ski grise", 40, "23", "images/equipement/6.jpg");
insert into equipement values (0007,4,"Chaussure ski noire", 38, "22", "images/equipement/7.jpg");
insert into equipement values (0008,4,"Chaussure ski noire et rouge",36, "20", "images/equipement/8.jpg");
insert into equipement values (0009,1,"Gants noir",35, "13", "images/equipement/9.jpg");
insert into equipement values (0010,1,"Gants noir et vert",40, "12", "images/equipement/10.jpg");
insert into equipement values (0011,1,"Gants noir",41, "20", "images/equipement/11.jpg");  
insert into equipement values (0012,3,"Casque Bleu", 32, "20", "images/equipement/12.jpg");
insert into equipement values (0013,3,"Casque vert", 38, "22", "images/equipement/13.jpg");
insert into equipement values (0014,3,"Casque vert",39, "15", "images/equipement/14.jpg");



insert into habitation values (1,2,1,"rue du salto",4,95120 ,"Font Romeu", "SUD", "200", "10", "10", "2 Km", "150", "images/habitation/1.jpg");
insert into habitation values (2,2,2,"rue de Kavin",4,96525,"Montaubans", "NORD", "150", "5", "8", "1 Km", "135", "images/habitation/2.jpg");
insert into habitation values (3,2,3,"avenue de la barre fixe",6,12017,"Matabiau", "SUD", "250", "20", "10", "2 Km", "125", "images/habitation/3.jpg");
insert into habitation values (4,2,1,"rue de la roue",28,98528,"Olette", "SUD", "100", "0", "5", "5 Km", "130", "images/habitation/4.jpg");
insert into habitation values (5,3,4,"rue de la croix",95,62382,"Toulouse", "SUD", "50", "20", "8", "2 Km", "150", "images/habitation/5.jpg");
insert into habitation values (6,3,5,"Rue de la chasse",58,85639,"Font Romeu", "NORD", "100", "10", "5", "1 Km", "140", "images/habitation/6.jpg");
insert into habitation values (7,3,2,"rue de la Potre",69,47557,"Montdemarsan", "SUD", "250", "20", "8", "2 Km", "120", "images/habitation/7.jpg");
insert into habitation values (8,1,3,"boulevard du Potro",26,84525,"Lyon", "SUD", "50", "20", "4", "1 Km", "100", "images/habitation/8.jpg");
insert into habitation values (9,3,2,"boulevard Victory",69,47557,"Montdemarsan", "SUD", "250", "20", "8", "2 Km", "150", "images/habitation/9.jpg");
insert into habitation values (10,1,1,"rue des roses",26,84525,"Thues entre valls", "SUD", "100", "20", "4", "1 Km", "110", "images/habitation/10.jpg");



insert into TYPEHABITATION values (1, "AP", "Appartement");
insert into TYPEHABITATION values (2, "CH", "Chalet");
insert into TYPEHABITATION values (3, "MA", "Maison");

insert into TYPEEQUIPEMENT values (1, "GA", "Gants");
insert into TYPEEQUIPEMENT values (2, "SK", "Ski");
insert into TYPEEQUIPEMENT values (3, "CA", "Casque");
insert into TYPEEQUIPEMENT values (4, "CH", "Chaussure");
insert into TYPEEQUIPEMENT values (5, "LU", "Luge");
insert into TYPEEQUIPEMENT values (6, "SB", "SnowBoard");


insert into saison values (0001, "03", "05","15%");
insert into saison values (0002, "06", "08","30%");
insert into saison values (0003, "09", "12","20%");
insert into saison values (0004, "01", "02","10%");



insert into client values (null, "Homme", "Jack", "Potro", "Jack@gmail.com", "0156589652", "1996-02-10", "aze", null);
insert into client values (null, "Femme", "Beatrice", "Dendre", "Dendre.Beatrice@gmail.com", "0658947512", "1975-03-18", "debea1975", null);
insert into client values (null, "Homme", "Thomas", "Menier", "Totomenier@gmail.com", "0628457300", "1981-10-04", "TOTOzob", null);
insert into client values (null, "Femme", "Sophia", "Petrovic", "SophiaPetro@gmail.com", "0628994103", "1989-11-05", "Socopoto18", null);
insert into client values (null, "Femme", "Zoubida", "Belkacem", "Belkazoub@gmail.com", "0658740012", "1963-12-25", "Molopoar523", null);
insert into client values (null, "Homme", "Patrick", "Motir", "Motir@gmail.com", "0658989652", "1994-06-20", "Patokil5", null);
insert into client values (null, "Femme", "Monique", "Maniko", "Monique@gmail.com", "0196589652", "1990-02-15", "OddfMS", null);
insert into client values (null, "Homme", "Nicolas", "Tori", "Torinic@gmail.com", "0699875125", "1996-06-19", "1254xskd", null);
insert into client values (null, "Homme", "Pierre", "Traore", "Traore.Pierre@gmail.com", "0185699652", "1990-12-10", "tra523dsd", null);
insert into client values (null, "Homme", "Hamidou", "Masnouhou", "Hamidou.masnou@gmail.com", "0698523468", "1985-02-06", "mas555ddf", null);

insert into proprietaire values (null, "Sakho", "Djemal");
insert into proprietaire values (null, "Sardarian", "Hamidou");
insert into proprietaire values (null, "Fournier", "Ayoub");
insert into proprietaire values (null, "Jiren", "Broly");
insert into proprietaire values (null, "Housni", "Pierre");
insert into proprietaire values (null, "Deunier", "Victor");
insert into proprietaire values (null, "Salif", "Frank");
insert into proprietaire values (null, "Qimpert", "Dominique");
insert into proprietaire values (null, "Lampard", "Thibault");
insert into proprietaire values (null, "Boubacari", "Koumba");  

insert into contratp values (null,1,2,'Maison', '2018-08-28','2018-08-30');
insert into contratp values (null,2,2,'Maison','2018-10-14','2018-12-30');
insert into contratp values (null,3,1,'Maison', '2019-10-15', '2019-11-12');
insert into contratp values (null,4,8,'Maison','2019-08-19', '2019-10-25');
insert into contratp values (null,5,4,'Maison', '2019-05-25', '2019-09-08');

insert into contrat values (null,5,5,"Ski",500,"2018-05-06","2018-07-15");
insert into contrat values (null,8,6,"planche",500,"2018-05-06","2018-08-04");
insert into contrat values (null,2,7,"chaussure",500,"2018-05-06","2018-08-02");
