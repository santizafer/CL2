CREATE DATABASE Control2BD;
USE Control2BD;
CREATE TABLE producto(
idproducto int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre varchar(25) NOT NULL,
descripcion varchar(80) NOT NULL,
cantidad int(10) NOT NULL,
fechavencimiento datetime DEFAULT NULL
);

INSERT PRODUCTO VALUES(1, "fideos", "para cocina", 5, "2023-04-30");
INSERT PRODUCTO VALUES(2, "papa", "amarilla cacera", 10, "2023-04-30");
INSERT PRODUCTO VALUES(3, "mantequilla", "para estofado", 5, "2023-04-30");
INSERT PRODUCTO VALUES(4, "arroz", "graneado superior", 10, "2023-04-30");
INSERT PRODUCTO VALUES(5, "pan", "pan de molde", 12, "2023-04-30");

select * from producto