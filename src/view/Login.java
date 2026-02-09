package view;

import controller.ColaboradorDao;
import entidade.Colaborador;
import entidade.Sessao;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldLogin = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonEntrar = new javax.swing.JButton();
        fundoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextFieldLogin.setForeground(new java.awt.Color(255, 153, 0));
        jTextFieldLogin.setText("Usuário");
        jTextFieldLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 0, 102))); // NOI18N
        jTextFieldLogin.setCaretColor(new java.awt.Color(255, 153, 0));
        jTextFieldLogin.setDisabledTextColor(new java.awt.Color(255, 153, 0));
        jTextFieldLogin.setSelectionColor(new java.awt.Color(255, 153, 0));
        jTextFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, 430, 70));

        jPasswordFieldSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPasswordFieldSenha.setForeground(new java.awt.Color(255, 153, 0));
        jPasswordFieldSenha.setText("jPass");
        jPasswordFieldSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 0, 153))); // NOI18N
        jPasswordFieldSenha.setCaretColor(new java.awt.Color(255, 153, 0));
        jPasswordFieldSenha.setDisabledTextColor(new java.awt.Color(255, 153, 0));
        jPasswordFieldSenha.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 430, 60));

        jButtonEntrar.setActionCommand("Entrar");
        jButtonEntrar.setContentAreaFilled(false);
        jButtonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, 420, 50));

        fundoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.png"))); // NOI18N
        fundoLabel.setText("jLabel1");
        fundoLabel.setMaximumSize(new java.awt.Dimension(1430, 889));
        fundoLabel.setMinimumSize(new java.awt.Dimension(1430, 889));
        fundoLabel.setPreferredSize(new java.awt.Dimension(1430, 889));
        getContentPane().add(fundoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1430, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLoginActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        Logar();
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jPasswordFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fundoLabel;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldLogin;
    // End of variables declaration//GEN-END:variables

    public void Logar() {
        try {
            String idLogin, idSenha;

            idLogin = jTextFieldLogin.getText();
            idSenha = jPasswordFieldSenha.getText();

            Colaborador objuser = new Colaborador();
            objuser.setIdLogin(idLogin);
            objuser.setIdSenha(idSenha);

            ColaboradorDao objusuariodao = new ColaboradorDao();
            ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objuser);

            if (rsusuariodao.next()) {
                //chamar tela que eu quero abrir
                Colaborador usuarioLogado = new Colaborador();
                usuarioLogado.setIdLogin(rsusuariodao.getString("idLogin"));
                usuarioLogado.setIdSenha(rsusuariodao.getString("idSenha"));
                usuarioLogado.setNivel(rsusuariodao.getString("nivel")); // supondo que a coluna exista
                usuarioLogado.setNomeUser(rsusuariodao.getString("nomeUser"));   // se tiver coluna nome

                Sessao.usuarioLogado = usuarioLogado;

                MenuPrincipal objtelamenu = new MenuPrincipal();
                objtelamenu.setVisible(true);

                dispose();
            } else {
                //enviar mensagem dizendo incorreto
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválida");
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Login View: Erro passa aqui" + erro);
        }
    }

}
