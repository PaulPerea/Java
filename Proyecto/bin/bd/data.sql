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

create table empleado(
nom_emp varchar(50),
ape_emp varchar(50),
dni_emp char(8),
cargo_emp varchar(50),
id_emp char(4)
);
select * from empleado;
create table producto(
desc_pro varchar(50),
cant_pro char(9),
prov_pro varchar(50),
id_pro char(4)
);
select * from producto;
