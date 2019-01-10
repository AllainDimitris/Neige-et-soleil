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
   TYPET VARCHAR(2) NULL  ,
   EXPOT VARCHAR(15) NULL  ,
   SURFACEHABT INTEGER(3) NULL  ,
   SURFACEBALT INTEGER(3) NULL  ,
   CAPACCT INTEGER(2) NULL  ,
   DISTANCEPISTET varchar(4) NULL  
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



insert into habitation values(0001,0001,"maisonP","rue du salto",4,"Toulouse");
insert into habitation values(0002,0015,"maisonC","rue de la galipette",5,"Montaubans");
insert into habitation values(0003,0003,"maisonA","avenue de la barre fixe",17,"Matabiau");
insert into habitation values(0004,0002,"maisonZ","rue de la roue",28,"Saint prix");
insert into habitation values(0005,0004,"maisonU","rue de l'appuie tendu renversé",82,"Toulouse");
insert into habitation values(0006,00011,"appartementP","Impasse du grand écart",9,"Matabiau");
insert into habitation values(0007,0007,"ChaletU","rue de la roulade",47,"Montdemarsan");
insert into habitation values(0008,0010,"ChaletC","boulevard du saut de chat",25,"Lyon");

insert into typeappartement values(0001,"T1","Ouest",120,200,8,"1km");
insert into typeappartement values(0002,"T1","Ouest",120,200,8,"2km");
insert into typeappartement values(0003,"T1","Ouest",120,200,8,"4km");
insert into typeappartement values(0004,"T1","Ouest",120,200,8,"6km");
insert into typeappartement values(0005,"T1","Ouest",120,200,8,"8km");
insert into typeappartement values(0006,"T1","Ouest",120,200,8,"10km");
insert into typeappartement values(0007,"T1","Sud",120,200,8,"1km");
insert into typeappartement values(0008,"T1","Sud",120,200,8,"2km");
insert into typeappartement values(0009,"T1","Sud",120,200,8,"4km");
insert into typeappartement values(0010,"T1","Sud",120,200,8,"6km");
insert into typeappartement values(0011,"T1","Sud",120,200,8,"8km");
insert into typeappartement values(0012,"T1","Sud",120,200,8,"10km");
insert into typeappartement values(0013,"T1","Est",120,200,8,"1km");
insert into typeappartement values(0014,"T1","Est",120,200,8,"2km");
insert into typeappartement values(0015,"T1","Est",120,200,8,"4km");
insert into typeappartement values(0016,"T1","Est",120,200,8,"6km");
insert into typeappartement values(0017,"T1","Est",120,200,8,"8km");
insert into typeappartement values(0018,"T1","Est",120,200,8,"10km");
insert into typeappartement values(0019,"T2","Est",120,200,8,"6km");
insert into typeappartement values(0019,"T2","Sud",120,200,8,"4km");
insert into typeappartement values(0019,"T2","Nord",120,200,8,"6km");
insert into typeappartement values(0019,"T2","Ouest",120,200,8,"2km");



insert into saison values(0001, 2018-11-18, 2018-12-20,"10%");
insert into saison values(0002, 2018-12-21, 2019-03-30,"0%");
insert into saison values (0003, 2019-04-01, 2019-06-30,"25%");



