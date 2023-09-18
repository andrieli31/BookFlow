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



CREATE TABLE IF NOT EXISTS `categoria`(
`idCategoria` INT NOT NULL,
`idioma` VARCHAR(45) NOT NULL,
`quantPaginas` INT NOT NULL,
`genero` VARCHAR (45) NOT NULL,

PRIMARY KEY (`idCategoria`)
);


CREATE TABLE IF NOT EXISTS `pessoa` (
`cpf` BIGINT NOT NULL,
`nome` VARCHAR (60) NOT NULL,
`sobrenome` VARCHAR (60) NOT NULL,
`senha` VARCHAR(255) NOT NULL, 

PRIMARY KEY (`cpf`)
);

CREATE TABLE IF NOT EXISTS `login` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf` BIGINT NOT NULL, 
  `senha` VARCHAR(255) NOT NULL, 
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_usuario` (`cpf`)
);


-- GATILHO RESPONSÁVEL PELO INSERT AUTOMATICO DO REGISTRO DO USUARIO FEITO NA TABELA 'PESSOA' PARA SEU LOGIN

DELIMITER //
CREATE TRIGGER after_insert_pessoa
AFTER INSERT ON pessoa FOR EACH ROW
BEGIN
  INSERT INTO login (cpf, senha) VALUES (NEW.cpf, NEW.senha);
END;
//
DELIMITER ;

INSERT INTO pessoa(cpf, nome,sobrenome, senha)VALUES('123456789', 'patricia', 'cordeiro', 'welcome');
INSERT INTO pessoa(cpf, nome,sobrenome,senha)VALUES('111111111', 'EMily', 'Joanna', 		'welcome');
INSERT INTO pessoa(cpf, nome,sobrenome,senha)VALUES('222222222', 'Andrieli', 'Mendes', 'welcome');
INSERT INTO pessoa(cpf, nome,sobrenome,senha)VALUES('333333333', 'Maria', 'Mendes', 'welcome');
INSERT INTO pessoa(cpf, nome,sobrenome,senha)VALUES('444444444', 'Tamires', 'pauli COrdeiro', 'welcome');
INSERT INTO pessoa(cpf, nome,sobrenome,senha)VALUES('555555555', 'Emily', 'Snow', 'welcome');




INSERT INTO usuario(id, login, senha) VALUES(1, '123456789', 'welcome');
INSERT INTO livro (isbn, titulo, editora, nrEdicao, anoLancamento, autor) VALUES ('978853330227', 'aumosso acima de tudo', 'ifsc','56', '2023', 'andrieli mendes');
INSERT INTO livro (isbn, titulo, editora, nrEdicao, anoLancamento, autor) VALUES ('598814475656', 'gripe', 'ifc', '48', '2022', 'patricia mendes');

INSERT INTO categoria (idCategoria, idioma, quantPaginas, genero) VALUES ('2', 'ingles', '265', 'drama');

SELECT * from pessoa;
SELECT * FROM login;
SELECT * FROM usuario;
SELECT*FROM livro;
SELECT*FROM categoria;