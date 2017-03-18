/**
 * Author:  Paulo
 * Created: 18/03/2017
 */

DROP TABLE contato;

CREATE TABLE contato
(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(90) NOT NULL,
    telefone VARCHAR(20)NOT NULL
);

INSERT INTO contato(nome, sobrenome, telefone) VALUES('Mikey', 'Mouse', '123-4567');