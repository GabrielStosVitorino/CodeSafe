package com.sptech.codesafe;

import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TelaInicial extends javax.swing.JFrame {

    FileHandler fh;
    Logger logger = Logger.getLogger("InicialLogger");
    
    Connection config = new Connection("Azure");
    JdbcTemplate template = new JdbcTemplate(config.getDataSource());
    Looca looca = new Looca();

    private Boolean ativarSQL = false;

    public Boolean getAtivarSQL() {
        return ativarSQL;
    }

    public void setAtivarSQL(Boolean ativarSQL) {
        this.ativarSQL = ativarSQL;
    }
    /**
     * Creates new form TelaLogin
     */
    public TelaInicial() {
        initComponents();
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        btnConfirmarEmpresa.setVisible(false);
        btnAcessarLogin.setVisible(false);

        String nomeServidor;

        try {
            fh = new FileHandler("../InicialLog.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (Exception e) {
            logger.severe("Erro ao inicializar log em txt");
        }
        
        try {
            nomeServidor = InetAddress.getLocalHost().getHostName();
            lblNomeServidor.setText(nomeServidor);

            logger.info("Inicial - Buscando nome da máquina atual no banco de dados");
            
            List buscarNomeServidor = template.queryForList(
                    "SELECT * FROM servidor "
                    + "WHERE funcao = '" + nomeServidor + "'");
            if (!buscarNomeServidor.isEmpty()) {
                logger.info("Inicial - Servidor encontrado no banco de dados. Habilitando tela de login.");
                lblInformativa.setText("Servidor Cadastrado");
                txtChaveSeguranca.setVisible(false);
                btnConfirmarChaveSeguranca.setVisible(false);
                btnAcessarLogin.setVisible(true);

//                new TelaLogin().setVisible(true);
            }

        } catch (UnknownHostException ex) {
            // MENSAGEM PARA LOG
            logger.severe(String.format("Inicial - Erro ao buscar hostname: %s",  ex.toString()));
        } catch (Exception ex) {
            logger.severe("Inicial - Erro ao conectar com banco de dados");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblRespostaEmpresa = new javax.swing.JLabel();
        iconLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblInformativa = new javax.swing.JLabel();
        lblNomeServidor = new javax.swing.JLabel();
        txtChaveSeguranca = new javax.swing.JTextField();
        btnConfirmarChaveSeguranca = new javax.swing.JButton();
        btnAcessarLogin = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSair = new javax.swing.JButton();
        btnConfirmarEmpresa = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        lblRespostaEmpresa.setBackground(new java.awt.Color(0, 0, 0));
        lblRespostaEmpresa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRespostaEmpresa.setForeground(new java.awt.Color(84, 182, 243));
        lblRespostaEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        iconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design sem nome.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(84, 182, 243));

        jPanel5.setBackground(new java.awt.Color(84, 182, 243));

        lblInformativa.setBackground(new java.awt.Color(84, 182, 243));
        lblInformativa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblInformativa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInformativa.setText("Cadastro de Servidor");

        lblNomeServidor.setBackground(new java.awt.Color(84, 182, 243));
        lblNomeServidor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNomeServidor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeServidor.setText("---");

        txtChaveSeguranca.setBackground(new java.awt.Color(84, 182, 243));
        txtChaveSeguranca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtChaveSeguranca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtChaveSeguranca.setText("Insira, aqui, a chave de segurança da sua empresa...");
        txtChaveSeguranca.setActionCommand("<Not Set>");
        txtChaveSeguranca.setBorder(null);
        txtChaveSeguranca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtChaveSegurancaFocusGained(evt);
            }
        });
        txtChaveSeguranca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChaveSegurancaActionPerformed(evt);
            }
        });

        btnConfirmarChaveSeguranca.setBackground(new java.awt.Color(84, 182, 243));
        btnConfirmarChaveSeguranca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnConfirmarChaveSeguranca.setText("Acessar");
        btnConfirmarChaveSeguranca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnConfirmarChaveSeguranca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarChaveSegurancaActionPerformed(evt);
            }
        });

        btnAcessarLogin.setBackground(new java.awt.Color(84, 182, 243));
        btnAcessarLogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAcessarLogin.setText("Logar");
        btnAcessarLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnAcessarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessarLoginActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmarChaveSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcessarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtChaveSeguranca))
                    .addComponent(lblNomeServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblInformativa, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInformativa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblNomeServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(txtChaveSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnConfirmarChaveSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAcessarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnSair.setBackground(new java.awt.Color(0, 0, 0));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseline_exit_to_app_white_24dp.png"))); // NOI18N
        btnSair.setBorder(null);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnConfirmarEmpresa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnConfirmarEmpresa.setText("Confirmar Empresa");
        btnConfirmarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConfirmarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRespostaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnConfirmarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(iconLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(iconLogo))
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRespostaEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirmarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnConfirmarChaveSegurancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarChaveSegurancaActionPerformed

        String nomeEmpresaFinal = buscarEmpresa("nome");

        if (nomeEmpresaFinal != null) {
            
            logger.info("Inicial - Empresa encontrada no banco de dados. Pedindo confirmação.");
            
            lblRespostaEmpresa.setText(nomeEmpresaFinal);
            btnConfirmarEmpresa.setVisible(true);
        } else {
            
            logger.info("Inicial - Empresa não encontrada no banco de dados.");
            
            txtChaveSeguranca.setText("Chave Incorreta");
            lblRespostaEmpresa.setText("");
            btnConfirmarEmpresa.setVisible(false);
        }
    }//GEN-LAST:event_btnConfirmarChaveSegurancaActionPerformed

    private String buscarEmpresa(String atributo) {
        String resultado = null;

        logger.info("Inicial - Buscando chave de segurança no banco de dados.");
        
        try {
            Empresa empresaTeste = new Empresa();
            List<Empresa> buscaEmpresa = template.query("SELECT * FROM empresa WHERE chaveSeguranca = ?",
                    new BeanPropertyRowMapper<>(Empresa.class), txtChaveSeguranca.getText());
            for (Empresa empresa : buscaEmpresa) {
                if (atributo.equals("id")) {
                    resultado = empresa.getIdEmpresa().toString();
                } else if (atributo.equals("nome")) {
                    resultado = empresa.getRazaoSocial();
                }
            }
        } catch (Exception erro) {
            logger.severe("Inicial - Erro ao buscar chave de segurança da empresa no banco de dados.");
        }
        return resultado;
    }

    private void txtChaveSegurancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChaveSegurancaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChaveSegurancaActionPerformed

    private void txtChaveSegurancaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtChaveSegurancaFocusGained
        // TODO add your handling code here:
        txtChaveSeguranca.setText("");
    }//GEN-LAST:event_txtChaveSegurancaFocusGained

    private void btnConfirmarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEmpresaActionPerformed
        String nomeServidor;
        try {
            nomeServidor = InetAddress.getLocalHost().getHostName();
            lblNomeServidor.setText(nomeServidor);

            String idEmpresa = buscarEmpresa("id");

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

        } catch (UnknownHostException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        exibirTelaLogin();    
    }//GEN-LAST:event_btnConfirmarEmpresaActionPerformed
    
    private void exibirTelaLogin() {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setAtivarSQL(ativarSQL);
        telaLogin.setVisible(true);
//        new TelaLogin().setVisible(true);
        this.setVisible(false);
    }
    
    private void btnAcessarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessarLoginActionPerformed
        exibirTelaLogin();            
    }//GEN-LAST:event_btnAcessarLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcessarLogin;
    private javax.swing.JButton btnConfirmarChaveSeguranca;
    private javax.swing.JButton btnConfirmarEmpresa;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel iconLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblInformativa;
    private javax.swing.JLabel lblNomeServidor;
    private javax.swing.JLabel lblRespostaEmpresa;
    private javax.swing.JTextField txtChaveSeguranca;
    // End of variables declaration//GEN-END:variables
}
