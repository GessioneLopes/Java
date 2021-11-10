package com.ordem.servico.telas;

import com.ordem.servico.models.Cor;
import com.ordem.servico.models.Estoque;
import com.ordem.servico.models.Fornecedor;
import com.ordem.servico.models.Produto;
import com.ordem.servico.repository.CorRepository;
import com.ordem.servico.repository.FornecedorRepository;
import com.ordem.servico.repository.ProdutoRepository;
import com.ordem.servico.util.RetornoUpdate;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class TelaCadastroProduto extends javax.swing.JDialog {

    private final RetornoUpdate processRetorno;
    private long idProduto = 0L;
    private CorRepository corRepository;

    public TelaCadastroProduto(java.awt.Frame parent, boolean modal, TelaListagemProdutos tela) {
        super(parent, modal);
        initComponents();

        corRepository = new CorRepository();
        carregaCores();

        this.processRetorno = tela;
        listaNomesFornecedores();
    }

    private void carregaCores() {
        List<Cor> cores = corRepository.lista(Cor.class);

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Selecione");

        for (int i = 0; i < cores.size(); i++) {
            model.addElement(cores.get(i).getCor().toUpperCase());
        }
        txtCor.setModel(model);
    }

    public TelaCadastroProduto(java.awt.Frame parent, boolean modal, TelaListagemProdutos tela, long idProduto) {
        super(parent, modal);
        initComponents();

        this.idProduto = idProduto;
        preparaUpdateData(idProduto);

        this.processRetorno = tela;
        listaNomesFornecedores();
    }

    private void listaNomesFornecedores() {
        List<Fornecedor> fornecedores = new FornecedorRepository().lista(Fornecedor.class);
        String[] nomes = new String[fornecedores.size()];

        int count = 0;
        for (Fornecedor it : fornecedores) {
            nomes[count] = it.getNome().toUpperCase();
            count++;
        }
        txtFornecedor.setModel(new DefaultComboBoxModel<>(nomes));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtEstoque = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtcodigoBar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtajuste = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCor = new javax.swing.JComboBox<>();
        txtTamanho = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUnt = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtValorPromocao = new javax.swing.JFormattedTextField();
        txtValorVenda = new javax.swing.JFormattedTextField();
        txtValorCusto = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtGarantia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo produto");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nome Produto:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Preço Custo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Preço Venda:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Estoque Inicial:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_orange.png"))); // NOI18N
        jButton1.setText("Efetuar cadastro");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtEstoque.setBackground(new java.awt.Color(255, 255, 245));
        txtEstoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Codigo de Barras:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Ajuste (%):");

        txtajuste.setText("0");
        txtajuste.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtajusteFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Preço Promoção:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Cor do Produto:");

        txtCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DOURADO", "PRETO", "BRANCO", "AMARELO", "AZUL", "VERMELHO", "ROSA", "CINZA", "BEGE", "VERDE", "MARRON", "MULTICOR", " " }));

        txtTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "P", "G", "XG", "XXG" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Tamanho:");

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Observação: (Opcional)");

        txtUnt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UND", "PAR", "PÇA", "KIT", " " }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Unidade:");

        txtFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Fornecedor:");

        txtValorPromocao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValorPromocao.setValue(BigDecimal.ZERO);

        txtValorVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValorVenda.setValue(BigDecimal.ZERO);

        txtValorCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValorCusto.setValue(BigDecimal.ZERO);

        jPanel1.setBackground(new java.awt.Color(224, 220, 220));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 153));
        jLabel14.setText("Foto Produto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel14)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Informações de Garantia:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnome)
                    .addComponent(txtObs)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(txtValorCusto)
                                    .addComponent(txtEstoque)
                                    .addComponent(txtCor, 0, 119, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGarantia)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtajuste, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel5)
                                                    .addComponent(txtValorPromocao, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel13)
                                            .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 1, Short.MAX_VALUE))))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigoBar)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(168, 168, 168)))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGarantia)
                                    .addComponent(txtEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11))
                                .addGap(1, 1, 1)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(1, 1, 1))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3)))
                                .addGap(1, 1, 1)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtajuste, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorPromocao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel13))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)))
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(1, 1, 1)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(txtcodigoBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (idProduto == 0L) {
            if (!txtEstoque.getText().isEmpty() && !txtnome.getText().isEmpty()) {
                var produto = new Produto();
                produto.setGarantia(txtGarantia.getText());
                produto.setNome(txtnome.getText().toUpperCase());
                produto.setCodbar(txtcodigoBar.getText());
                produto.setObs(txtObs.getText().toUpperCase());
                produto.setAjuste(Double.valueOf(txtajuste.getText()));
                produto.setCor(txtCor.getSelectedItem().toString());
                produto.setUnd(txtUnt.getSelectedItem().toString());
                produto.setTamanho(txtTamanho.getSelectedItem().toString());
                produto.setValor(new BigDecimal(String.valueOf(txtValorVenda.getValue())));

                if (new BigDecimal(String.valueOf(txtValorPromocao.getValue())).intValue() > 0) {
                    produto.setValorPromo(new BigDecimal(String.valueOf(txtValorPromocao.getValue())));
                } else {
                    produto.setValorPromo(new BigDecimal(String.valueOf(txtValorVenda.getValue())));
                }

                produto.setCusto(new BigDecimal(String.valueOf(txtValorCusto.getValue())));
                produto.setMargen(Double.parseDouble(txtajuste.getText().replace(",", ".")));

                Estoque eq = new Estoque();
                eq.setInicial(Integer.parseInt(String.valueOf(txtEstoque.getValue())));
                eq.setAtual(eq.getInicial());
                eq.setMinimo(1);

                produto.setEstoque(eq);

                new ProdutoRepository().saveOrUpdate(produto);

                JOptionPane.showMessageDialog(panel, "Cadastro efetuado com sucesso", "Confirmação", 1);
                processRetorno.update(null);
                limpar();

            } else {
                JOptionPane.showMessageDialog(panel, "Preencha todos os campos", "Atenção", 0);
            }
        } else {

            Produto produto = new ProdutoRepository().find(Produto.class, idProduto);
            produto.setNome(txtnome.getText().toUpperCase());
            produto.setCodbar(txtcodigoBar.getText());
            produto.setObs(txtObs.getText());
            produto.setAjuste(Double.valueOf(txtajuste.getText().replace(",", ".")));
            produto.setCor(txtCor.getSelectedItem().toString());
            produto.setUnd(txtUnt.getSelectedItem().toString());
            produto.setTamanho(txtTamanho.getSelectedItem().toString());
            produto.setValor(new BigDecimal(String.valueOf(txtValorVenda.getValue())));
            produto.setValorPromo(new BigDecimal(String.valueOf(txtValorPromocao.getValue())));
            produto.setCusto(new BigDecimal(String.valueOf(txtValorCusto.getValue())));
            produto.setMargen(Double.parseDouble(txtajuste.getText().replace(",", ".")));

            produto.getEstoque().setAtual(Integer.parseInt(String.valueOf(txtEstoque.getValue())));
            produto.getEstoque().setInicial(Integer.parseInt(String.valueOf(txtEstoque.getValue())));

            new ProdutoRepository().saveOrUpdate(produto);
            JOptionPane.showMessageDialog(panel, "Atualização efetuada com sucesso", "Atualizado", 1);
            processRetorno.update(null);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtajusteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtajusteFocusLost
        String replace = null;
        if (!txtajuste.getText().trim().equals("") && !txtValorCusto.getValue().equals(0)) {

            if (txtajuste.getText().contains("%") || txtajuste.getText().contains(",")) {
                replace = txtajuste.getText().replace("%", "").replace(",", ".").trim();

                txtValorVenda.setValue(new BigDecimal(String.valueOf(txtValorCusto.getValue()))
                        .multiply(new BigDecimal(replace))
                        .divide(new BigDecimal(100)).add(new BigDecimal(String.valueOf(txtValorCusto.getValue()))));
            } else {
                txtValorVenda.setValue(new BigDecimal(String.valueOf(txtValorCusto.getValue()))
                        .multiply(new BigDecimal(txtajuste.getText().trim()))
                        .divide(new BigDecimal(100)).add(new BigDecimal(String.valueOf(txtValorCusto.getValue()))));
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o valor de custo do produto", "Atenção", 0);
        }
    }//GEN-LAST:event_txtajusteFocusLost

    private void txtValorVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorVendaFocusLost
        if (new BigDecimal(String.valueOf(txtValorCusto.getValue())).doubleValue() > 0.0 && !txtajuste.getText().isBlank()) {

            txtajuste.setText(String.valueOf(calculaAjustePrecoVenda(new BigDecimal(String.valueOf(txtValorCusto.getValue())), new BigDecimal(String.valueOf(txtValorVenda.getValue())))));
        }
    }//GEN-LAST:event_txtValorVendaFocusLost

    private double calculaAjustePrecoVenda(BigDecimal custo, BigDecimal venda) {

        BigDecimal diferenca = venda.subtract(custo);

        BigDecimal margen = diferenca.divide(custo, MathContext.DECIMAL128);
        BigDecimal result = margen.multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);

        return result.doubleValue();
    }

    private void preparaUpdateData(long id) {
        Produto produto = new ProdutoRepository().find(Produto.class, id);
        txtnome.setText(produto.getNome().toUpperCase());
        txtObs.setText(produto.getObs().toUpperCase());
        txtValorCusto.setValue(produto.getCusto());
        txtValorPromocao.setValue(produto.getValorPromo());
        txtajuste.setValue(produto.getAjuste());
        txtcodigoBar.setText(produto.getCodbar());
        txtValorVenda.setValue(produto.getValor());
        txtEstoque.setValue(produto.getEstoque().getInicial());
        txtCor.setSelectedItem(produto.getCor());
        txtTamanho.setSelectedItem(produto.getTamanho());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox<String> txtCor;
    private javax.swing.JFormattedTextField txtEstoque;
    private javax.swing.JComboBox<String> txtFornecedor;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtObs;
    private javax.swing.JComboBox<String> txtTamanho;
    private javax.swing.JComboBox<String> txtUnt;
    private javax.swing.JFormattedTextField txtValorCusto;
    private javax.swing.JFormattedTextField txtValorPromocao;
    private javax.swing.JFormattedTextField txtValorVenda;
    private javax.swing.JFormattedTextField txtajuste;
    private javax.swing.JTextField txtcodigoBar;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables

    private void limpar() {
        txtnome.setText("");
        txtObs.setText("");
        txtValorCusto.setValue(BigDecimal.ZERO);
        txtValorVenda.setValue(BigDecimal.ZERO);
        txtValorPromocao.setValue(BigDecimal.ZERO);
        txtajuste.setText("0");
        txtEstoque.setText("");
        txtcodigoBar.setText("");
    }
}