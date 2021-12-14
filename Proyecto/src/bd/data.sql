create database Proyecto;
use Proyecto;
create table CLIENTE (
nom_clie varchar(50) not null,
ape_clie varchar(50) not null,
dni_clie char(8) not null,
edad char(3) not null,
id char(4) not null PRIMARY KEY
);

select * from cliente;
INSERT INTO CLIENTE VALUES('JEAN CARLOS','RODRIGUEZ VALLE','75468146','23','CL01');
INSERT INTO CLIENTE VALUES('JEAN MARCO','TORRES MOREM','74986548','18','CL02');
INSERT INTO CLIENTE VALUES('JESUS MARIANO','LAUGH DÍAS','74985645','31','CL03');
