package com.ordem.servico.telas;

import com.ordem.servico.models.Produto;
import com.ordem.servico.repository.ProdutoRepository;
import com.ordem.servico.util.OrdemRetornoAdiciona;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TelaListagemProdutos extends javax.swing.JDialog {

    private final OrdemRetornoAdiciona ordemRetornoAdiciona;
    private final ProdutoRepository produtoRepository;

    private final NumberFormat numberFormat;

    public TelaListagemProdutos(java.awt.Frame parent, boolean modal, TelaCadastroOrdemServico tela) {
        super(parent, modal);
        initComponents();
        numberFormat = DecimalFormat.getCurrencyInstance();

        produtoRepository = new ProdutoRepository();
        listagemProdutos();

        ordemRetornoAdiciona = tela;
    }

    private void listagemProdutos() {
        List<Produto> lista = produtoRepository.lista(Produto.class);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[6];
        lista.forEach(i -> {

            row[0] = i.getCodigo();
            row[1] = i.getNome().toUpperCase();
            row[3] = i.getEstoque().getQtde();
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

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextField1.setText("jTextField1");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() > 1) {

            long codigo = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            Produto produto = produtoRepository.find(Produto.class, codigo);
            ordemRetornoAdiciona.adiciona(produto);
            dispose();

        }
    }//GEN-LAST:event_tabelaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
