CREATE TABLE empresa(
idEmpresa INT IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(45),
cnpj VARCHAR(18),
logradouro VARCHAR(45),
numero INT,
bairro VARCHAR(45),
cidade VARCHAR(45),
estado CHAR(2),
telefone VARCHAR(20),
email VARCHAR(50),
site VARCHAR(45),
chaveSeguranca VARCHAR(20)
);

CREATE TABLE usuario(
idUsuario INT IDENTITY(1,1) PRIMARY KEY,
nome_usuario VARCHAR(45),
usuario VARCHAR(45),
senha VARCHAR(45),
email VARCHAR(45),
fkEmpresaUsuario INT,
CONSTRAINT fkEmpresaUsuario FOREIGN KEY (fkEmpresaUsuario) REFERENCES empresa (idEmpresa)
);

CREATE TABLE servidor(
idServidor INT IDENTITY(1,1) PRIMARY KEY,
funcao VARCHAR(45),
sistema VARCHAR (45),
fkEmpresaServidor INT,
CONSTRAINT fkEmpresaServidor FOREIGN KEY (fkEmpresaServidor)
	REFERENCES empresa (idEmpresa)
);

CREATE TABLE componente(
idComponente INT IDENTITY(1,1) PRIMARY KEY,
tipo VARCHAR(45),
fkServidor INT,
CONSTRAINT fkServidor FOREIGN KEY (fkServidor)
	REFERENCES servidor (idServidor)
);

CREATE TABLE historico(
idHistorico INT IDENTITY(1,1) PRIMARY KEY,	
dataHorario datetime,
unidadeMedida VARCHAR(45),
consumo FLOAT,
total FLOAT,
percentualConsumo INT,
fkComponente INT,
CONSTRAINT fkComponente FOREIGN KEY (fkComponente)
	REFERENCES componente (idComponente)
);