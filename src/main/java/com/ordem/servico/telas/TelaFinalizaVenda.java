package com.ordem.servico.telas;

import com.ordem.servico.models.Produto;
import com.ordem.servico.models.Venda;
import com.ordem.servico.repository.ProdutoRepository;
import com.ordem.servico.repository.VendaRepository;
import com.ordem.servico.util.DataHora;
import com.ordem.servico.util.FormasPgto;
import com.ordem.servico.util.RetornoUpdate;
import java.math.BigDecimal;
import javax.swing.DefaultComboBoxModel;

public class TelaFinalizaVenda extends javax.swing.JDialog {

    private final Venda venda;
    private final RetornoUpdate retornoUpdate;

    public TelaFinalizaVenda(java.awt.Frame parent, boolean modal, Venda venda, TelaMinhasVendas minhasVendas) {
        super(parent, modal);
        initComponents();

        retornoUpdate = minhasVendas;

        this.venda = venda;
        txtTotal.setValue(venda.getTotal());
        carregaTipoPgtos();
    }

    private void carregaTipoPgtos() {
        var status = FormasPgto.values();

        var model = new DefaultComboBoxModel();
        for (FormasPgto fms : status) {
            model.addElement(fms.name());
        }
        txtTipoPgto.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTotal = new javax.swing.JFormattedTextField();
        txtTipoPgto = new javax.swing.JComboBox<>();
        txtObs = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 51));
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotal.setEditable(false);
        txtTotal.setForeground(new java.awt.Color(255, 102, 0));
        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 34));

        txtTipoPgto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(txtTipoPgto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 34));
        getContentPane().add(txtObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 320, 32));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 320, 34));

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Observação:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, -1));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Forma Pagamento:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtDesconto.setValue(BigDecimal.ZERO
        );
        getContentPane().add(txtDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 160, 33));

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Desconto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bgpdv3.png"))); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        var vendaRepository = new VendaRepository();

        venda.setFormaPgto(FormasPgto.valueOf(txtTipoPgto.getSelectedItem().toString()));
        venda.setObs(txtObs.getText());
        venda.setResponsavel(MainApp.txtUserLogado.getText());
        venda.setDesconto(new BigDecimal(String.valueOf(txtDesconto.getValue())));
        venda.setHora(new DataHora().ler_hora());
        venda.setTotal(new BigDecimal(String.valueOf(txtTotal.getValue())));

        venda.setId(vendaRepository.salvaVenda(venda));

        //update estoque
        var repo = new ProdutoRepository();
        venda.getItens().forEach(it -> {
            var produto = repo.find(Produto.class, it.getCodigo_interno());
            int qtdeAtual = produto.getEstoque().getAtual();
            produto.getEstoque().setAtual(qtdeAtual - it.getQtde());
            repo.saveOrUpdate(produto);
        });

        retornoUpdate.update(venda);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField txtDesconto;
    private javax.swing.JTextField txtObs;
    private javax.swing.JComboBox<String> txtTipoPgto;
    public javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
