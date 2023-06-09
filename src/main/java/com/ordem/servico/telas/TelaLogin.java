package com.ordem.servico.telas;

import com.ordem.servico.repository.UsuarioRepository;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JDialog {

    private final UsuarioRepository repository;

    public TelaLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        repository = new UsuarioRepository();
        
    }
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GDM O.S - Login");
        setAlwaysOnTop(true);
        setIconImage(icone());
        setPreferredSize(new java.awt.Dimension(415, 354));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 233, 211));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 280, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bgpdv2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 50));

        txtUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 220, 33));

        txtSenha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(51, 51, 51));
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 180, 33));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Usuário:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, 20));

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Senha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bgpdv.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 260, -1));

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/loginLogo.png"))); // NOI18N
        jLabel5.setText("Informe seus dados de Acesso");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 90));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            login();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            login();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    public Image icone() {
        return (new ImageIcon(getClass().getResource("/imagens/menu-circulado-16.png"))).getImage();
    }

    private void login() {
        if (!txtUser.getText().isEmpty() && txtSenha.getPassword().length > 0) {

            var okUser = repository.login(txtUser.getText(), new String(txtSenha.getPassword()));

            if (okUser != null) {
                var app = new MainApp();
                MainApp.txtUserLogado.setText(okUser.getLogin());
                app.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados de acesso incorretos", "Usuário Inválido", 0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe seus dados de acesso corretamente", "Atenção", 0);
        }
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
