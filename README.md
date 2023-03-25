# backend-parcial1

##Querys a ejecutar
create database parcial1;

create table parcial1.public.cliente(
	id serial primary key,
	nombre varchar(100) null,
	apellido varchar(100) null,
	nro_documento varchar(50) null,
	tipo_documento varchar(10) null,
	nacionalidad varchar(100) null, 
	email varchar(100) null, 
	telefono varchar(100) null, 
	fecha_nacimiento date null
);