DROP DATABASE IF EXISTS bookflow;

CREATE DATABASE IF NOT EXISTS bookflow;

USE bookflow;

CREATE TABLE IF NOT EXISTS `livro` (
 `isbn` BIGINT NOT NULL,
 `titulo` VARCHAR (60) NOT NULL,
 `editora` VARCHAR (60) NOT NULL, 
 `nrEdicao` INT NOT NULL,
 `anoLancamento` INT NOT NULL,
 `autor` VARCHAR (60) NOT NULL,
 
PRIMARY KEY (`isbn`)
 
);

CREATE TABLE IF NOT EXISTS `usuario` (
`id` BIGINT NOT NULL,
`login` VARCHAR (45) NOT NULL,
`senha` VARCHAR (45) NOT NULL,

PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `autor`(
`id` BIGINT NOT NULL,
`nome` VARCHAR (60) NOT NULL,
`sobrenome` VARCHAR (60) NOT NULL,

PRIMARY KEY (`id`)

);

CREATE TABLE IF NOT EXISTS `pessoa` (
`cpf` BIGINT NOT NULL,
`nome` VARCHAR (60) NOT NULL,
`sobrenome` VARCHAR (60) NOT NULL,

PRIMARY KEY (`cpf`)
);

CREATE TABLE IF NOT EXISTS `categoria`(
`idCategoria` INT NOT NULL,
`idioma` VARCHAR(45) NOT NULL,
`quantPaginas` INT NOT NULL,
`genero` VARCHAR (45) NOT NULL,

PRIMARY KEY (`idCategoria`)
);

INSERT INTO livro (isbn, titulo, editora, nrEdicao, anoLancamento, autor) VALUES ('978853330227', 'aumosso acima de tudo', 'ifsc','56', '2023', 'andrieli mendes');
INSERT INTO livro (isbn, titulo, editora, nrEdicao, anoLancamento, autor) VALUES ('598814475656', 'gripe', 'ifc', '48', '2022', 'patricia mendes');

INSERT INTO categoria (idCategoria, idioma, quantPaginas, genero) VALUES ('2', 'ingles', '265', 'drama');

SELECT*FROM livro;
SELECT*FROM categoria;