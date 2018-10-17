CREATE SCHEMA prova
  AUTHORIZATION postgres;

CREATE TABLE prova.usuario
(
  id serial NOT NULL,
  nome character varying(100) NOT NULL,
  usuario character varying(50) NOT NULL,
  senha character varying(50) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT usuario_usuario_key UNIQUE (usuario)
);

insert into prova.usuario(nome, usuario, senha)
	values ('Administrador', 'admin', '123');
	
	
CREATE TABLE prova.livro
(
id serial NOT NULL,
titulo varchar(100) NOT NULL UNIQUE,
data_publicacao timestamp NOT NULL,
id_autor integer not null,
id_categoria integer not null,
CONSTRAINT pk_livro PRIMARY KEY (id)
)

	
CREATE TABLE prova.autor
(
id serial NOT NULL,
nome varchar(100) NOT NULL,
pseudonimo varchar(100) NOT NULL,
CONSTRAINT pk_autor PRIMARY KEY (id)
)
	
CREATE TABLE prova.categoria
(
id serial not null,
descricao varchar(100) not null,
CONSTRAINT pk_categoria PRIMARY KEY (id)
)

alter table prova.livro
    add constraint fk_autor foreign key (id_autor) references prova.autor(id);

alter table prova.livro
    add constraint fk_categoria foreign key (id_categoria) references prova.categoria(id);

insert into prova.usuario(nome, usuario, senha)
	values ('Administrador', 'admin', '123');

insert into prova.categoria(descricao) values ('Piadas');
insert into prova.categoria(descricao) values ('Terror');
insert into prova.autor(nome,pseudonimo) values ('Joao','Das Neves');
insert into prova.autor(nome,pseudonimo) values ('Marcos','Cabrito');