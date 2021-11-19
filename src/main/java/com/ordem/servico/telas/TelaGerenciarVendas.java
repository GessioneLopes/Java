package com.ordem.servico.telas;

import com.ordem.servico.models.ItemVenda;
import com.ordem.servico.models.Venda;
import com.ordem.servico.repository.UsuarioRepository;
import com.ordem.servico.repository.VendaRepository;
import com.ordem.servico.util.GeraRelatorioUtil;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class TelaGerenciarVendas extends javax.swing.JDialog {

    private final VendaRepository vendaRepository;
    private final UsuarioRepository usuarioRepository;

    private final NumberFormat formate;

    public TelaGerenciarVendas() {
        initComponents();

        formate = NumberFormat.getCurrencyInstance();

        usuarioRepository = new UsuarioRepository();

        vendaRepository = new VendaRepository();
        mostarVendasNaTabela();

    }

    private void mostarVendasNaTabela() {
        var modelo = (DefaultTableModel) tablevendas.getModel();
        modelo.setNumRows(0);

        var listagemVendas = vendaRepository.lista(Venda.class);

        var rows = new Object[10];
        for (Venda object : listagemVendas) {
            rows[0] = object.getId();
            rows[1] = object.getDataVenda().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            rows[2] = object.getHora();
            rows[3] = formate.format(object.getTotal());

            if (object.getDesconto() != null) {
                rows[4] = formate.format(object.getDesconto());
            } else {
                rows[4] = formate.format(0);
            }

            if (object.getCliente() != null) {
                rows[5] = object.getCliente().getCodigo();
                rows[6] = object.getCliente().getCpf();
            } else {
                rows[5] = "0";
                rows[6] = "Não Informado";
            }

            rows[7] = object.getResponsavel();
            rows[8] = object.getFormaPgto().name();
            rows[9] = object.getObs();

            modelo.addRow(rows);

        }
        if (listagemVendas.isEmpty()) {
            var dados = new String[2];
            dados[0] = "0";
            dados[1] = "Nenhuma venda realizada.";
            modelo.addRow(dados);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablevendas = new javax.swing.JTable(){
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaitem = new javax.swing.JTable();
        try{
            busca = new javax.swing.JTextField(){

                final BufferedImage image = ImageIO.read(getClass().getResource("/imagens/icons8-pesquisar-24.png"));

                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int centerPoint = (getHeight() - image.getHeight())/2;
                    g.drawImage(image, 6, centerPoint, this);
                }
            };
            jButton2 = new javax.swing.JButton();
            jButton1 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Vendas");
            setAlwaysOnTop(true);
            setBackground(new java.awt.Color(255, 239, 224));
            setResizable(false);

            jSplitPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
            jSplitPane1.setDividerSize(10);
            jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
            jSplitPane1.setName(""); // NOI18N
            jSplitPane1.setOneTouchExpandable(true);

            tablevendas.setFont(new java.awt.Font("Noto Mono", 0, 12)); // NOI18N
            tablevendas.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null}
                },
                new String [] {
                    "Codigo", "Data", "Hora", "Total", "Desconto", "Cod. Cliente", "CPF", "Operador", "Pagamento", "Observação"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    true, false, false, false, true, false, false, false, true, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            tablevendas.setGridColor(new java.awt.Color(243, 255, 255));
            tablevendas.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tablevendasMouseClicked(evt);
                }
            });
            jScrollPane2.setViewportView(tablevendas);
            if (tablevendas.getColumnModel().getColumnCount() > 0) {
                tablevendas.getColumnModel().getColumn(0).setMinWidth(90);
                tablevendas.getColumnModel().getColumn(0).setMaxWidth(100);
                tablevendas.getColumnModel().getColumn(1).setMinWidth(90);
                tablevendas.getColumnModel().getColumn(1).setMaxWidth(130);
                tablevendas.getColumnModel().getColumn(2).setMaxWidth(100);
                tablevendas.getColumnModel().getColumn(3).setMinWidth(90);
                tablevendas.getColumnModel().getColumn(6).setMinWidth(120);
                tablevendas.getColumnModel().getColumn(7).setMinWidth(180);
                tablevendas.getColumnModel().getColumn(8).setMinWidth(100);
            }

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jSplitPane1.setLeftComponent(jPanel1);

            tabelaitem.setFont(new java.awt.Font("Noto Mono", 0, 12)); // NOI18N
            tabelaitem.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String [] {
                    "#", "Produtos da Venda", "Qtde", "Valor", "Codigo Interno"
                }
            ));
            tabelaitem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            tabelaitem.setGridColor(new java.awt.Color(243, 240, 224));
            jScrollPane3.setViewportView(tabelaitem);
            if (tabelaitem.getColumnModel().getColumnCount() > 0) {
                tabelaitem.getColumnModel().getColumn(0).setMaxWidth(120);
                tabelaitem.getColumnModel().getColumn(1).setMinWidth(380);
                tabelaitem.getColumnModel().getColumn(2).setMaxWidth(60);
                tabelaitem.getColumnModel().getColumn(3).setMinWidth(120);
                tabelaitem.getColumnModel().getColumn(4).setMinWidth(120);
            }

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3)
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
            );

            jSplitPane1.setRightComponent(jPanel2);

        }catch(Exception e){}
        busca.setBackground(new java.awt.Color(255, 245, 236));
        busca.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        busca.setMargin(new java.awt.Insets(0, 20, 0, 0));
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excl.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(busca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        var table = (DefaultTableModel) tablevendas.getModel();
        var tr = new TableRowSorter<>(table);
        tablevendas.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (usuarioRepository.verificaPermissao(MainApp.txtUserLogado.getText()) == true) {

            long idvenda = Long.valueOf(tablevendas.getValueAt(tablevendas.getSelectedRow(), 0).toString());

            vendaRepository.delete(vendaRepository.find(Venda.class, idvenda));
            mostarVendasNaTabela();

            var table = (DefaultTableModel) tabelaitem.getModel();
            table.setNumRows(0);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablevendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablevendasMouseClicked
        if (evt.getClickCount() > 1) {

        } else {
            var modelo = (DefaultTableModel) tabelaitem.getModel();
            modelo.setNumRows(0);

            long vendaId = (long) tablevendas.getValueAt(tablevendas.getSelectedRow(), 0);
            var rows = new Object[5];

            var venda = new VendaRepository().find(Venda.class, vendaId);

            for (ItemVenda object : venda.getItens()) {
                rows[0] = object.getId();
                rows[1] = object.getDescr().toUpperCase();
                rows[2] = object.getQtde();
                rows[3] = formate.format(object.getPrecoUnit());
                rows[4] = object.getCodigo_interno();
                modelo.addRow(rows);
            }
        }

    }//GEN-LAST:event_tablevendasMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tablevendas.getSelectedRow() != -1) {

            long idVenda = (long) tablevendas.getValueAt(tablevendas.getSelectedRow(), 0);
            var venda = vendaRepository.find(Venda.class, idVenda);

            long codigoCliente = 0L;

            if (venda.getCliente() != null) {
                codigoCliente = venda.getCliente().getCodigo();
            }

            var gera = new GeraRelatorioUtil();
            gera.geraReletorioVendasEfetuadas(idVenda, codigoCliente);

        } else {
            JOptionPane.showMessageDialog(tablevendas, "Selecione uma venda na tabela", "Atenção", 0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tabelaitem;
    private javax.swing.JTable tablevendas;
    // End of variables declaration//GEN-END:variables
}
