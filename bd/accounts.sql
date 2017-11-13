create database accounts;
use accounts;

create table tb_customer_account(
	id_customer int primary key,
	cpf_cnpj varchar(18),
	nm_customer varchar(50),
	is_active char(3),
	vl_total decimal(8,2)
);

