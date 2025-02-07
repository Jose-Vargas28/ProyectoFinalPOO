create database GYM;
use GYM;

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    descripcion TEXT
);


CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    correo VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol ENUM('administrador', 'usuario', 'cliente') NOT NULL
);

INSERT INTO usuarios (correo, password, rol) 
VALUES ('administrador', SHA2('admin123', 256), 'administrador');

INSERT INTO Usuarios (nombre_usuario,  clave, rol) 
VALUES ('Admin',  SHA2('admin123', 256), 'administrador');

CREATE TABLE Miembros (
    id int PRIMARY KEY auto_increment,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    fecha_registro DATE 
);


CREATE TABLE Pagos (
    id INTEGER PRIMARY KEY auto_increment,
    id_miembro INTEGER NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha_pago DATE,
    metodo_pago VARCHAR(50),
    FOREIGN KEY (id_miembro) REFERENCES Miembros(id)
);



CREATE TABLE Rutinas (
    id INTEGER PRIMARY KEY auto_increment,
    id_miembro INTEGER NOT NULL,
    descripcion TEXT NOT NULL,
    duracion_semanas INTEGER NOT NULL,
    FOREIGN KEY (id_miembro) REFERENCES Miembros(id)
);


CREATE TABLE Reservas (
    id INTEGER PRIMARY KEY auto_increment,
    id_miembro INTEGER NOT NULL,
    fecha_hora DATETIME NOT NULL,
    tipo_clase VARCHAR(50),
    FOREIGN KEY (id_miembro) REFERENCES Miembros(id)
);


