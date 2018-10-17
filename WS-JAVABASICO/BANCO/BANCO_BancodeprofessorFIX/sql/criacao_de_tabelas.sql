CREATE TABLE sala.professor (
	id serial,
	nome VARCHAR(100) not null,
	materia VARCHAR(100) not null
);

ALTER TABLE sala.professor 
ADD CONSTRAINT pk_professor PRIMARY KEY (id);

CREATE TABLE sala.aluno (
	id serial,
	nome VARCHAR(100) NOT NULL,
	id_professor INTEGER
);

ALTER TABLE sala.aluno 
ADD CONSTRAINT pk_aluno PRIMARY KEY (id);

ALTER TABLE sala.aluno
ADD CONSTRAINT fk_aluno_professor FOREIGN KEY (id_professor) 
REFERENCES sala.professor (id)
ON DELETE SET NULL;
