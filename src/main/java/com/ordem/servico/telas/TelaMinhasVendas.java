package com.ordem.servico.telas;

import com.ordem.servico.models.Cliente;
import com.ordem.servico.models.ItemVenda;
import com.ordem.servico.models.Produto;
import com.ordem.servico.models.Venda;
import com.ordem.servico.repository.ProdutoRepository;
import com.ordem.servico.util.DataHora;
import com.ordem.servico.util.RetornoUpdate;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TelaMinhasVendas extends javax.swing.JInternalFrame implements RetornoUpdate {

    private final List<ItemVenda> listaItens = new ArrayList<>();
    private final NumberFormat numberFormat;
    private final ProdutoRepository produtoRepository;
    private TelaFinalizaVenda telafinalizaVenda;

    private Venda venda;
    private Cliente cliente;

    public TelaMinhasVendas() {

        initComponents();

        produtoRepository = new ProdutoRepository();
        numberFormat = DecimalFormat.getCurrencyInstance();

        venda = new Venda();
        txtDataVenda.setText(new DataHora().ler_Data());

    }

    public Image icone() {
        return (new ImageIcon(getClass().getResource("/imagens/menu-circulado-16.png"))).getImage();
    }

    private void listaItemsOrdem() {

        var modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        var row = new Object[7];
        listaItens.forEach(i -> {
            row[0] = i.getCodigo_interno();
            row[1] = i.getDescr();
            row[2] = i.getQtde();
            row[3] = numberFormat.format(i.getPrecoUnit());
            row[4] = numberFormat.format(i.getSubtotal());

            modelo.addRow(row);
        });

        if (listaItens.isEmpty()) {
            row[1] = "Nenhum serviço ou produto adicionado";
            modelo.addRow(row);
        }

        txtTotalGeral.setValue(listaItens.stream()
                .map(it -> it.getSubtotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        txtTotalGeral = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtNomeCliente = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtValorUnt = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtDataVenda = new javax.swing.JLabel();
        txtDescProduto = new javax.swing.JLabel();
        txtQtdeSpiner = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        printcupom = new javax.swing.JCheckBox();
        modoPromocao = new javax.swing.JCheckBox();
        txtCodigoBar = new javax.swing.JTextField();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menu-circulado-16.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1034, 575));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Quantidade", "Valor Unt", "SubTotal"
            }
        ));
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(100);
            tabela.getColumnModel().getColumn(0).setMaxWidth(101);
            tabela.getColumnModel().getColumn(1).setMinWidth(300);
            tabela.getColumnModel().getColumn(1).setMaxWidth(320);
            tabela.getColumnModel().getColumn(2).setMinWidth(120);
            tabela.getColumnModel().getColumn(2).setMaxWidth(130);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 720, 350));

        txtTotalGeral.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtTotalGeral.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtTotalGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, 160, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("TOTAL VENDA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 486, -1, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excl.png"))); // NOI18N
        jButton1.setText("Retirar Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, -1, 32));
        getContentPane().add(txtNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 495, 32));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 34, 32));

        jLabel3.setText("Cliente:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/barcode-scanner.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 30, 32));

        jLabel5.setText("Codigo Produto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        getContentPane().add(txtValorUnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 220, 32));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_orange.png"))); // NOI18N
        jButton3.setText("Finalizar Venda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 260, 50));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menu-list-16.png"))); // NOI18N
        jButton4.setText("Vendas Efetuadas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 260, 34));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Descrição:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        txtDataVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDataVenda.setForeground(new java.awt.Color(153, 153, 153));
        txtDataVenda.setText("00/00/0000");
        getContentPane().add(txtDataVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, -1, -1));

        txtDescProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDescProduto.setForeground(new java.awt.Color(102, 102, 102));
        txtDescProduto.setText("PRODUTO XYZ");
        getContentPane().add(txtDescProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, 680, 30));

        txtQtdeSpiner.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtQtdeSpiner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        txtQtdeSpiner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtQtdeSpinerStateChanged(evt);
            }
        });
        txtQtdeSpiner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtdeSpinerFocusLost(evt);
            }
        });
        getContentPane().add(txtQtdeSpiner, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 220, 32));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendasBgTop.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Quantidade:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Preço Unitário:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bgpdv.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 160));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bgpdv2.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, -1, -1));

        printcupom.setText("Imprimir Cupom");
        getContentPane().add(printcupom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, -1));

        modoPromocao.setText("Modo Promoção");
        modoPromocao.setEnabled(false);
        getContentPane().add(modoPromocao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        txtCodigoBar.setBackground(new java.awt.Color(242, 253, 242));
        txtCodigoBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigoBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 220, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!listaItens.isEmpty()) {

            venda.setDataVenda(LocalDate.parse(txtDataVenda.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            venda.setTotal(new BigDecimal(String.valueOf(txtTotalGeral.getValue())));
            venda.setItens(listaItens);
            venda.setCliente(cliente);

            telafinalizaVenda = new TelaFinalizaVenda(null, rootPaneCheckingEnabled, venda, this);

            if (printcupom.isSelected()) {
                telafinalizaVenda.printCupom = true;
            } else {
                telafinalizaVenda.printCupom = false;
            }

            telafinalizaVenda.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhum item adicionado", "Venda inválida", 0);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tabela.getSelectedRow() != -1) {
            var codigo_interno = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            listaItens.removeIf(it -> it.getCodigo_interno() == codigo_interno);
            listaItemsOrdem();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelaGerenciarVendas tlv = new TelaGerenciarVendas();
        tlv.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        telafinalizaVenda = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        var tlist = new TelaListagemClientes(this);
        tlist.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtQtdeSpinerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtdeSpinerFocusLost
        txtCodigoBar.requestFocus();
    }//GEN-LAST:event_txtQtdeSpinerFocusLost

    private void txtQtdeSpinerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtQtdeSpinerStateChanged
        txtCodigoBar.requestFocus();
    }//GEN-LAST:event_txtQtdeSpinerStateChanged

    private void txtCodigoBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarActionPerformed
        if (!txtCodigoBar.getText().isEmpty()) {

            try {
                String codigoBar = txtCodigoBar.getText();
                var codigo = Long.parseLong(txtCodigoBar.getText());

                Produto produto = produtoRepository.findByCodBarAndId(codigo, codigoBar);
                var produtoEstoque = produto.getEstoque().getAtual();

                if (produtoEstoque >= ((int) txtQtdeSpiner.getValue())) {

                    txtDescProduto.setText(produto.getNome() + " - " + produto.getMarca());
                    txtValorUnt.setText(numberFormat.format(produto.getValor()));

                    var item = new ItemVenda();
                    item.setDescr(produto.getNome());
                    item.setPrecoUnit(produto.getValor());
                    item.setQtde((Integer) txtQtdeSpiner.getValue());
                    item.setSubtotal(produto.getValor().multiply(new BigDecimal(item.getQtde())));
                    item.setCodigo_interno(produto.getCodigo());
                    item.setVenda(venda);

                    var isAdicionado = listaItens.stream().anyMatch(it -> it.getCodigo_interno() == produto.getCodigo());
                    if (isAdicionado) {
                        var qtdeAtual = listaItens.stream()
                                .filter(it -> it.getCodigo_interno() == produto.getCodigo())
                                .findFirst().get()
                                .getQtde();

                        listaItens.removeIf(it -> it.getCodigo_interno() == produto.getCodigo());
                        item.setQtde((int) txtQtdeSpiner.getValue() + qtdeAtual);
                        item.setSubtotal(item.getPrecoUnit().multiply(new BigDecimal(item.getQtde())));
                        listaItens.add(item);
                    } else {
                        listaItens.add(item);
                    }

                    listaItemsOrdem();

                    txtCodigoBar.setText("");
                    txtCodigoBar.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Produto sem estoque suficiente", "Sem Estoque", 0);
                    txtCodigoBar.setText("");
                    txtCodigoBar.requestFocus();

                }
            } catch (HeadlessException | NoResultException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Produto não encontrado " + ex.getMessage(), "Codigo inválido", 0);
                txtCodigoBar.setText("");
                txtCodigoBar.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoBarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox modoPromocao;
    private javax.swing.JCheckBox printcupom;
    private javax.swing.JTable tabela;
    public javax.swing.JTextField txtCodigoBar;
    private javax.swing.JLabel txtDataVenda;
    private javax.swing.JLabel txtDescProduto;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JSpinner txtQtdeSpiner;
    private javax.swing.JFormattedTextField txtTotalGeral;
    private javax.swing.JTextField txtValorUnt;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object obj) {
        if (obj instanceof Venda v) {
            venda = new Venda();
            listaItens.clear();
            listaItemsOrdem();
            txtCodigoBar.setText("");
            txtCodigoBar.requestFocus();
            txtDescProduto.setText("LIVRE");
            txtQtdeSpiner.setValue(1);
            txtTotalGeral.setValue(BigDecimal.ZERO);
            txtValorUnt.setText("");
            JOptionPane.showMessageDialog(rootPane, "Venda efetuada com sucesso", "N° venda " + v.getId(), 1);
        } else if (obj instanceof Cliente cliente) {
            this.cliente = cliente;
            txtNomeCliente.setText(cliente.getNome());
        }
    }
}
