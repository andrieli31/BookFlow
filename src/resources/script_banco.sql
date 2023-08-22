DROP DATABASE IF EXISTS book_flow;

CREATE SCHEMA IF NOT EXISTS ´book_flow´;

USE book_flow;

-- base p/ tabelas!!!!!!!!!!!!
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id_pessoa` INT NOT NULL,
  `primeiro_nome` VARCHAR(45) NOT NULL, 
  `idade` INT NOT NULL,
  PRIMARY KEY (`id_pessoa`)
);