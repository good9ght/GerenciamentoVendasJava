/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;
import Controllers.UsuariosController;
import Models.Senha;
import Models.Usuario;

/**
 *
 * @author victor
 */
public class CadastrarUsuario extends javax.swing.JFrame {
    
    /**
     * Creates new form CadastrarUsuario
     */
    public CadastrarUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void verificaUsuario(){
        if (jFormattedTextUsuario.getText().equals("")) {
            jLabelAviso1.setText("Campo obrigatório");
        }
        else{
            jLabelAviso1.setText("");
        }
    }
    
    private void verificaNome(){
        if(jFormattedTextNome.getText().equals("")){
            jLabelAviso2.setText("Campo obrigatório");
        }
        else{
            jLabelAviso2.setText("");
        }
    }
    
    private void verificaCpf(){
        if(jTextCpf.getText().equals("")){
            jLabelAviso3.setText("Campo obrigatório");
        }
        else if(jTextCpf.getText().length()!=11){
            jLabelAviso3.setText("CPF inválido");
        }
        else{
            jLabelAviso3.setText("");
        }
    }
    
    private void verificaSenha(){
        if(jPwSenha.getText().equals("")){
            jLabelAviso4.setText("Campo obrigatório");
        }
        else if(jPwSenha.getText().length() < 8){
            jLabelAviso4.setText("Mínimo 8 caracteres");
        }
        else{
            jLabelAviso4.setText("");
        }
    }
    
    private void verificaSenhaCoincide(){
        if(jPwSenha.getText().length()>=8){
            if(jPwRepete.getText().equals("")){
                jLabelAviso5.setText("Campo obrigatório");
            }
            else if(jPwSenha.getText().equals(jPwRepete.getText())){
                jLabelAviso5.setText("");
            }
            else{
                jLabelAviso5.setText("Senhas não coincidem");
            }
        }
        else if(jPwSenha.getText().length()<8){
            if(jPwSenha.getText().equals(jPwRepete.getText())){
                jLabelAviso5.setText("Campo obrigatório");
            }
            else if(!jPwRepete.getText().equals("")){
                jLabelAviso5.setText("Senhas não coincidem");
            }
            else{
                jLabelAviso5.setText("");
            }
        }
        else{
                jLabelAviso5.setText("");
        }
    }
    
    private void limpaAvisos(){
        jLabelAviso1.setText("");
        jLabelAviso2.setText("");
        jLabelAviso3.setText("");
        jLabelAviso4.setText("");
        jLabelAviso5.setText("");
    }
    
    private void limparCampos(){
        jFormattedTextNome.setText("");
        jFormattedTextUsuario.setText("");
        jTextCpf.setText("");
        jPwRepete.setText("");
        jPwSenha.setText("");
    }
    
    private boolean getStatusAvisos(){
        return jLabelAviso1.getText().equals("") &&
                jLabelAviso2.getText().equals("") &&
                jLabelAviso3.getText().equals("") &&
                jLabelAviso4.getText().equals("") &&
                jLabelAviso5.getText().equals("");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jFormattedTextNome = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPwSenha = new javax.swing.JPasswordField();
        jPwRepete = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabelAviso1 = new javax.swing.JLabel();
        jLabelAviso2 = new javax.swing.JLabel();
        jLabelAviso3 = new javax.swing.JLabel();
        jLabelAviso4 = new javax.swing.JLabel();
        jLabelAviso5 = new javax.swing.JLabel();
        jFormattedTextUsuario = new javax.swing.JFormattedTextField();
        jTextCpf = new javax.swing.JTextField();
        jBtVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Usuário");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 600));

        jLabel1.setText("Nome:");
        jLabel1.setPreferredSize(new java.awt.Dimension(105, 30));

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setText("Usuário:");
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(105, 30));

        jLabel4.setText("CPF");
        jLabel4.setMinimumSize(new java.awt.Dimension(105, 30));
        jLabel4.setPreferredSize(new java.awt.Dimension(105, 30));

        jBtSalvar.setText("Salvar");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo:");
        jLabel5.setPreferredSize(new java.awt.Dimension(105, 30));

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Admin" }));
        jComboBoxTipo.setMinimumSize(new java.awt.Dimension(85, 30));
        jComboBoxTipo.setPreferredSize(new java.awt.Dimension(120, 30));

        jFormattedTextNome.setPreferredSize(new java.awt.Dimension(185, 30));
        jFormattedTextNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextNomeFocusLost(evt);
            }
        });
        jFormattedTextNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextNomeKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel3.setText("Cadastrar Usuário");

        jLabel6.setText("Senha:");
        jLabel6.setPreferredSize(new java.awt.Dimension(105, 30));

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

        jLabel7.setText("Confirm Senha:");
        jLabel7.setPreferredSize(new java.awt.Dimension(105, 30));

        jLabelAviso1.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAviso1.setForeground(java.awt.Color.red);
        jLabelAviso1.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAviso2.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAviso2.setForeground(java.awt.Color.red);
        jLabelAviso2.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAviso3.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAviso3.setForeground(java.awt.Color.red);
        jLabelAviso3.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAviso4.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAviso4.setForeground(java.awt.Color.red);
        jLabelAviso4.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAviso5.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAviso5.setForeground(java.awt.Color.red);
        jLabelAviso5.setPreferredSize(new java.awt.Dimension(185, 30));

        jFormattedTextUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextUsuarioFocusLost(evt);
            }
        });
        jFormattedTextUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextUsuarioActionPerformed(evt);
            }
        });
        jFormattedTextUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextUsuarioKeyTyped(evt);
            }
        });

        jTextCpf.setPreferredSize(new java.awt.Dimension(185, 30));
        jTextCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCpfKeyTyped(evt);
            }
        });

        jBtVoltar.setText("Voltar");
        jBtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 365, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPwSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPwRepete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jFormattedTextNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jFormattedTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelAviso3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelAviso4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelAviso5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelAviso1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelAviso2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(212, 212, 212))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(433, 433, 433))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAviso1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFormattedTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAviso2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelAviso3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPwSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAviso4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAviso5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPwRepete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtVoltar)
                    .addComponent(jBtSalvar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        this.limpaAvisos();
        this.verificaUsuario();
        this.verificaNome();
        this.verificaCpf();
        this.verificaSenha();
        this.verificaSenhaCoincide();
        if(getStatusAvisos()){
            
            Usuario usuario = new Usuario();
            usuario.setNomeUsuario(jFormattedTextUsuario.getText());
            usuario.setNome(jFormattedTextNome.getText());
            usuario.setCpf(jTextCpf.getText());
            usuario.setSenha(Senha.criptografarSenha(jPwSenha.getText()));
            usuario.setTipo(jComboBoxTipo.getSelectedItem().toString());
            
            new UsuariosController().cadastraUsuario(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado");
            this.limparCampos();
        }
        else{
            JOptionPane.showMessageDialog(null, "Verifique os campos e tente novamente");
        }
        
        
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jPwRepeteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwRepeteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPwRepeteFocusGained

    private void jPwSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwSenhaFocusLost
        
    }//GEN-LAST:event_jPwSenhaFocusLost

    private void jPwRepeteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwRepeteFocusLost
        
    }//GEN-LAST:event_jPwRepeteFocusLost

    private void jFormattedTextUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextUsuarioFocusLost
        this.verificaUsuario();
    }//GEN-LAST:event_jFormattedTextUsuarioFocusLost

    private void jFormattedTextNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextNomeFocusLost
        
    }//GEN-LAST:event_jFormattedTextNomeFocusLost

    private void jBtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarActionPerformed
        CadastrarUsuario.this.dispose();
        new Usuarios().setVisible(true);
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jTextCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCpfKeyTyped
        if(!(evt.getKeyChar()+"").matches("[0-9]")){
            evt.consume();
        }
    }//GEN-LAST:event_jTextCpfKeyTyped

    private void jFormattedTextNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextNomeKeyTyped
        if(!(evt.getKeyChar()+"").matches("[a-zA-Z]")){
            evt.consume();
        }
    }//GEN-LAST:event_jFormattedTextNomeKeyTyped

    private void jFormattedTextUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextUsuarioKeyTyped
        
    }//GEN-LAST:event_jFormattedTextUsuarioKeyTyped

    private void jFormattedTextUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtVoltar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JFormattedTextField jFormattedTextNome;
    private javax.swing.JFormattedTextField jFormattedTextUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAviso1;
    private javax.swing.JLabel jLabelAviso2;
    private javax.swing.JLabel jLabelAviso3;
    private javax.swing.JLabel jLabelAviso4;
    private javax.swing.JLabel jLabelAviso5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPwRepete;
    private javax.swing.JPasswordField jPwSenha;
    private javax.swing.JTextField jTextCpf;
    // End of variables declaration//GEN-END:variables
}
