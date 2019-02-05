package views;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.Usuario;

public class AlteracaoSenha extends javax.swing.JFrame {
    private Usuario usuario;

    public AlteracaoSenha(Usuario usuario) {
        this.usuario = usuario;
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void verificarCaracteresSenha() {
        if (jPwSenha.getText().equals("")) {
            jLabelAviso4.setText(" Campo obrigatório");
        } else if (jPwSenha.getText().length() < 8) {
            jLabelAviso4.setText(" Mínimo 8 caracteres");
        } else {
            jLabelAviso4.setText("");
        }
    }

    private void verificarCamposCoincidem() {
        if (jPwSenha.getText().length() >= 8) {
            if (jPwRepete.getText().equals("")) {
                jLabelAviso5.setText(" Campo obrigatório");
            } else if (jPwSenha.getText().equals(jPwRepete.getText())) {
                jLabelAviso5.setText("");
            } else {
                jLabelAviso5.setText(" Senhas não coincidem");
            }
        } else if (jPwSenha.getText().length() < 8) {
            if (jPwSenha.getText().equals(jPwRepete.getText())) {
                jLabelAviso5.setText(" Campo obrigatório");
            } else if (!jPwRepete.getText().equals("")) {
                jLabelAviso5.setText(" Senhas não coincidem");
            } else {
                jLabelAviso5.setText("");
            }
        } else {
            jLabelAviso5.setText("");
        }
    }

    private void limpaAvisos() {
        jLabelAviso4.setText("");
        jLabelAviso5.setText("");
    }

    private boolean podeAlterarSenha() {
        return jLabelAviso4.getText().equals("") && jLabelAviso5.getText().equals("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jBtVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPwSenha = new javax.swing.JPasswordField();
        jPwRepete = new javax.swing.JPasswordField();
        jLabelAviso4 = new javax.swing.JLabel();
        jLabelAviso5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Senha");

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Alterar Senha");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jBtVoltar.setText("Voltar");
        jBtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Repita a Senha:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel1.setText("Nova Senha:");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 30));

        jPwSenha.setMinimumSize(new java.awt.Dimension(10, 19));
        jPwSenha.setPreferredSize(new java.awt.Dimension(185, 30));
        jPwSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPwSenhaFocusLost(evt);
            }
        });

        jPwRepete.setPreferredSize(new java.awt.Dimension(185, 30));
        jPwRepete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPwRepeteFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jPwRepeteFocusLost(evt);
            }
        });

        jLabelAviso4.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAviso4.setForeground(java.awt.Color.red);

        jLabelAviso5.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAviso5.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jBtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel3).addGap(226, 226, 226))))
                .addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addGap(245, 245, 245)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabelAviso4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPwSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelAviso5, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 185,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(197, 197, 197)))))
                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(116, 116, 116)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPwRepete, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 166, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(51, 51, 51).addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPwSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAviso4, javax.swing.GroupLayout.PREFERRED_SIZE, 17,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPwRepete, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAviso5, javax.swing.GroupLayout.PREFERRED_SIZE, 17,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtVoltar).addComponent(jButtonSalvar))
                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSalvarActionPerformed
        this.limpaAvisos();
        this.verificarCaracteresSenha();
        this.verificarCamposCoincidem();

        if (!podeAlterarSenha()) {
            JOptionPane.showMessageDialog(null, "Verifique os campos e tente novamente");
            return;
        }

        this.usuario.setSenha(jPwSenha.getText());

        try {
            this.usuario.save();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha.");
            System.exit(0);
        }
        
        JOptionPane.showMessageDialog(null, "Senha alterada");

        AlteracaoSenha.this.dispose();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jBtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarActionPerformed
        AlteracaoSenha.this.dispose();
        Usuarios usuariosTela = new Usuarios();
        usuariosTela.setVisible(true);
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jPwSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwSenhaFocusLost

    }//GEN-LAST:event_jPwSenhaFocusLost

    private void jPwRepeteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwRepeteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPwRepeteFocusGained

    private void jPwRepeteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwRepeteFocusLost
        this.verificarCaracteresSenha();
    }//GEN-LAST:event_jPwRepeteFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtVoltar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAviso4;
    private javax.swing.JLabel jLabelAviso5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPwRepete;
    private javax.swing.JPasswordField jPwSenha;
    // End of variables declaration//GEN-END:variables
}
