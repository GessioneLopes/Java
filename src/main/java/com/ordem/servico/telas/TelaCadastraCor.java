package com.ordem.servico.telas;

import com.ordem.servico.models.Cor;
import com.ordem.servico.repository.CorRepository;
import com.ordem.servico.util.RetornoUpdate;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import org.hsqldb.HsqlException;

public class TelaCadastraCor extends javax.swing.JDialog {

    private final RetornoUpdate retornoUpdate;
    private final CorRepository corRepository;

    public TelaCadastraCor(java.awt.Frame parent, boolean modal, TelaCadastroEquipamento tela) {
        super(parent, modal);
        initComponents();
        corRepository = new CorRepository();
        retornoUpdate = tela;
    }

    public TelaCadastraCor(java.awt.Frame parent, boolean modal, TelaCadastroProduto tela) {
        super(parent, modal);
        initComponents();
        corRepository = new CorRepository();
        retornoUpdate = tela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nova Cor:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton1.setText("Adicionar");
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
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cor)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 165, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (!cor.getText().isEmpty()) {
                var cr = cor.getText().toUpperCase();
                corRepository.saveOrUpdate(new Cor(cr));
                retornoUpdate.update(corRepository.getByNome(cr));
                dispose();
            }
        } catch (PersistenceException | HsqlException ex) {
            JOptionPane.showMessageDialog(this, "Cor ja cadastrada", "Atenção", 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
