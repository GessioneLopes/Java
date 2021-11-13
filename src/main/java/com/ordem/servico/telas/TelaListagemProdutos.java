package com.ordem.servico.telas;

import com.ordem.servico.models.Produto;
import com.ordem.servico.repository.ProdutoRepository;
import com.ordem.servico.util.OrdemRetornoAdiciona;
import com.ordem.servico.util.RetornoUpdate;
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class TelaListagemProdutos extends javax.swing.JInternalFrame implements RetornoUpdate {

    private final OrdemRetornoAdiciona ordemRetornoAdiciona;
    private final ProdutoRepository produtoRepository;

    private final NumberFormat numberFormat;

    public TelaListagemProdutos(TelaCadastroOrdemServico tela) {

        initComponents();
        numberFormat = DecimalFormat.getCurrencyInstance();

        produtoRepository = new ProdutoRepository();
        listagemProdutos();

        ordemRetornoAdiciona = tela;
    }

    public TelaListagemProdutos() {

        initComponents();
        numberFormat = DecimalFormat.getCurrencyInstance();

        produtoRepository = new ProdutoRepository();
        listagemProdutos();

        ordemRetornoAdiciona = null;

    }

    private void listagemProdutos() {
        var lista = produtoRepository.lista(Produto.class);

        var modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        var row = new Object[6];
        lista.forEach(i -> {

            row[0] = i.getCodigo();
            row[1] = i.getNome().toUpperCase();
            row[3] = i.getEstoque().getAtual();
            row[2] = numberFormat.format(i.getValor());
            row[4] = i.getMarca();
            row[5] = i.getTamanho();

            modelo.addRow(row);
        });

        if (lista.isEmpty()) {
            row[1] = "Nenhum serviço cadastrado";
            modelo.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer r, int row, int column){
                Component comp = super.prepareRenderer(r, row, column);

                if(row % 2 == 0 && !isCellSelected(row, column)){
                    comp.setBackground(new Color(238, 238, 238));
                }else if(!isCellSelected(row, column)){
                    comp.setBackground(new Color(255, 255, 254));
                }else{
                    comp.setBackground(new Color(38, 117, 191));
                }
                return comp;
            }
        };
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Produtos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menu-list-16.png"))); // NOI18N

        txtBusca.setBackground(new java.awt.Color(255, 255, 246));
        txtBusca.setText("Buscar produto..");
        txtBusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscaFocusGained(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaKeyTyped(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Preço", "Estoque", "Marca", "Tamanho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(100);
            tabela.getColumnModel().getColumn(0).setMaxWidth(105);
            tabela.getColumnModel().getColumn(1).setMinWidth(300);
            tabela.getColumnModel().getColumn(1).setMaxWidth(320);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_orange.png"))); // NOI18N
        jButton1.setText("Novo Produto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excl.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() > 1) {
            long codigo = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);

            if (ordemRetornoAdiciona != null) {
                var produto = produtoRepository.find(Produto.class, codigo);
                ordemRetornoAdiciona.adiciona(produto);
                dispose();

            } else {
                var cadastroUpdateProduto = new TelaCadastroProduto(null, closable, this, codigo);
                cadastroUpdateProduto.setVisible(true);
            }

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        var tcp = new TelaCadastroProduto(null, rootPaneCheckingEnabled, this);
        tcp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaFocusGained
        txtBusca.setText("");
    }//GEN-LAST:event_txtBuscaFocusGained

    private void txtBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyTyped
        var table = (DefaultTableModel) tabela.getModel();
        var tr = new TableRowSorter<>(table);
        tabela.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(txtBusca.getText().toUpperCase()));
    }//GEN-LAST:event_txtBuscaKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tabela.getSelectedRow() != -1) {
            long codigo = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            produtoRepository.deleteById(Produto.class, codigo);
            listagemProdutos();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object obj) {
        listagemProdutos();
    }
}
