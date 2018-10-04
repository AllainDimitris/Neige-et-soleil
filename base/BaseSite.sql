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
   NOMH VARCHAR(20) NULL  ,
   ADRH VARCHAR(35) NULL  ,
   NUMEROH INTEGER(2) NULL  ,
   CPH INTEGER(5) NULL  ,
   VILLEH VARCHAR(25) NULL  
   , PRIMARY KEY (IDH) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE HABITATION
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_HABITATION_TYPEAPPARTEMENT
     ON HABITATION (IDT ASC);

# -----------------------------------------------------------------------------
#       TABLE : TYPEAPPARTEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TYPEAPPARTEMENT
 (
   IDT INTEGER(4) NOT NULL  ,
   TYPET CHAR(2) NULL  ,
   EXPOT VARCHAR(15) NULL  ,
   SURFACEHABT INTEGER(3) NULL  ,
   SURFACEBALT INTEGER(3) NULL  ,
   CAPACCT INTEGER(2) NULL  ,
   DISTANCEPISTET INTEGER(4) NULL  
   , PRIMARY KEY (IDT) 
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
   REDUCTIONS INTEGER(3) NULL  
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
   DATESIGNCP date NULL  
   , PRIMARY KEY (REFERENCECP) 
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
   ADRCL VARCHAR(50) not NULL  ,
   CPCL char(5) not NULL  ,
   VILLECL VARCHAR(30) not NULL  ,
   TelCL char(10) not null ,
   DATENAICL date not NULL   ,
   LoginCL varchar(20) not null,
   MdpCL varchar(20) not null,
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
   ETATE VARCHAR(10) NULL  
   , PRIMARY KEY (CODEE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE EQUIPEMENT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_EQUIPEMENT_TYPEAPPARTEMENT
     ON EQUIPEMENT (IDT ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE HABITATION 
  ADD FOREIGN KEY FK_HABITATION_TYPEAPPARTEMENT (IDT)
      REFERENCES TYPEAPPARTEMENT (IDT) ;


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
  ADD FOREIGN KEY FK_EQUIPEMENT_TYPEAPPARTEMENT (IDT)
      REFERENCES TYPEAPPARTEMENT (IDT) ;

Insert into client values (null, "HOMME", "JOJO", "Mojo", "MojoJOJO@gmail.com", "2 Rue du palais", "75017", "Paris", "0675856880", "1992/10/05", "MOJO", "aaazzeee", 0); 
insert into saison values (1, "2018-05-01", "2018-12-31", "20"); 

