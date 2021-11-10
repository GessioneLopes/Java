package com.ordem.servico.telas;

import com.ordem.servico.models.Cliente;
import com.ordem.servico.repository.ClienteRepository;
import com.ordem.servico.util.RetornoUpdate;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class TelaListagemClientes extends javax.swing.JDialog {

    private final ClienteRepository clienteRepository;
    private RetornoUpdate retornoUpdate;

    public TelaListagemClientes(TelaCadastroOrdemServico telaCadastroOrdemServico) {

        initComponents();

        retornoUpdate = telaCadastroOrdemServico;

        clienteRepository = new ClienteRepository();
        listaClientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCli = new javax.swing.JTable(){
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
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes Cadastrados");

        tabelaCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "CPF", "NOME", "CNPJ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCli.setGridColor(new java.awt.Color(249, 249, 249));
        tabelaCli.setRowHeight(26);
        tabelaCli.setShowHorizontalLines(true);
        tabelaCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCliMouseClicked(evt);
            }
        });
        tabelaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaCliKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCli);
        if (tabelaCli.getColumnModel().getColumnCount() > 0) {
            tabelaCli.getColumnModel().getColumn(0).setMinWidth(100);
            tabelaCli.getColumnModel().getColumn(0).setMaxWidth(105);
            tabelaCli.getColumnModel().getColumn(1).setMinWidth(160);
            tabelaCli.getColumnModel().getColumn(1).setMaxWidth(165);
            tabelaCli.getColumnModel().getColumn(2).setMinWidth(300);
        }

        txtBuscar.setBackground(new java.awt.Color(255, 255, 228));
        txtBuscar.setToolTipText("Procurar..");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabelaCli.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabelaCli.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(txtBuscar.getText().toUpperCase()));
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void tabelaCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCliMouseClicked
        if (evt.getClickCount() > 1) {

            long codigo = (long) tabelaCli.getValueAt(tabelaCli.getSelectedRow(), 0);
            Cliente cliente = clienteRepository.find(Cliente.class, codigo);

            retornoUpdate.update(cliente);
            dispose();

        }
    }//GEN-LAST:event_tabelaCliMouseClicked

    private void tabelaCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaCliKeyPressed
        if (tabelaCli.getSelectedRow() != -1 && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            long codigo = (long) tabelaCli.getValueAt(tabelaCli.getSelectedRow(), 0);
            Cliente cliente = clienteRepository.find(Cliente.class, codigo);

            retornoUpdate.update(cliente);
            dispose();
        }
    }//GEN-LAST:event_tabelaCliKeyPressed

    private void listaClientes() {

        List<Cliente> lista = clienteRepository.lista(Cliente.class);

        DefaultTableModel modelo = (DefaultTableModel) tabelaCli.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[4];
        lista.forEach(i -> {

            row[0] = i.getCodigo();
            row[1] = i.getCpf();
            row[2] = i.getNome();
            row[3] = i.getCnpj();

            modelo.addRow(row);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCli;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
