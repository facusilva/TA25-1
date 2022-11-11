DROP TABLE IF EXISTS fabricante;
DROP TABLE IF EXISTS articulo;

CREATE TABLE fabricante(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre varchar(100)
);

CREATE TABLE articulo(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100),
    precio int,
    fabricante int,
    FOREIGN KEY (fabricante) REFERENCES fabricante(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO fabricante (nombre) VALUES ('AMD');
INSERT INTO articulo (nombre, precio, fabricante) VALUES ('procesador', 40, 1);