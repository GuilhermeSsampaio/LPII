DROP TABLE IF EXISTS Interpretações;
DROP TABLE IF EXISTS ApresentaçõesMusicais;
DROP TABLE IF EXISTS PeçasMusicaisClássicas;
DROP TABLE IF EXISTS PeçasMusicaisPopulares;
DROP TABLE IF EXISTS Maestros;
DROP TABLE IF EXISTS PeçasMusicais;
DROP TABLE IF EXISTS Repertórios;

CREATE TABLE Maestros (
    Nome VARCHAR(50) NOT NULL PRIMARY KEY,
    Anos_experiencia INT NOT NULL,
    Estilo_regencia VARCHAR(50) NOT NULL,
    Estrangeiro BOOLEAN NOT NULL
);

CREATE TABLE PeçasMusicais (
    Titulo VARCHAR(50) NOT NULL PRIMARY KEY,
    Compositor VARCHAR(50) NOT NULL,
    Genero VARCHAR(50) NOT NULL,
    Duracao INT NOT NULL,
    Tom VARCHAR(10) NOT NULL
);

CREATE TABLE PeçasMusicaisClássicas (
    Estilo_música_clássica INT NOT NULL,
    Muito_conhecida BOOLEAN NOT NULL,
    PeçaMusicalId VARCHAR(50) NOT NULL,
    FOREIGN KEY (PeçaMusicalId) REFERENCES PeçasMusicais(Titulo)
);

CREATE TABLE PeçasMusicaisPopulares (
    Estilo_música_popular INT NOT NULL,
    Instrumentação_característica INT NOT NULL,
    PeçaMusicalId VARCHAR(50) NOT NULL,
    FOREIGN KEY (PeçaMusicalId) REFERENCES PeçasMusicais(Titulo)
);

CREATE TABLE Repertórios (
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(50),
    Data_montagem TIMESTAMP NOT NULL,
    descrição VARCHAR(200)
);

CREATE TABLE Interpretações (
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    RepertórioId INT NOT NULL,
    PeçaMusicalId VARCHAR(50) NOT NULL,
    FOREIGN KEY (RepertórioId) REFERENCES Repertórios(Sequencial),
    FOREIGN KEY (PeçaMusicalId) REFERENCES PeçasMusicais(Titulo)
);

CREATE TABLE ApresentaçõesMusicais (
   Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   DataHora TIMESTAMP NOT NULL,
   RepertórioId INT NOT NULL,
   MaestroId VARCHAR(50),
   Nacional BOOLEAN NOT NULL,
   FOREIGN KEY (RepertórioId) REFERENCES Repertórios(Sequencial),
   FOREIGN KEY (MaestroId) REFERENCES Maestros(Nome)
);
