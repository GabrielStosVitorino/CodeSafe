create database codesafe;

use codesafe;

create table primeiroCadastro(
seu_nome varchar(45),
email varchar(50),
telefone char(9),
nome_fantasia varchar(45),
necessidade varchar(1000)
);


create table empresa(
idEmpresa int primary key auto_increment,
razao_social varchar(45),
nome_fantasia varchar(45),
cnpj varchar(18),
site varchar(45),
email_empresa varchar(50),
logradouro varchar(45),
numero int,
bairro varchar(45),
cidade varchar(45),
estado char(2),
telefone char(9),
celular char(9),
responsavel varchar(45),
telefone_resp char(9),
email_resp varchar(50)
);

insert into empresa values 
(1, 'Casa da Segurança LTDA' , 'SafeCode', '18.479.167/0001-42', 'safecode.com', 'safecode@gmail.com', 'Rua Haddock Lobo', 545, 'Paulista', 'São Paulo', 'SP', '345728978', '987656789', 'Beatriz Sena', '987786678', 'beatriz@safecode.com'); 

create table chave_seguranca(
chave varchar(20),
fk_empchave int, 
foreign key (fk_empchave) references empresa (idempresa)
);

create table usuario(
idUsuario int primary key auto_increment,
nome_usuario varchar(45),
usuario varchar(45),
senha varchar(45),
email varchar(45),
tipoUsuario varchar(45),
CHECK (tipoUsuario = "adm" or tipoUsuario = "comum"),
fkEmpresaUsuario int,
foreign key (fkEmpresaUsuario) references empresa (idEmpresa)
);

insert into usuario values
(100, 'Beatriz Sena', 'beatriz_sena', 'senha123', 'beatriz@safecode.com', 'comum', 1);

create table servidor(
idServidor int primary key auto_increment,
funcao varchar(45),
sistema varchar (45),
fkEmpresaServidor int,
foreign key (fkEmpresaServidor) references empresa (idEmpresa)
);

insert into servidor values
(400, 'Dados de cadastro', 'Windows', 1);

create table componente(
idComponente int primary key auto_increment,
tipo varchar(45),
fkServidor int,
foreign key (fkServidor) references servidor (idServidor)
);

insert into componente values
(510, 'RAM', 400);


create table historico(
data_uso datetime primary key,
unidade varchar(45),
consumo double,
disponivel double,
total double,
percentualConsumo INT,
fkComponente int,
foreign key (fkComponente) references componente (idComponente)
);

insert into historico values
('2022-04-19', '%', 5.3, 2.4, 8, 510);

select * from empresa 
join usuario on idEmpresa = fkEmpresaUsuario
join servidor on idEmpresa = fkEmpresaServidor
join componente on idServidor = fkServidor
join historico on idComponente = fkComponente
;

select * from primeiroCadastro;
select * from empresa;
select * from usuario;
select * from servidor;
select * from componente;
select * from historico;


