package com.ordem.servico.telas;

import com.ordem.servico.models.Cliente;
import com.ordem.servico.models.Equipamento;
import com.ordem.servico.models.ItemOrdem;
import com.ordem.servico.models.ItemVenda;
import com.ordem.servico.models.Ordem;
import com.ordem.servico.models.Produto;
import com.ordem.servico.models.Servico;
import com.ordem.servico.models.Tecnico;
import com.ordem.servico.models.Venda;
import com.ordem.servico.repository.ItemOrdemRepository;
import com.ordem.servico.repository.OrdemRepository;
import com.ordem.servico.repository.TecnicoRepository;
import com.ordem.servico.util.DataHora;
import com.ordem.servico.util.GeraRelatorioUtil;
import com.ordem.servico.util.ItemOrdemTipo;
import com.ordem.servico.util.OrdemRetornoAdiciona;
import com.ordem.servico.util.OrdemStatus;
import com.ordem.servico.util.OrdemTipo;
import com.ordem.servico.util.RetornoUpdate;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TelaCadastroOrdemServico extends javax.swing.JInternalFrame implements RetornoUpdate, OrdemRetornoAdiciona {

    private final TecnicoRepository tecnicoRepository;
    private final ItemOrdemRepository itemOrdemRepository;

    private Cliente cliente;
    private Equipamento equipamento;
    private Ordem ordem;

    private final NumberFormat numberFormat;
    private boolean produtoExistenteOrdem;

    private List<ItemOrdem> listaItens = new ArrayList<>();

    private RetornoUpdate retornoUpdate;

    private boolean ordemEdit = false;
    private long nrOrdemEdit = 0L;

    private TelaCadastroEquipamento cadastroEquipamento;

    public TelaCadastroOrdemServico() {
        initComponents();

        retornoUpdate = null;

        ordem = new Ordem();
        numberFormat = DecimalFormat.getCurrencyInstance();

        tecnicoRepository = new TecnicoRepository();
        carregaTecnicos();

        itemOrdemRepository = new ItemOrdemRepository();
        listaItemsOrdem();

        dataHoraOrdemInicial();

        carregaStatus();
        carregaTiposOrdem();
    }

    public TelaCadastroOrdemServico(TelaOrcamentos telaOrcamentos) {
        initComponents();

        ordem = new Ordem();
        retornoUpdate = telaOrcamentos;
        numberFormat = DecimalFormat.getCurrencyInstance();

        tecnicoRepository = new TecnicoRepository();
        carregaTecnicos();

        itemOrdemRepository = new ItemOrdemRepository();
        listaItemsOrdem();

        dataHoraOrdemInicial();

        carregaStatus();
        carregaTiposOrdem();
    }

    public TelaCadastroOrdemServico(TelaOrdemServicos telaOrdemServicos) {
        initComponents();

        ordem = new Ordem();
        retornoUpdate = telaOrdemServicos;
        numberFormat = DecimalFormat.getCurrencyInstance();

        tecnicoRepository = new TecnicoRepository();
        carregaTecnicos();

        itemOrdemRepository = new ItemOrdemRepository();
        listaItemsOrdem();

        dataHoraOrdemInicial();

        carregaStatus();
        carregaTiposOrdem();
    }

    private void dataHoraOrdemInicial() {
        txtDateOrdem.setIcon(iconeCalendario());
        txtDateOrdem.setDate(new Date());
        txtHora.setText(new DataHora().ler_hora());
    }

    private void carregaTecnicos() {
        var tecnicos = tecnicoRepository.lista(Tecnico.class);

        var model = new DefaultComboBoxModel();
        model.addElement("Selecione");

        for (int i = 0; i < tecnicos.size(); i++) {
            model.addElement(tecnicos.get(i).getCodigo() + "-" + tecnicos.get(i).getNomeTecnico().toUpperCase());
        }

        txtTecnicos.setModel(model);
    }

    private void carregaStatus() {
        var status = OrdemStatus.values();

        var model = new DefaultComboBoxModel();
        for (OrdemStatus sts : status) {
            model.addElement(sts.name());
        }
        txtStatusOrdem.setModel(model);
    }

    private void carregaTiposOrdem() {
        var status = OrdemTipo.values();

        var model = new DefaultComboBoxModel();
        for (OrdemTipo sts : status) {
            model.addElement(sts.name());
        }
        txtTipo.setModel(model);
    }

    private void listaItemsOrdem() {

        var modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        var row = new Object[7];
        listaItens.forEach(i -> {
            row[0] = i.getCodigo();
            row[1] = i.getDescricao();
            row[2] = i.getTipo().name();
            row[3] = i.getQtde();
            row[4] = numberFormat.format(i.getValor());
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

        txtTotalProduto.setValue(listaItens.stream().filter(itm -> itm.getTipo() == ItemOrdemTipo.PRODUTO)
                .map(it -> it.getSubtotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        txtTotalServico.setValue(listaItens.stream().filter(itm -> itm.getTipo() == ItemOrdemTipo.SERVICO)
                .map(it -> it.getSubtotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add));

    }

    private ImageIcon iconeCalendario() {
        return (new ImageIcon(getClass().getResource("/imagens/calendar.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtHora = new javax.swing.JTextField();
        txtDateOrdem = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtStatusOrdem = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtNomeEquip = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDefeitoEquip = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        txtModeloEquip = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNumeroSerieEquip = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtCorEquip = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTecnicos = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtFone = new javax.swing.JFormattedTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtEmialCliente = new javax.swing.JFormattedTextField();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
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
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtTotalProduto = new javax.swing.JFormattedTextField();
        txtTotalServico = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtTotalGeral = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        txtNrOrdem = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ordens");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menu-circulado-16.png"))); // NOI18N

        txtDateOrdem.setDateFormatString("dd/MM/yyyy");

        jLabel1.setText("Data da Ordem:");

        jLabel2.setText("Hora:");

        txtTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORDEM SERVICO", "ORCAMENTO" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Tipo de Ordem:");

        txtStatusOrdem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtStatusOrdem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Status:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Equipamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtNomeEquip.setEditable(false);
        txtNomeEquip.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNomeEquip.setForeground(new java.awt.Color(51, 51, 51));

        txtDefeitoEquip.setColumns(20);
        txtDefeitoEquip.setForeground(new java.awt.Color(51, 0, 0));
        txtDefeitoEquip.setLineWrap(true);
        txtDefeitoEquip.setRows(4);
        txtDefeitoEquip.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtDefeitoEquip);

        jLabel13.setText("Defeito:");

        jLabel14.setText("Modelo:");

        jLabel15.setText("Cor:");

        jLabel16.setText("Número Série/ Chassi:");

        txtNumeroSerieEquip.setBackground(new java.awt.Color(252, 255, 252));
        txtNumeroSerieEquip.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNumeroSerieEquip.setForeground(new java.awt.Color(51, 51, 51));

        jLabel17.setText("Nome:");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_orange.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtNumeroSerieEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNomeEquip))
                        .addGap(2, 2, 2)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtModeloEquip, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCorEquip, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(1, 1, 1)
                        .addComponent(txtNumeroSerieEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNomeEquip, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtModeloEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addGap(1, 1, 1)
                        .addComponent(txtCorEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtObs.setBackground(new java.awt.Color(255, 251, 247));
        txtObs.setColumns(20);
        txtObs.setRows(4);
        jScrollPane1.setViewportView(txtObs);

        jLabel5.setText("Laudo/Observações da Ordem:");

        jLabel6.setText("Técnico Responsável:");

        txtTecnicos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTecnicos.setForeground(new java.awt.Color(51, 51, 51));
        txtTecnicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel7.setText("Nome do Cliente:");

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCliente.setForeground(new java.awt.Color(51, 51, 51));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Telefone:");

        txtFone.setForeground(new java.awt.Color(51, 51, 51));
        txtFone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtCPF.setForeground(new java.awt.Color(51, 51, 51));
        txtCPF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel9.setText("CPF:");

        jLabel18.setText("Email:");

        txtEmialCliente.setForeground(new java.awt.Color(51, 51, 51));

        txtCNPJ.setForeground(new java.awt.Color(51, 51, 51));
        txtCNPJ.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel19.setText("CNPJ:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEmialCliente)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCNPJ)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel18))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel19))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(1, 1, 1)
                .addComponent(txtEmialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Categoria", "Qtde", "Valor", "SubTotal"
            }
        ));
        jScrollPane2.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(100);
            tabela.getColumnModel().getColumn(0).setMaxWidth(105);
            tabela.getColumnModel().getColumn(1).setMinWidth(400);
            tabela.getColumnModel().getColumn(1).setMaxWidth(410);
        }

        jLabel10.setText("Produtos/ Serviços:");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_orange.png"))); // NOI18N
        jButton3.setText("Adicionar Serviço");
        jButton3.setToolTipText("Produto ou um Serviço");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_orange.png"))); // NOI18N
        jButton4.setText("Adicionar Produto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtTotalProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtTotalProduto.setValue(BigDecimal.ZERO);

        txtTotalServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtTotalServico.setValue(BigDecimal.ZERO);

        jLabel11.setText("Total Produtos:");

        jLabel12.setText("Total Serviços:");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton5.setText("Salvar Dados");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel20.setText("Total Geral:");

        txtTotalGeral.setEditable(false);
        txtTotalGeral.setBackground(new java.awt.Color(255, 255, 250));
        txtTotalGeral.setForeground(new java.awt.Color(0, 51, 0));
        txtTotalGeral.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtTotalGeral.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalGeral.setValue(BigDecimal.ZERO);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excl.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtNrOrdem.setBackground(new java.awt.Color(242, 253, 242));
        txtNrOrdem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNrOrdem.setForeground(new java.awt.Color(153, 102, 0));
        txtNrOrdem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNrOrdemKeyPressed(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jLabel21.setText("N° Ordem:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(txtNrOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDateOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStatusOrdem, 0, 118, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTecnicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTotalProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTotalServico, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(txtTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(51, 51, 51)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)
                                        .addGap(3, 3, 3)
                                        .addComponent(jButton3)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNrOrdem)
                            .addComponent(txtTipo)
                            .addComponent(txtTecnicos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(txtStatusOrdem, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel21)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(txtHora))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(txtDateOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jLabel10)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jButton3))
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotalProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotalServico, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20)
                                .addGap(4, 4, 4)
                                .addComponent(txtTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        var tlist = new TelaListagemClientes(this);
        tlist.setVisible(true);
        dataHoraOrdemInicial();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (ordemEdit == false) {
            if (!txtCliente.getText().isEmpty() && !txtNomeEquip.getText().isEmpty() && !txtDefeitoEquip.getText().isEmpty() && txtTecnicos.getSelectedIndex() > 0) {

                if (!listaItens.isEmpty()) {
                    ordem.setHora(new DataHora().ler_hora());
                    ordem.setCliente(cliente);
                    ordem.setObs(txtObs.getText());
                    ordem.setStatus(OrdemStatus.valueOf(txtStatusOrdem.getSelectedItem().toString()));
                    ordem.setTipo(OrdemTipo.valueOf(txtTipo.getSelectedItem().toString()));

                    long idTecnico = Long.valueOf(txtTecnicos.getSelectedItem().toString().split("-")[0]);
                    ordem.setTecnico(tecnicoRepository.find(Tecnico.class, idTecnico));

                    var dateOrdem = txtDateOrdem.getCalendar()
                            .toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();

                    ordem.setData(dateOrdem);

                    ordem.setEquipamento(equipamento);
                    ordem.setItens(listaItens);
                    ordem.setTotal(new BigDecimal(String.valueOf(txtTotalGeral.getValue())));

                    var idOrdemSalva = new OrdemRepository().salvaOrdem(ordem);

                    JOptionPane.showMessageDialog(rootPane, "Dados da ordem salvos com sucesso", "Confirmado", 1);

                    if (ordem.getTipo() == OrdemTipo.ORCAMENTO) {
                        new GeraRelatorioUtil().geraReletorioOrcamento(idOrdemSalva);
                    } else {
                        new GeraRelatorioUtil().geraViaOrdemServico(idOrdemSalva);
                    }

                    if (retornoUpdate != null) {
                        retornoUpdate.update(ordem);
                    }

                    limpar();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum produto ou serviço adicionado na ordem", "Adicione", 0);

                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Complete o preenchimento dos dados da ordem de serviço", "Incompleta", 0);
            }
        } else {

            var os = new OrdemRepository().find(Ordem.class, nrOrdemEdit);

            os.setObs(txtObs.getText());
            os.setStatus(OrdemStatus.valueOf(txtStatusOrdem.getSelectedItem().toString()));
            os.setTipo(OrdemTipo.valueOf(txtTipo.getSelectedItem().toString()));
            os.getEquipamento().setDefeito(txtDefeitoEquip.getText());

            long idTecnico = Long.valueOf(txtTecnicos.getSelectedItem().toString().split("-")[0]);
            os.setTecnico(tecnicoRepository.find(Tecnico.class, idTecnico));

            os.setTotal(new BigDecimal(String.valueOf(txtTotalGeral.getValue())));
            os.setItens(listaItens);

            if (os.getStatus() == OrdemStatus.FINALIZADA) {
                var venda = new Venda();

                venda.setDataVenda(LocalDate.now());
                venda.setObs("O.S Finalizada N° " + os.getId());
                venda.setTotal(os.getTotal());
                venda.setCliente(os.getCliente());

                var listItensVenda = new ArrayList<ItemVenda>();

                os.getItens().forEach(it -> {
                    var itemVenda = new ItemVenda();
                    itemVenda.setDescr(it.getDescricao());
                    itemVenda.setPrecoUnit(it.getValor());
                    itemVenda.setQtde(it.getQtde());
                    itemVenda.setVenda(venda);
                    itemVenda.setSubtotal(it.getSubtotal());
                    itemVenda.setCodigo_interno(it.getCodigo());
                    listItensVenda.add(itemVenda);
                });

                venda.setItens(listItensVenda);

                TelaFinalizaVenda fn = new TelaFinalizaVenda(null, closable, venda);
                fn.txtObs.setText(venda.getObs());
                fn.setVisible(true);
            }

            new OrdemRepository().saveOrUpdate(os);

            JOptionPane.showMessageDialog(rootPane, "Dados da ordem atualizados com sucesso", "Confirmado", 1);
            limpar();

            ordemEdit = false;
            nrOrdemEdit = 0L;

            new GeraRelatorioUtil().geraViaOrdemServico(os.getId());

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        var tleq = new TelaListagemEquipamentos(null, closable, this);
        tleq.setVisible(true);
        dataHoraOrdemInicial();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        var tsv = new TelaListagemServicos(null, closable, this);
        tsv.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (tabela.getSelectedRow() != -1) {
            var codigo = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            listaItens.removeIf(it -> it.getCodigo() == codigo);
            listaItemsOrdem();
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        var tlp = new TelaListagemProdutos(this);
        MainApp.getDesktop().add(tlp);
        tlp.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtNrOrdemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNrOrdemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            nrOrdemEdit = Long.parseLong(txtNrOrdem.getText());

            ordem = new OrdemRepository().find(Ordem.class, nrOrdemEdit);

            if (ordem != null) {

                if (ordem.getStatus() != OrdemStatus.FINALIZADA) {

                    txtStatusOrdem.setSelectedItem(ordem.getStatus().name());
                    txtTecnicos.setSelectedItem(ordem.getTecnico().getCodigo() + "-" + ordem.getTecnico().getNomeTecnico().toUpperCase());
                    txtTipo.setSelectedItem(ordem.getTipo().name());
                    txtObs.setText(ordem.getObs());
                    txtHora.setText(ordem.getHora());
                    txtTotalGeral.setValue(ordem.getTotal());
                    txtDateOrdem.setDate(Date.from(ordem.getData().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

                    txtCNPJ.setText(ordem.getCliente().getCnpj());
                    txtCPF.setText(ordem.getCliente().getCpf());
                    txtCliente.setText(ordem.getCliente().getNome());
                    txtEmialCliente.setText(ordem.getCliente().getContato().getEmail());
                    txtFone.setText(ordem.getCliente().getContato().getCelular());

                    txtNomeEquip.setText(ordem.getEquipamento().getNomeEquipamante());
                    txtNumeroSerieEquip.setText(ordem.getEquipamento().getNumero_serie());
                    txtModeloEquip.setText(ordem.getEquipamento().getModelo());
                    txtDefeitoEquip.setText(ordem.getEquipamento().getDefeito());
                    txtCorEquip.setText(ordem.getEquipamento().getCor());

                    listaItens.clear();
                    listaItens = ordem.getItens();
                    listaItemsOrdem();
                    ordemEdit = true;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "A Ordem de N° " + ordem.getId() + " já foi Finalizada. Não é possível editar a ordem.", "Finalizada", 2);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ordem não encontrada", "Verifique o N°", 0);
            }
        }
    }//GEN-LAST:event_txtNrOrdemKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        if (cadastroEquipamento == null) {
            cadastroEquipamento = new TelaCadastroEquipamento(this);
            MainApp.getDesktop().add(cadastroEquipamento);
        }
        cadastroEquipamento.setVisible(true);
        var desktopSize = MainApp.getDesktop().getSize();
        var screenSize = cadastroEquipamento.getSize();
        cadastroEquipamento.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);

        cadastroEquipamento.toFront();
        cadastroEquipamento.requestFocus();

        cadastroEquipamento = null;


    }//GEN-LAST:event_jButton7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCorEquip;
    private com.toedter.calendar.JDateChooser txtDateOrdem;
    private javax.swing.JTextArea txtDefeitoEquip;
    private javax.swing.JFormattedTextField txtEmialCliente;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtModeloEquip;
    private javax.swing.JTextField txtNomeEquip;
    private javax.swing.JTextField txtNrOrdem;
    private javax.swing.JTextField txtNumeroSerieEquip;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JComboBox<String> txtStatusOrdem;
    private javax.swing.JComboBox<String> txtTecnicos;
    public javax.swing.JComboBox<String> txtTipo;
    private javax.swing.JFormattedTextField txtTotalGeral;
    private javax.swing.JFormattedTextField txtTotalProduto;
    private javax.swing.JFormattedTextField txtTotalServico;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object obj) {

        if (obj instanceof Cliente cli) {
            this.cliente = cli;
            txtCPF.setText(cli.getCpf());
            txtCliente.setText(cli.getNome());
            txtFone.setText(cli.getContato().getCelular());
            txtCNPJ.setText(cli.getCnpj());
            txtEmialCliente.setText(cli.getContato().getEmail());
        } else if (obj instanceof Equipamento equip) {
            this.equipamento = equip;
            txtDefeitoEquip.setText(equip.getDefeito());
            txtNumeroSerieEquip.setText(equip.getNumero_serie());
            txtCorEquip.setText(equip.getCor());
            txtModeloEquip.setText(equip.getModelo());
            txtNomeEquip.setText(equip.getNomeEquipamante());
        }

    }

    private void limpar() {
        ordem = new Ordem();
        txtNrOrdem.setText("");
        txtCPF.setText("");
        txtCNPJ.setText("");
        txtCorEquip.setText("");
        txtCliente.setText("");
        txtFone.setText("");
        txtHora.setText(new DataHora().ler_hora());
        txtEmialCliente.setText("");
        txtObs.setText("");
        txtModeloEquip.setText("");
        txtNomeEquip.setText("");
        txtNumeroSerieEquip.setText("0");
        txtTecnicos.setSelectedIndex(0);
        txtTotalGeral.setText("");
        txtDefeitoEquip.setText("");
        txtCliente.requestFocus();

        listaItens.clear();
        listaItemsOrdem();
    }

    @Override
    public void adiciona(Object obj) {
        var item = new ItemOrdem();

        if (obj instanceof Servico svs) {

            item.setCodigo(svs.getId());
            item.setDescricao(svs.getDescricao());
            item.setQtde(1);
            item.setValor(svs.getValor());
            item.setSubtotal(svs.getValor().multiply(new BigDecimal(item.getQtde())));
            item.setOrdem(ordem);
            item.setTipo(ItemOrdemTipo.SERVICO);

            listaItens.add(item);
            listaItemsOrdem();

        } else if (obj instanceof Produto prod) {
            item.setCodigo(prod.getCodigo());
            item.setDescricao(prod.getNome());
            item.setQtde(1);
            item.setValor(prod.getValor());
            item.setSubtotal(prod.getValor().multiply(new BigDecimal(item.getQtde())));
            item.setOrdem(ordem);
            item.setTipo(ItemOrdemTipo.PRODUTO);

            produtoExistenteOrdem = false;
            listaItens.stream().forEach(it -> {
                if (it.getCodigo() == prod.getCodigo() && it.getTipo() == ItemOrdemTipo.PRODUTO) {
                    it.setQtde(it.getQtde() + item.getQtde());
                    it.setSubtotal(prod.getValor().multiply(new BigDecimal(it.getQtde())));
                    produtoExistenteOrdem = true;
                }
            });

            if (!produtoExistenteOrdem) {
                listaItens.add(item);
            }
            listaItemsOrdem();
        }
    }

}
