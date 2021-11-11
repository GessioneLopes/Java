package com.ordem.servico.telas;

import com.ordem.servico.models.Ordem;
import com.ordem.servico.repository.OrdemRepository;
import com.ordem.servico.util.GeraRelatorioUtil;
import com.ordem.servico.util.OrdemTipo;
import com.ordem.servico.util.RetornoUpdate;
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class TelaOrdemServicos extends javax.swing.JInternalFrame implements RetornoUpdate {

    private OrdemRepository ordemRepository;
    private NumberFormat numberFormat;
    private TelaCadastroOrdemServico cadastroOrdemServico;
    private RetornoUpdate retornoUpdate;

    public TelaOrdemServicos() {
        initComponents();

        numberFormat = DecimalFormat.getCurrencyInstance();

        ordemRepository = new OrdemRepository();
        listagemOrdens();
    }
    
    public TelaOrdemServicos(TelaRecibos recibos) {
        initComponents();

        retornoUpdate = recibos;
        numberFormat = DecimalFormat.getCurrencyInstance();

        ordemRepository = new OrdemRepository();
        listagemOrdens();
    }


    private void listagemOrdens() {
        List<Ordem> lista = ordemRepository.lista(Ordem.class);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[7];
        lista.forEach(i -> {
            if (i.getTipo() == OrdemTipo.ORDEM_SERVICO) {
                row[0] = i.getId();
                row[1] = i.getData();
                row[2] = i.getHora();
                row[4] = numberFormat.format(i.getTotal());
                row[3] = i.getCliente().getNome();
                row[5] = i.getStatus().name();
                row[6] = i.getTecnico().getNomeTecnico();

                modelo.addRow(row);
            }
        });

        var existeOS = lista.stream()
                .filter(it -> it.getTipo() == OrdemTipo.ORDEM_SERVICO)
                .findAny().isEmpty();

        if (existeOS) {
            row[3] = "Nenhuma Ordem de serviço cadastrada";
            modelo.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
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
        jButton2 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setTitle("O.S");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menu-list-16.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton1.setText("Nova Ordem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Data", "Horario", "Cliente", "Total", "Status", "Tecnico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            tabela.getColumnModel().getColumn(0).setMinWidth(90);
            tabela.getColumnModel().getColumn(0).setMaxWidth(100);
            tabela.getColumnModel().getColumn(1).setMinWidth(100);
            tabela.getColumnModel().getColumn(1).setMaxWidth(102);
            tabela.getColumnModel().getColumn(2).setMinWidth(80);
            tabela.getColumnModel().getColumn(2).setMaxWidth(82);
            tabela.getColumnModel().getColumn(3).setMinWidth(300);
            tabela.getColumnModel().getColumn(3).setMaxWidth(305);
            tabela.getColumnModel().getColumn(6).setMinWidth(200);
            tabela.getColumnModel().getColumn(6).setMaxWidth(230);
        }

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png"))); // NOI18N
        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excl.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabela.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabela.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(txtBuscar.getText().toUpperCase()));
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tabela.getSelectedRow() != -1) {
            long idOrdem = Long.parseLong(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            ordemRepository.deleteById(Ordem.class, idOrdem);
            listagemOrdens();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tabela.getSelectedRow() != -1) {
            long idOrdem = Long.parseLong(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            new GeraRelatorioUtil().geraViaOrdemServico(idOrdem);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cadastroOrdemServico == null) {
            cadastroOrdemServico = new TelaCadastroOrdemServico(this);
            MainApp.getDesktop().add(cadastroOrdemServico);
        }
        cadastroOrdemServico.setVisible(true);
        var desktopSize = MainApp.getDesktop().getSize();
        var screenSize = cadastroOrdemServico.getSize();
        cadastroOrdemServico.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() > 1) {

            long codigo = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            Ordem ordem = ordemRepository.find(Ordem.class, codigo);

            retornoUpdate.update(ordem);
            dispose();

        }
    }//GEN-LAST:event_tabelaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object obj) {
        listagemOrdens();
    }
}
