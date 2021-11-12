
package com.ordem.servico.telas;

import com.ordem.servico.models.ItemVenda;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TelaMinhasVendas extends javax.swing.JDialog {

    private final List<ItemVenda> listaItens = new ArrayList<>();
    private final NumberFormat numberFormat;
    
    public TelaMinhasVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        numberFormat = DecimalFormat.getCurrencyInstance();
    }

   private void listaItemsOrdem() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[7];
        listaItens.forEach(i -> {
            row[0] = i.getId();
            row[1] = i.getDescr();
            row[3] = i.getQtde();
            row[4] = numberFormat.format(i.getPrecoUnit());
            row[5] = numberFormat.format(i.getSubtotal());

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
        tabela = new javax.swing.JTable();
        txtTotalGeral = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        getContentPane().add(txtTotalGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, 160, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("TOTAL VENDA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 486, -1, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excl.png"))); // NOI18N
        jButton1.setText("Retirar Item");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, -1, 32));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 495, 32));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 34, 32));

        jLabel3.setText("Cliente:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/barcode-scanner.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 30, 32));

        jTextField2.setBackground(new java.awt.Color(245, 255, 245));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 201, 32));

        jLabel5.setText("Codigo Produto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel6.setText("Observação:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jTextField3.setBackground(new java.awt.Color(255, 245, 225));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 260, 32));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_orange.png"))); // NOI18N
        jButton3.setText("Finalizar Venda");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 260, 34));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menu-list-16.png"))); // NOI18N
        jButton4.setText("Vendas Efetuadas");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 260, 34));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Descrição:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("00/00/0000");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("PRODUTO XYZ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, 680, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendasBgTop.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMinhasVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMinhasVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMinhasVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMinhasVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaMinhasVendas dialog = new TelaMinhasVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField txtTotalGeral;
    // End of variables declaration//GEN-END:variables
}
