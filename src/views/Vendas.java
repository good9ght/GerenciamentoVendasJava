
package views;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import helpers.MascaraMonetaria;
import controllers.ProdutosController;
import controllers.VendasController;
import models.Produto;
import models.Venda;

public class Vendas extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Produto> produtos = new ArrayList<>();
    private int linhaProdutoTbVendas = -1;
    private int linhaProdutoTbprodutos = -1;

    DefaultTableModel modeloTabelaCarrinho = new DefaultTableModel(new Object[][] {},
            new Object[] { "Código", "Produto", "Quantidade", "Preço" }) {
        private static final long serialVersionUID = 1L;
        boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };
    DefaultTableModel modeloTabelaProdutos = new DefaultTableModel(new Object[][] {},
            new Object[] { "Código", "Produto", "Em Estoque", "Preço Unidade" }) {
        private static final long serialVersionUID = 1L;
        boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };
    
    public Vendas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.geraTabelaProdutos();
        this.setTotal();
    }
    
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTextPesquisa = new javax.swing.JTextField();
        jBtAdicionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTbVenda = new javax.swing.JTable();
        jBtSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbProdutos = new javax.swing.JTable();
        jBtRemover = new javax.swing.JButton();
        jBtLimparCarrinho = new javax.swing.JButton();
        jLabelQnt = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jBtMenu = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jLabelPesquisar = new javax.swing.JLabel();
        jBtLimparPesquisar = new javax.swing.JButton();
        jTextQntProd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendas");

        jLayeredPane1.setBackground(new java.awt.Color(254, 254, 254));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1100, 600));

        jTextPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPesquisaKeyTyped(evt);
            }

            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPesquisaKeyPressed(evt);
            }
        });

        jBtAdicionar.setText("+");
        jBtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarActionPerformed(evt);
            }
        });

        jTbVenda.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

        }, new String[] { "Código", "Produto", "Quantidade", "Preço" }) {
            private static final long serialVersionUID = 1L;
            Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class };
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTbVenda.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTbVenda);
        if (jTbVenda.getColumnModel().getColumnCount() > 0) {
            jTbVenda.getColumnModel().getColumn(0).setResizable(false);
            jTbVenda.getColumnModel().getColumn(1).setResizable(false);
            jTbVenda.getColumnModel().getColumn(2).setResizable(false);
            jTbVenda.getColumnModel().getColumn(3).setResizable(false);
        }

        jBtSalvar.setText("Salvar");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jTbProdutos.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

        }, new String[] { "Código", "Produto", "Em Estoque", "Preço Unidade" }) {
            private static final long serialVersionUID = 1L;
            Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class };
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTbProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTbProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTbProdutos.setMaximumSize(new java.awt.Dimension(202, 220));
        jTbProdutos.setMinimumSize(new java.awt.Dimension(202, 220));
        jTbProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTbProdutos);

        jBtRemover.setText("-");
        jBtRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRemoverActionPerformed(evt);
            }
        });

        jBtLimparCarrinho.setText("Limpar");
        jBtLimparCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLimparCarrinhoActionPerformed(evt);
            }
        });

        jLabelQnt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelQnt.setText("Qnt:");

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitle.setText("Vendas");

        jBtMenu.setText("Menu");
        jBtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtMenuActionPerformed(evt);
            }
        });

        jLabelTotal.setBackground(java.awt.Color.white);
        jLabelTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTotal.setText(" Total: R$");
        jLabelTotal.setBorder(new javax.swing.border.LineBorder(java.awt.Color.lightGray, 1, true));
        jLabelTotal.setOpaque(true);

        jLabelPesquisar.setText("Pesquisar:");

        jBtLimparPesquisar.setText("Limpar");
        jBtLimparPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLimparPesquisarActionPerformed(evt);
            }
        });

        jTextQntProd.setText("1");
        jTextQntProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextQntProdKeyTyped(evt);
            }
        });

        jLayeredPane1.setLayer(jTextPesquisa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtAdicionar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtRemover, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtLimparCarrinho, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelQnt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelTitle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtMenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelPesquisar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtLimparPesquisar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextQntProd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(jLayeredPane1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGroup(jLayeredPane1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(24, 24, 24)
                                .addGroup(jLayeredPane1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 82,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10).addComponent(jBtLimparPesquisar))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jLayeredPane1Layout.createSequentialGroup().addContainerGap().addComponent(jBtMenu,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(35, 35, 35)
                                        .addGroup(jLayeredPane1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                        .addComponent(jLabelQnt)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextQntProd))
                                                .addComponent(jBtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25)
                                        .addGroup(jLayeredPane1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                        .addComponent(jBtLimparCarrinho,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(43, 43, 43).addComponent(jBtRemover,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jLayeredPane1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 460,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(13, 13, 13)
                                        .addComponent(jLabelTitle)))
                        .addContainerGap(13, Short.MAX_VALUE)));
        jLayeredPane1Layout.setVerticalGroup(jLayeredPane1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(41, 41, 41).addComponent(jLabelTitle)
                        .addGap(108, 108, 108)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelQnt).addComponent(jTextQntProd,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18).addComponent(jBtAdicionar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap(143, Short.MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtLimparPesquisar).addComponent(jLabelTotal,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(
                                        jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtLimparCarrinho).addComponent(jBtRemover))
                        .addGap(82, 82, 82)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtMenu).addComponent(jBtSalvar))
                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geraTabelaProdutos() {
        try {
            produtos = new ProdutosController().buscarProdutosEmEstoque();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos.");
        }
        
        for (int i = 0; i < produtos.size(); i++) {
            modeloTabelaProdutos.addRow(new String[]{
                String.valueOf(produtos.get(i).getId()),
                String.valueOf(produtos.get(i).getNome()),
                String.valueOf(produtos.get(i).getQuantidade()),
                String.valueOf(MascaraMonetaria.add(produtos.get(i).getValor()))});
        }

        jTbProdutos.setModel(modeloTabelaProdutos);
    }
    
    private void setTotal(){
        double total = 0;

        for (int contador = 0; contador < jTbVenda.getRowCount(); contador++) {
            total = total + MascaraMonetaria.rm(jTbVenda.getValueAt(contador, 3).toString());
        }

        jLabelTotal.setText("  Total: " + MascaraMonetaria.add(total));
    }
    
    private void procurarLinha(String palavra){
        
        for (int i = 0; i < jTbProdutos.getRowCount(); i++){
            String nome = jTbProdutos.getValueAt(i, 1).toString();
            
            if (nome.contains(palavra)){
                jTbProdutos.setRowSelectionInterval(i, i);
                break;
            }
            
        }
    }
    
    private boolean estoqueEstaVazio(){
        return (jTbProdutos.getValueAt(jTbProdutos.getSelectedRow(), 2).toString()).equals("0");
    }
    
    private int verificaQuantidade() {
        int opcao = 0;

        int quantidadeEscolhida = Integer.parseInt(jTextQntProd.getText());
        int quantidadeProduto = Integer.parseInt(jTbProdutos.getValueAt(jTbProdutos.getSelectedRow(), 2).toString());

        
        if (quantidadeEscolhida > quantidadeProduto) {
            opcao = 0;
            //se tem ao menos 1 linha
        } else if (jTbVenda.getRowCount() > 0) {
            this.linhaProdutoTbVendas = linhaTabelaVendas();
            
            if(linhaProdutoTbVendas != -1){
                int quantidadeCarrinho = Integer.parseInt(
                        jTbVenda.getValueAt(linhaTabelaVendas(), 2).toString());
                
                if(quantidadeCarrinho + quantidadeEscolhida > quantidadeProduto){
                    opcao = 0;
                } else{
                    opcao = 2;
                }
            }
            //se a table tem mais de 1 linha mas nao contem
            else{
                opcao = 1;
            }
        }
        else {
            opcao = 1;
        }

        return opcao;
    }
    
    private int linhaTabelaVendas(){
        int testador = -1;
        int contador;
        
        for (contador = 0; contador < jTbVenda.getRowCount(); contador++) {
            Object linhaTbProd = jTbProdutos.getValueAt(jTbProdutos.getSelectedRow(), 0);
            Object linhaTbVenda = jTbVenda.getValueAt(contador, 0);
            
            if (linhaTbProd == linhaTbVenda) {
                testador = contador;
                break;
            }
        }
        return testador;
    }
    
    private void limpaTabela(){
        modeloTabelaCarrinho.setNumRows(0);
        modeloTabelaProdutos.setNumRows(0);
    }
    
    private void linhaTabelaProdutos(){
        for (int i = 0; i < jTbProdutos.getRowCount(); i++) {
            Object linhaTbProd = jTbProdutos.getValueAt(i, 0);
            Object linhaTbVenda = jTbVenda.getValueAt(jTbVenda.getSelectedRow(), 0);
            if (linhaTbProd == linhaTbVenda) {
                this.linhaProdutoTbprodutos = i;
                break;
            }
        }
    }
    
    private void adicionaTbVenda(){
        int row = this.jTbProdutos.getSelectedRow();

        double valor_produto = MascaraMonetaria.rm(
                jTbProdutos.getValueAt(row, 3).toString());
        int quantidade_produto = Integer.parseInt(jTextQntProd.getText());
        double valor_total = valor_produto * quantidade_produto;

        String codigo_produto = jTbProdutos.getValueAt(row, 0).toString();
        String nome_produto = jTbProdutos.getValueAt(row, 1).toString();
        String valorConvertido = MascaraMonetaria.add(valor_total);

        modeloTabelaCarrinho.addRow(new String[]{
            codigo_produto,
            nome_produto,
            String.valueOf(quantidade_produto),
            valorConvertido});

        jTbVenda.setModel(modeloTabelaCarrinho);
    }
    
    private void atualizaTbVenda(){
        double valor_produto = MascaraMonetaria.rm(jTbProdutos.getValueAt(jTbProdutos.getSelectedRow(),3).toString());
        int quantidadeSelecionada = Integer.parseInt(jTextQntProd.getText());
        int quantidade_produto = Integer.parseInt(jTbVenda.getValueAt(this.linhaProdutoTbVendas, 2).toString());

        int novaQuantidade_produto =quantidadeSelecionada+quantidade_produto;

        double valor = valor_produto*novaQuantidade_produto;

        modeloTabelaCarrinho.setValueAt(novaQuantidade_produto, this.linhaProdutoTbVendas,2 );

        modeloTabelaCarrinho.setValueAt(MascaraMonetaria.add(valor), this.linhaProdutoTbVendas,3 );
        
    }
    
    private void atualizaTbProdutos(){
        int quantidadeSelecionada = Integer.parseInt(jTextQntProd.getText());
        int quantidade_produto = Integer.parseInt(jTbProdutos.getValueAt(jTbProdutos.getSelectedRow(), 2).toString());
        int novaQuantidade = quantidade_produto-quantidadeSelecionada;

        modeloTabelaProdutos.setValueAt(novaQuantidade, jTbProdutos.getSelectedRow() ,2 );
    }
    
    private void atualizaTbProdRemove(){
        this.linhaTabelaProdutos();
        int quantidade_produto = Integer.parseInt(jTbProdutos.getValueAt(this.linhaProdutoTbprodutos, 2).toString());
        int quntidade_produtoCarrinho = Integer.parseInt(jTbVenda.getValueAt(jTbVenda.getSelectedRow(), 2).toString());
        
        int novaQntP = quantidade_produto+quntidade_produtoCarrinho;

        modeloTabelaProdutos.setValueAt(novaQntP, this.linhaProdutoTbprodutos ,2 );
    }
    
    private void registrarVenda(){
        Venda venda = new Venda();
       
        for(int i = 0; i < jTbVenda.getRowCount(); i++){
            venda.addItem(
                Integer.parseInt(jTbVenda.getValueAt(i, 0).toString()), 
                Integer.parseInt(jTbVenda.getValueAt(i, 2).toString()), 
                MascaraMonetaria.rm(jTbVenda.getValueAt(i, 3).toString())
            );
        }

        try {
            new VendasController().registrarVenda(venda);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao registrar venda.");
        }
        
        JOptionPane.showMessageDialog(null,"Venda registrada.");
   }
    
    
    private void jBtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarActionPerformed
        if(jTbProdutos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
            return;
        }

        if(jTextQntProd.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Você não digitou uma quantidade");
            return;
        }

        switch (this.verificaQuantidade()){
            case 0:
                if (estoqueEstaVazio()){
                    JOptionPane.showMessageDialog(null, "Produto em falta");
                } else{
                    JOptionPane.showMessageDialog(null, "Quantidade maior que estoque");
                }
                break;
            case 1:
                this.adicionaTbVenda();
                this.atualizaTbProdutos();
                break;
            case 2:
                this.atualizaTbVenda();
                this.atualizaTbProdutos();
                break;
        }
        this.setTotal();
    }//GEN-LAST:event_jBtAdicionarActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        if(jTbVenda.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "O carrinho está vazio");
            return;
        }

        this.registrarVenda();
        this.limpaTabela();
        this.geraTabelaProdutos();
        this.setTotal();
        
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRemoverActionPerformed
        if (jTbVenda.getSelectedRow() == -1) { 
            return;
        }

        atualizaTbProdRemove();
        modeloTabelaCarrinho.removeRow(jTbVenda.getSelectedRow());
        this.setTotal();
    }//GEN-LAST:event_jBtRemoverActionPerformed

    private void jBtLimparCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLimparCarrinhoActionPerformed
        this.limpaTabela();
        this.geraTabelaProdutos();
        this.setTotal();
    }//GEN-LAST:event_jBtLimparCarrinhoActionPerformed

    private void jBtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtMenuActionPerformed
        Vendas.this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_jBtMenuActionPerformed

    private void jTextPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPesquisaKeyTyped
        procurarLinha(jTextPesquisa.getText());
    }//GEN-LAST:event_jTextPesquisaKeyTyped

    private void jTextPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPesquisaKeyPressed
        
    }//GEN-LAST:event_jTextPesquisaKeyPressed

    private void jBtLimparPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLimparPesquisarActionPerformed
        jTextPesquisa.setText("");
    }//GEN-LAST:event_jBtLimparPesquisarActionPerformed

    private void jTextQntProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextQntProdKeyTyped
        if(!(evt.getKeyChar()+"").matches("[0-9]")){
            evt.consume();
        }
    }//GEN-LAST:event_jTextQntProdKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAdicionar;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtLimparCarrinho;
    private javax.swing.JButton jBtLimparPesquisar;
    private javax.swing.JButton jBtMenu;
    private javax.swing.JButton jBtRemover;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JLabel jLabelQnt;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTbProdutos;
    private javax.swing.JTable jTbVenda;
    private javax.swing.JTextField jTextPesquisa;
    private javax.swing.JTextField jTextQntProd;
    // End of variables declaration//GEN-END:variables
}
