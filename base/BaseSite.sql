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
   ADRH VARCHAR(35) NULL  ,
   NUMEROH INTEGER(2) NULL  ,
   CPH INTEGER(5) NULL  ,
   VILLEH VARCHAR(25) NULL ,
   EXPOH VARCHAR(15) NULL  ,
   SURFACEHABH INTEGER(3) NULL  ,
   SURFACEBALH INTEGER(3) NULL  ,
   CAPACCH INTEGER(2) NULL  ,
   DISTANCEPISTEH varchar(6) NULL  
   ,  PRIMARY KEY (IDH) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE HABITATION
# -----------------------------------------------------------------------------


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
   IDP INTEGER(4) NOT NULL  ,
   NOMP VARCHAR(20) NULL  ,
   PRENOMP VARCHAR(20) NULL  ,
   ADRP VARCHAR(50) NULL  ,
   CPP INTEGER(5) NULL  ,
   VILLEP VARCHAR(20) NULL  ,
   DATENAIP date NULL  
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
   DATESIGNCP date NULL ,
   RENOUVELLEMENTC boolean,  
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
   DATESIGNC date NULL  
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
   IDS INTEGER(4) NOT NULL  ,
   IDH INTEGER(4) NOT NULL  ,
   DATEDEBUTE date NULL  ,
   DATEFINRE date NULL  ,
   ETATRE VARCHAR(15) NULL  ,
   MONTANTRE INTEGER(5) NULL  
   , PRIMARY KEY (IDRE)
 ) 
 comment = "";

CREATE  INDEX I_FK_RESERVATIONE_CLIENT
     ON RESERVATIONE (IDCL ASC);

CREATE  INDEX I_FK_RESERVATIONE_SAISON
     ON RESERVATIONE (IDS ASC);

CREATE  INDEX I_FK_RESERVATIONE_HABITATION
     ON RESERVATIONE (IDH ASC);

# -----------------------------------------------------------------------------
#       TABLE : EQUIPEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EQUIPEMENT
 (
   CODEE INTEGER(4) auto_increment NOT NULL  ,
   IDT INTEGER(4) NOT NULL  ,
   NOME VARCHAR(25) NULL  ,
   TAILLE varchar(2) NULL,
   PRIMARY KEY (CODEE) 
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


CREATE  INDEX I_FK_EQUIPEMENT_TYPEHABITATION
     ON EQUIPEMENT (IDT ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE HABITATION 
  ADD FOREIGN KEY FK_HABITATION_TYPEHABITATION (IDT)
      REFERENCES TYPEHABITATION (IDT) ;


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
  ADD FOREIGN KEY FK_EQUIPEMENT_TYPEHABITATION (IDT)
      REFERENCES TYPEHABITATION (IDT) ;

ALTER TABLE RESERVATIONE
  ADD FOREIGN KEY FK_RESERVATIONE_SAISONERVATION_CLIENT (IDCL)
      REFERENCES CLIENT (IDCL) ;

ALTER TABLE RESERVATIONE
  ADD FOREIGN KEY FK_RESERVATIONE_SAISON (IDS)
      REFERENCES SAISON (IDS) ;

ALTER TABLE RESERVATIONE
  ADD FOREIGN KEY FK_RESERVATIONE_HABITATION (IDH)
      REFERENCES HABITATION (IDH) ;


insert into equipement values(0001,0001,"Ski noire et orange",42);
insert into equipement values(0002,0001,"Ski noire et rouge",40);
insert into equipement values(0003,0001,"Ski Orange", 38);
insert into equipement values(0004,0001,"Ski noire et Vert", 36);
insert into equipement values(0005,0002,"Chaussure ski bleu", 42);
insert into equipement values(0006,0002,"Chaussure ski grise", 40);
insert into equipement values(0007,0002,"Chaussure noire", 38);
insert into equipement values(0008,0002,"Chaussure noire et rouge",36);
insert into equipement values(0009,0003,"Gants noir",35);
insert into equipement values(0010,0003,"Gants noir et vert",40);
insert into equipement values(0011,0003,"Gants noir",41);  
insert into equipement values(0012,0004,"Casque Bleu", 32);
insert into equipement values(0013,0004,"Casque vert", 38);
insert into equipement values(0014,0004,"Casque vert",39);



insert into habitation values(1,2,"rue du salto",4,95120 ,"Toulouse", "SUD", "200", "10", "10", "2 Km");
insert into habitation values(2,2,"rue de Kavin",4,96525,"Montaubans", "NORD", "150", "5", "8", "1 Km");
insert into habitation values(3,2,"avenue de la barre fixe",6,12017,"Matabiau", "SUD", "250", "20", "10", "2 Km");
insert into habitation values(4,2,"rue de la roue",28,98528,"Saint prix", "SUD", "100", "0", "5", "5 Km");
insert into habitation values(5,3,"rue de la croix",95,62382,"Toulouse", "SUD", "50", "20", "8", "2 Km");
insert into habitation values(6,3,"Rue de la chasse",58,85639,"Matabiau", "NORD", "100", "10", "5", "1 Km");
insert into habitation values(7,3,"rue de la Potre",69,47557,"Montdemarsan", "SUD", "250", "20", "8", "2 Km");
insert into habitation values(8,1,"boulevard du Potro",26,84525,"Lyon", "SUD", "50", "20", "4", "1 Km");

insert into TYPEHABITATION values(1, "AP", "Appartement");
insert into TYPEHABITATION values(2, "CH", "Chalet");
insert into TYPEHABITATION values(3, "MA", "Maison");



insert into saison values(0001, "03", "05","15%");
insert into saison values(0002, "06", "08","30%");
insert into saison values (0003, "09", "11","20%");
insert into saison values (0004, "12", "02","10%");



insert into client values (null, "Homme", "Jack", "Potro", "Jack@gmail.com", "0156589652", "1996-02-10", "aze", null);