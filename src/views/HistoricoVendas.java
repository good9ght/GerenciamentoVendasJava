package views;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import helpers.MascaraMonetaria;
import controllers.VendasController;
import models.Venda;
import services.AuthService;

public class HistoricoVendas extends javax.swing.JFrame {
    private static final long serialVersionUID = 4637498981172080815L;

    ArrayList<Venda> vendas;

    DefaultTableModel modelTbHistorico = new DefaultTableModel(
            new Object[][]{},
            new String [] {
                "Código", "Quantidade", "Valor Total", "Usuário", "Data"
            }
    ) {
        private static final long serialVersionUID = -8035511455101067299L;
        boolean[] canEdit = new boolean[] {
            false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    };
    
    public HistoricoVendas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.updateTb();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbHistorico = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jBtProdutos = new javax.swing.JButton();
        jBtMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Histórico de Vendas");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 600));

        jTbHistorico.setModel(this.modelTbHistorico);
        jTbHistorico.getTableHeader().setReorderingAllowed(false);

        jScrollPane1.setViewportView(jTbHistorico);
        if (jTbHistorico.getColumnModel().getColumnCount() > 0) {
            jTbHistorico.getColumnModel().getColumn(0).setResizable(false);
            jTbHistorico.getColumnModel().getColumn(1).setResizable(false);
            jTbHistorico.getColumnModel().getColumn(2).setResizable(false);
            jTbHistorico.getColumnModel().getColumn(3).setResizable(false);
            jTbHistorico.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitle.setText("Histórico");

        jBtProdutos.setText("Ver Produtos");
        jBtProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtProdutosActionPerformed(evt);
            }
        });

        jBtMenu.setText("Menu");
        jBtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(483, 483, 483)
                .addComponent(jLabelTitle)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelTitle)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtProdutos)
                    .addComponent(jBtMenu))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtProdutosActionPerformed
        if(jTbHistorico.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Você nâo selecionou uma venda");
        }

        new HistoricoVendasProdutos(vendas.get(jTbHistorico.getSelectedRow())).setVisible(true);
        HistoricoVendas.this.dispose();
        
    }//GEN-LAST:event_jBtProdutosActionPerformed

    private void jBtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtMenuActionPerformed
        HistoricoVendas.this.dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_jBtMenuActionPerformed
    
    private void updateTb(){
        this.vendas = new ArrayList<>();

        try {           
            vendas = new VendasController().buscarVendasUsuario(AuthService.getUser());
            
            for (int i = 0; i < vendas.size(); i++) {
                String valor = String.valueOf(
                    MascaraMonetaria.add(vendas.get(i).getValorTotal())
                );
                
                modelTbHistorico.addRow(new String[]{
                    String.valueOf(vendas.get(i).getId()),
                    String.valueOf(vendas.get(i).getQuantidadeTotal()),
                    valor,
                    String.valueOf(vendas.get(i).getLogin()),
                    String.valueOf(vendas.get(i).getCreatedAt())
                });
            }

            jTbHistorico.setModel(modelTbHistorico);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao gerar tabela historico");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtMenu;
    private javax.swing.JButton jBtProdutos;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbHistorico;
    // End of variables declaration//GEN-END:variables
}
