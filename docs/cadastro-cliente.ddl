CREATE SCHEMA `cadastro_cliente` ;

use cadastro_cliente;

create table cliente(
	codigo int not null auto_increment primary key,
	nome varchar(100)
)

SELECT * FROM cadastro_cliente.cliente;