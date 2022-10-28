#!/usr/bin/env bash
#
#criarSQL.sh - criação de banco em docker para backup de CodeSafe
#
#Autor:      CodeSafe
#Manutenção  Allan Bernardo
#
#------------------------------------------------------------------------------#
#Este programa ira configurar automáticamente um banco de dados local em Docker
#
# Exemplos:
#       $ ./tarefa8/sh
#       início
#------------------------------------------------------------------------------#
#Histórico:
#   v1.0 01/06/2022, Allan
#       - Criação do Script
#------------------------------------------------------------------------------#
#Testado em:
#   bash 4.4.23
#------------------------------------------------------------------------------#
#------------------------------Variáveis---------------------------------------#
#------------------------------------------------------------------------------#
#------------------------------Testes------------------------------------------#
#Lynx Instalado
[ ! -x "$(which docker)" ] && sudo apt install docker.io -y
#------------------------------Funções-----------------------------------------#
#------------------------------------------------------------------------------#
#------------------------------Execução----------------------------------------#
sudo systemctl start docker
sudo systemctl enable docker

#Instalar a imagem do mysql:
sudo docker pull mysql:5.7
#Executar com mysql:
sudo docker run -d -p 3306:3306 --name ConteinerBD -e "MYSQL_DATABASE=banco1" -e "MYSQL_ROOT_PASSWORD=urubu100" mysql:5.7
#Execução interativa + bash do container:
sudo docker exec -it ConteinerBD bash
#Acessar o mysql:
mysql -u root -p urubu100
#Criação do Banco:
# use banco1
# create table historico(idHistorico INT PRIMARY KEY AUTO_INCREMENT, dataHorario DATETIME, unidadeMedida VARCHAR(45), consumo FLOAT, total FLOAT, percentualConsumo INT, fkComponente INT);
#Fechar Configuração
# exit
# exit

echo "Banco local configurado com sucesso"

#------------------------------------------------------------------------------#