create schema banco;

create table banco.conta (
    numero varchar (10), 
    saldo numeric(10,2), 
    primary key(numero)
);