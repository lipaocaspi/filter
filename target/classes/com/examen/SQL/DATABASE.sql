CREATE DATABASE cinecampus;

USE cinecampus;

CREATE TABLE tipoActor (
    id int AUTO_INCREMENT,
    descripcion VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE genero (
    id int AUTO_INCREMENT,
    descripcion VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE formato (
    id int AUTO_INCREMENT,
    descripcion VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE pelicula (
    id int AUTO_INCREMENT,
    codinterno VARCHAR(5),
    nombre VARCHAR(50),
    duracion VARCHAR(20),
    sinopsis TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE pais (
    id int AUTO_INCREMENT,
    descripcion VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE actor (
    id int AUTO_INCREMENT,
    nombre VARCHAR(50),
    idNacionalidad INT,
    edad INT,
    idGenero INT,
    PRIMARY KEY (id),
        CONSTRAINT FK_Nacionalidad FOREIGN KEY (idNacionalidad) REFERENCES pais(id),
        CONSTRAINT FK_Genero FOREIGN KEY (idGenero) REFERENCES genero(id)
);

CREATE TABLE peliculaProtagonista(
    idProtagonista INT,
    idPelicula INT,
    PRIMARY KEY(idProtagonista, idPelicula),
    idTipoActor INT,
        CONSTRAINT FK_Protagonista FOREIGN KEY (idProtagonista) REFERENCES actor(id),
        CONSTRAINT FK_Pelicula FOREIGN KEY (idPelicula) REFERENCES pelicula(id),
        CONSTRAINT FK_TipoActor FOREIGN KEY (idTipoActor) REFERENCES tipoActor(id)
);
    
CREATE TABLE peliculaFormato (
    idPelicula INT,
    idFormato INT,
    PRIMARY KEY(idFormato, idPelicula),
    cantidad INT,
        CONSTRAINT FK_PeliculaFormato FOREIGN KEY (idPelicula) REFERENCES pelicula(id),
        CONSTRAINT FK_Formato FOREIGN KEY (idFormato) REFERENCES formato(id)
);

