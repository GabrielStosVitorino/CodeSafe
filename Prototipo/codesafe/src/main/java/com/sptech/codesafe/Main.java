package com.sptech.codesafe;

import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitorNumerico = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);
        Connection config = new Connection("Azure");
        JdbcTemplate template = new JdbcTemplate(config.getDataSource());
        Looca looca = new Looca();
        
        Logger logger = Logger.getLogger("Main");
        try {
            FileHandler fh = new FileHandler("../MainLog.log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);  
        } catch (SecurityException | IOException e) {  
            logger.severe("Erro ao inicializar arquivo de log.");
        }

        System.out.println("\n"
                + "\n    ____         ____     ____     _____     ______      _____   _______   ______   ______"
                + "\n   /    \\       / ___\\   / __ \\   |  __ \\   |  ____|    / ____\\ |  ___  | |  ____| |  ____|"
                + "\n _|______|_    / /      / /  \\ \\  | |  \\ \\  | |___     / /___   | |___| | | |___   | |___"
                + "\n|    _     |  | |      | |    | | | |   | | |  ___|    \\____ \\  |  ___  | |  ___|  |  ___|"
                + "\n|   ( )    |  | |      | |    | | | |   | | | |             \\ \\ | |   | | | |      | |"
                + "\n|   /_\\    |   \\ \\___   \\ \\__/ /  | |__/ /  | |____     ____/ / | |   | | | |      | |____"
                + "\n|__________|    \\____/   \\____/   |_____/   |______|   \\_____/  |_|   |_| |_|      |______|");

        Boolean menuLoop = true;
        while (menuLoop) {

            System.out.println("\nEscolha o modo de execução:"
                    + "\n   1 - Padrão (Com GUI)"
                    + "\n   2 - Servidor (Sem GUI)"
                    + "\n   3 - Completo (Com GUI + MySQL)"
                    + "\n   4 - Sair");

            Integer modoSelecionado = leitorNumerico.nextInt();
            Insersor insersor = new Insersor();

            switch (modoSelecionado) {
                case 1:
                    new TelaInicial().setVisible(true);
                    menuLoop = false;
                    break;
////////////////////////////////////////////////////////////////////////////////                    
                case 2:
//                    insersor.setAtivarSQL(true);

                    System.out.println("Validando Servidor...");
                    String nomeServidor = null;
                    String nomeEmpresa = null;
                    String idEmpresa = null;

                    try {
                        nomeServidor = InetAddress.getLocalHost().getHostName();
                        System.out.println("Servidor: " + nomeServidor);
                        List buscarNomeServidor = template.queryForList(
                                "SELECT * FROM servidor "
                                + "WHERE funcao = '" + nomeServidor + "'");
                        if (!buscarNomeServidor.isEmpty()) {
                            System.out.println("Servidor já cadastrado..."
                                    + "\nRedirecionando para login...");

                        } else {
                            Boolean empresaConfirmada = false;
                            while (!empresaConfirmada) {
                                nomeEmpresa = null;
                                idEmpresa = null;
                                while (nomeEmpresa == null) {

                                    System.out.println("\nServidor ainda não cadastrado!!!"
                                            + "\nDigite a chave de segurança da sua empresa:");
                                    String chaveDigitada = leitorTexto.nextLine();

                                    try {
                                        Empresa empresaTeste = new Empresa();
                                        List<Empresa> buscaEmpresa = template.query("SELECT * FROM empresa WHERE chaveSeguranca = ?",
                                                new BeanPropertyRowMapper<>(Empresa.class), chaveDigitada);
                                        for (Empresa empresa : buscaEmpresa) {
                                            nomeEmpresa = empresa.getRazaoSocial();
                                            idEmpresa = empresa.getIdEmpresa().toString();
                                        }
                                        if (buscaEmpresa.isEmpty()) {
                                            System.out.println("Chave Incorreta!!!");
                                        }
                                    } catch (Exception erro) {
                                        logger.severe(String.format("Erro ao buscar chave de segurança para cadastro do servidor: %s", erro));
                                    }
                                }
                                System.out.println("\nSua empresa é: " + nomeEmpresa + "? [Y/N]");
                                String confirmacaoEmpresa = leitorTexto.nextLine();
                                if (confirmacaoEmpresa.equalsIgnoreCase("y")) {

                                    String insertStatement = "INSERT INTO servidor VALUES (?, ?, ?)";
                                    template.update(insertStatement,
                                            nomeServidor,
                                            looca.getSistema().getSistemaOperacional(),
                                            idEmpresa);
                                    Servidor servidorTeste = new Servidor();
                                    List<Servidor> buscaServidor = template.query("SELECT * FROM servidor WHERE funcao = ?",
                                            new BeanPropertyRowMapper<>(Servidor.class), nomeServidor);
                                    for (Servidor servidor : buscaServidor) {
                                        String insertStatement2 = "INSERT INTO componente VALUES (?, ?)";
                                        template.update(insertStatement2,
                                                "RAM",
                                                servidor.getIdServidor());
                                        template.update(insertStatement2,
                                                "CPU",
                                                servidor.getIdServidor());
                                        template.update(insertStatement2,
                                                "DISCO",
                                                servidor.getIdServidor());
                                    }
                                    empresaConfirmada = true;
                                } else {
                                    System.out.println("Chave digitada não corresponde há sua empresa...");
                                }
                            }
                        }

                    } catch (UnknownHostException ex) {
                        logger.severe(String.format("Erro ao buscar dados da máquina: %s", ex));
                    }

                    Boolean usuarioLogado = false;
                    while (!usuarioLogado) {
                        System.out.println("Usuário:");
                        String usuarioDigitado = leitorTexto.nextLine();
                        System.out.println("Senha:");
                        String senhaDigitada = leitorTexto.nextLine();

                        System.out.println("Verificando Dados...");

                        try {
                            List buscarUsuario = template.queryForList(
                                    "SELECT * FROM usuario "
                                    + "WHERE usuario = '" + usuarioDigitado
                                    + "' AND senha = '" + senhaDigitada + "'");
                            if (buscarUsuario.isEmpty()) {
                                System.out.println("Credenciais Incorretas");

                            } else {
                                System.out.println("Usuário Logado com sucesso!"
                                        + "\nBem-vindo " + usuarioDigitado + "!!!");
                                usuarioLogado = true;
                            }

                        } catch (Exception erro) {
                            logger.severe(String.format("Erro ao tentar logar o usuário: %s Erro: %s", usuarioDigitado, erro));
                        }
                    }

                    //////////Rodar CodeSafe
                    CodeSafeCLI codeSafeCLI = new CodeSafeCLI();
                    codeSafeCLI.rodarCodeSafe(insersor);

                    menuLoop = false;
                    break;
////////////////////////////////////////////////////////////////////////////////

                case 3:
                    insersor.setAtivarSQL(true);
                    TelaInicial telaInicial = new TelaInicial();
                    telaInicial.setAtivarSQL(true);
                    telaInicial.setVisible(true);
//                    new TelaInicial().setVisible(true);
                    menuLoop = false;
                    break;
////////////////////////////////////////////////////////////////////////////////                    
                case 4:
                    System.out.println("Obrigado por utilizar nosso produto");
                    System.exit(0);
                    break;
////////////////////////////////////////////////////////////////////////////////                    
                default:
                    System.out.println("Opção inválida! Digite o número da opção deseja, de acordo com o menu:");
                    break;
            }
        }

    }

}
