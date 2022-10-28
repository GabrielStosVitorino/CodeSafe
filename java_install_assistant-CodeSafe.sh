#!/usr/bin/env bash

PURPLE='0;35'
NC='\033[0m' 
VERSAO=11
	
echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)Saudações, vou te ajudar a instalar o Java!"
sleep 2
echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Verificando aqui se você possui o Java instalado..."
sleep 2

java -version
if [ $? -eq 0 ]
	then
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Você já tem o java instalado!!!"
		sleep 2
	else
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Opa! Não identifiquei nenhuma versão do Java instalado, mas sem problemas, irei resolver isso agora!"
		sleep 2
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Confirme para mim se realmente deseja instalar o Java (Y/n)?"		
	read inst
	if [ \"$inst\" == \"Y\" ]
		then
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Ok! Você escolheu instalar o Java, um momento..."
			sleep 4
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Adicionando o repositório!"
			sleep 2
			sudo add-apt-repository ppa:webupd8team/java -y
			clear
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Atualizando Pacotes! Quase lá."
			sleep 2
			sudo apt update -y
			clear
			
			if [ $VERSAO -eq 11 ]
				then
					echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Preparando para instalar a versão 11 do Java. Confirme a instalação quando solicitado ;D"
					sleep 1
					sudo apt install default-jre ; apt install openjdk-11-jre-headless; -y
					clear
					echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Java instalado com sucesso!"
					sleep 1
				fi
		else 	
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Você optou por não instalar o Java por enquanto, até a próxima!"
		sleep 1
		exit 1
	fi
fi

<<<<<<< HEAD
=======
echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Agora vou verificar se você tem o Docker instalado!"
sleep 2
echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Verificando aqui se você possui o Docker instalado...;"
sleep 2

docker --version
if [$? -eq 0]
	then
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Você já tem o Docker instalado!!!"
		sleep 2
	else
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Opa! Não identifiquei nenhuma versão do Docker instalado, mas sem problemas, irei resolver isso agora!"
		sleep 2
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Confirme para mim se realmente deseja instalar o Docker (Y/n)?"		
	read inst2
	if [\"$inst2\" == \"Y\"]
		then
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Ok! Você escolheu instalar o Docker, um momento..."
			sleep 4
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Adicionando o repositório!"
			sleep 2
			sudo add-apt-repository ppa:webupd8team/docker -y
			clear
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Atualizando Pacotes! Quase lá."
			sleep 2
			sudo apt update -y
			clear
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Preparando para instalar o Docker."
					sleep 1
					sudo apt install docker.io;
					clear
					echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Docker instalado com sucesso!"
					sleep 1
					
		else 	
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Você optou por não instalar o Docker por enquanto, até a próxima!"
		sleep 1
		exit 1
	fi
fi

echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Vou iniciar a criação do container!"
sleep 2
sudo docker run --name codesafe-bd mysql

>>>>>>> 23053e4a2a7ad8417a71a6134f28187909d5f03e
echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Baixando executável da aplicação CodeSafe!"
curl -O https://github.com/CS-CodeSafe/CodeSafe.git/codesafe-1.0-SNAPSHOT-jar-with-dependencies.jar

# ===================================================================
# Todos direitos reservados para o autor: Dra. Profa. Marise Miranda.
# Sob licença Creative Commons @2020
# Podera modificar e reproduzir para uso pessoal.
# Proibida a comercialização e a exclusão da autoria.
# ===================================================================

