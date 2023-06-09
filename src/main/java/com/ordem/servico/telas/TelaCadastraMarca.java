package com.ordem.servico.telas;

import com.ordem.servico.models.Marca;
import com.ordem.servico.repository.MarcaRepository;
import com.ordem.servico.util.RetornoUpdate;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import org.hsqldb.HsqlException;

public class TelaCadastraMarca extends javax.swing.JDialog {

    private final RetornoUpdate retornoUpdate;
    private final MarcaRepository marcaRepository;

    public TelaCadastraMarca(java.awt.Frame parent, boolean modal, TelaCadastroEquipamento tela) {
        super(parent, modal);
        initComponents();

        marcaRepository = new MarcaRepository();
        retornoUpdate = tela;
    }

    public TelaCadastraMarca(java.awt.Frame parent, boolean modal, TelaCadastroProduto tela) {
        super(parent, modal);
        initComponents();

        marcaRepository = new MarcaRepository();
        retornoUpdate = tela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nova Marca:");

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
                    .addComponent(txtMarca)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 193, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (!txtMarca.getText().isEmpty()) {
                var novaMarca = txtMarca.getText().toUpperCase();
                marcaRepository.saveOrUpdate(new Marca(novaMarca));
                retornoUpdate.update(marcaRepository.getByNome(novaMarca));
                dispose();
            }
        } catch (PersistenceException | HsqlException ex) {
            JOptionPane.showMessageDialog(this, "Marca ja cadastrada", "Atenção", 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtMarca;
    // End of variables declaration//GEN-END:variables
}
