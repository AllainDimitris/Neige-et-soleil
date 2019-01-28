DROP DATABASE IF EXISTS BaseSite;

CREATE DATABASE IF NOT EXISTS BaseSite;
USE BaseSite;
# -----------------------------------------------------------------------------
#       TABLE : HABITATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS HABITATION
 (
   IDH INTEGER(4) NOT NULL  ,
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
   DATEDEBUTS date NULL  ,
   DATEFINS date NULL  ,
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
   REFERENCECP INTEGER(4) NOT NULL  ,
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
   REFERENCEC INTEGER(4) NOT NULL  ,
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
   IDR INTEGER(4) NOT NULL  ,
   IDCL INTEGER(4) NOT NULL  ,
   IDS INTEGER(4) NOT NULL  ,
   DATEDEBUTR date NULL  ,
   DATEFINR date NULL  ,
   ETATR VARCHAR(15) NULL  ,
   SAISONR VARCHAR(15) NULL  ,
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

# -----------------------------------------------------------------------------
#       TABLE : EQUIPEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EQUIPEMENT
 (
   CODEE INTEGER(4) NOT NULL  ,
   IDT INTEGER(4) NOT NULL  ,
   NOME VARCHAR(25) NULL  ,
   ETATE VARCHAR(10) NULL,
   COULEUR CHAR(10) NULL, 
   TAILLE varchar(2) NULL,
   LETTRETAILLE CHAR(3) NULL 
   , PRIMARY KEY (CODEE) 
 ) 
 comment = "";

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


ALTER TABLE EQUIPEMENT 
  ADD FOREIGN KEY FK_EQUIPEMENT_TYPEHABITATION (IDT)
      REFERENCES TYPEHABITATION (IDT) ;

Insert into client values (null, "HOMME", "JOJO", "Mojo", "MojoJOJO@gmail.com", "2 Rue du palais", "75017", "Paris", "0675856880", "1992/10/05", "MOJO", "aaazzeee", 0); 


insert into equipement values(0001,0001,"ski","neuf","bleu",42,"M");
insert into equipement values(0002,0001,"ski","neuf","rouge",40,"M");
insert into equipement values(0003,0001,"ski","neuf","blanc",38,"M");
insert into equipement values(0004,0001,"ski","neuf","noir",36,"M");
insert into equipement values(0005,0002,"chaussure","neuf","jaune",42,"H");
insert into equipement values(0006,0002,"chaussure","neuf","bleu",40,"F");
insert into equipement values(0007,0002,"chaussure","neuf","rouge",38,"H");
insert into equipement values(0008,0002,"chaussure","neuf","vert",36,"F");
insert into equipement values(0009,0003,"gant","neuf","noir","S","H");
insert into equipement values(0010,0003,"gant","neuf","rouge","M","F");
insert into equipement values(0011,0003,"gant","neuf","vert","L","H");  
insert into equipement values(0012,0004,"casque","neuf","bleu","L","H");
insert into equipement values(0013,0004,"casque","neuf","vert","L","H");
insert into equipement values(0014,0004,"casque","neuf","vert","L","F");
insert into equipement values(0015,0005,"manteau","neuf","vert","L","F");
insert into equipement values(0016,0005,"manteau","neuf","vert","S","F");
insert into equipement values(0017,0005,"manteau","neuf","vert","M","H");
insert into equipement values(0018,0005,"manteau","neuf","vert","M","F");
insert into equipement values(0019,0005,"manteau","neuf","vert","XL","H");



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



insert into saison values(0001, "2018-11-18", "2018-12-20","10%");
insert into saison values(0002, "2018-12-21", "2019-03-30","0%");
insert into saison values (0003, "2019-04-01", "2019-06-30","25%");



