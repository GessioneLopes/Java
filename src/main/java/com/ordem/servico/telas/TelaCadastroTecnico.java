package com.ordem.servico.telas;

import com.ordem.servico.models.Contato;
import com.ordem.servico.models.Endereco;
import com.ordem.servico.models.Tecnico;
import com.ordem.servico.repository.TecnicoRepository;
import com.ordem.servico.util.BuscaViaCepUtil;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class TelaCadastroTecnico extends javax.swing.JDialog {
    
    private TecnicoRepository tecnicoRepository;
    private Tecnico tecnico;
    
    public TelaCadastroTecnico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        tecnico = new Tecnico();
        
        tecnicoRepository = new TecnicoRepository();
        listagemTecnicos();
    }
    
    private void listagemTecnicos() {
        var lista = tecnicoRepository.lista(Tecnico.class);
        
        var modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        
        var row = new Object[4];
        lista.forEach(i -> {
            
            row[0] = i.getCodigo();
            row[1] = i.getNomeTecnico().toUpperCase();
            row[2] = i.getContato().getCelular();
            row[3] = i.getCpf();
            
            modelo.addRow(row);
        });
        
        if (lista.isEmpty()) {
            row[1] = "Nenhum Técnico cadastrado";
            modelo.addRow(row);
        }
    }
    
    public Image icone() {
        return (new ImageIcon(getClass().getResource("/imagens/menu-list-16.png"))).getImage();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
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
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSalvaDados = new javax.swing.JButton();
        txtSexo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFone = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUf = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtRedeSocial = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JFormattedTextField();
        btnUpdate = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tecnicos");
        setIconImage(icone());

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Telefone", "CPF"
            }
        ));
        tabela.setRowHeight(25);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(80);
            tabela.getColumnModel().getColumn(0).setMaxWidth(85);
            tabela.getColumnModel().getColumn(1).setMinWidth(300);
            tabela.getColumnModel().getColumn(1).setMaxWidth(305);
        }

        jLabel1.setText("Nome:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("CPF:");

        jLabel3.setText("RG:");

        btnSalvaDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnSalvaDados.setText("Salvar Dados");
        btnSalvaDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaDadosActionPerformed(evt);
            }
        });

        txtSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMININO", "NEUTRO" }));

        jLabel4.setText("Sexo:");

        jLabel5.setText("E-mail:");

        try {
            txtFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Telefone:");

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));

        jLabel7.setText("Logradouro:");

        jLabel8.setText("N°:");

        txtCep.setBackground(new java.awt.Color(245, 255, 245));
        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCepFocusLost(evt);
            }
        });

        jLabel9.setText("Cep:");

        txtUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO", " " }));

        jLabel11.setText("UF:");

        jLabel12.setText("Cidade:");

        jLabel13.setText("Bairro:");

        jLabel15.setText("Ponto Referencia:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtUf, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtNumero)
                    .addComponent(txtEndereco)
                    .addComponent(txtCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBairro)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excl.png"))); // NOI18N
        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Rede Social:");

        jLabel17.setText("Salário:");

        txtSalario.setBackground(new java.awt.Color(240, 255, 240));
        txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtSalario.setValue(BigDecimal.ZERO
        );

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circular-arrow.png"))); // NOI18N
        btnUpdate.setText("Atualizar");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvaDados))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(txtRedeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(txtSalario))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(txtCpf)
                                .addComponent(txtFone, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRg)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel17))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel16))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRedeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvaDados, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvaDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaDadosActionPerformed
        
        if (!txtNome.getText().isEmpty() && !txtEndereco.getText().isEmpty() && !txtRg.getText().isEmpty()) {
            
            tecnico = new Tecnico();
            tecnico.setNomeTecnico(txtNome.getText());
            tecnico.setCpf(txtCpf.getText());
            tecnico.setRg(txtRg.getText());
            tecnico.setSexo(txtSexo.getSelectedItem().toString());
            tecnico.setSalario(new BigDecimal(String.valueOf(txtSalario.getValue())));
            tecnico.setContato(new Contato(txtFone.getText(), txtEmail.getText(), txtRedeSocial.getText()));
            
            var endereco = new Endereco();
            endereco.setBairro(txtBairro.getText());
            endereco.setCidade(txtCidade.getText());
            endereco.setCep(txtCep.getText());
            endereco.setLogradouro(txtEndereco.getText());
            endereco.setNumero(txtNumero.getText());
            endereco.setUf(txtUf.getSelectedItem().toString());
            
            tecnico.setEndereco(endereco);
            
            tecnicoRepository.saveOrUpdate(tecnico);
            JOptionPane.showMessageDialog(rootPane, "Cadastro efetuado com sucesso", "Confirmado", 1);
            
            listagemTecnicos();
            limpa();
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos", "Atenção", 0);
            
        }

    }//GEN-LAST:event_btnSalvaDadosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tabela.getSelectedRow() != -1) {
            long codigo = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            tecnicoRepository.deleteById(Tecnico.class, codigo);
            listagemTecnicos();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCepFocusLost
        try {
            var endereco = new BuscaViaCepUtil().get(txtCep.getText().replace("-", ""));
            txtBairro.setText(endereco.getBairro());
            txtCidade.setText(endereco.getCidade());
            txtEndereco.setText(endereco.getLogradouro());
            txtUf.setSelectedItem(endereco.getUf());
            txtReferencia.setText(endereco.getReferencia());
        } catch (java.lang.NullPointerException ex) {
            System.out.println("cep inválido");
        }
    }//GEN-LAST:event_txtCepFocusLost

    private void txtBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyTyped
        var table = (DefaultTableModel) tabela.getModel();
        var tr = new TableRowSorter<>(table);
        tabela.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(txtBusca.getText().toUpperCase()));
    }//GEN-LAST:event_txtBuscaKeyTyped

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedRow() != -1) {
            long codigo = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            
            tecnico = tecnicoRepository.find(Tecnico.class, codigo);
            
            txtNome.setText(tecnico.getNomeTecnico());
            txtEndereco.setText(tecnico.getEndereco().getLogradouro());
            txtCpf.setText(tecnico.getCpf());
            txtEmail.setText(tecnico.getContato().getEmail());
            txtReferencia.setText(tecnico.getEndereco().getReferencia());
            txtCidade.setText(tecnico.getEndereco().getCidade());
            txtBairro.setText(tecnico.getEndereco().getBairro());
            txtCep.setText(tecnico.getEndereco().getCep());
            txtFone.setText(tecnico.getContato().getCelular());
            txtSalario.setValue(tecnico.getSalario());
            txtRg.setText(tecnico.getRg());
            txtNumero.setText(tecnico.getEndereco().getNumero());
            txtRedeSocial.setText(tecnico.getContato().getRedesocial());
            txtNome.requestFocus();
            btnUpdate.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (!txtNome.getText().isEmpty() && !txtEndereco.getText().isEmpty() && !txtRg.getText().isEmpty()) {
            
            tecnico.setNomeTecnico(txtNome.getText());
            tecnico.setCpf(txtCpf.getText());
            tecnico.setRg(txtRg.getText());
            tecnico.setSexo(txtSexo.getSelectedItem().toString());
            tecnico.setSalario(new BigDecimal(String.valueOf(txtSalario.getValue())));
            tecnico.setContato(new Contato(txtFone.getText(), txtEmail.getText(), txtRedeSocial.getText()));
            
            tecnico.getEndereco().setReferencia(txtReferencia.getText());
            tecnico.getEndereco().setBairro(txtBairro.getText());
            tecnico.getEndereco().setCidade(txtCidade.getText());
            tecnico.getEndereco().setCep(txtCep.getText());
            tecnico.getEndereco().setLogradouro(txtEndereco.getText());
            tecnico.getEndereco().setNumero(txtNumero.getText());
            tecnico.getEndereco().setUf(txtUf.getSelectedItem().toString());
            
            tecnico.getContato().setCelular(txtFone.getText());
            tecnico.getContato().setEmail(txtEmail.getText());
            tecnico.getContato().setRedesocial(txtRedeSocial.getText());
            
            tecnicoRepository.saveOrUpdate(tecnico);
            JOptionPane.showMessageDialog(rootPane, "Dados atualizados com sucesso", "Confirmado", 1);
            
            limpa();
            listagemTecnicos();
            btnUpdate.setEnabled(false);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    
    private void limpa() {
        txtRedeSocial.setText("");
        txtReferencia.setText("");
        txtNome.setText("");
        txtEndereco.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtBusca.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtCep.setText("");
        txtFone.setText("");
        txtNome.requestFocus();
        txtRg.setText("");
        txtNumero.setText("");
        txtNome.requestFocus();
        txtSalario.setValue(BigDecimal.ZERO);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvaDados;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRedeSocial;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtRg;
    private javax.swing.JFormattedTextField txtSalario;
    private javax.swing.JComboBox<String> txtSexo;
    private javax.swing.JComboBox<String> txtUf;
    // End of variables declaration//GEN-END:variables
}
