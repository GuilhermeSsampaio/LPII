DROP TABLE IF EXISTS Maestros;
DROP TABLE IF EXISTS PeçasMusicais;
DROP TABLE IF EXISTS Interpretações;
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

CREATE TABLE Repertórios (
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(50),
    Data_montagem DATE,
    descrição VARCHAR(200)
);

CREATE TABLE Interpretações (
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    RepertórioId INT NOT NULL,
    PeçaMusicalId VARCHAR(50) NOT NULL,
    FOREIGN KEY (RepertórioId) REFERENCES Repertórios(Sequencial),
    FOREIGN KEY (PeçaMusicalId) REFERENCES PeçasMusicais(Titulo)
);
