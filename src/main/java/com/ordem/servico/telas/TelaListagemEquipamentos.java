package com.ordem.servico.telas;

import com.ordem.servico.models.Equipamento;
import com.ordem.servico.repository.EquipamentoRepository;
import com.ordem.servico.util.RetornoUpdate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TelaListagemEquipamentos extends javax.swing.JDialog {

    private RetornoUpdate retornoUpdate;
    private EquipamentoRepository equipamentoRepository;

    public TelaListagemEquipamentos(java.awt.Frame parent, boolean modal, TelaCadastroOrdemServico cadastroOrdemServico) {
        super(parent, modal);
        initComponents();

        equipamentoRepository = new EquipamentoRepository();
        listaEquipamentos();

        retornoUpdate = cadastroOrdemServico;
    }
    
    public TelaListagemEquipamentos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        equipamentoRepository = new EquipamentoRepository();
        listaEquipamentos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Equipamentos");

        jTextField1.setBackground(new java.awt.Color(255, 255, 239));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Modelo", "Placa", "Cor", "Marca", "N° Série", "Garantia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            tabela.getColumnModel().getColumn(0).setMinWidth(105);
            tabela.getColumnModel().getColumn(0).setMaxWidth(110);
            tabela.getColumnModel().getColumn(1).setMinWidth(300);
            tabela.getColumnModel().getColumn(1).setMaxWidth(350);
            tabela.getColumnModel().getColumn(7).setMinWidth(80);
            tabela.getColumnModel().getColumn(7).setMaxWidth(85);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() > 1) {

            long codigo = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            var equipamento = equipamentoRepository.find(Equipamento.class, codigo);

            retornoUpdate.update(equipamento);
            dispose();

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void listaEquipamentos() {

        List<Equipamento> lista = equipamentoRepository.lista(Equipamento.class);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[8];
        lista.forEach(i -> {

            row[0] = i.getId();
            row[1] = i.getNomeEquipamante();
            row[2] = i.getModelo();
            row[3] = i.getPlaca();
            row[4] = i.getCor();
            row[5] = i.getMarca();
            row[6] = i.getNumero_serie();
            row[7] = i.isGarantia();

            modelo.addRow(row);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
