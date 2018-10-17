CREATE TABLE pessoa.pessoa(

cpf VARCHAR(11) PRIMARY KEY NOT NULL,
nome VARCHAR(100) NOT NULL,
email VARCHAR(100) not null,
id_endereco VARCHAR not null

);

CREATE TABLE pessoa.endereco(

cep VARCHAR(8) PRIMARY KEY NOT NULL,
logradouro varchar(200) not null,
numero varchar(5) not null,
complemento varchar(20) not null,
bairro varchar(200) not null,
cidade varchar(200)not null,
uf varchar(2)not null

);


ALTER TABLE pessoa.pessoa
 ADD CONSTRAINT fk_id_endereco FOREIGN KEY (id_endereco)
     REFERENCES pessoa.endereco (cep)