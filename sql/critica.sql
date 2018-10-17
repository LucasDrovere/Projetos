create table forum.usuario(
id serial not null,
nome varchar(100) not null,
usuario varchar(100) not null unique,
senha varchar(100) not null,
CONSTRAINT pk_usuario PRIMARY KEY (id)
);


create table forum.critica (
id serial not null,
titulo varchar(50) not null,
descricao varchar(290) not null,
id_usuario integer,
CONSTRAINT pk_critica PRIMARY KEY (id)
);

alter table forum.critica
    add constraint fk_usuario foreign key (id_usuario) references forum.usuario(id);

CREATE TABLE forum.imagem(
id serial NOT NULL,
arquivo character varying(100) NOT NULL,
id_rec integer NOT NULL,
CONSTRAINT pk_imagem PRIMARY KEY (id),
CONSTRAINT fk_forum_imagem FOREIGN KEY (id_rec)
REFERENCES forum.critica (id) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION
);


select * from forum.critica