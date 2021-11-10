/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ordem.servico.telas;

import com.ordem.servico.models.Servico;
import com.ordem.servico.repository.ServicoRepository;
import com.ordem.servico.util.OrdemRetornoAdiciona;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deibi
 */
public class TelaListagemServicos extends javax.swing.JDialog {

    private ServicoRepository servicoRepository;
    private final NumberFormat numberFormat;

    private OrdemRetornoAdiciona ordemRetornoAdiciona;

    public TelaListagemServicos(java.awt.Frame parent, boolean modal, TelaCadastroOrdemServico tela) {
        super(parent, modal);
        initComponents();

        ordemRetornoAdiciona = tela;

        numberFormat = DecimalFormat.getCurrencyInstance();

        servicoRepository = new ServicoRepository();
        listagemServicos();

    }

    private void listagemServicos() {
        List<Servico> lista = servicoRepository.lista(Servico.class);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[6];
        lista.forEach(i -> {

            row[0] = i.getId();
            row[1] = i.getDescricao().toUpperCase();
            row[2] = i.getStatus();
            row[3] = numberFormat.format(i.getValor());
            row[4] = i.getDuracao();
            row[5] = i.getGarantia();

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Status", "Valor", "Duração", "Garantia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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
            tabela.getColumnModel().getColumn(1).setMinWidth(320);
            tabela.getColumnModel().getColumn(1).setMaxWidth(325);
        }

        jTextField1.setText("Pesquisa..");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() > 1) {

            long codigo = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            Servico servico = servicoRepository.find(Servico.class, codigo);
            ordemRetornoAdiciona.adiciona(servico);
            dispose();

        }
    }//GEN-LAST:event_tabelaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
