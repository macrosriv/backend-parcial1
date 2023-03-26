# backend-parcial1

## Querys a ejecutar


```
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
```

luego en el standalone.xml (o donde sea que este consumiendo las confiduraciones del wildfly), agregan las sgte dependencia

cambien el usuario y contraseña al correcto de ser necesario

```
                <datasource jndi-name="java:jboss/datasources/parcial1" pool-name="parcial1PU" enabled="true" use-java-context="true">
                    <connection-url>jdbc:postgresql://localhost:5433/parcial1</connection-url>
                    <driver>postgres</driver>
                    <security>
                        <user-name>postgres</user-name>
                        <password>postgres</password>
                    </security>
                </datasource>
```
